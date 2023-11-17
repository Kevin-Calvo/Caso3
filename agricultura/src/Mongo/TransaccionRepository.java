package Mongo;

import java.util.ArrayList;
import java.util.Date;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TransaccionRepository {
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	TransaccionRepository() {
		 mongoClient = MongoClients.create("mongodb://localhost:27017"); //Conecta con mongo
	     database = mongoClient.getDatabase("Cooperativa");  //conecta con base de datos 
	     collection = database.getCollection("Transaccion"); //permite interaccion
	}
	
	
	public void escribir(Date fecha, String agricultor, String producto, int precioU, int cantidad, int total) {
	     
		 Document document = new Document("fecha", fecha)
				 .append("agricultor", agricultor)//Crea tipo de dato a guardar en mongo
                .append("producto", producto)
                .append("precioUnidad", precioU)
                .append("cantidad", cantidad)
                .append("total", total);
        collection.insertOne(document); //Mete dato en Mongo

        System.out.println("Documento insertado correctamente."); //Confirma insercion
	}
	
	
	
}

