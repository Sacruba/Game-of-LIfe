package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.GameFieldChangeController;
import Controller.SettingsController;
import Main.GameOfLife;

public class MainFrame extends JFrame {

	private GameOfLife game;
	private GameFieldChangeController gameFieldController;
	private SettingsController settingsContoller;

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 1400;
	private static final int HEIGHT = 800;

	private JLabel generations;
	private JTextField generationsTF;
	private JButton[][] table;
	private JButton calculateB, exitB, settingsB;
	private JPanel[] menu;

	// Button handlers:
	private CalculateButtonHandler cbHandler;
	private ExitButtonHandler ebHandler;
	private GameFieldButtonHandler gfbHandler;
	private SettingsButtonHandler sbHandler;

	public MainFrame(GameOfLife theGame, GameFieldChangeController pGameFieldController,
			SettingsController pSettingsContoller) {

		game = theGame;
		gameFieldController = pGameFieldController;
		settingsContoller = pSettingsContoller;

		generations = new JLabel("Generations: ", SwingConstants.RIGHT);
		generationsTF = new JTextField(10);
		generationsTF.setText("1");
		generationsTF.setHorizontalAlignment(JTextField.CENTER);

		menu = new JPanel[10];
		table = new JButton[10][10];

		for (int i = 0; i < table.length; i++) {
			menu[i] = new JPanel();
		}

		// SPecify handlers for each button and add (register) ActionListeners
		// to each button.
		calculateB = new JButton("Calculate");
		cbHandler = new CalculateButtonHandler();
		calculateB.addActionListener(cbHandler);

		exitB = new JButton("Exit");
		ebHandler = new ExitButtonHandler();
		exitB.addActionListener(ebHandler);

		settingsB = new JButton("Settings");
		sbHandler = new SettingsButtonHandler();
		settingsB.addActionListener(sbHandler);

		setTitle("The Game of Life");

		Container pane = getContentPane();
		pane.setLayout(new GridLayout(10, 11));

		gfbHandler = new GameFieldButtonHandler();

		for (int i = 0; i < table.length; i++) {
			pane.add(menu[i]);
			for (int j = 0; j < table[i].length; j++) {
				table[i][j] = new JButton("Dead");
				table[i][j].addActionListener(gfbHandler);
				pane.add(table[i][j]);
				table[i][j].setBackground(new Color(255, 100, 100));
				table[i][j].setHorizontalAlignment(JButton.CENTER);
			}
		}

		menu[1].add(generations);
		menu[2].add(generationsTF);
		menu[3].add(calculateB);
		menu[8].add(settingsB);
		menu[9].add(exitB);

		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private class CalculateButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			gameFieldController.updateGameField(game, table, generationsTF);
		}
	}

	private class ExitButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	private class GameFieldButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton sourceButton = (JButton) (e.getSource());
			if (sourceButton.getText().equals("Dead")) {
				sourceButton.setText("Alive");
				sourceButton.setBackground(new Color(100, 255, 100));
			} else {
				sourceButton.setText("Dead");
				sourceButton.setBackground(new Color(255, 100, 100));
			}
		}
	}

	private class SettingsButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new SettingsFrame(settingsContoller);
		}
	}

}
