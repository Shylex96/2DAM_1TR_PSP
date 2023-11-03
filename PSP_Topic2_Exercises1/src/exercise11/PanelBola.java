package exercise11;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

import exercise10.Bola;

public class PanelBola extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	private int numBolas = 5;
	Thread[] hilosBola;
	Thread hiloBolin; // Ejercicio 11
	Bola[] bola;
	Bolin bolin; // Ejercicio 11

	public PanelBola() {
		hilosBola = new Thread[numBolas];
		hiloBolin = new Thread(this); // Ejercicio 11
		bolin = new Bolin(200, 530, new Color(0, 0, 0)); // Ejercicio 11
		bola = new Bola[numBolas];
		for (int i = 0; i < hilosBola.length; i++) {
			hilosBola[i] = new Thread(this);
			Random aleatorio = new Random();
			int velocidad = aleatorio.nextInt(50);
			int posX = aleatorio.nextInt(250) + 50;
			int posY = aleatorio.nextInt(300) + 50;
			Color color = new Color(aleatorio.nextInt(254), aleatorio.nextInt(254), aleatorio.nextInt(254));
			bola[i] = new Bola(posX, posY, velocidad, color);
		}
		for (int i = 0; i < hilosBola.length; ++i) {
			hilosBola[i].start();
		}
		hiloBolin.start(); // Ejercicio 11
		setBackground(Color.white);
	}

	public void run() {
		for (int i = 0; i < hilosBola.length; ++i) {
			while (Thread.currentThread() == hilosBola[i]) {
				try {
					Thread.sleep(bola[i].getVelocidad());
					bola[i].mover();
				} catch (InterruptedException e) {
				}
				repaint();
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < bola.length; ++i) {
			bola[i].pinta(g);
		}
		bolin.pinta(g); // Ejercicio 11
	}

	public void mover(int direccion) {
		bolin.mover(direccion); // Ejercicio 11
	}
}
