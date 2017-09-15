package Main;

public class GameOfLife implements IGameOfLife{

		
	
	@Override
	public boolean[][] gameOfLife(boolean[][] pPopulation, int generations) {
		
		//Exception checks
		if (pPopulation == null){
			throw new IllegalArgumentException("There was no population");
		}
		else if (generations < 0){
			throw new IllegalArgumentException("Generations can't be negative");
		}
		for (int i = 0; i < pPopulation.length; i++) {
			if(pPopulation[i].length != pPopulation[1].length){
				throw new IllegalArgumentException("The population must be rectangle shaped");
			}
		}
		
		boolean[][] population = pPopulation;
		
			//one iteration for each generation
			for (int k=0 ;k < generations;k++){
				boolean[][] newPopulation = new boolean[population.length][population[1].length];	
				for (int i = 0; i < population.length; i++) {
					for (int j = 0; j < population[i].length; j++){
						
						newPopulation[i][j] = suriveOrDie(population ,i ,j);	
					}
				}
				population = newPopulation;
			}
			
		return population;
	}
	
	/*
	 * Private Method used to check if one cell is alive or dead in the next Generation
	 */
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

	/*
	 * Private Method used to count the living neighbours for the givne cell
	 */
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
	
	
	/*
	 * Private Method used to calcualte modulo as the % Operator can return negative Values
	 */
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
