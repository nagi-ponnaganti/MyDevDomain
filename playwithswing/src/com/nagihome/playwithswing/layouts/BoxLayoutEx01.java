/**
 * 
 */
package com.nagihome.playwithswing.layouts;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author nageswararao
 *
 */
public class BoxLayoutEx01 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BoxLayoutEx01() {

		System.out.println("Creating Instances");

		initUI();

	}

	private void initUI() {

		System.out.println("Initilizing UI Now");

		JPanel basic = new JPanel();
		basic.setLayout(new BoxLayout(basic, BoxLayout.Y_AXIS));

		add(basic);
		
		basic.add(Box.createVerticalGlue());

		JPanel bottom = new JPanel();
		bottom.setAlignmentX(1f);
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));

		JButton ok = new JButton("OK");
		JButton close = new JButton("CLOSE");

		bottom.add(ok);
		bottom.add(Box.createRigidArea(new Dimension(5, 0)));
		bottom.add(close);
		bottom.add(Box.createRigidArea(new Dimension(15, 0)));

		basic.add(bottom);
		basic.add(Box.createRigidArea(new Dimension(0, 50)));

		setTitle("Two Buttons");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				BoxLayoutEx01 ex01 = new BoxLayoutEx01();
				ex01.setVisible(true);
			}
		});

	}
}
