package Controllers;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import Objetos.SistemaCentralizado;

public class VenderController {
	private SistemaCentralizado sistema = SistemaCentralizado.getSistemaCentralizado();
	private boolean preciosCalculados = false;
	private float costoXunidad;
	private float valorTotal;
	
	public VenderController(){};
	
	public String[] obtenerListaNombreProductos() {
		ArrayList<String> listaProducto = sistema.obtenerListaNombreProducto();
		return  listaProducto.toArray(new String[listaProducto.size()]);
	}
	
	public void CalcularPrecioYGanancia(JComboBox cultivoComboBox, JSpinner cantidadSpinner, JLabel costoUnidad, JLabel total, JLabel gananciaCoope, JLabel gananciaAgri) {
		String cultivo = (String) cultivoComboBox.getSelectedItem();
		int cantidad = (int) cantidadSpinner.getValue(); 
		costoXunidad = sistema.calcularPrecioXKilo(cultivo, cantidad); 
		valorTotal = (costoXunidad * cantidad) * 2; 
		float gananciaAgricultorValor = sistema.gananciaAgricultor(cultivo, cantidad); 
		float gananciaCoopeValor = (valorTotal / 2) - gananciaAgricultorValor;
		if (costoXunidad != 0)
		{
			costoUnidad.setText(String.valueOf(costoXunidad));    
			total.setText(String.valueOf(valorTotal)); 
			gananciaCoope.setText(String.valueOf(gananciaCoopeValor));
			
			gananciaAgri.setText(String.valueOf(gananciaAgricultorValor)); 
			preciosCalculados = true;
		}

	}
	
	public void Vender(JComboBox cultivoComboBox, JSpinner cantidadSpinner, JLabel costoUnidad, JLabel total, JLabel gananciaCoope, JLabel gananciaAgri) {
		if (preciosCalculados)
		{
			String cultivo = (String) cultivoComboBox.getSelectedItem();
			int cantidad = (int) cantidadSpinner.getValue(); 
			sistema.VenderCultivo(cultivo, cantidad);
			total.setText("");
			costoUnidad.setText("");
			gananciaAgri.setText("");
			gananciaCoope.setText("");
			preciosCalculados = false; 
		}

	}
}
