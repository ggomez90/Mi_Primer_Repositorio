package Productos;

import java.util.*;

import Archivos.Fichero;
import Archivos.FicheroAccesorio;

//Hereda de Productos

public class Accesorios extends Productos{
	
	//Lista estatica donde se almacenarán todos los objetos creados de la clase Accesorios
	
	public static ArrayList<Accesorios> ListaAccesorios = new ArrayList<Accesorios>();
	
	//Contador para llevar la cuenta de cuantos objetos se crean
	
	private static int contadorAccesorios = 0;

	public static int mostrarContadorAccesorios()
	{
		return contadorAccesorios;
	}
	
	//Solo un atributo propio de esta clase
	
	private String categoriaUso;
	
	//Constructor
	
	public Accesorios (int codigo, String marca, String detalle, double precio, int stock, String categoriaUso)
	{
		super(codigo, marca, detalle, precio, stock);
		this.categoriaUso = categoriaUso;
	}
	
	//Set y get para el unico atributo propio

	public String getCategoriaUso() {
		return categoriaUso;
	}

	public void setCategoriaUso(String categoriaUso) {
		this.categoriaUso = categoriaUso;
	}
	
	//Metodo para crear objetos

	public static void crearAccesorio() {
		int codigo, stock;
		String marca, detalle, categoriaUso;
		double precio;
		Scanner entrada = new Scanner(System.in);
		codigo = Productos.ingresarNumeroEntero("Ingrese codigo.");
		System.out.println("Ingrese marca");
		marca = entrada.nextLine();
		System.out.println("Ingrese detalle");
		detalle = entrada.nextLine();
		System.out.println("Ingrese categoria de uso");
		categoriaUso = entrada.nextLine();
		precio = Productos.ingresarNumeroDouble("Ingrese precio.");
		stock = Productos.ingresarNumeroEntero("Ingrese stock.");
		String aux = codigo+"$"+marca+"$"+detalle+"$"+precio+"$"+stock+"$"+categoriaUso;
		Accesorios elemento = new Accesorios (codigo, marca, detalle, precio, stock, categoriaUso);
		ListaAccesorios.add(elemento);
		contadorAccesorios++;
		Fichero.escribirArchivo(FicheroAccesorio.fichero, aux);
	}
	
	//Metodo para crear objetos en forma automatica, se usará para traer los objetos de una base de datos al programa
	
	public static void crearAccesorioAut(int codigo,String marca,String detalle,double precio,int stock,String categoriaUso) 
	{		
		Accesorios elemento = new Accesorios (codigo, marca, detalle, precio, stock, categoriaUso);
		ListaAccesorios.add(elemento);
		contadorAccesorios++;
	}
	
	//metodo polimorfico, redefine el de la super clase
	
	public void mostrarProductos()
	{
		super.mostrarProductos();
		System.out.println("Categoria de uso: " + categoriaUso);
	}
	
	//Metodo estatico para mostrar un listado completo de los objetos de tipo Accesorios
	
	public static void listarAccesorios()
	{
		int indice = 1;
		System.out.println("Listado completo de Accesorios");
		for (Accesorios elemento: ListaAccesorios)
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
	
	public static void modificarAccesorio()
	{
		int codigoBuscado = Productos.buscarCodigo();
		int indice = 0;
		boolean flag = false;
		for (Accesorios elemento : ListaAccesorios)
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
			System.out.println("Reingrese los datos nuevamente del Accesorio.");
			int codigo, stock;
			String marca, detalle, categoriaUso;
			double precio;
			Scanner entrada = new Scanner(System.in);
			codigo = Productos.ingresarNumeroEntero("Ingrese codigo.");
			System.out.println("Ingrese marca");
			marca = entrada.nextLine();
			System.out.println("Ingrese detalle");
			detalle = entrada.nextLine();
			System.out.println("Ingrese categoria de uso");
			categoriaUso = entrada.nextLine();
			precio = Productos.ingresarNumeroDouble("Ingrese precio.");
			stock = Productos.ingresarNumeroEntero("Ingrese stock.");
			
			ListaAccesorios.get(indice).setCodigo(codigo);
			ListaAccesorios.get(indice).setMarca(marca);
			ListaAccesorios.get(indice).setDetalle(detalle);
			ListaAccesorios.get(indice).setCategoriaUso(categoriaUso);
			ListaAccesorios.get(indice).setPrecio(precio);
			ListaAccesorios.get(indice).setStock(stock);
			Fichero.eliminarArchivo(FicheroAccesorio.fichero);
			FicheroAccesorio.escribirFicheroAccesorio();
			System.out.println("Se ha actualizado correctamente su Accesorio.");
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
			for (Accesorios elemento : ListaAccesorios)
			{
				elemento.setPrecio(getPrecio() + (getPrecio() * porcentaje / 100));
			}
		}
		else
		{
			for (Accesorios elemento : ListaAccesorios)
			{
				elemento.setPrecio(getPrecio() - (getPrecio() * porcentaje / 100));
			}
		}
	}

}
