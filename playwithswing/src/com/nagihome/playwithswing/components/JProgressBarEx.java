/**
 * 
 */
package com.nagihome.playwithswing.components;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 * @author nageswararao
 *
 */
public class JProgressBarEx extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JProgressBar proBar;
	private JButton jButton;
	private Timer timer;

	public JProgressBarEx() {
		initUI();
	}

	private void initUI() {
		proBar = new JProgressBar();
		proBar.setStringPainted(true);

		jButton = new JButton("Start");
		jButton.addActionListener(new ClickAction());

		timer = new Timer(50, new UpdatebarListener());

		createLayout(proBar, jButton);

	}

	private void createLayout(JComponent... components) {
		Container container = getContentPane();
		GroupLayout gl = new GroupLayout(container);
		container.setLayout(gl);

		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);

		gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(components[0]).addComponent(components[1]));
		gl.setVerticalGroup(
				gl.createParallelGroup(Alignment.CENTER).addComponent(components[0]).addComponent(components[1]));

		pack();
	}

	/**
	 * @author nageswararao
	 *
	 */
	public class ClickAction implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
		 * ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {

			if (timer.isRunning()) {
				timer.stop();
				jButton.setText("Start");
			} else if (!"End".equals(jButton.getText())) {
				timer.start();
				jButton.setText("Stop");
			}

		}

	}

	/**
	 * @author nageswararao
	 *
	 */
	public class UpdatebarListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
		 * ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int value = proBar.getValue();

			if (value >= 100) {

				timer.stop();
				jButton.setText("End");
				return;
			}

			proBar.setValue(++value);

		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JProgressBarEx ex = new JProgressBarEx();
				ex.setVisible(true);
			}
		});

	}

}
