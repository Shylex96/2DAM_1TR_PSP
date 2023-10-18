package Content5;

public class ThreadEjemplo3 implements Runnable
{
	public ThreadEjemplo3()
	{
		super();
	}
	public static void main(String[] args)
	{
		new Thread(new ThreadEjemplo3(),"Uno").start();
		new Thread(new ThreadEjemplo3(),"Dos").start();
		System.out.println("Termina el programa principal");
	}
	public void run()
	{
		for(int i=0; i<10; i++)
		{
			System.out.println("Paso "+ i + " del proceso "+
					Thread.currentThread().getName());
		}
		System.out.println("Termina el thread "+ Thread.currentThread().getName());
	}
}