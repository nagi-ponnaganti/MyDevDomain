/**
 * 
 */
package com.nagihome.swings.menu;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;

/**
 * @author Nagi
 *
 */
public class MenuOnRightExample extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9108841035769575260L;

	public MenuOnRightExample() {
		initUI();
	}

	private void initUI() {
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("file");
		JMenu viewMenu = new JMenu("view");
		JMenu toolsMenu = new JMenu("tools");
		JMenu helpMenu = new JMenu("help");
		
		menuBar.add(fileMenu);
		menuBar.add(viewMenu);
		menuBar.add(toolsMenu);
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(helpMenu);
		
		setJMenuBar(menuBar);
		
		setTitle("This is Right Menu");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MenuOnRightExample().setVisible(true);
			}
		});

	}

}
