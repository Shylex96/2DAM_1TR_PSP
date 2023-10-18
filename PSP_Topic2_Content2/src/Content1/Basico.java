package Content1;

public class Basico {

	public static void main(String[] args) {
		
		HiloBasico h1 = new HiloBasico("Uno");
		HiloBasico h2 = new HiloBasico("Dos");
		HiloBasico h3 = new HiloBasico("Tres");
		
		h1.start();
		h2.start();
		h3.start();
		
		System.out.println("Programa Principal Finalizado...");
	}
}