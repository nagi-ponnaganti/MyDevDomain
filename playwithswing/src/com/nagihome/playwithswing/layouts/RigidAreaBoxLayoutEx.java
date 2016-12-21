/**
 * 
 */
package com.nagihome.playwithswing.layouts;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 * @author nageswararao
 *
 */
public class RigidAreaBoxLayoutEx extends JFrame {

	public RigidAreaBoxLayoutEx() {
		initUI();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void initUI() {

		System.out.println("Initializing the UI");

		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
		jPanel.setBorder(new EmptyBorder(new Insets(40, 60, 40, 60)));

		jPanel.add(new JButton("Button"));
		jPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		jPanel.add(new JButton("Button"));
		jPanel.add(Box.createRigidArea(new Dimension(0, 50)));
		jPanel.add(new JButton("Button"));
		jPanel.add(Box.createRigidArea(new Dimension(0, 50)));
		jPanel.add(new JButton("Button"));
		jPanel.add(Box.createRigidArea(new Dimension(0, 50)));

		add(jPanel);

		pack();

		setTitle("RigidArea");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				RigidAreaBoxLayoutEx ex = new RigidAreaBoxLayoutEx();
				ex.setVisible(true);
			}
		});
	}

}
