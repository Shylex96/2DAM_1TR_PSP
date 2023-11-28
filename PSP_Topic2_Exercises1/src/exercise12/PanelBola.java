package exercise12;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class PanelBola extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	private int numBolas = 5;
	Thread[] hilosBola;
	Thread hiloBolin; // Ejercicio 11
	Bola[] bola;
	Bolin bolin; // Ejercicio 11
	boolean fin = false; // Ejercicio 12

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
			while ((Thread.currentThread() == hilosBola[i]) && (!fin)) // Ejercicio 12
			{
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
		Font fuente = new Font("Times New Roman", 0, 20); // Ejercicio 12
		g.setFont(fuente); // Ejercicio 12
		g.drawString("Salida", 210, 20); // Ejercicio 12
	}

	public void mover(int direccion) {
		int xBolin, yBolin;
		int xBola, yBola;
		xBolin = bolin.dameX();
		yBolin = bolin.dameY();
		if ((xBolin >= 200) && (xBolin <= 241) && (yBolin <= 20)) {
			if (!fin) // Para mostrar solo una vez
			{
				System.out.println("Has salido ileso!");
			}
			// Esta sería la forma natural de matar los hilos
			// Pero el método stop() está deprecated
			/*
			 * for (int i=0; i<hilosBola.length; ++i) { hilosBola[i].stop(); }
			 * hiloBolin.stop();
			 */
			fin = true;
		} else {
			for (int i = 0; i < hilosBola.length; ++i) {
				xBola = bola[i].dameX();
				yBola = bola[i].dameY();
				if ((xBolin + 12 >= xBola - 25) && (yBolin + 12 >= yBola +25) && (xBolin - 12 <= xBola + 25)
						&& (yBolin - 12 <= yBola + 25)) {
					if (!fin) {
						System.out.println("Has muerto!");
					}
					fin = true;
				}
			}
			if (!fin) {
				bolin.mover(direccion); // Ejercicio 11
			}
		}
	}
}
