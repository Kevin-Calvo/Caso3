package main;
import com.mongodb.client.MongoClients;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import Mongo.conector; 

public class main {

	public static void main(String[] args) {
        
		conector linker = new conector(); //Conector con Mongo
		
		linker.escribir("Andres" , 19 , "Concepcion"); //Funcion escribir en Mongo
		linker.leer(); //Funcion leer de Mongo
	}
}
