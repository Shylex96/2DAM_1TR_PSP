package EjemploJoin;

public class Principal
{
	public static void main(String[] args) throws InterruptedException
	{
		TiradaDados tirada = new TiradaDados(0);
		JoinHilos obj1 = new JoinHilos(tirada);
		JoinHilos obj2 = new JoinHilos(tirada);
		JoinHilos obj3 = new JoinHilos(tirada);
		Thread hilo_1 = new Thread(obj1);
		hilo_1.setName("Dado 1");
		Thread hilo_2 = new Thread(obj2);
		hilo_2.setName("Dado 2");
		Thread hilo_3 = new Thread(obj3);
		hilo_3.setName("Dado 3");
		hilo_1.start();
		hilo_2.start();
		hilo_3.start();
		hilo_1.join(); // Espera el hilo_1 que el hilo principal, que lo ha invocado, termine
		hilo_2.join();
		hilo_3.join();
		System.out.println("Total tirada: " + tirada.getSumaTirada());
		System.out.println("Final del Hilo Principal");
	}
}