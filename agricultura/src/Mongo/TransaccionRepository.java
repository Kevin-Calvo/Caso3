package Mongo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TransaccionRepository {
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	public TransaccionRepository() {
		 mongoClient = MongoClients.create("mongodb://localhost:27017"); //Conecta con mongo
	     database = mongoClient.getDatabase("Cooperativa");  //conecta con base de datos 
	     collection = database.getCollection("Transaccion"); //permite interaccion
	}
	
	
	public void agregarTransaccion(Date fecha, String agricultor, String producto, int precioU, int cantidad, int total) {
	     
		 Document document = new Document("fecha", fecha)
				 .append("agricultor", agricultor)//Crea tipo de dato a guardar en mongo
                .append("producto", producto)
                .append("precioUnidad", precioU)
                .append("cantidad", cantidad)
                .append("total", total);
        collection.insertOne(document); //Mete dato en Mongo

        System.out.println("Documento insertado correctamente."); //Confirma insercion
	}
	
	public List<List<String>> obtenerListaTransacciones() {
		List<List<String>> tabla = new ArrayList<>();
		
		try (MongoCursor<Document> cursor = collection.find()
                .sort(new Document("nombre", 1).append("fecha", 1))
                .iterator()) {
            // Iterar sobre los resultados
            while (cursor.hasNext()) {
            	 List<String> transaccionInfo = new ArrayList<>();
                Document document = cursor.next();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                transaccionInfo.add(formatoFecha.format(document.getDate("fecha")));
                transaccionInfo.add(document.getString("agricultor")); 
                transaccionInfo.add(document.getString("producto"));
                transaccionInfo.add(String.valueOf(document.getInteger("precioUnidad"))); 
                transaccionInfo.add(String.valueOf(document.getInteger("cantidad")));
                transaccionInfo.add(String.valueOf(document.getInteger("total"))); 
                tabla.add(transaccionInfo); 
            }
            return tabla;
        }
     
	}	
	
}

