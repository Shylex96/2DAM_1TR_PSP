package productoConsumidorFail;

public class Principal
{
	public static void main(String[] args) throws InterruptedException
	{
		Monitor ban = new Monitor();
		Productor p = new Productor(ban);
		Consumidor c = new Consumidor(ban);
		Thread productor = new Thread(p);
		Thread consumidor = new Thread(c);
		productor.start();
		consumidor.start();
	}
}