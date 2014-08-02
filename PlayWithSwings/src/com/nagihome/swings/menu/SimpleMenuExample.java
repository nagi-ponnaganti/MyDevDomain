/**
 * 
 */
package com.nagihome.swings.menu;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author Nagi
 *
 */
public class SimpleMenuExample extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7942395335598513164L;

	public SimpleMenuExample() {
		initUI();
	}

	private void initUI() {

		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		ImageIcon exitIcon = new ImageIcon("close.jpg");
		
		JMenuItem closeItem = new JMenuItem("Exit", exitIcon);

		closeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		fileMenu.add(closeItem);
		menuBar.add(fileMenu);

		setJMenuBar(menuBar);

		setTitle(" Simple menu :) ");
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
				new SimpleMenuExample().setVisible(true);

			}
		});

	}

}
