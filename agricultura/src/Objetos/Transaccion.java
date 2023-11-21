package Objetos;

import java.util.Date;
import java.util.List;

import Mongo.TransaccionRepository;

public class Transaccion {
	private TransaccionRepository repository; 
	
	Transaccion(){
		this.repository = new TransaccionRepository();
	}
	
	public void agregarTransaccion(Date fecha, String agricultor, String producto, int precioU, int cantidad, int total) {
		repository.agregarTransaccion(fecha, agricultor, producto, precioU, cantidad, total); 
	}
	
	public List<List<String>> obtenerListaTransacciones(){
		return repository.obtenerListaTransacciones();
	}
}
