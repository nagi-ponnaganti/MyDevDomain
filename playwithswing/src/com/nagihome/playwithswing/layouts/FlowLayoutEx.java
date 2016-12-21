/**
 * 
 */
package com.nagihome.playwithswing.layouts;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.SwingUtilities;

/**
 * @author nageswararao
 *
 */
public class FlowLayoutEx extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlowLayoutEx() {
		initUI();
	}

	public void initUI() {
		
		setTitle("Flow Layout Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel jpanel = new JPanel();
		
		JTextArea jTextArea = new JTextArea("New Area");
		jTextArea.setPreferredSize(new Dimension(200, 200));
		
		JButton jButton = new JButton("button");
		jpanel.add(jButton);
		
		JTree tree = new JTree();
		jpanel.add(tree);
		
		jpanel.add(jTextArea);
		
		add(jpanel);
		
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				FlowLayoutEx ex = new FlowLayoutEx();
				ex.setVisible(true);				
			}
		});
	}

}
