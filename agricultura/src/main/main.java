package main;
import com.mongodb.client.MongoClients;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import Mongo.*;
import UISistema.MenuPrincipal;

public class main {

	public static void main(String[] args) {
		RepositoryFacade repository= RepositoryFacade.getRepositoryFacade(); 
		
		MenuPrincipal menu = new MenuPrincipal(); 
		menu.setVisible(true); 
		
	}
}
