package Archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import Productos.Indumentaria;

public class FicheroIndumentaria {
	
	public static String carpeta = "src\\Archivos\\INDUMENTARIA";
	public static String fichero = "src\\Archivos\\INDUMENTARIA\\FicheroIndumentaria.txt";
	
	public static void carpetaAccesorios()
	{
		Fichero.crearCarpeta(carpeta);
	}
	
	public static void archivoAccesorios()
	{
		Fichero.crearArchivo(fichero);
	}
	
	public static void escribirFicheroAccesorio()
	{
		for (Indumentaria elemento: Productos.Indumentaria.ListaIndumentaria)
		{
			String aux = elemento.getCodigo() + "$" + elemento.getMarca() + "$" + elemento.getDetalle() + "$" + elemento.getPrecio() + "$" + elemento.getStock() + "$" + elemento.getTalle();
			Fichero.escribirArchivo(fichero, aux);
		}
	}
	
	public static void leerFicheroAccesorio()
	{
			File miArchivo = new File (fichero);
			
			try
			{
				BufferedReader lectura = new BufferedReader(new FileReader(miArchivo));
				String contenido = lectura.readLine();
				while (contenido != null)
				{
					String [] vectorContenido = contenido.split("[$]");
					Indumentaria elemento = new Indumentaria (Integer.parseInt(vectorContenido[0]), vectorContenido[1], vectorContenido[2], Double.parseDouble(vectorContenido[3]), Integer.parseInt(vectorContenido[4]), vectorContenido[5]);
					Indumentaria.ListaIndumentaria.add(elemento);
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
