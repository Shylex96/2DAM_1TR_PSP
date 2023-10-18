package bolsa;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Principal implements WindowListener
{
	Frame ventana = new Frame("Bolsa");
	Label lblOro = new Label("Oro");
	TextField txtOro = new TextField(10);
	Label lblPlata = new Label("Plata");
	TextField txtPlata = new TextField(10);
	Label lblPetroleo = new Label("Petróleo");
	TextField txtPetroleo = new TextField(10);
	
	Principal()
	{
		ventana.setSize(200,150);
		ventana.setLayout(new FlowLayout());
		ventana.add(lblOro);
		txtOro.setEditable(false);
		ventana.add(txtOro);
		ventana.add(lblPlata);
		txtPlata.setEditable(false);
		ventana.add(txtPlata);
		ventana.add(lblPetroleo);
		txtPetroleo.setEditable(false);
		ventana.add(txtPetroleo);
		ventana.addWindowListener(this);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
		Hilo oro = new Hilo(txtOro, 1743.12); // Valor inicial
		Hilo plata = new Hilo(txtPlata, 22.09);
		Hilo petroleo = new Hilo(txtPetroleo, 78.72);
		oro.start();
		plata.start();
		petroleo.start();
	}
	public static void main(String[] args)
	{
		new Principal();
	}
	@Override
	public void windowOpened(WindowEvent e){}
	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	@Override
	public void windowClosed(WindowEvent e){}
	@Override
	public void windowIconified(WindowEvent e){}
	@Override
	public void windowDeiconified(WindowEvent e){}
	@Override
	public void windowActivated(WindowEvent e){}
	@Override
	public void windowDeactivated(WindowEvent e){}
}