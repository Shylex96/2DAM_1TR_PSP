package es.studium.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import es.studium.model.ProcessScanner;
import es.studium.view.MainMenu;
import es.studium.view.ScanView;

public class ApplicationController implements WindowListener, MouseListener, MouseMotionListener, ActionListener {

	private ProcessScanner processScanner;
	private MainMenu mainMenu;
	private ScanView scanview;

	private boolean buttonScannerActivated = false;
	private boolean buttonExitActivated = false;
	// Important: Needed scannerOn to control when Scanner must be initiated.
	// Prevent progress-bar overlap with mouse-over images
	private boolean scannerOn = false;
	public boolean ready = false;
	public int valueAlert = 0;

	public ApplicationController(ProcessScanner processScanner, MainMenu mainMenu) {

		this.processScanner = processScanner;
		this.mainMenu = mainMenu;

		mainMenu.addMouseListener(this);
		mainMenu.addWindowListener(this);
		mainMenu.addMouseMotionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {

		int mouseX = e.getX();
		int mouseY = e.getY();

		// Check if the mouse is within the desired coordinates
		boolean insideButtonScan = (mouseX >= 312 && mouseX <= 437 && mouseY >= 375 && mouseY <= 420);
		boolean insideButtonExit =  (mouseX >= 609 && mouseX <= 673 && mouseY >= 46 && mouseY <= 112);

		// Check if the mouse has left all areas of interest
		// -- Main Menu:
		if (mainMenu != null && mainMenu.isActive() && !scannerOn) {

			// ## Scan Button ##
			if (insideButtonScan && !buttonScannerActivated) {
				mainMenu.swapImage1();
				buttonScannerActivated = true;

			} else if (!insideButtonScan && buttonScannerActivated) {
				mainMenu.restoreImage();
				buttonScannerActivated = false;
			}

			// ## Exit Button ##
			if (insideButtonExit && !buttonExitActivated) {
				mainMenu.swapImage2();
				buttonExitActivated = true;

			} else if (!insideButtonExit && buttonExitActivated) {
				mainMenu.restoreImage();
				buttonExitActivated = false;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int mouseX = e.getX();
		int mouseY = e.getY();

		//System.out.println("X: " +mouseX + ", Y: " +mouseY);

		// Check if the mouse is within the desired coordinates
		boolean scanBtn = (mouseX >= 312 && mouseX <= 437 && mouseY >= 375 && mouseY <= 420);
		boolean exitBtn =  (mouseX >= 609 && mouseX <= 673 && mouseY >= 46 && mouseY <= 112);

		if (mainMenu != null && mainMenu.isActive() && !scannerOn) {
			//  ## Exit Button ##
			if (exitBtn) {
				System.exit(0);
			}

			// ## Scan Button ##
			if (scanBtn) {
				int dialogResult = mainMenu.showAlert();

				if (dialogResult == mainMenu.yesOption) {
					scannerOn = true;
					//ready = true;
					ready = mainMenu.swapImage3();

					if (ready) {
						try {
							mainMenu.loadProgress();

						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}	 
				}
			}
		}

		if (mainMenu != null && mainMenu.isActive() && mainMenu.showResults) {
			boolean displayResults = (mouseX >= 318 && mouseX <= 431 && mouseY >= 312 && mouseY <= 427);

			if (displayResults) {
				scanview = new ScanView();
				scanview.addWindowListener(this);
				scanview.addMouseListener(this);

				// Start real scanner and fill view list with app names
				processScanner.findApplications();
				scanview.updateLists(processScanner.getApplications32Bit(), processScanner.getApplications64Bit());
				scanview.list32Bit.addMouseListener(this);
				scanview.list64Bit.addMouseListener(this);

				mainMenu.setVisible(false);
				scanview.setVisible(true); 
			}
		}

		if (scanview != null && scanview.isActive() ) {
			boolean btnPDF = (mouseX >= 331 && mouseX <= 390 && mouseY >= 420 && mouseY <= 479);
			boolean btnUpdate = (mouseX >= 328 && mouseX <= 387 && mouseY >= 56 && mouseY <= 116);

			if (btnPDF) {
				valueAlert = 1;
				scanview.viewAlert(valueAlert);
			}

			if (btnUpdate) {
				valueAlert = 2;
				scanview.viewAlert(valueAlert);
				scanview.updateLists(processScanner.getApplications32Bit(), processScanner.getApplications64Bit());
			}

			if (e.getClickCount() == 2) {

				String selectedItem;
				int selectedIndex;

				if (e.getSource() == scanview.list32Bit) {
					selectedIndex = scanview.list32Bit.getSelectedIndex();
					if (selectedIndex != -1) {
						selectedItem = scanview.list32Bit.getModel().getElementAt(selectedIndex);
						System.out.println("Element selected in list 32Bits: " + selectedItem);
						processScanner.executeApp(selectedItem);
					}
				} else {
					selectedIndex = scanview.list64Bit.getSelectedIndex();
					if (selectedIndex != -1) {
						selectedItem = scanview.list64Bit.getModel().getElementAt(selectedIndex);
						System.out.println("Element selected in list 64Bits: " + selectedItem);
						processScanner.executeApp(selectedItem);
					}
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}