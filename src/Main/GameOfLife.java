package Main;

public class GameOfLife implements IGameOfLife{

		
	
	@Override
	public boolean[][] gameOfLife(boolean[][] population, int generations) {
		// TODO Auto-generated method stub
		
		if(generations > 0){
		boolean[][] newPopulation = new boolean[population.length][population[1].length];
		
			for (int i = 0; i < population.length; i++) {
				for (int j = 0; j < population[i].length; j++){
					
					newPopulation[i][j] = suriveOrDie(population ,i ,j);
					
				}
			}
			return newPopulation;
		}
		return population;
	}
	
	private boolean suriveOrDie(boolean[][] population, int row, int column){
		int livingNeighbours = countLivingNeighbours(population, row, column);
	
		if(livingNeighbours == 3){
			return true;
		}
		else if(livingNeighbours == 2 && population[row][column]){
			return true;
		}
		else{
		return false;
		}
	}


	private int countLivingNeighbours(boolean[][] population, int row, int column){
		int count = 0;
		for (int i = -1;i < 2 ; i++){
			for (int j = -1;j < 2 ; j++){
				if (i!=0 || j!=0){
					if (population[mod(row + i, population.length)][mod(column + j, population[row].length)]){
						count++;
					}
				}
			}
		}
		return count;
	}
	
	private int mod(int x, int y)
	{
	    int result = x % y;
	    if (result < 0)
	    {
	        result += y;
	    }
	    return result;
	}
}
