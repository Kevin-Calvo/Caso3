package Mongo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.*; 

public class AgricultorRepository{
	
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collection;

	public AgricultorRepository() {
		 mongoClient = MongoClients.create("mongodb://localhost:27017"); //Conecta con mongo
	     database = mongoClient.getDatabase("Cooperativa");  //conecta con base de datos 
	     collection = database.getCollection("Agricultor"); //permite interaccion
	}

	public void agregarAgricultor(String nombre, String apellido, int identificacion, int numero, String zona, String fecha) {
	     
		 Document document = new Document("nombre", nombre)
				 .append("apellido", apellido)//Crea tipo de dato a guardar en mongo
               .append("identificacion", identificacion)
               .append("numeroTelefonico", numero)
               .append("zona", zona)
               .append("fechaRegistro", fecha);
       collection.insertOne(document); //Mete dato en Mongo

	}
	
	public ArrayList<String> obtenerListaNombres()
	{
		ArrayList<String> lista_agricultor = new ArrayList<>();
		FindIterable<Document> documents =  collection.find().sort(new Document("nombre", 1));

		for (Document documento : documents) {
			String nombre =documento.getString("nombre");
			String apellido = documento.getString("apellido");
			lista_agricultor.add(nombre+" "+apellido);
			
			}
		
		return lista_agricultor ; 
		
	}
	
	public List<List<String>> obtenerTablaAgricultor(){
		List<List<String>> tabla = new ArrayList<>();
		
		FindIterable<Document> sortedDocuments = collection.find().sort(new Document("nombre", 1));
		Iterator<Document> iterator = sortedDocuments.iterator();
		
        for (Document agricultorDocumento : sortedDocuments) {
            List<String> agricultorInfo = new ArrayList<>();	
            agricultorInfo.add(agricultorDocumento.getString("nombre"));
            agricultorInfo.add(agricultorDocumento.getString("apellido"));
            agricultorInfo.add(String.valueOf(agricultorDocumento.getInteger("identificacion")));
            agricultorInfo.add(String.valueOf(agricultorDocumento.getInteger("numeroTelefonico")));
            agricultorInfo.add(agricultorDocumento.getString("zona"));
            agricultorInfo.add(agricultorDocumento.getString("fechaRegistro"));
            tabla.add(agricultorInfo); 
        }
        
        return tabla;
	}

	
}
