package agenciaViajes;

public class Principal
{
	public static void main(String[] args)
	{
		AgenciaViajes objAg = new AgenciaViajes();
		// Creamos los dos hilos sobre la misma instancia
		Thread Hilo_1 = new Thread(objAg);
		Thread Hilo_2 = new Thread(objAg);
		Hilo_1.setName("Cliente 1");
		Hilo_2.setName("Cliente 2");
		Hilo_1.start();
		Hilo_2.start();
	}
}