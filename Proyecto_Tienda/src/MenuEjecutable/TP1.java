package MenuEjecutable;

import javax.swing.JOptionPane;
import Archivos.*;

import Enumeradores.TalleLetras;

public class TP1 {

	public static void main(String[] args) {
		
		//Se levantan los metodos para crear carpetas, archivos si no existiesen y leer archivos en caso de existir.
		FicheroAccesorio.carpetaAccesorios();
		FicheroAccesorio.archivoAccesorios();
		FicheroIndumentaria.carpetaAccesorios();
		FicheroIndumentaria.archivoAccesorios();
		FicheroCalzado.carpetaAccesorios();
		FicheroCalzado.archivoAccesorios();
		FicheroAccesorio.leerFicheroAccesorio();
		FicheroIndumentaria.leerFicheroAccesorio();
		FicheroCalzado.leerFicheroAccesorio();
		Menu.mostrarMenu();
		
		
		//Codigo que fue enviado para el TP1, se comenta ya que en el TP2 solo se muestra una opcion de menu
		/*Scanner entrada = new Scanner (System.in);
		Usuarios admin = new Usuarios(); //los argumentos para instanciar los usuarios 
		Usuarios operador = new Usuarios(); //deberan ser traidos de una base de datos
		String usuario, clave;
		boolean flag;
		do
		{	
			System.out.println("Ingrese Usuario: ");
			usuario = entrada.nextLine();
			System.out.println("Ingrese Clave: ");
			clave = entrada.nextLine();
			if (usuario == admin.obtenerUsuario() && clave == admin.obtenerClave())
			{
				Menu.mostrarMenu(admin.obtenerPermiso(), admin.obtenerUsuario());
				flag = true;
			}
			else if (usuario == operador.obtenerUsuario() && clave == operador.obtenerClave())
			{
				Menu.mostrarMenu(operador.obtenerPermiso(), admin.obtenerUsuario());
				flag = true;
			}
			else
			{
				System.out.println("Credenciales incorrectas, reintente");
				flag = false;
			}
		}while (flag == false);*/
	}

}
