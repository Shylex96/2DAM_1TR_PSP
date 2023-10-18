package parametros;

public class Parametros implements Runnable
{
	private int param1;
	private int param2;
	public Parametros(int p1, int p2)
	{
		param1 = p1;
		param2 = p2;
	}
	public void run()
	{
		System.out.println(Thread.currentThread().getName() + "\n\tp1 = " + param1 + "\n\tp2 = " +
				param2);
	}
	public static void main(String[] args)
	{
		new Thread(new Parametros(4, 5), "Hilo 1").start();
		new Thread(new Parametros(7, 9), "Hilo 2").start();
	}
}