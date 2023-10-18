package Supermercado;

public class Cliente {
	private String nombre;
	private int[] carroCompra;
	public Cliente(String n, int[] c)
	{
		nombre = n;
		carroCompra = c;
	}
	public String getNombre()
	{
		return this.nombre;
	}
	public int[] getCarroCompra()
	{
		return carroCompra;
	}
}