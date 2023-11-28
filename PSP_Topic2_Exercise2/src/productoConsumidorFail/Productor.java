package productoConsumidorFail;

class Productor implements Runnable
{
	private Monitor bandeja;
	public Productor( Monitor s )
	{
		bandeja=s;
	}
	private int numero=0;
	public void run()
	{
		for(int i=0; i < 5; i++ )
		{
			numero= (int)(10*Math.random());
			bandeja.dejar(numero);
			System.out.println( "Producido el número "+numero );
			try 
			{
				Thread.sleep( (int)(Math.random() * 1000 ) );
			}
			catch( InterruptedException e ) {}
		}
	}
}