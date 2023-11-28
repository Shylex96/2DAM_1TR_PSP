package es.sudium.NaveEspacial;

import javax.swing.JFrame;
public class NaveEspacial extends JFrame
{
	private static final long serialVersionUID = 1L;
	public NaveEspacial()
	{
		initComponents();
	}
	private void initComponents()
	{
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(255, 255, 255));
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).
				addGap(0, 300, Short.MAX_VALUE));
		pack();
	}
	public static void main(String args[])
	{
		try
		{
			for (javax.swing.UIManager.LookAndFeelInfo info
					:javax.swing.UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch (ClassNotFoundException ex)
		{
			System.out.println(ex.getMessage());
		}
		catch (InstantiationException ex)
		{
			System.out.println(ex.getMessage());
		}
		catch (IllegalAccessException ex)
		{
			System.out.println(ex.getMessage());
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			System.out.println(ex.getMessage());
		}
		NaveEspacial f = new NaveEspacial();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Naves Espaciales");
		f.setContentPane(new PanelNave());
		f.setSize(480, 560);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
