package exercise2;

public class HiloSimple2 implements Runnable {

	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			System.out.println("Este es el Hilo: "+ Thread.currentThread().getName());
		}
	}
	public static void main(String[] args)
	{
		HiloSimple2 hiloSimple2Runnable = new HiloSimple2();
		
		Thread hiloSimple2 = new Thread (hiloSimple2Runnable);
		hiloSimple2.setName("Hilo de Prueba");
		hiloSimple2.start();
	}
}