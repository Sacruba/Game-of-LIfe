package Main;

public class GameOfLife implements IGameOfLife{

		
	
	@Override
	public boolean[][] gameOfLife(boolean[][] population, int genarations) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < population.length; i++) {
			for (int j = 0; j < population[i].length; j++){
				population[i][j] = false;
				}
			}
		
		return population;
	}


}
