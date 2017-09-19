package Main;

import Controller.GameFieldChangeController;
import GUI.MainFrame;

public class Main {

	static MainFrame mainFrame;
	static GameOfLife game;
	static GameFieldChangeController gameFieldController;

	public static void main(String[] args) {
		game = new GameOfLife();
		gameFieldController = new GameFieldChangeController();
		mainFrame = new MainFrame(game, gameFieldController);
	}

}