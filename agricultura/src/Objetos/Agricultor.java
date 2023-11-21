package Objetos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;

import Mongo.AgricultorRepository;

public class Agricultor {
	private AgricultorRepository repository;

	Agricultor(){
		this.repository = new AgricultorRepository();
	}
	
	public void agregarAgricultor(String nombre, String apellido, int identificacion, int numero, String zona, String fecha) {
		repository.agregarAgricultor(nombre, apellido, identificacion, numero, zona, fecha);
	}
	
	public ArrayList<String>obtenerListaNombres()
	{
		return repository.obtenerListaNombres();
	}
	
	public List<List<String>> obtenerTablaAgricultor(){
		return repository.obtenerTablaAgricultor(); 
	}
}
