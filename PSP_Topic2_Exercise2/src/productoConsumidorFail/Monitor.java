package productoConsumidorFail;

class Monitor
{
	private int numero = 0 ;
	Monitor()
	{
		numero = 0 ;
	}
	public synchronized int coger()
	{
		return(numero) ;
	}
	public synchronized void dejar(int num)
	{
		numero = num ;
	}
}