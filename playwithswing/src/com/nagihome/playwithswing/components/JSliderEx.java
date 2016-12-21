/**
 * 
 */
package com.nagihome.playwithswing.components;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author nageswararao
 *
 */
public class JSliderEx extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ImageIcon min;
	private ImageIcon med;
	private ImageIcon max;
	private ImageIcon mut;

	private JSlider slider;
	private JLabel jLabel;

	public JSliderEx() {
		initUI();
	}

	private void initUI() {

		loadImages();

		slider = new JSlider(0, 150, 0);
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {

				int value = slider.getValue();

				if (value == 0) {
					jLabel.setIcon(mut);
				} else if (value > 0 && value <= 30) {
					jLabel.setIcon(min);
				} else if (value > 30 && value < 80) {
					jLabel.setIcon(med);
				} else {
					jLabel.setIcon(max);
				}
			}
		});

		jLabel = new JLabel(mut, JLabel.CENTER);

		createLayout(slider, jLabel);

		setTitle("JSlider Demo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(1000, 800);
		pack();
	}

	private void createLayout(JComponent... comps) {

		Container container = getContentPane();
		GroupLayout gl = new GroupLayout(container);
		container.setLayout(gl);

		gl.setAutoCreateContainerGaps(true);

		gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(comps[0]).addComponent(comps[1]));
		gl.setVerticalGroup(gl.createParallelGroup(Alignment.CENTER).addComponent(comps[0]).addComponent(comps[1]));

	}

	private void loadImages() {

		min = new ImageIcon(
				new ImageIcon("images/min_vol.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		med = new ImageIcon(
				new ImageIcon("images/med_vol.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		max = new ImageIcon(
				new ImageIcon("images/max_vol.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		mut = new ImageIcon(
				new ImageIcon("images/mut_vol.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JSliderEx ex = new JSliderEx();
				ex.setVisible(true);
			}
		});

	}

}
