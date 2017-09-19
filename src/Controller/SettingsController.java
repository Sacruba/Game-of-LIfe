package Controller;

import javax.swing.JTextField;

import Main.GameOfLife;

public class SettingsController {

	private GameOfLife game;

	public SettingsController(GameOfLife theGame) {
		game = theGame;
	}

	public void getCurrentSettings(JTextField minAlvieForDeadTF, JTextField maxAlvieForDeadTF,
			JTextField minAlvieForAliveTF, JTextField maxAlvieForAliveTF) {

		minAlvieForDeadTF.setText(Integer.toString(game.getMinLivingNeighboursForDead()));
		maxAlvieForDeadTF.setText(Integer.toString(game.getMaxLivingNeighboursForDead()));
		minAlvieForAliveTF.setText(Integer.toString(game.getMinLivingNeighboursForAlive()));
		maxAlvieForAliveTF.setText(Integer.toString(game.getMaxLivingNeighboursForAlive()));
	}

	public void setSettings(JTextField minAlvieForDeadTF, JTextField maxAlvieForDeadTF, JTextField minAlvieForAliveTF,
			JTextField maxAlvieForAliveTF) {
		game.setMinLivingNeighboursForDead(Integer.parseInt(minAlvieForDeadTF.getText()));
		game.setMaxLivingNeighboursForDead(Integer.parseInt(maxAlvieForDeadTF.getText()));
		game.setMinLivingNeighboursForAlive(Integer.parseInt(minAlvieForAliveTF.getText()));
		game.setMaxLivingNeighboursForAlive(Integer.parseInt(maxAlvieForAliveTF.getText()));
	}

}
