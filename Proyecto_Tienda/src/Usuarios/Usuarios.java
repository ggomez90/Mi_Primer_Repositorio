package Usuarios;
//La clase Usuarios queda dentro del paquete ya que fue parte del TP1, para el TP2 esta clase queda sin efecto, pasa a ser
//una opcion del programa "a desarrollar"

public class Usuarios {
	
	private String nombre;
	private String clave;
	private boolean administrador;
	
	
	//Constructor generico para la clase usuarios
	
	public Usuarios()
	{
		this.nombre = "admin";
		this.clave = "admin";
		this.administrador = true;
	}
	
	public String obtenerUsuario()
	{
		return this.nombre;
	}
	
	public String obtenerClave()
	{
		return this.clave;
	}
	
	public boolean obtenerPermiso()
	{
		return this.administrador;
	}
	
	public boolean ingresar (String nombre, String clave)
	//Metodo para ingresar
	{
		boolean flag = false;
		//Comprobar si el usuario y clave existen
		return flag;
	}
}
