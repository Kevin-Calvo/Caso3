package Mongo;

import java.util.Date;
import java.util.Random;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import Objetos.Transaccion;

public class InventarioRepository {
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	public InventarioRepository() {
		 mongoClient = MongoClients.create("mongodb://localhost:27017"); //Conecta con mongo
	     database = mongoClient.getDatabase("Cooperativa");  //conecta con base de datos 
	     collection = database.getCollection("Inventario"); //permite interaccion
	}
	
	public void agregarCultivo(String cultivo, int costo, int cantidad, Date fecha, int porcentaje, String agricultor) {

		 Document document = new Document("cultivo", cultivo)
				 .append("costo", costo)//Crea tipo de dato a guardar en mongo
                .append("cantidad", cantidad)
                .append("cosecha", fecha)
                .append("porcentajeGanancia", porcentaje)
                .append("agricultor", agricultor); 
        collection.insertOne(document); //Mete dato en Mongo

	}
	
	public void eliminarCultivo(Document documento) {
		
		collection.deleteOne(documento);
	}
	
	public void actualizarCantidadCultivo(Document documento, int nueva_cantidad) {
		Document campos = new Document("cantidad",nueva_cantidad);
		Document actualizacion = new Document("$set", campos);
		collection.updateOne(documento, actualizacion);
	}
	
	public boolean confirmarCantidadEnInventario(int cantidadSolicitada, String cultivo) {
		int cantidadInventario = 0;
		FindIterable<Document> documents =  collection.find();
		
		for (Document documento : documents) {
			String nombre_cultivo = documento.getString("cultivo");
			if ((nombre_cultivo).trim().equals(cultivo.trim()))
				cantidadInventario += documento.getInteger("cantidad"); 
		}
		return cantidadInventario < cantidadSolicitada;
	}
	
	public Document encontrarMasAntiguo(String cultivo) {
		FindIterable<Document> documents =  collection.find();
	
		Document fifo = null; 
		for (Document documento : documents) {
			String nombre_cultivo = documento.getString("cultivo");
			
		
			if ((nombre_cultivo).trim().equals(cultivo.trim()))
			{
				if (fifo == null)
				{
					fifo = documento;
				}
				else {
					if(fifo.getDate("cosecha").compareTo(documento.getDate("cosecha")) >= 0)
						fifo = documento; 
				}
				
			}
		}
		return fifo;
	}
	
	public void venderCultivo(String cultivo, int cantidad)
	{
		//FindIterable<Document> documents =  collection.find();
		
		while (cantidad != 0)
		{
			System.out.println(cantidad); 
			Document fifo = encontrarMasAntiguo(cultivo); 
			
			if (fifo != null)
			{ 
				if (fifo.getInteger("cantidad") <= cantidad)
				{
					cantidad = cantidad - fifo.getInteger("cantidad");
					eliminarCultivo(fifo); 
				}
				else
				{
					int nueva_cantidad = fifo.getInteger("cantidad") - cantidad;
					cantidad = 0;
					actualizarCantidadCultivo(fifo, nueva_cantidad); 
				}	
			}
			else
			{
				break;
			}
		}	
	}
	
	public float calcularPrecioKilo(String cultivo, int cantidad)
	{
		int productosRestantes = cantidad; 
		int precioXkilo = 0;
		FindIterable<Document> documents =  collection.find().sort(new Document("cosecha", 1));
		for (Document documento : documents) {
			if (productosRestantes == 0)
				break;
			else
			{
				String nombre_cultivo = documento.getString("cultivo");
				if ((nombre_cultivo).trim().equals(cultivo.trim()))
				{
					if (documento.getInteger("cantidad") <= productosRestantes)
					{
						productosRestantes -= documento.getInteger("cantidad");
						precioXkilo += (documento.getInteger("cantidad") * documento.getInteger("costo")); 
					}
					else
					{
						precioXkilo += (productosRestantes * documento.getInteger("costo")); 
						productosRestantes = 0;
					}	
				}
			}
			
		}
		
		precioXkilo = precioXkilo / cantidad;
		
		return precioXkilo;
	}
	
	public float calcularGananciaAgricultoresGeneral(String cultivo, int cantidad)
	{
		int productosRestantes = cantidad; 
		int gananciaAgricultores = 0;
		FindIterable<Document> documents =  collection.find().sort(new Document("cosecha", 1));
		for (Document documento : documents) {
			if (productosRestantes == 0)
				break;
			else
			{
				String nombre_cultivo = documento.getString("cultivo");
				if ((nombre_cultivo).trim().equals(cultivo.trim()))
				{
					if (documento.getInteger("cantidad") <= productosRestantes)
					{
						productosRestantes -= documento.getInteger("cantidad");
						float precioTotal = (documento.getInteger("cantidad") * documento.getInteger("costo"));
						float porcentajeAgricultores = (100 - documento.getInteger("porcentajeGanancia")) ;
						gananciaAgricultores += (precioTotal * porcentajeAgricultores)/100 ; 
					}
					else
					{
						float precioTotal = (productosRestantes * documento.getInteger("costo"));
						float porcentajeAgricultores = (100 - documento.getInteger("porcentajeGanancia")) ;
						
						gananciaAgricultores += (precioTotal * porcentajeAgricultores)/100;
						productosRestantes = 0;
					}	
				}
			}
			
		}
		
		return gananciaAgricultores;
	}
	
	public void generarTransacciones(String cultivo, int cantidad, Transaccion transaccionControlador)
	{
		int productosRestantes = cantidad; 
		FindIterable<Document> documents =  collection.find().sort(new Document("cosecha", 1));
		for (Document documento : documents) {
			float gananciaAgricultores = 0; 
			if (productosRestantes == 0)
				break;
			else
			{
				String nombre_cultivo = documento.getString("cultivo");
				if ((nombre_cultivo).trim().equals(cultivo.trim()))
				{
					if (documento.getInteger("cantidad") <= productosRestantes)
					{
						productosRestantes -= documento.getInteger("cantidad");
						float precioTotal = (documento.getInteger("cantidad") * documento.getInteger("costo"));
						float porcentajeAgricultores = (100 - documento.getInteger("porcentajeGanancia")) ;
						float gananciaPorProducto = (documento.getInteger("costo") * porcentajeAgricultores) / 100;
						gananciaAgricultores = (precioTotal * porcentajeAgricultores)/100 ; 
						transaccionControlador.agregarTransaccion(new Date(), documento.getString("agricultor"), cultivo,
								gananciaPorProducto, documento.getInteger("cantidad"), gananciaAgricultores*-1);
					}
					else
					{
						float precioTotal = (productosRestantes * documento.getInteger("costo"));
						float porcentajeAgricultores = (100 - documento.getInteger("porcentajeGanancia")) ;
						float gananciaPorProducto = (documento.getInteger("costo") * porcentajeAgricultores) / 100;
						gananciaAgricultores = (precioTotal * porcentajeAgricultores)/100;
						transaccionControlador.agregarTransaccion(new Date(), documento.getString("agricultor"), cultivo, 
								gananciaPorProducto, productosRestantes, gananciaAgricultores*-1);
						productosRestantes = 0;
					}	
				}
			}
			
		}
		System.out.println("Transaccion Hecha"); 
	}
}
