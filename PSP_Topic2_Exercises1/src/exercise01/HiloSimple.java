package exercise01;

public class HiloSimple extends Thread
{
	public HiloSimple(String str)
	{
		super(str);
	}
	public void run()
	{
		for(int i=0; i<10;i++)
		{
			System.out.println("Este es el Hilo: "+ Thread.currentThread().getName());
		}
	}
	public static void main(String[] args)
	{
		HiloSimple hiloSimple = new HiloSimple("Hilo de Prueba");
		hiloSimple.start();
	}
}