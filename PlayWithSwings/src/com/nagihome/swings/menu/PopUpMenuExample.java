/**
 * 
 */
package com.nagihome.swings.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * @author Nagi
 *
 */
public class PopUpMenuExample extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5664702885720232298L;

	public PopUpMenuExample() {
		intiUI();
	}

	private void intiUI() {

		JPopupMenu popUpMenu = new JPopupMenu();

		JMenuItem maxMenuItem = new JMenuItem("maximise");
		maxMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});

		JMenuItem closeMenuItem = new JMenuItem("close");
		closeMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		popUpMenu.add(maxMenuItem);
		popUpMenu.add(closeMenuItem);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					popUpMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		
		setTitle("Pop-Up menu Example");
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new PopUpMenuExample().setVisible(true);

	}

}
