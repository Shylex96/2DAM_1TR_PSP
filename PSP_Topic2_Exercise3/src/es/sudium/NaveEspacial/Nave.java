package es.sudium.NaveEspacial;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

public class Nave extends Panel
{
	private static final long serialVersionUID = 1L;
	private int x, y;
	private int dsx, dsy, v; // Desplazamientos, v sleep
	private int tx = 10; // Margen x
	private int ty = 10; // Margen i image
	private Image image;
	Toolkit herramienta;
	public Nave(int x, int y, int dsx, int dsy, int v )
	{
		this.x = x;
		this.y = y;
		this.dsx = dsx;
		this.dsy = dsy;
		this.v = v;
		herramienta = getToolkit();
		image = herramienta.getImage("images\\nave.png");
	}
	public int velocidad()
	{
		// Sleep en milisegundos
		return v;
	}
	public void mover()
	{
		x = x + dsx;
		y = y + dsy;
		// Llega a los márgenes
		if ( x>= 450-tx || x<= tx)
		{
			dsx = -dsx;
		}
		if ( y >= 500- ty || y<=ty )
		{
			dsy = -dsy;
		}
	}
	public void pinta(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(this.image, x, y, null);
	}
}