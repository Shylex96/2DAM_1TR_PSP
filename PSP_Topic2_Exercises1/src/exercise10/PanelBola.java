package exercise10;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class PanelBola extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	private int numBolas = 5;
	Thread[] hilosBola;
	Bola[] bola;

	public PanelBola() {
		hilosBola = new Thread[numBolas];
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
	}
}
