package Controller;

import java.awt.Color;

import javax.swing.JTextField;

import Main.GameOfLife;

public class GameFieldChangeController {

	public void updateGameField(GameOfLife game, JTextField[][] table, JTextField generationsTF) {
		boolean[][] currentPopulation = new boolean[table.length][table[1].length];
		boolean[][] newPopulation;

		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if (table[i][j].getText().equals("Alive")) {
					currentPopulation[i][j] = true;
				} else {
					currentPopulation[i][j] = false;
				}
			}
		}

		newPopulation = game.gameOfLife(currentPopulation, Integer.parseInt(generationsTF.getText()));

		for (int i = 0; i < newPopulation.length; i++) {
			for (int j = 0; j < newPopulation[i].length; j++) {
				if (newPopulation[i][j]) {
					table[i][j].setText("Alive");
					table[i][j].setBackground(new Color(100, 255, 100));
				} else {
					table[i][j].setText("Dead");
					table[i][j].setBackground(new Color(255, 100, 100));
				}
			}
		}
	}

}
