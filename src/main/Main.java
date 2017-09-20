package main;

import controller.GameFieldChangeController;
import controller.SettingsController;
import gui.MainFrame;

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