package exercise5;

public class PrRunnable implements Runnable {

	public final void run() {
		
		Thread hebra = Thread.currentThread();
		boolean sigue = true;
		
		for (int i = 0; i<100 && sigue; i++) {
			try {
				System.out.println(hebra.getName() + ": " +i);
				Thread.sleep(500);

				if (i == 10) {
					hebra.interrupt();
				}
			} catch (InterruptedException e) {
				System.out.println(hebra.getName()+ "interrumpido...");
				sigue = false;
			}
		}
	}
	public static void main(String[] args) {

		Thread p = new Thread(new PrRunnable(), "Hilo");
		p.start();
	}
}
