package exercise12;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class PrincipalBola extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L;
	static PanelBola panel = new PanelBola(); // Ejercicio 11

	public PrincipalBola() {
		super();
	}

	public static void main(String args[]) {
		PrincipalBola f = new PrincipalBola();
		f.addKeyListener(f); // Ejercicio 11
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Bolas");
		f.setContentPane(panel); // Ejercicio 11
		f.setSize(500, 600);
		f.setVisible(true);
	}

	// Ejercicio 11
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case 37:
			panel.mover(2);
			break;
		case 38:
			panel.mover(3);
			break;
		case 39:
			panel.mover(0);
			break;
		case 40:
			panel.mover(1);
			break;
		}
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}
}
