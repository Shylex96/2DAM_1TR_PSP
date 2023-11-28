package agenciaViajes;

public class AsientosAvion {

	// Empezamos con 5 asientos libres en el avi�n
	private int asientosLibres = 5;
	// Obtener el n�mero de asientos libres disponibles
	public int getAsientosLibres()
	{
		return asientosLibres ;
	}
	// Calcula si hay suficientes asientos para una reserva
	public boolean getAsientosLibres(int numPlazas)
	{
		if (numPlazas<=asientosLibres)
			return true;
		else
			return false;
	}
	// Hace efectiva la reserva
	public void reservaAsientos(int numAsientosReserva)
	{
		asientosLibres = asientosLibres - numAsientosReserva;
	}
}