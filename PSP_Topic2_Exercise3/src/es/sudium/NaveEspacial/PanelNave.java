package es.sudium.NaveEspacial;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
public class PanelNave extends JPanel implements Runnable
{
	private static final long serialVersionUID = 1L;
	private int numNaves=3;
	Thread[] hilosNave;
	Nave[] nave;
	public PanelNave()
	{
		hilosNave = new Thread[numNaves]; // Creo tres hilos
		nave = new Nave[numNaves];
		for (int i=0;i<hilosNave.length;i++)
		{
			hilosNave[i]= new Thread(this);
			hilosNave[i].setName("Hilo Nave-"+i);
			Random rand = new Random();
			int velocidad=rand.nextInt(50);
			int posX=rand.nextInt(100)+30;
			int posY=rand.nextInt(100)+30;
			int dX=rand.nextInt(3)+1;
			int dY=rand.nextInt(3)+1;
			nave[i]= new Nave(posX,posY,dX,dY,velocidad);
		}
		for (int i=0; i<hilosNave.length; ++i)
		{
			hilosNave[i].start();
		}
	}
	public void run()
	{
		for (int i=0; i<hilosNave.length; ++i)
		{
			while (Thread.currentThread()== hilosNave[i])
			{
				try
				{
					Thread.sleep(nave[i].velocidad());
					nave[i].mover();
				}
				catch (InterruptedException e) {}
				repaint();
			}
		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i=0; i<nave.length;++i)
		{
			nave[i].pinta(g);
		}
	}
}