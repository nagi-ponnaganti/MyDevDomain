/**
 * 
 */
package com.nagihome.playwithswing.components;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * @author nageswararao
 *
 */
public class JCheckBoxEx extends JFrame implements ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JCheckBoxEx() {
		initUI();
	}

	private void initUI() {

		System.out.println("Initizie the UI");

		JCheckBox checkBox = new JCheckBox("JCheckBox");
		checkBox.setBounds(100, 100, 100, 100);
		checkBox.addItemListener(this);

		addJComponent(checkBox);

		setTitle("JCheck Box Example");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);

	}

	private void addJComponent(JComponent... args) {
		Container container = getContentPane();
		GroupLayout gl = new GroupLayout(container);
		container.setLayout(gl);

		gl.setAutoCreateContainerGaps(true);

		gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(args[0]));
		gl.setVerticalGroup(gl.createParallelGroup().addComponent(args[0]));

		pack();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {

				JCheckBoxEx ex = new JCheckBoxEx();
				ex.setVisible(true);				
			}
		});
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {

		if(arg0.getStateChange() == ItemEvent.SELECTED) {
			setTitle("Jcheckbox selected");
		} else if (arg0.getStateChange() == ItemEvent.DESELECTED) {
			setTitle("JCheckBox UnSelected");
		} else {
			System.err.println("Something is wrong");
		}		
		
	}

}
