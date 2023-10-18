package exercise3;

import java.util.Random;

public class Nombres_v1 extends Thread {

	static String planetas  []= {"Mercurio", "Venus", "Tierra", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno", "Plutón"};
	static Random random = new Random();
	static int planeta1 = random.nextInt(9); 
	static int planeta2 = random.nextInt(9); 
	static int planeta3 = random.nextInt(9);
	
	static String planeta1Escogido = planetas[planeta1];
	static String planeta2Escogido = planetas[planeta2];
	static String planeta3Escogido = planetas[planeta3];

	public Nombres_v1(String cadena)
	{
		super(cadena);
	}
	public void run()
	{
		for(int i=0; i<10;i++)
		{
			System.out.println("Paso "+ i + " del proceso "+
					Thread.currentThread().getName());
		}
		System.out.println("Termina el thread "+ Thread.currentThread().getName());
	}


	public static void main(String[] args) {

		System.out.println(""+ planeta1Escogido + " " + planeta2Escogido + " "+ planeta3Escogido);

	}

}
