package Mongo;
import com.mongodb.client.MongoClients;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class conector {
	
	public void escribir(String name, int age, String city) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {  //Conecta con Mongo
            MongoDatabase database = mongoClient.getDatabase("testdb"); //Conecta con base de datos
            MongoCollection<Document> collection = database.getCollection("testcollection"); //permite interaccion

            Document document = new Document("name", name) //Crea tipo de dato a guardar en mongo
                    .append("age", age)
                    .append("city", city);
            collection.insertOne(document); //Mete dato en Mongo

            System.out.println("Documento insertado correctamente."); //Confirma insercion
        } catch (Exception e) {
            System.err.println("Error al escribir en la base de datos: " + e.getMessage()); //Atrapa en caso de error
        }
    }
	
	public void leer() { 
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) { //Conecta con mongo
            MongoDatabase database = mongoClient.getDatabase("testdb");  //conecta con base de datos
            MongoCollection<Document> collection = database.getCollection("testcollection"); //permite interaccion

            FindIterable<Document> documents = collection.find(); //busca documentos
            for (Document doc : documents) { //imprime la informacion de todos los documentos
                System.out.println(doc.toJson());
                

            }
            } catch (Exception e) {
            System.err.println("Error al leer desde la base de datos: " + e.getMessage()); //Atrapa en caso de error
        }
    } 

}
