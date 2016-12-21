/**
 * 
 */
package com.nagihome.playwithswing.components;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

/**
 * @author nageswararao
 *
 */
public class JToggleButtonEx extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JToggleButton redBtn;
	private JToggleButton greenBtn;
	private JToggleButton blueBtn;
	private JPanel display;

	public JToggleButtonEx() {
		initUI();
	}

	private void initUI() {
		redBtn = new JToggleButton("Red");
		redBtn.addActionListener(this);

		greenBtn = new JToggleButton("Green");
		greenBtn.addActionListener(this);

		blueBtn = new JToggleButton("Blue");
		blueBtn.addActionListener(this);

		display = new JPanel();
		display.setBorder(LineBorder.createGrayLineBorder());
		display.setPreferredSize(new Dimension(120, 120));
		display.setBackground(Color.BLACK);

		createLayout(redBtn, greenBtn, blueBtn, display);

		setTitle("JToggleButton");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void createLayout(JComponent... comps) {
		Container container = getContentPane();
		GroupLayout gl = new GroupLayout(container);
		container.setLayout(gl);

		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);

		gl.setHorizontalGroup(
				gl.createSequentialGroup()
						.addGroup(gl.createParallelGroup().addComponent(comps[0]).addComponent(comps[1])
								.addComponent(comps[2]))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(comps[3]));

		gl.setVerticalGroup(gl.createParallelGroup(Alignment.CENTER)
				.addGroup(
						gl.createSequentialGroup().addComponent(comps[0]).addComponent(comps[1]).addComponent(comps[2]))
				.addComponent(comps[3]));

		gl.linkSize(redBtn, greenBtn, blueBtn);

		pack();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		Color color = display.getBackground();
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();

		if ("red".equalsIgnoreCase(arg0.getActionCommand())) {

			if (red == 0) {
				red = 255;
			} else {
				red = 0;
			}
		}

		if ("green".equalsIgnoreCase(arg0.getActionCommand())) {

			if (green == 0) {
				green = 255;
			} else {
				green = 0;
			}
		}

		if ("blue".equalsIgnoreCase(arg0.getActionCommand())) {

			if (blue == 0) {
				blue = 255;
			} else {
				blue = 0;
			}
		}

		Color newColor = new Color(red, green, blue);
		display.setBackground(newColor);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JToggleButtonEx ex = new JToggleButtonEx();
				ex.setVisible(true);
			}
		});

	}

}
