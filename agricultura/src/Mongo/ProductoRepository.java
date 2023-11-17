package Mongo;

import java.util.ArrayList;
import java.util.Date;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ProductoRepository {
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	ProductoRepository() {
		 mongoClient = MongoClients.create("mongodb://localhost:27017"); //Conecta con mongo
	     database = mongoClient.getDatabase("Cooperativa");  //conecta con base de datos 
	     collection = database.getCollection("Producto"); //permite interaccion
	}
	
	public void agregarProducto(String nombre) {

		 Document document = new Document("nombre", nombre); 
		 collection.insertOne(document); 

	}
	
	public ArrayList<String> obtenerListaProductos()
	{
		ArrayList<String> lista_producto = new ArrayList<>();
		FindIterable<Document> documents =  collection.find().sort(new Document("nombre", 1));

		for (Document documento : documents) {
			String nombre =documento.getString("nombre");
			lista_producto.add(nombre);
			
			}
		
		return lista_producto ; 
		
	}
	
}
