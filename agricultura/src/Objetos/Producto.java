package Objetos;

import java.util.ArrayList;

import Mongo.ProductoRepository;

public class Producto {
private ProductoRepository repository; 

	Producto(){
		this.repository = new ProductoRepository();
	}
	
	public void agregarProducto(String nombre) {
		repository.agregarProducto(nombre); 
	}
	
	public ArrayList<String> obtenerListaProductos(){
		return repository.obtenerListaProductos(); 
	}
}
