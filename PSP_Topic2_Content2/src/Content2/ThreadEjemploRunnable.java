package Content2;

public class ThreadEjemploRunnable implements Runnable
{
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			System.out.println(i + " " + Thread.currentThread().getName());
		}
		System.out.println("Termina thread " + Thread.currentThread().getName());
	}
	public static void main(String[] args)
	{
		// Creamos dos objetos de la clase ThreadEjemploRunnable
		ThreadEjemploRunnable objRunnable1 = new ThreadEjemploRunnable();
		ThreadEjemploRunnable objRunnable2 = new ThreadEjemploRunnable();
		
		// Creamos dos Hilos
		// y le pasamos por parámetros los objetos de la clase ThreadEjemploRunnable
		Thread primero = new Thread (objRunnable1);
		primero.setName("Pepe");
		Thread segundo = new Thread (objRunnable2);
		segundo.setName("Juan");
		
		// Hemos creado dos hilos primero y segundo, pero no se han ejecutado
		// Para poderlo ejecutar se debe llamar al método start ()
		primero.start();
		segundo.start();
		
		System.out.println("Termina el hilo principal (Thread main)");
	}
}