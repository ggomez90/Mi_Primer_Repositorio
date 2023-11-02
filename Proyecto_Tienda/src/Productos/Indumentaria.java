package Productos;

import java.util.*;
import javax.swing.JOptionPane;

import Archivos.Fichero;
import Archivos.FicheroIndumentaria;
import Enumeradores.*;
import Interfaces.*;

public class Indumentaria extends Productos implements Talles{

	//Lista estatica donde se almacenarán todos los objetos creados de la clase Indumentaria
	
		public static ArrayList<Indumentaria> ListaIndumentaria = new ArrayList<Indumentaria>();
		
		//Contador para llevar la cuenta de cuantos objetos se crean
		
		private static int contadorIndumentaria = 0;

		public static int mostrarContadorIndumentaria()
		{
			return contadorIndumentaria;
		}
		
		//Atributos de la clase Indumentaria
		
		private String talle;
		
		//Constructor de la clase Indumentaria
		
		public Indumentaria (int codigo, String marca, String detalle, double precio, int stock, String talle)
		{
			super(codigo, marca, detalle, precio, stock);
			this.talle = talle;
		}
		
		public String getTalle() {
			return talle;
		}

		private void setTalle(String talle) {
			this.talle = talle;
		}
		
		public void cambiarTalle()
		{
			setTalle(Productos.seleccionarTalleLetra());
		}

		//Metodo para crear un objeto Indumentaria

		public static void crearIndumentaria()
		{
			int codigo, stock;
			String marca, detalle, talle;
			double precio;
			Scanner entrada = new Scanner(System.in);
			codigo = Productos.ingresarNumeroEntero("Ingrese codigo.");
			System.out.println("Ingrese marca");
			marca = entrada.nextLine();
			System.out.println("Ingrese detalle");
			detalle = entrada.nextLine();
			talle = Productos.seleccionarTalleLetra();
			precio = Productos.ingresarNumeroDouble("Ingrese precio.");
			stock = Productos.ingresarNumeroEntero("Ingrese stock.");
			String aux = codigo+"$"+marca+"$"+detalle+"$"+precio+"$"+stock+"$"+talle;
			Indumentaria elemento = new Indumentaria (codigo, marca, detalle, precio, stock, talle);
			ListaIndumentaria.add(elemento);
			contadorIndumentaria++;
			Fichero.escribirArchivo(FicheroIndumentaria.fichero, aux);
		}
		
		//Metodo para crear objetos en forma automatica, se usará para traer los objetos de una base de datos al programa
		
		public static void crearIndumentariaAut(int codigo, String marca, String detalle,double precio,int stock,String talle)
		{
			Indumentaria elemento = new Indumentaria (codigo, marca, detalle, precio, stock, talle);
			ListaIndumentaria.add(elemento);
			contadorIndumentaria++;
		}
		
		//metodo polimorfico, redefine el de la super clase
		
		public void mostrarProductos()
		{
			super.mostrarProductos();
			System.out.println("Talle: " + talle);
		}
		
		//Metodo estatico para mostrar un listado completo de los objetos de tipo indumentaria
		
		public static void listarIndumentaria()
		{
			int indice = 1;
			System.out.println("Listado completo de indumentaria");
			for (Indumentaria elemento: ListaIndumentaria)
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
		
		public static void modificarIndumentaria()
		{
			int codigoBuscado = Productos.buscarCodigo();
			int indice = 0;
			boolean flag = false;
			for (Indumentaria elemento : ListaIndumentaria)
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
				System.out.println("Reingrese los datos nuevamente de la prenda.");
				int codigo, stock;
				String marca, detalle, talle;
				double precio;
				Scanner entrada = new Scanner(System.in);
				codigo = Productos.ingresarNumeroEntero("Ingrese codigo.");                                                                                                                                                   
				System.out.println("Ingrese marca");
				marca = entrada.nextLine();
				System.out.println("Ingrese detalle");
				detalle = entrada.nextLine();
				precio = Productos.ingresarNumeroDouble("Ingrese precio.");
				stock = Productos.ingresarNumeroEntero("Ingrese stock.");
				
				ListaIndumentaria.get(indice).setCodigo(codigo);
				ListaIndumentaria.get(indice).setMarca(marca);
				ListaIndumentaria.get(indice).setDetalle(detalle);
				ListaIndumentaria.get(indice).cambiarTalle();
				ListaIndumentaria.get(indice).setPrecio(precio);
				ListaIndumentaria.get(indice).setStock(stock);
				Fichero.eliminarArchivo(FicheroIndumentaria.fichero);
				FicheroIndumentaria.escribirFicheroAccesorio();
				System.out.println("Se ha actualizado correctamente su prenda.");
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
				for (Indumentaria elemento : ListaIndumentaria)
				{
					elemento.setPrecio(getPrecio() + (getPrecio() * porcentaje / 100));
				}
			}
			else
			{
				for (Indumentaria elemento : ListaIndumentaria)
				{
					elemento.setPrecio(getPrecio() - (getPrecio() * porcentaje / 100));
				}
			}
		}
		
		
}
