/**
 * 
 */
package com.nagihome.playwithswing.components;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author nageswararao
 *
 */
public class JComboBoxEx extends JFrame implements ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JComboBox<String> box;
	private JLabel label;
	private String[] distros;

	public JComboBoxEx() {

		initUI();

		setTitle("JCombobox Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	private void initUI() {

		distros = new String[] { "Ubuntu", "Redhat", "Arch", "Debian", "Mint" };

		box = new JComboBox<>(distros);
		box.addItemListener(this);

		label = new JLabel("Ubuntu");

		createLayout(box, label);

	}

	private void createLayout(JComponent... comps) {

		Container container = getContentPane();
		GroupLayout gl = new GroupLayout(container);
		container.setLayout(gl);
		
		gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

		gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(comps[0]).addComponent(comps[1]));
		gl.setVerticalGroup(gl.createParallelGroup(Alignment.BASELINE).addComponent(comps[0]).addComponent(comps[1]));

		pack();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent arg0) {

		if (arg0.getStateChange() == ItemEvent.SELECTED) {
			label.setText(arg0.getItem().toString());
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JComboBoxEx ex = new JComboBoxEx();
				ex.setVisible(true);
			}
		});
	}

}
