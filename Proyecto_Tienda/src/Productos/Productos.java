package Productos;

import java.util.Scanner;

import javax.swing.JOptionPane;

import Enumeradores.TalleLetras;
import Interfaces.Precios;

public abstract class Productos implements Precios {
	
	//Atributos para super clase productos
	
	private int codigo;
	private String marca;
	private String detalle;
	private double precio;
	private int stock;
	
	//Constructor para super clase productos
	
	public Productos(int codigo, String marca, String detalle, double precio, int stock) 
	{
		this.codigo = codigo;
		this.marca = marca;
		this.detalle = detalle;
		this.precio = precio;
		this.stock = stock;
	}
	
	//Metodos setters y getters para la clase productos

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void mostrarProductos()
	{
		System.out.println("Codigo: " + this.codigo);
		System.out.println("Marca: " + this.marca);
		System.out.println("Detalle: " + this.detalle);
		System.out.println("Precio: " + this.precio);
		System.out.println("Stock: " + this.stock);
	}
	
	public static int buscarCodigo()
	{
		int codigoBuscado = ingresarNumeroEntero("Ingrese codigo a buscar.");
		return codigoBuscado;
	}
	
	public static String seleccionarTalleLetra()
	{
		String[] talles = new String[9];
		talles[0] = TalleLetras.DOBLE_EXTRA_SMALL.getAbreviatura();
		talles[1] = TalleLetras.EXTRA_SMALL.getAbreviatura();
		talles[2] = TalleLetras.SMALL.getAbreviatura();
		talles[3] = TalleLetras.MEDIUM.getAbreviatura();
		talles[4] = TalleLetras.BIG.getAbreviatura();
		talles[5] = TalleLetras.EXTRA_BIG.getAbreviatura();
		talles[6] = TalleLetras.DOBLE_EXTRA_BIG.getAbreviatura();
		talles[7] = TalleLetras.TRIPLE_EXTRA_BIG.getAbreviatura();
		talles[8] = TalleLetras.ESPECIAL.getAbreviatura();
		
		String respuesta = (String) JOptionPane.showInputDialog(null, "SELECCIONE UN TALLE", "ALTA DE INDUMENTARIA", JOptionPane.DEFAULT_OPTION, null, talles, talles[0]);
		return respuesta;
	}
	
	public static int seleccionarTalleNumero()
	{
		String[] talles = new String [60];
		for (int i=0; i<60; i++)
		{
			talles[i] = Integer.toString(i+1);
		}
		int respuesta = Integer.parseInt((String) JOptionPane.showInputDialog(null, "SELECCIONE UN TALLE", "ALTA DE INDUMENTARIA", JOptionPane.DEFAULT_OPTION, null, talles, talles[0]));
		return respuesta;
	}
	
	//Metodo para tratamiento de excepciones cuando se solicite valores numericos
	
	public static boolean esNumeroEntero(String cadena) {
        boolean flag;
        try {
            Integer.parseInt(cadena);
            flag = true;
        } 
        catch (NumberFormatException e) {
            flag = false;
        }
        return flag;
    }
	
	public static boolean esNumeroDouble(String cadena) {
        boolean flag;
        try {
            Double.parseDouble(cadena);
            flag = true;
        } 
        catch (NumberFormatException e) {
            flag = false;
        }
        return flag;
    }
	
	//se utilizara este metodo para asegurar el ingreso de un numero entero
	
	public static int ingresarNumeroEntero(String leyenda)
	{
		int numero;
		String auxiliar;
		Scanner entrada = new Scanner (System.in);
		System.out.println(leyenda);
		auxiliar = entrada.nextLine();
		while (esNumeroEntero(auxiliar) == false)
		{
			System.out.println("ERROR: " + leyenda);
			auxiliar = entrada.nextLine();
		}
		if (esNumeroEntero(auxiliar) == true)
		{
			numero = Integer.parseInt(auxiliar);
		}
		else
		{
			System.out.println("ERROR: Se asigna 0 por default");
			numero = 0;
		}
		return numero;
	}
	
	//similar metodo para asegurar el ingreso de un valor double
	
	public static double ingresarNumeroDouble(String leyenda)
	{
		double numero;
		String auxiliar;
		Scanner entrada = new Scanner (System.in);
		System.out.println(leyenda);
		auxiliar = entrada.nextLine();
		while (esNumeroDouble(auxiliar) == false)
		{
			System.out.println("ERROR: " + leyenda);
			auxiliar = entrada.nextLine();
		}
		if (esNumeroDouble(auxiliar) == true)
		{
			numero = Double.parseDouble(auxiliar);
		}
		else
		{
			System.out.println("ERROR: Se asigna 0 por default");
			numero = 0;
		}
		return numero;
	}
	
}
