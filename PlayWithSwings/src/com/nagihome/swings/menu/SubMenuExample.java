/**
 * 
 */
package com.nagihome.swings.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

/**
 * @author Nagi
 *
 */
public class SubMenuExample extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8332406149058749381L;

	public SubMenuExample() {
		init();
	}

	private void init() {

		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("file");
		fileMenu.setMnemonic(KeyEvent.VK_F);

		JMenu importMenu = new JMenu("import");
		importMenu.setMnemonic(KeyEvent.VK_I);

		ImageIcon newIcon = new ImageIcon("new.jpg");
		ImageIcon saveIcon = new ImageIcon("save.jpg");
		ImageIcon openIcon = new ImageIcon("open.jpg");
		ImageIcon closeIcon = new ImageIcon("close.jpg");

		JMenuItem newMenuItem = new JMenuItem("new", newIcon);
		newMenuItem.setMnemonic(KeyEvent.VK_N);

		JMenuItem saveMenuItem = new JMenuItem("save", saveIcon);
		saveMenuItem.setMnemonic(KeyEvent.VK_S);

		JMenuItem openMenuItem = new JMenuItem("open", openIcon);
		openMenuItem.setMnemonic(KeyEvent.VK_O);

		JMenuItem closeMenuItem = new JMenuItem("close", closeIcon);
		closeMenuItem.setMnemonic(KeyEvent.VK_C);

		JMenuItem importBookMarks = new JMenuItem("import bookmarks");
		JMenuItem importMails = new JMenuItem("import mails");
		JMenuItem importNewsFeeds = new JMenuItem("import news feeds");

		importMenu.add(importBookMarks);
		importMenu.add(importMails);
		importMenu.add(importNewsFeeds);

		closeMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);

		fileMenu.addSeparator();

		fileMenu.add(importMenu);

		fileMenu.addSeparator();

		fileMenu.add(closeMenuItem);

		menuBar.add(fileMenu);

		setJMenuBar(menuBar);

		setTitle("Sub Menu Example");
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
				new SubMenuExample().setVisible(true);
			}
		});
	}

}
