package Main;

import Controller.GameFieldChangeController;
import Controller.SettingsController;
import GUI.MainFrame;

public class Main {

	static MainFrame mainFrame;
	static GameOfLife game;
	static GameFieldChangeController gameFieldController;
	static SettingsController settingsController;

	public static void main(String[] args) {
		game = new GameOfLife();
		gameFieldController = new GameFieldChangeController();
		settingsController = new SettingsController(game);
		mainFrame = new MainFrame(game, gameFieldController, settingsController);
	}

}