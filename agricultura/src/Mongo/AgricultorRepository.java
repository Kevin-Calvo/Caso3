package Mongo;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class AgricultorRepository {
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collection; 
	private static AgricultorRepository agricultorRepository = new AgricultorRepository(); 
	
	private AgricultorRepository() {
		 mongoClient = MongoClients.create("mongodb://localhost:27017"); //Conecta con mongo
	     database = mongoClient.getDatabase("Cooperativa");  //conecta con base de datos 
	     collection = database.getCollection("Agricultor"); //permite interaccion
	}
	
	static public AgricultorRepository getAgricultorRepository() {
		return agricultorRepository; 
	}
	
	public void escribir(String nombre, String apellido, int identificacion, int numero, String zona, String fecha) {
		     
		 Document document = new Document("nombre", nombre)
				 .append("apellido", apellido)//Crea tipo de dato a guardar en mongo
                 .append("identificacion", identificacion)
                 .append("numeroTelefonico", numero)
                 .append("zona", zona)
                 .append("fechaRegistro", fecha);
         collection.insertOne(document); //Mete dato en Mongo

         System.out.println("Documento insertado correctamente."); //Confirma insercion
	}
	
	public void actualizar(String nombre, String apellido, int identificacion, int numero, String zona, String fecha) {
		Document filtro = new Document("numeroTelefonico", numero);
		Document campos = new Document("nombre",nombre)
				.append("apellido",  apellido)
				.append("identificacion", identificacion)
                .append("numeroTelefonico", numero)
                .append("zona", zona)
                .append("fechaRegistro", fecha);
		Document actualizacion = new Document("$set", campos);
		collection.updateOne(filtro, actualizacion);
		
		System.out.println("Documento actualizado");
	}
	
	public void eliminar(int numero) {
		Document filtro = new Document("numeroTelefonico", numero);
		
		collection.deleteOne(filtro);
	}
	
	public void getDato(String dato, int numero)
	{
		Document filtro = new Document("numeroTelefonico", numero);
		Document buscado = collection.find(filtro).first();
		
		if (buscado != null) {
			
			if (dato == "identificacion") {
				int datoEncontrado = buscado.getInteger(dato); 
				System.out.println(datoEncontrado);
			}
			else {
				String datoEncontrado = buscado.getString(dato);
				System.out.println(datoEncontrado);
			}	
		}
		else {
			System.out.println("No se encontro un agricultor con ese numero telefonico"); 
		}
	}
	

}
