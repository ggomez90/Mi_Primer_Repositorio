package Clientes;

public class CuentaCorriente {
	
	private int codigoMovimiento;
	private int codigoCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String detalleMovimiento;
	private double debe;
	private double haber;
	private double saldo;
	private static int contadorMovimientos = 1;
	
	public CuentaCorriente(int codigoCliente, String nombre, String apellido, String detalle, double debe, double haber, double saldo)
	{
		this.contadorMovimientos = contadorMovimientos;
		this.codigoCliente = codigoCliente;
		this.nombreCliente = nombre;
		this.apellidoCliente = apellido;
		this.detalleMovimiento = detalle;
		this.debe = debe;
		this.haber = haber;
		this.saldo = saldo;
		contadorMovimientos++;
	}
	
	public void calcularSaldo(double debe, double haber)
	//metodo para calcular el saldo final de la cta cte de un cliente, sera invocado cada vez que se cree un objeto de este tipo
	{
		this.saldo = this.saldo - debe + haber;
	}

}
