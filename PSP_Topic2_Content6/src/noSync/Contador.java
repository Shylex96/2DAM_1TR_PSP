package noSync;

public class Contador {
	private int c;
	Contador(int c)
	{
		this.c = c;
	}
	public void incrementa()
	{
		c = c + 1;
	}
	public void decrementa()
	{
		c = c - 1;
	}
	public int getValor()
	{
		return c;
	}
}