package Objetos;

import java.util.Date;

import javax.swing.text.Document;

import Mongo.InventarioRepository;

public class Inventario {
	private InventarioRepository repository; 
	
	Inventario(){
		this.repository = new InventarioRepository(); 
	}
	
	public void agregarCultivo(String cultivo, int costo, int cantidad, Date fecha, int porcentaje, String agricultor) {
		repository.agregarCultivo(cultivo, costo, cantidad, fecha, porcentaje, agricultor); 
	}
	
	
	public void venderCultivo(String cultivo, int cantidad) {
		if (!repository.confirmarCantidadEnInventario(cantidad, cultivo)) 
			repository.venderCultivo(cultivo, cantidad); 
	}
	
	public float calcularPrecioKilo(int cantidad, String cultivo)
	{
		if (!repository.confirmarCantidadEnInventario(cantidad, cultivo)) 
			return repository.calcularPrecioKilo(cultivo, cantidad); 
		else
			return 0; 
	}
	
}
