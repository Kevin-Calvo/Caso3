package Mongo;

import java.util.Date;
import java.util.Random;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InventarioRepository {
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	InventarioRepository() {
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
	
	public boolean confirmarCantidadEnInventario(int cantidadSolicitada) {
		int cantidadInventario = 0;
		FindIterable<Document> documents =  collection.find();
		
		for (Document documento : documents) {
			cantidadInventario += documento.getInteger("cantidad"); 
		}
		
		return cantidadInventario >= cantidadSolicitada;
	}
	
	public void venderCultivo(String cultivo, int cantidad)
	{
		FindIterable<Document> documents =  collection.find();

		while (cantidad != 0)
		{
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
		}	
	}
}
