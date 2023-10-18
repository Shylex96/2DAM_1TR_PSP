package es.studium.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private Image imgMenu;
	private JProgressBar progressBar;

	public int yesOption = JOptionPane.YES_OPTION;
	// Show results needed to know when to open and show lists
	public boolean showResults = false;

	public MainMenu() {

		this.setTitle("Application Launcher");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		imgMenu = toolkit.getImage("resources/mainview.png");

		progressBar = new JProgressBar(0, 100);
		progressBar.setStringPainted(true);
		progressBar.setVisible(false);

		JPanel panel = new JPanel(null);
		getContentPane().add(panel);

		progressBar.setBounds(312, 330, 110, 20);
		panel.add(progressBar);

		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(imgMenu, 0, 30, this);
	}

	public void swapImage1() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		imgMenu = toolkit.getImage("resources/mainviewBtn.png");
		repaint();
	}

	public void swapImage2() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		imgMenu = toolkit.getImage("resources/mainviewExit.png");
		repaint();
	}

	public boolean swapImage3() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		imgMenu = toolkit.getImage("resources/mainviewLoading.png");
		repaint();
		//validate(); || revalidate();
		return true;
	}

	public void restoreImage() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		imgMenu = toolkit.getImage("resources/mainview.png");
		repaint();
	}

	public int showAlert() {

		int result = JOptionPane.showConfirmDialog(null, "¿Desea escanear el equipo? Esta acción puede llevar algúnn tiempo.", "Alert", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION);
		return result;
	}

	public void loadProgress() throws InterruptedException {

		progressBar.setValue(0);
		progressBar.setVisible(true);

		// Problem: Running both -> the swaping image and the progress bar in the same swing UI thread.
		// This may block the graphical interface from updating
		// Solution: Use a separate thread using 'SwingWorker' class from Swing to run the progress bar
		//  in a separate thread, which prevents it from blocking the main UI.
		// <Void, Void> because background work is not expected to produce a specific result or report progress.
		
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				for (int progress = 0; progress <= 100; progress+=2) {
					progressBar.setValue(progress);
					Thread.sleep(20);
				}
				progressBar.setVisible(false);
				// Return null because will not produce results that must be returned to the UI thread.
				return null;
			}

			@Override
			protected void done() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				imgMenu = toolkit.getImage("resources/mainviewShowResults.png");
				repaint();
				showResults = true;
			}
		};
		worker.execute();
	}
}