/**
 * 
 */
package com.nagihome.playwithswing.event;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * @author nageswararao
 *
 */
public class EventObjectEx extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Logger LOGGER = Logger.getLogger(EventObjectEx.class.getName());

	public EventObjectEx() {
		LOGGER.info("Initilizing the UI");
		initUI();
		LOGGER.info("Initilizing the UI Done");

	}

	@SuppressWarnings("rawtypes")
	private JList jList;
	@SuppressWarnings("rawtypes")
	private DefaultListModel defaultListModel;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initUI() {

		Container contentPane = getContentPane();
		GroupLayout layout = new GroupLayout(contentPane);
		contentPane.setLayout(layout);

		layout.setAutoCreateContainerGaps(true);

		defaultListModel = new DefaultListModel();
		jList = new JList(defaultListModel);
		jList.setMinimumSize(new Dimension(250, 150));
		jList.setBorder(BorderFactory.createEtchedBorder());

		JButton jButton = new JButton("OK");
		jButton.addActionListener(new ClickAction());

		layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(jList).addGap(20).addComponent(jButton));
		layout.setVerticalGroup(layout.createParallelGroup().addComponent(jButton).addComponent(jList));

		pack();

		setTitle("Event Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				EventObjectEx ex = new EventObjectEx();
				ex.setVisible(true);
			}
		});
	}

	private class ClickAction extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent ae) {

			Locale locale = Locale.getDefault();
			LOGGER.info("Locale Info: " + locale.getCountry());

			Date date = new Date(ae.getWhen());
			String tm = DateFormat.getDateInstance(DateFormat.SHORT, locale).format(date);

			if (defaultListModel != null) {
				defaultListModel.clear();
			}

			if (ae.getID() == ActionEvent.ACTION_PERFORMED) {
				defaultListModel.addElement("Event Id: ACTION_PERFORMED ");
			}

			defaultListModel.addElement("Time: " + tm);
			defaultListModel.addElement("Source: " + ae.getSource().getClass().getName());

			StringBuffer buffers = new StringBuffer();
			buffers.append("Modifiers: ");

			int mod = ae.getModifiers();

			if ((mod & ActionEvent.ALT_MASK) > 0) {
				buffers.append("Alt");
			}

			if ((mod & ActionEvent.CTRL_MASK) > 0) {
				buffers.append("Ctrl");
			}

			if ((mod & ActionEvent.META_MASK) > 0) {
				buffers.append("Meta");
			}

			if ((mod & ActionEvent.SHIFT_MASK) > 0) {
				buffers.append("Shift");
			}

			defaultListModel.addElement(buffers);

		}

	}

}
