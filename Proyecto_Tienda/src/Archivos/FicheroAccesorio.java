package Archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import Productos.Accesorios;

public class FicheroAccesorio {
	
	
	//atributos estaticos para crear una carpeta y un archivo en una ruta especifica
	public static String carpeta = "src\\Archivos\\ACCESORIOS";
	public static String fichero = "src\\Archivos\\ACCESORIOS\\FicheroAccesorios.txt";
	
	public static void carpetaAccesorios()
	{
		Fichero.crearCarpeta(carpeta);
	}
	
	public static void archivoAccesorios()
	{
		Fichero.crearArchivo(fichero);
	}
	
	
	//metodo para escribir un archivo por completo desde , recorriendo la lista de elementos completa  grabando el archivo, antes de utilizar este metodo se debe borrar el contenido actual del archivo
	public static void escribirFicheroAccesorio()
	{
		for (Accesorios elemento: Productos.Accesorios.ListaAccesorios)
		{
			//se utiliza el simbolo $ para separar los atributos formando una cadena que pasara por parametro al metodo escribir
			String aux = elemento.getCodigo() + "$" + elemento.getMarca() + "$" + elemento.getDetalle() + "$" + elemento.getPrecio() + "$" + elemento.getStock() + "$" + elemento.getCategoriaUso();
			Fichero.escribirArchivo(fichero, aux);
		}
	}
	
	//metodo para leer linea por linea un fichero e ir creando una instancia por cada linea leida y almacenando en la lista
	public static void leerFicheroAccesorio()
	{
			File miArchivo = new File (fichero);
			
			try
			{
				BufferedReader lectura = new BufferedReader(new FileReader(miArchivo));
				String contenido = lectura.readLine();
				while (contenido != null)
				{
					//Se utiliza el metodo split para buscar el caracter $ e ir cortando la cadena para crear valores almacenados en un vector para luego pasar por parametros para crear la instancia
					String [] vectorContenido = contenido.split("[$]");
					Accesorios elemento = new Accesorios (Integer.parseInt(vectorContenido[0]), vectorContenido[1], vectorContenido[2], Double.parseDouble(vectorContenido[3]), Integer.parseInt(vectorContenido[4]), vectorContenido[5]);
					Accesorios.ListaAccesorios.add(elemento);
					contenido = lectura.readLine();
				}
				lectura.close();
			}
			catch (FileNotFoundException error)
			{
				System.out.println(error.getMessage());
			}
			catch ( IOException error)
			{
				System.out.println(error.getMessage());
			}
	}
}
