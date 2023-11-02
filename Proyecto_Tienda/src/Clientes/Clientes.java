package Clientes;

public class Clientes {

	private int codigo;
	private String nombre;
	private String apellido;
	private String razonSocial;
	private String dniCuitCuil;
	private String direccion;
	private String contacto;
	private static int contadorCodigo = 1;
	
	public Clientes (String nombre, String apellido, String razonSocial, String dniCuitCuil, String direccion, String contacto)
	//Constructor para cargar el estado inicial de la instancia, el codigo lo provee el mismo programa. 
	{
		this.codigo = contadorCodigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.razonSocial = razonSocial;
		this.dniCuitCuil = dniCuitCuil;
		this.direccion = direccion;
		this.contacto = contacto;
		contadorCodigo++;
	}
	
	public void modificarNombre(String nombre)
	//metodos para modificar datos de la instancia
	{
		this.nombre = nombre;
	}
}