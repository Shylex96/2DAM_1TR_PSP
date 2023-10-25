package exercise4;

public class PrThread extends Thread {

	public PrThread (String str) {
		super(str);
	}

	public void run()
	{
		int min = 0; 
		int max = 99;
		int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
		boolean sigue = true;

		System.out.println("Número aleatorio: " +random_int);

		for (int i = 0; i < 99 && sigue; i++)
		{
			try {
				if (random_int == i) {
					interrupt();
				}

				System.out.println("Hilo: "+ i);
				sleep(500);

			} catch (InterruptedException e) {
				sigue = false;
				System.out.println(getName() + " interrumpido..");
			}
		}
	}

	public static void main(String[] args) {

		PrThread PrThread = new PrThread("Hilo");
		PrThread.start();
	}
}
