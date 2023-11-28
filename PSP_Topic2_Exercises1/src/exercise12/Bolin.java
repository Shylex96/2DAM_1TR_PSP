package exercise12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Bolin {
	private int x, y;
	private Color color;

	public Bolin(int xx, int yy, Color c) {
		this.x = xx;
		this.y = yy;
		this.color = c;
	}

	public void mover(int direccion) {
		switch (direccion) {
		// Derecha
		case 0:
			if (x < 450)
				x++;
			break;
			// Abajo
		case 1:
			if (y < 550)
				y++;
			break;
			// Izquierda
		case 2:
			if (x > 0)
				x--;
			break;
			// Arriba
		case 3:
			if (y > 0)
				y--;
			break;
		}
	}

	public int dameX() // Ejercicio 12
	{
		return (this.x);
	}

	public int dameY() // Ejercicio 12
	{
		return (this.y);
	}

	public void pinta(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(color);
		g2d.fillOval(this.x, this.y, 25, 25);
	}
}
