package Test;
import static org.junit.Assert.*;
import org.hamcrest.Matcher;

import org.junit.Before;
import org.junit.Test;

import Main.GameOfLife;

public class GameOfLifeTest{
	
	GameOfLife testSystem;
	boolean[][] testPopulation;
	
	@Before
	public void setUp() {
	testSystem = new GameOfLife();
	testPopulation = new boolean[5][5];
	for (int i = 0; i < testPopulation.length; i++) {
		for (int j = 0; j < testPopulation[i].length; j++){
			testPopulation[i][j] = false;
			}
		}
	}
	
	@Test
	public void testDeadPopulation(){
	assertArrayEquals(testSystem.gameOfLife(testPopulation, 1),testPopulation);
	assertArrayEquals(testSystem.gameOfLife(testPopulation, 3),testPopulation);
	}
	
	


}

