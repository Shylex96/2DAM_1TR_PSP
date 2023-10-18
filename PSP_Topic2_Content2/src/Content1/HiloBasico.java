package Content1;

import java.util.Random;

public class HiloBasico extends Thread
{
	String nombre;
	Random aleatorio = new Random();
	public HiloBasico(String n)
	{
		nombre = n;
	}
	public void run()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println("Hilo "+nombre+" en fase "+i);
			try
			{
				sleep(aleatorio.nextInt(10)*1000);
			}
			catch(InterruptedException ie)
			{
				System.out.println("Despertando prematuramente...");
			}
		}
	}
}