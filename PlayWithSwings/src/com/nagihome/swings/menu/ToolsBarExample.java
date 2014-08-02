/**
 * 
 */
package com.nagihome.swings.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

/**
 * @author Nagi
 *
 */
public class ToolsBarExample extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4996202824677828903L;

	public ToolsBarExample() {
		initUI();
	}

	private void initUI() {

		JMenuBar menuBar = new JMenuBar();

		JMenuItem fileMenuItem = new JMenuItem("file");
		menuBar.add(fileMenuItem);
		setJMenuBar(menuBar);

		JToolBar toolBar = new JToolBar();
		ImageIcon closeIcon = new ImageIcon("close.jpg");

		JButton closebutton = new JButton(closeIcon);
		closebutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		toolBar.add(closebutton);

		add(toolBar, BorderLayout.NORTH);

		setTitle("Pop-Up Menu");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new ToolsBarExample().setVisible(true);

			}
		});
	}

}
