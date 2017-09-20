package main;

public interface IGameOfLife {
	
	/**
	 * Calculates the changes in the given population after the given numbers of generations
	 * @param population the starting population
	 * @param genarations the amount of generations that shall be calculated
	 * @return returns the new population after the given amount of generations
	 */
	public boolean[][] gameOfLife (boolean[][] population, int genarations);
	

}
