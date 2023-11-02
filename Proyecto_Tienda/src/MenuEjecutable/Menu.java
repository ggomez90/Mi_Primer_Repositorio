package MenuEjecutable;
import Productos.*;

import java.util.Scanner;

public class Menu {
	
	private static int opcion;
	
	public static void mostrarMenu()
	{
		Scanner entrada = new Scanner (System.in);
		System.out.println("BIENVENIDO: ");
		while(true) {
				do{
					System.out.println("1-CONSULTA");			
					System.out.println("2-Alta");
					System.out.println("3-Modificacion");
					System.out.println("4-Venta");
					System.out.println("5-Recibo");
					System.out.println("6-Listado");
					System.out.println("0-SALIR");
					opcion = entrada.nextInt();
					entrada.nextLine();
				}while (opcion < 0 || opcion > 6);
				
				switch (opcion) {
					case 1:
						do {
							System.out.println("1-Calzado");			
							System.out.println("2-Indumentaria");
							System.out.println("3-Accesorio");
							System.out.println("0-VOLVER");
							opcion = entrada.nextInt();
							entrada.nextLine();
						}while(opcion < 0 || opcion > 3);
							switch(opcion)
							{
								case 1: Calzado.listarCalzado();
										break;
								case 2: Indumentaria.listarIndumentaria();
										break;
								case 3: Accesorios.listarAccesorios();
										break;
								case 4: break;
							}
						break;
						
					case 2: 
						do {
							System.out.println("1-Calzado");			
							System.out.println("2-Indumentaria");
							System.out.println("3-Accesorio");
							System.out.println("0-VOLVER");
							opcion = entrada.nextInt();
							entrada.nextLine();
						}while(opcion < 0 || opcion > 3);
							switch(opcion)
							{
								case 1: Calzado.crearCalzado();
										break;
								case 2: Indumentaria.crearIndumentaria();
										break;
								case 3: Accesorios.crearAccesorio();
										break;
								case 4: break;
							}
						break;
						
					case 3: 
						do {
							System.out.println("1-Calzado");			
							System.out.println("2-Indumentaria");
							System.out.println("3-Accesorio");
							System.out.println("0-VOLVER");
							opcion = entrada.nextInt();
							entrada.nextLine();
						}while(opcion < 0 || opcion > 3);
							switch(opcion)
							{
								case 1: Calzado.modificarCalzado();
										break;
								case 2: Indumentaria.modificarIndumentaria();
										break;
								case 3: Accesorios.modificarAccesorio();
										break;
								case 4: break;
							}
						break;
						
					case 4: System.out.println("Esta opcion del sistema se encuentra en desarrollo");
							break;
					
					case 5: System.out.println("Esta opcion del sistema se encuentra en desarrollo");
							break;
							
					case 6: System.out.println("Esta opcion del sistema se encuentra en desarrollo");
							break;
					
					case 0: System.exit(0);
				}

		}	
	}
}
