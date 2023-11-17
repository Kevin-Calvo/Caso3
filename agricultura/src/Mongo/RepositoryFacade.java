package Mongo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class RepositoryFacade {
private AgricultorRepository agricultor;
private InventarioRepository inventario;
private TransaccionRepository transaccion;
private ProductoRepository producto;
private static RepositoryFacade repository = new RepositoryFacade();

private RepositoryFacade() {		
   this.agricultor = new AgricultorRepository();   
   this.inventario =  new InventarioRepository();
   this.transaccion = new TransaccionRepository();
   this.producto = new ProductoRepository();
}

static public RepositoryFacade getRepositoryFacade() {
	if (repository == null) {
		RepositoryFacade instance = new RepositoryFacade();
	}
	
	return repository; 
}

public void AgregarCultivo(String cultivo, int costo, int cantidad, Date cosecha, int porcentaje, String agricultorNombre) {
	inventario.agregarCultivo(cultivo, costo, cantidad, cosecha, porcentaje, agricultorNombre);
}

public void AgregarProducto(String nombre) {
	producto.agregarProducto(nombre); 
}

public void VenderCultivo(String cultivo, int cantidad) {
	if (inventario.confirmarCantidadEnInventario(cantidad)) 
		inventario.venderCultivo(cultivo, cantidad); 
	else
		System.out.println("No hay suficientes cultivos"); 
}

public void agregarAgricultor(String nombre, String apellidos, int identificacion, int numero, String zona, String fecha) {
	agricultor.agregarAgricultor(nombre, apellidos, identificacion, numero, zona, fecha); 
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
