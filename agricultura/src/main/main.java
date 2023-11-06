package main;
import com.mongodb.client.MongoClients;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import Mongo.AgricultorRepository;
import UISistema.MenuPrincipal;

public class main {

	public static void main(String[] args) {
		
		AgricultorRepository agricultorRepository = AgricultorRepository.getAgricultorRepository();
		agricultorRepository.escribir("Kevin",  "Calvo Rodriguez", 119030042, 83453888, "Cartago", "5/11/2023");
		//agricultorRepository.actualizar("Andres", "Arroyo", 1, 83453888, "San Jose", "31/10/2023");
		//agricultorRepository.eliminar(83453888); 
		agricultorRepository.getDato("fechaRegistro", 83453888);
		
		MenuPrincipal menu = new MenuPrincipal(); 
		menu.setVisible(true); 
		

	}
}
