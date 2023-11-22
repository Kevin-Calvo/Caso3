package Objetos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 

public class SistemaCentralizado {
private Agricultor agricultor;
private Inventario inventario;
private Producto producto;
private Transaccion transaccion;
private static SistemaCentralizado sistema = new SistemaCentralizado();

	private SistemaCentralizado() {
		this.agricultor = new Agricultor();
		this.inventario = new Inventario();
		this.producto = new Producto();
		this.transaccion = new Transaccion(); 
	}
	
	static public SistemaCentralizado getSistemaCentralizado() {
		if (sistema == null) {
			SistemaCentralizado instance = new SistemaCentralizado();
		}
		return sistema; 
	}
	
	public void AgregarCultivoAIventarioYTransaccion(String cultivo, int costo, int cantidad, Date cosecha, int porcentaje, String agricultorNombre) {
		inventario.agregarCultivo(cultivo, costo, cantidad, cosecha, porcentaje, agricultorNombre);
		transaccion.agregarTransaccion(new Date(), agricultorNombre, cultivo, costo, cantidad, costo*cantidad*-1);  
	}

	public void AgregarProducto(String nombre) {
		producto.agregarProducto(nombre); 
	}

	public void VenderCultivo(String cultivo, int cantidad) {
		inventario.venderCultivo(cultivo, cantidad);  
	}
	
	public float calcularPrecioXKilo(String cultivo, int cantidad) {
		return inventario.calcularPrecioKilo(cantidad, cultivo); 
	}

	public void agregarAgricultor(String nombre, String apellidos, int identificacion, int numero, String zona, String fecha) {
		agricultor.agregarAgricultor(nombre, apellidos, identificacion, numero, zona, fecha); 
	}

	public void agregarTransaccion(Date fecha, String agricultorNombre, String productoNombre, int precioU, int cantidad, int total) {
		transaccion.agregarTransaccion(fecha, agricultorNombre, productoNombre, precioU, cantidad, total); 
	}

	public ArrayList<String> obtenerListaNombreAgricultor() {
	return agricultor.obtenerListaNombres();
	}

	public ArrayList<String> obtenerListaNombreProducto() {
	return producto.obtenerListaProductos();
	}

	public  String[][] mostrarAgricultoresTabla() {
		String[][] tablaAgricultores = convertListListToStringArray(agricultor.obtenerTablaAgricultor());
		return tablaAgricultores;
	}

	public  String[][] mostrarTransaccionesTabla() {
		String[][] tablaTransacciones = convertListListToStringArray(transaccion.obtenerListaTransacciones());
		return tablaTransacciones;
	}

	public static String[][] convertListListToStringArray(List<List<String>> listOfLists) { 
	    int numRows = listOfLists.size();
	    int maxCols = 0;

	    // Obtener el número máximo de columnas
	    for (List<String> list : listOfLists) {
	        maxCols = Math.max(maxCols, list.size());
	    }

	    // Crear la matriz resultante
	    String[][] stringArray = new String[numRows][maxCols];

	    // Rellenar la matriz con los valores de la lista de listas
	    for (int i = 0; i < numRows; i++) {
	        List<String> currentList = listOfLists.get(i);
	        for (int j = 0; j < currentList.size(); j++) {
	            stringArray[i][j] = currentList.get(j);
	        }
	    }

	    return stringArray;
	}
}
