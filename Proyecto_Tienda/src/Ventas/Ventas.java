package Ventas;
import java.util.*;
public class Ventas {
	
	private int codigo;
	private Date fecha;
	private int codigoCliente;
	private String nombre;
	private String apellido;
	private int codigoProducto;
	private String detalleProducto;
	private int cantidad;
	private double precioUnidad;
	private double precioTotal;
	private static int contadorVentas = 1;
	
	public Ventas (Date fecha, int codigoCliente, String nombre, String apellido, int codigoProducto, String detalleProducto, 
	int cantidad, double precioUnidad, double precioTotal)
	{
		this.codigo = contadorVentas;
		this.fecha = fecha;
		this.codigoCliente = codigoCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.codigoProducto = codigoProducto;
		this.detalleProducto = detalleProducto;
		this.cantidad = cantidad;
		this.precioUnidad = precioUnidad;
		this.precioTotal = precioTotal;
		contadorVentas++;
	}

}
