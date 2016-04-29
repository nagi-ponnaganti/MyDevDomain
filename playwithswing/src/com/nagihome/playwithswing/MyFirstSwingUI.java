/**
 * 
 */
package com.nagihome.playwithswing;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;

/**
 * @author nageswararao
 *
 */
public class MyFirstSwingUI {

	static JFrame frmMyFirstSwing = new JFrame();
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args){
		frmMyFirstSwing.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(181, 16, 285, 508);
		frmMyFirstSwing.getContentPane().add(panel);
		frmMyFirstSwing.setBackground(Color.GRAY);
		frmMyFirstSwing.setTitle("My First Swing");
		
		frmMyFirstSwing.setVisible(true);
		
	}
}
