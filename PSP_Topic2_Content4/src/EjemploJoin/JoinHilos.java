package EjemploJoin;

public class JoinHilos implements Runnable
{
	private TiradaDados xobj;
	public JoinHilos(TiradaDados m)
	{
		xobj = m;
	}
	public void run()
	{
		try
		{
			Thread.sleep(1000);
			int resultadoDado = (int) (Math.random() * 6) + 1;
			xobj.setSumaTirada(resultadoDado);
			System.out.println("Tirada del hilo " + Thread.currentThread().getName() + ":" + resultadoDado);
		}
		catch (InterruptedException e) {}
	}
}