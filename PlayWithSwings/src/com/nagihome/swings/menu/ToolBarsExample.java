/**
 * 
 */
package com.nagihome.swings.menu;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * @author Nagi
 *
 */
public class ToolBarsExample extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7087485531575659977L;
	
	public ToolBarsExample(){
		initUI();
	}
	
	private void initUI(){
		JToolBar toolBar01 = new JToolBar();
		JToolBar toolBar02 = new JToolBar();
		
		ImageIcon newIcon = new ImageIcon("new.jpg");
		ImageIcon openIcon = new ImageIcon("open.jpg");
		ImageIcon saveIcon = new ImageIcon("save.jpg");
		ImageIcon closeIcon = new ImageIcon("close.jpg");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton newButton = new JButton(newIcon);
		JButton openButton = new JButton(openIcon);
		JButton saveButton = new JButton(saveIcon);
		JButton closeButton = new JButton(closeIcon);
		
		toolBar01.add(newButton);
		toolBar01.add(openButton);
		toolBar01.add(saveButton);
		toolBar01.setAlignmentX(0);
		
		toolBar02.add(closeButton);
		toolBar02.setAlignmentX(0);
		
		panel.add(toolBar01);
		panel.add(toolBar02);
		
		add(panel, BorderLayout.NORTH);
		
		setTitle("ToolBars Menu");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ToolBarsExample().setVisible(true);
	}

}
