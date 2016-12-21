/**
 * 
 */
package com.nagihome.playwithswing.layouts;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author nageswararao
 *
 */
public class RemoveListenerEx extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel label;
	private JButton addButton;
	private JCheckBox activeBox;
	private ButtonListener listener;
	int counter = 0;

	public RemoveListenerEx() {
		initUI();
	}

	private void initUI() {

		Container contentPane = getContentPane();
		GroupLayout gl = new GroupLayout(contentPane);
		contentPane.setLayout(gl);

		addButton = new JButton("+");
		listener = new ButtonListener();

		activeBox = new JCheckBox("Active Listener");
		activeBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (activeBox.isSelected()) {
					addButton.addActionListener(listener);
				} else {
					addButton.removeActionListener(listener);
				}

			}
		});

		label = new JLabel("0");
		gl.setAutoCreateContainerGaps(true);

		gl.setHorizontalGroup(gl.createSequentialGroup()
				.addGroup(gl.createParallelGroup().addComponent(addButton).addComponent(label)).addGap(30)
				.addComponent(activeBox));

		gl.setVerticalGroup(gl.createSequentialGroup().addGroup(gl.createParallelGroup().addComponent(addButton)
				.addComponent(activeBox)).addGap(30).addComponent(label));

		pack();

		setTitle("Remove listener");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText(Integer.toString(++counter));

		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				RemoveListenerEx ex = new RemoveListenerEx();
				ex.setVisible(true);
			}
		});
	}

}
