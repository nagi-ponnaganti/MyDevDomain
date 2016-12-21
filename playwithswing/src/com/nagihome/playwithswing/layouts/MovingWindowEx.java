/**
 * 
 */
package com.nagihome.playwithswing.layouts;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author nageswararao
 *
 */
public class MovingWindowEx extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel labelX;
	private JLabel labelY;

	public MovingWindowEx() {
		initUI();
	}

	private void initUI() {

		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		addComponentListener(new MoveAdapter());

		labelX = new JLabel("X: ");
		labelX.setFont(new Font("Serif", Font.BOLD, 14));
		labelX.setBounds(20, 20, 65, 25);

		labelY = new JLabel("Y: ");
		labelY.setFont(new Font("Serif", Font.BOLD, 14));
		labelY.setBounds(20, 45, 65, 25);

		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);

		gl.setHorizontalGroup(gl.createParallelGroup().addComponent(labelX).addComponent(labelY));
		gl.setVerticalGroup(gl.createSequentialGroup().addComponent(labelX).addComponent(labelY));
		
		pack();
		setTitle("Moving Window Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500, 500);		
	}
	
	class MoveAdapter extends ComponentAdapter {
		
		 @Override
	        public void componentMoved(ComponentEvent e) {
	            
	            int x = e.getComponent().getX();
	            int y = e.getComponent().getY();
	            
	            labelX.setText("X: " + x);
	            labelY.setText("Y: " + y);
	        }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				MovingWindowEx ex = new MovingWindowEx();
				ex.setVisible(true);
			}
		});
	}

}
