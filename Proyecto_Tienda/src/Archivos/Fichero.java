package Archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Fichero {
	
	//metodo para crear una carpeta en una ruta especifica que vendra por parametro
	public static void crearCarpeta (String ruta)
	{
		File miArchivo = new File (ruta);
		if (miArchivo.exists() == false)
		{
			miArchivo.mkdir();
		}
	}
	
	//metodo para crear un archivo en una ruta especifica que vendra por parametro
	public static void crearArchivo(String ruta)
	{
		File miArchivo = new File (ruta);
		
		if (miArchivo.exists() == false)
		{
			try
			{
				PrintWriter salida = new PrintWriter(miArchivo);
				salida.close();
			}
			catch (FileNotFoundException error)
			{
				System.out.println(error.getMessage());
			}
		}
	}
	
	//metodo general para escribir un archivo con la ruta y un string por parametro
	public static void escribirArchivo(String ruta, String contenido)
	{
		File miArchivo = new File (ruta);
		
		try
		{
			PrintWriter escritura = new PrintWriter(new FileWriter(miArchivo, true));
			escritura.println(contenido);
			escritura.close();
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
	
	//metodo para eliminar el contenido de un archivo
	public static void eliminarArchivo(String ruta)
	{
		File miArchivo = new File (ruta);
		if (miArchivo.exists() == true)
		{
			miArchivo.delete();
			System.out.println("Se ha eliminado correctamente el archivo.");
		}
		else
		{
			System.out.println("No se elimino nada porque no existe.");
		}
	}

}
