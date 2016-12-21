/**
 * 
 */
package com.nagihome.playwithswing.layouts;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 * @author nageswararao
 *
 */
public class MultipleListenersEx extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel statusBar;

	private JSpinner spinner;

	private int count = 0;

	public MultipleListenersEx() {
		initUI();
	}

	public void initUI() {

		JPanel panel = new JPanel();
		GroupLayout gl = new GroupLayout(panel);
		panel.setLayout(gl);
		add(panel, BorderLayout.CENTER);

		statusBar = new JLabel("0");
		add(statusBar, BorderLayout.SOUTH);

		JButton button01 = new JButton("+");
		button01.addActionListener(new ButtonListener01());
		button01.addActionListener(new ButtonListener02());

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);

		SpinnerModel spinnerModel = new SpinnerNumberModel(year, year - 100, year + 100, 1);
		spinner = new JSpinner(spinnerModel);
		spinner.setEditor(new JSpinner.NumberEditor(spinner, "#"));

		gl.setAutoCreateGaps(true);

		gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(button01).addGap(20).addComponent(spinner,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));

		gl.setVerticalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(button01)
				.addComponent(spinner, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));

		pack();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setTitle("Multiple Listeners");

	}

	class ButtonListener01 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Integer val = (Integer) spinner.getValue();
			spinner.setValue(val);
		}

	}

	class ButtonListener02 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			statusBar.setText(Integer.toString(++count));

		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {

				MultipleListenersEx ex = new MultipleListenersEx();
				ex.setVisible(true);

			}
		});

	}

}
