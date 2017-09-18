package Main;

import GUI.MainFrame;

public class Main {
	
	static MainFrame mainFrame;
	static GameOfLife game;
	
	public static void main(String[] args)
	{		
		game = new GameOfLife();
		mainFrame = new MainFrame(game);
	}
	
}