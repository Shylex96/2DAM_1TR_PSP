package sync;

public class HiloBSincronizado extends Thread
{
	private Contador contador;
	public HiloBSincronizado(String n, Contador c)
	{
		setName(n);
		contador = c;
	}
	public void run()
	{
		synchronized (contador)
		{
			for (int i = 0; i < 300; i++)
			{
				contador.decrementa();
				try
				{
					sleep(100);
				}
				catch (InterruptedException e) {}
			}
			System.out.println(getName() + " contador vale " + contador.getValor());
		}
	}
}