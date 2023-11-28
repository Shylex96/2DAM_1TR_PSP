package agenciaViajes;

public class AgenciaViajes implements Runnable
{
	private AsientosAvion aa = new AsientosAvion();
	public void run()
	{
		gestionaAsientosAvion(3);
		if(aa.getAsientosLibres()<=0)
		{
			System.out.println("No hay asientos libres");
		}
	}
	public synchronized void gestionaAsientosAvion(int numAsientosReserva)
	{
		System.out.println(Thread.currentThread().getName() + " tiene la llave del candado");
		// Comprobamos si hay asientos suficientes
		if(aa.getAsientosLibres()>=numAsientosReserva)
		{
			System.out.println(Thread.currentThread().getName()+" hará una reserva de "+ numAsientosReserva +" plazas");
			try
			{
				Thread.sleep(1000); // Dormimos el hilo durante un segundo simulando tiempo real
			}
			catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}
			// Hacemos la reserva de los asientos
			aa.reservaAsientos(numAsientosReserva);
			System.out.println(Thread.currentThread().getName() + " Reserva realizada con éxito."+" Las plazas libres ahora son "+aa.getAsientosLibres());
		}
		else
		{
			System.out.println(Thread.currentThread().getName() + " Las plazas libres son " + aa.getAsientosLibres());
			System.out.println("No hay plazas suficientes para " + Thread.currentThread().getName()+".Las plazas libres son "+aa.getAsientosLibres());
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " deja la llave del candado");
	}
}