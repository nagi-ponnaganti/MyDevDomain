/**
 * 
 */
package com.nagihome.playwithswing.layouts;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author nageswararao
 *
 */
public class GridLayoutEx extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public GridLayoutEx() {
		setUp();
	}

	private void setUp() {

		setTitle("Grid Layout Example");
		setSize(350, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.setLayout(new GridLayout(5, 4, 5, 5));

		String[] buttons = { "Cls", "Bck", "", "Close", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0",
				".", "=", "+" };

		for (int i = 0; i < buttons.length; i++) {

			if (i == 2) {
				panel.add(new JLabel(buttons[i]));
			} else {
				panel.add(new JButton(buttons[i]));
			}
		}

		add(panel);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				GridLayoutEx ex = new GridLayoutEx();
				ex.setVisible(true);
			}
		});

	}

}
