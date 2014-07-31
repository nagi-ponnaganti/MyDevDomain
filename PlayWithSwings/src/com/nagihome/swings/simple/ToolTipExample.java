/**
 * 
 */
package com.nagihome.swings.simple;

import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Nagi
 *
 */
public class ToolTipExample extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1913921314774293374L;

	public ToolTipExample() {
		System.out.println("Start Initilizing UI");
		initUI();
		System.out.println("Done Initilizing UI");
	}

	private void initUI() {
		
		Container pane = (JPanel)getContentPane();
		GroupLayout groupLayOut = new GroupLayout(pane);
		pane.setLayout(groupLayOut);
		
		JButton btn = new JButton("Button");
		
        btn.setToolTipText("A button component");
        
		groupLayOut.setHorizontalGroup(groupLayOut.createSequentialGroup().addComponent(btn).addGap(200));
		groupLayOut.setVerticalGroup(groupLayOut.createSequentialGroup().addComponent(btn).addGap(100));
		
		pack();
		
		setTitle("Tool Tip");
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
				new ToolTipExample().setVisible(true);
			}
		});
	}

}
