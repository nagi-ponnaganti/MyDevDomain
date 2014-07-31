/**
 * 
 */
package com.nagihome.swings.simple;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * @author Nagi
 *
 */
public class SimpleWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimpleWindow(){
		
		setTitle("Simple Window");
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
				new SimpleWindow().setVisible(true);				
			}
		});
		

	}

}
