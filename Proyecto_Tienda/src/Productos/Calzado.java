package Productos;

import java.util.*;

import Archivos.Fichero;
import Archivos.FicheroCalzado;
import Interfaces.Talles;

public class Calzado extends Productos implements Talles{
	
	//Lista estatica donde se almacenarán todos los objetos creados de la clase Calzado
	
	public static ArrayList<Calzado> ListaCalzado = new ArrayList<Calzado>();
	
	//Contador para llevar la cuenta de cuantos objetos se crean
	
	private static int contadorCalzados = 0;

	public static int mostrarContadorCalzados()
	{
		return contadorCalzados;
	}
	
	//Atributos de la clase Calzado
	
	private int talle;
	
	//Constructor de la clase Calzado
	
	public Calzado (int codigo, String marca, String detalle, double precio, int stock, int talle)
	{
		super(codigo, marca, detalle, precio, stock);
		this.talle = talle;
	}
	
	public int getTalle() {
		return talle;
	}

	private void setTalle(int talle) {
		this.talle = talle;
	}
	
	public void cambiarTalle()
	{
		setTalle(Productos.seleccionarTalleNumero());
	}

	//Metodo para crear un objeto calzado, se usará para que el cliente cree objetos de este tipo.

	public static void crearCalzado()
	{
		int codigo, stock, talle;
		String marca, detalle;
		double precio;
		Scanner entrada = new Scanner(System.in);
		codigo = Productos.ingresarNumeroEntero("Ingrese codigo.");
		System.out.println("Ingrese marca");
		marca = entrada.nextLine();
		System.out.println("Ingrese detalle");
		detalle = entrada.nextLine();
		talle = Productos.seleccionarTalleNumero();
		precio = Productos.ingresarNumeroDouble("Ingrese precio.");
		stock = Productos.ingresarNumeroEntero("Ingrese stock.");
		String aux = codigo+"$"+marca+"$"+detalle+"$"+precio+"$"+stock+"$"+talle;
		Calzado elemento = new Calzado (codigo, marca, detalle, precio, stock, talle);
		ListaCalzado.add(elemento);
		contadorCalzados++;
		Fichero.escribirArchivo(FicheroCalzado.fichero, aux);
	}
	
	//Metodo para crear objetos en forma automatica, se usará para traer los objetos de una base de datos al programa
	
	public static void crearCalzadoAut(int codigo, String marca, String detalle, double precio, int stock, int talle)
	{		
		Calzado elemento = new Calzado (codigo, marca, detalle, precio, stock, talle);
		ListaCalzado.add(elemento);
		contadorCalzados++;
	}
	
	//metodo polimorfico, redefine el de la super clase
	
	public void mostrarProductos()
	{
		super.mostrarProductos();
		System.out.println("Talle: " + talle);
	}
	
	//Metodo estatico para mostrar un listado completo de los objetos de tipo calzado
	
	public static void listarCalzado()
	{
		int indice = 1;
		System.out.println("Listado completo de Calzado");
		for (Calzado elemento: ListaCalzado)
		{
			System.out.println("-------------------------");
			System.out.println("Elemento: " + indice);
			elemento.mostrarProductos();
			System.out.println("\n");
			indice++;
		}
	}
	
	//Metodo que recorrerá toda la lista de accesorios buscando alguna coicidencia de codigo, en caso de encontrar
	//se tomará el indice y se utilizará para modificar el registro en la lista, solicitando nuevamente todos los datos del objeto
	
	public static void modificarCalzado()
	{
		int codigoBuscado = Productos.buscarCodigo();
		int indice = 0;
		boolean flag = false;
		for (Calzado elemento : ListaCalzado)
		{
			if (elemento.getCodigo() == codigoBuscado)
			{
				flag = true;
				break;
			}
			indice++;
		}
		if (flag == true)
		{
			System.out.println("Reingrese los datos nuevamente del Calzado.");
			int codigo, stock, talle;
			String marca, detalle;
			double precio;
			Scanner entrada = new Scanner(System.in);
			codigo = Productos.ingresarNumeroEntero("Ingrese codigo.");
			System.out.println("Ingrese marca");
			marca = entrada.nextLine();
			System.out.println("Ingrese detalle");
			detalle = entrada.nextLine();
			precio = Productos.ingresarNumeroDouble("Ingrese precio.");
			stock = Productos.ingresarNumeroEntero("Ingrese stock.");
			
			ListaCalzado.get(indice).setCodigo(codigo);
			ListaCalzado.get(indice).setMarca(marca);
			ListaCalzado.get(indice).setDetalle(detalle);
			ListaCalzado.get(indice).cambiarTalle();
			ListaCalzado.get(indice).setPrecio(precio);
			ListaCalzado.get(indice).setStock(stock);
			Fichero.eliminarArchivo(FicheroCalzado.fichero);
			FicheroCalzado.escribirFicheroAccesorio();
			System.out.println("Se ha actualizado correctamente su Calzado.");
		}
		else
		{
			System.out.println("No se ha encontrado coincidencia");
		}
	}
	
	public void subaPreciosGlobal()
	{
		double porcentaje = Productos.ingresarNumeroDouble("Ingrese porcentaje a subir o disminuir.");
		if (porcentaje >= 0)
		{
			for (Calzado elemento : ListaCalzado)
			{
				elemento.setPrecio(getPrecio() + (getPrecio() * porcentaje / 100));
			}
		}
		else
		{
			for (Calzado elemento : ListaCalzado)
			{
				elemento.setPrecio(getPrecio() - (getPrecio() * porcentaje / 100));
			}
		}
	}
	
}
