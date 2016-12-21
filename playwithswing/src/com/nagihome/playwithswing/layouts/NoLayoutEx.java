package com.nagihome.playwithswing.layouts;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class NoLayoutEx extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoLayoutEx() {
		initUI();
	}
	

	public void initUI() {

		setTitle("No Layout UI");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JButton ok = new JButton("Ok");
		ok.setBounds(50, 50, 50, 25);

		JButton close = new JButton("Close");
		close.setBounds(100, 50, 50, 25);

		add(ok);
		add(close);

		setLayout(null);

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				NoLayoutEx ex = new NoLayoutEx();
				ex.setVisible(true);
			}
		});
	}

}
