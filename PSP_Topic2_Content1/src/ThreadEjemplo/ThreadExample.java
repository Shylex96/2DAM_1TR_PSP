package ThreadEjemplo;

public class ThreadExample extends Thread {

	public ThreadExample(String str)
	{
		super(str);
	}
	public void run() {

		for (int i = 0; i < 10; i++)
		{
			System.out.println(i + " " + getName());
		}
		System.out.println("Termina thread " + getName());
	}
	public static void main(String[] args)
	{
		ThreadExample uno = new ThreadExample("Pepe");
		ThreadExample dos = new ThreadExample("Juan");
		uno.start();
		dos.start();
		System.out.println("Termina el hilo principal (Thread main)");
	}
}
