package exercise3;

import java.util.Random;

public class Nombres_v2 extends Thread {

	public Nombres_v2(String nombre)
	{
		super(nombre);
	}
	public void run()
	{
		for(int i=0; i<5;i++)
		{
			System.out.println("Este es el hilo "+ Thread.currentThread().getName());
		}
	}


	public static void main(String[] args) {

		String nombres[] = {"Mercurio", "Venus", "Tierra", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno", "Plutón"};
		Random aleatorio = new Random();
		
		for (int i = 0; i < 3; i++) 
		{
			new Nombres_v2(nombres[aleatorio.nextInt(9)]).start();
		}
	}
}

