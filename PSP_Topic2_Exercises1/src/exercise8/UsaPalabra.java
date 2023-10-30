package exercise8;

public class UsaPalabra
{
	public static void main (String[] args) throws InterruptedException
	{
		Palabra pal1 = new Palabra("casa");
		Palabra pal2 = new Palabra("ala");
		Palabra pal3 = new Palabra("Oso");
		
		// A continuación, lanzamos los hilos
		pal1.start();
		pal2.start();
		pal3.start();
		
		// Esperamos a que terminen los hilos
		pal1.join();
		pal2.join();
		pal3.join();
		
		System.out.println("Hilos terminados.");
	}
}