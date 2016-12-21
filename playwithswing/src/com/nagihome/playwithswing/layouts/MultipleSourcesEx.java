/**
 * 
 */
package com.nagihome.playwithswing.layouts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author nageswararao
 *
 */
public class MultipleSourcesEx extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel statusBar;

	public MultipleSourcesEx() {
		initUI();
	}

	private void initUI() {

		JPanel jPanel = new JPanel();
		GroupLayout layout = new GroupLayout(jPanel);
		jPanel.setLayout(layout);

		statusBar = new JLabel("Zetcode");
		statusBar.setBorder(BorderFactory.createEtchedBorder());

		ButtonListener butlist = new ButtonListener();

		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(butlist);
		closeButton.setPreferredSize(new Dimension(100, 50));
		
		JButton openButton = new JButton("Open");
		openButton.addActionListener(butlist);

		JButton findButton = new JButton("Find");
		findButton.addActionListener(butlist);

		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(butlist);

		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);

		layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(closeButton).addComponent(openButton)
				.addComponent(findButton).addComponent(saveButton).addGap(230));

		layout.setVerticalGroup(layout.createParallelGroup().addComponent(closeButton).addComponent(openButton)
				.addComponent(findButton).addComponent(saveButton).addGap(200));

		layout.linkSize(closeButton, openButton, findButton, saveButton);

		add(jPanel, BorderLayout.CENTER);
		add(statusBar, BorderLayout.SOUTH);
		pack();

		setSize(new Dimension(1000, 1000));
		setTitle("Multiple Sources");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				MultipleSourcesEx ms = new MultipleSourcesEx();
				ms.setVisible(true);
			}
		});
	}

	class ButtonListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
		 * ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent ae) {

			JButton jButton = (JButton) ae.getSource();

			statusBar.setText(" " + jButton.getText() + " button clicked");

		}

	}
}
