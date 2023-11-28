package sync;

public class Principal {
	public static void main(String[] args) {
		Contador cont = new Contador(100);
		
		HiloASincronizado hiloASincronizado = new HiloASincronizado("Hilo A Sincronizado", cont);
		HiloBSincronizado hiloBSincronizado = new HiloBSincronizado("Hilo A Sincronizado", cont);
		hiloASincronizado.start();
		hiloBSincronizado.start();
	}
}
