package es.studium.view;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class ScanView extends JFrame {

	private static final long serialVersionUID = 1L;

	private DefaultListModel<String> listModel32Bit;
	private DefaultListModel<String> listModel64Bit;
	public JList<String> list32Bit;
	public JList<String> list64Bit;
	public String selectedValue1;
	public String selectedValue2;
	public int yesOption = JOptionPane.YES_OPTION;

	public ScanView() {
		this.setTitle("Application Launcher");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		// JLayeredPane allows components to be overlaid on different layers
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setLayout(null);

		// Background config
		ImageIcon backgroundImg = new ImageIcon("resources/scanview.png");
		JLabel background = new JLabel(backgroundImg);
		background.setBounds(0, -25, 700, 500); 

		// Lists config
		listModel32Bit = new DefaultListModel<>();
		listModel64Bit = new DefaultListModel<>();
		list32Bit = new JList<>(listModel32Bit);
		list64Bit = new JList<>(listModel64Bit);

		// JScrollPane config
		JScrollPane scrollPane32Bit = new JScrollPane(list32Bit);
		JScrollPane scrollPane64Bit = new JScrollPane(list64Bit);
		scrollPane32Bit.setBounds(75, 85, 195, 300);
		scrollPane64Bit.setBounds(435, 85, 195, 300);

		// Add the components to the JLayeredPane in the proper layer order
		layeredPane.add(background, JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(scrollPane32Bit, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(scrollPane64Bit, JLayeredPane.PALETTE_LAYER);

		getContentPane().add(layeredPane);

		setVisible(true);
	}

	public void viewAlert(int valueAlert) {

		// int result = JOptionPane.DEFAULT_OPTION;

		if (valueAlert == 1) {
			JOptionPane.showConfirmDialog(null, "Esta función aún no está implementada.", "Alert", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);

		} else if (valueAlert == 2) {
			JOptionPane.showConfirmDialog(null, "Lista actualizada.", "Alert", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);

			/* If add some confirmation dialog
			 * 
			 * } else if (valueAlert == 3) {
			selectedValue1 = list32Bit.getSelectedValue();
			result = JOptionPane.showConfirmDialog(null, "¿Desea ejecutar la aplicación " +selectedValue1+ "?" , "Alert", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION);

		} else if (valueAlert == 4) {
			selectedValue2 = list64Bit.getSelectedValue();
			result = JOptionPane.showConfirmDialog(null, "¿Desea ejecutar la aplicación " +selectedValue2+ "?" , "Alert", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION);
		}
		return result;
			 */
		}
	}

	// Used to update the application lists in the graphical interface
	// with the information obtained from ProcessScanner model.
	public void updateLists(List<String> List32bits, List<String> List64bits) {
		listModel32Bit.clear();
		listModel64Bit.clear();

		for (String app : List32bits) {
			listModel32Bit.addElement(app);
		}

		for (String app : List64bits) {
			listModel64Bit.addElement(app);
		}
	}
}
