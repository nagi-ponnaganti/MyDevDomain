/**
 * 
 */
package com.nagihome.swings.simple;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Nagi
 *
 */
public class QuitButtonExample extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1378291708529602412L;

	public QuitButtonExample() {
		System.out.println("Intializing the UI");
		initUI();
	}

	private void initUI() {

		Container container = getContentPane();
		GroupLayout groupLayOut = new GroupLayout(container);

		container.setLayout(groupLayOut);

		JButton quitButton = new JButton("Quit");

		quitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		groupLayOut.setAutoCreateGaps(true);

		groupLayOut.setHorizontalGroup(groupLayOut.createSequentialGroup()
				.addComponent(quitButton));
		groupLayOut.setVerticalGroup(groupLayOut.createSequentialGroup()
				.addComponent(quitButton));

		pack();

		setTitle("Quit Button Sample");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new QuitButtonExample().setVisible(true);
			}
		});
	}

}
