package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.SettingsController;

public class SettingsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 450;
	private static final int HEIGHT = 350;

	private JLabel minAmountLabel, maxAmountLabel, AliveLabel, DeadLabel;
	private JTextField minAlvieForDeadTF, maxAlvieForDeadTF, minAlvieForAliveTF, maxAlvieForAliveTF;
	private JButton saveAndCloseB;
	private SettingsController controller;

	private SaveAndCloseButtonHandler scHandler;

	public SettingsFrame(SettingsController pController) {

		controller = pController;

		minAmountLabel = new JLabel("Min Amount (Inclusive)");
		maxAmountLabel = new JLabel("Max Amount (Inclusive)");
		AliveLabel = new JLabel("Living Neighbours for Living to Survive");
		DeadLabel = new JLabel("Living Neighbours for Dead to get Alive");

		minAlvieForDeadTF = new JTextField();
		maxAlvieForDeadTF = new JTextField();
		minAlvieForAliveTF = new JTextField();
		maxAlvieForAliveTF = new JTextField();

		saveAndCloseB = new JButton("Save And Close");
		scHandler = new SaveAndCloseButtonHandler();
		saveAndCloseB.addActionListener(scHandler);

		controller.getCurrentSettings(minAlvieForDeadTF, maxAlvieForDeadTF, minAlvieForAliveTF, maxAlvieForAliveTF);

		setTitle("Settings");

		Container pane = getContentPane();
		pane.setLayout(new GridLayout(7, 2));

		pane.add(AliveLabel);
		pane.add(new JPanel());
		pane.add(minAmountLabel);
		pane.add(maxAmountLabel);
		pane.add(minAlvieForAliveTF);
		pane.add(maxAlvieForAliveTF);
		pane.add(DeadLabel);
		pane.add(new JPanel());
		pane.add(minAmountLabel);
		pane.add(maxAmountLabel);
		pane.add(minAlvieForDeadTF);
		pane.add(maxAlvieForDeadTF);
		pane.add(saveAndCloseB);

		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setResizable(false);

	}

	private class SaveAndCloseButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.setSettings(minAlvieForDeadTF, maxAlvieForDeadTF, minAlvieForAliveTF, maxAlvieForAliveTF);
			setVisible(false);
		}
	}

}
