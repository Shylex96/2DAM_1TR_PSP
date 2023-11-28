package es.studium.holaAdios;

public class HolaAdios {
	
	public static void main(String args[])
	{
		EscribeHolaAdios eha = new EscribeHolaAdios();
		new E_Adios(eha);
		new E_Hola(eha);
	}
}

class E_Hola implements Runnable
{
	EscribeHolaAdios eh;
	E_Hola(EscribeHolaAdios eh)
	{
		this.eh = eh;
		new Thread(this, "Hola").start();
	}
	public void run()
	{
		try
		{
			for(int x=0;x<5;x++)
			{
				Thread.sleep(1000);
				eh.eHola();
			}
		}
		catch (InterruptedException e){}
	}
}
class E_Adios implements Runnable
{
	EscribeHolaAdios eh;
	E_Adios (EscribeHolaAdios eh)
	{
		this.eh = eh;
		new Thread(this, "Adios").start();
	}
	public void run()
	{
		for(int x=0;x<5;x++)
		{
			eh.eAdios();
		}
	}
}
class EscribeHolaAdios
{
	boolean haEscritoHola = false;
	public synchronized void eAdios()
	{
		while (haEscritoHola == false)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e) {}
		}
		haEscritoHola = false;
		System.out.print(" Adiós ");
	}
	public synchronized void eHola()
	{
		System.out.print(" Hola ");
		haEscritoHola = true;
		notify();
	}
}
