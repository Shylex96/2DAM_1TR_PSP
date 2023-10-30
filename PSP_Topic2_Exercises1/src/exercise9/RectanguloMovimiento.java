package exercise9;

import java.awt.Graphics;
import java.awt.Panel;

public class RectanguloMovimiento extends Panel implements Runnable
{
	private static final long serialVersionUID = 1L;
	int x, y;
	boolean seguir = true;
	public RectanguloMovimiento() {}
	@Override
	public void run()
	{
		x = 50;
		y = 50;
		setVisible(true);
		for(int i = 0; i < 50; i++)
		{
			if(seguir)
			{
				try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException e){}
				repaint();
			}
		}
	}
	public void paint(Graphics g) 
	{
		g.drawRect(x, y, 25, 25);
		x++;
		y++;
	}
	public void setSeguir(boolean seguir)
	{
		this.seguir = seguir;
	}
}