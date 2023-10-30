package exercise7;

public class Prueba {

	public static void main(String[] args)  throws InterruptedException {

		Storage m1 = new Storage("Múltiplos de 5", 5);
		Storage m2 = new Storage("Múltiplos de 12", 12);
		Storage m3 = new Storage("Múltiplos de 28", 28);

		Thread hilo1 = new Thread(m1);
		Thread hilo2 = new Thread(m2);
		Thread hilo3 = new Thread(m3);

		hilo1.start();
		hilo2.start();
		hilo3.start();

		hilo1.join();
		hilo2.join();
		hilo3.join();

		System.out.println("Hilos terminados");

	}

}
