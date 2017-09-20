package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 450;
	private static final int HEIGHT = 250;

	private JLabel WidthLabel, HeightLabel;
	private JTextField WidthTF, HeightTF;
	private JButton saveAndCloseB;

	private SaveAndCloseButtonHandler scHandler;

	MainFrame main;

	public NewFrame(int gameFieldWidth, int gameFieldHeight, MainFrame mainFrame) {

		main = mainFrame;

		WidthLabel = new JLabel("Set the gamefield width");
		HeightLabel = new JLabel("Set the gamefield height");

		WidthTF = new JTextField(gameFieldWidth);
		WidthTF.setText(Integer.toString(gameFieldWidth));
		HeightTF = new JTextField(gameFieldHeight);
		HeightTF.setText(Integer.toString(gameFieldHeight));

		saveAndCloseB = new JButton("Save And Close");
		scHandler = new SaveAndCloseButtonHandler();
		saveAndCloseB.addActionListener(scHandler);

		setTitle("Settings");

		Container pane = getContentPane();
		pane.setLayout(new GridLayout(3, 2));

		pane.add(WidthLabel);
		pane.add(HeightLabel);
		pane.add(WidthTF);
		pane.add(HeightTF);
		pane.add(saveAndCloseB);

		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setResizable(false);

	}

	private class SaveAndCloseButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			main.createFrame(Integer.parseInt(WidthTF.getText()), Integer.parseInt(HeightTF.getText()));
		}
	}

}
