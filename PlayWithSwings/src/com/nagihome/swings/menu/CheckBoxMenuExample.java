/**
 * 
 */
package com.nagihome.swings.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.border.EtchedBorder;

/**
 * @author Nagi
 *
 */
public class CheckBoxMenuExample extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4581033402852308908L;

	public CheckBoxMenuExample() {
		initUI();
	}

	private void initUI() {

		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("file");
		fileMenu.setMnemonic(KeyEvent.VK_F);

		JMenu viewMenu = new JMenu("view");
		viewMenu.setMnemonic(KeyEvent.VK_V);

		JCheckBoxMenuItem statusCheckBaxMenuItem = new JCheckBoxMenuItem(
				"Status Bar");
		statusCheckBaxMenuItem.setState(true);

		JLabel statusBar = new JLabel("StatusBar");

		statusCheckBaxMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (statusBar.isVisible()) {
					statusBar.setVisible(false);
				} else {
					statusBar.setVisible(true);
				}

			}
		});

		viewMenu.add(statusCheckBaxMenuItem);

		menuBar.add(fileMenu);
		menuBar.add(viewMenu);

		setJMenuBar(menuBar);

		statusBar.setBorder(BorderFactory
				.createEtchedBorder(EtchedBorder.RAISED));

		add(statusBar, BorderLayout.SOUTH);

		setTitle("Checkbox Menu Item");
		setSize(500, 400);
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
				new CheckBoxMenuExample().setVisible(true);
			}
		});

	}

}
