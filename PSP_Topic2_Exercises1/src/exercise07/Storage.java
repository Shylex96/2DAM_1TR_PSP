package exercise07;

public class Storage implements Runnable {

	int numero;
	String nombreHilo;
	public Storage(String n, int num) {
		nombreHilo = n;
		numero = num;
	}

	@Override
	public void run() {
		for (int i = 0; i<10;i++) {
			System.out.println("Hilo" +this.nombreHilo + ": " + numero + " * " + i + " = " + (numero*i));
		}
	}
}
