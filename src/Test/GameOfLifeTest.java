package Test;
import static org.junit.Assert.*;
import org.hamcrest.Matcher;

import org.junit.Before;
import org.junit.Test;

import Main.GameOfLife;

public class GameOfLifeTest{
	
	GameOfLife testSystem;
	boolean[][] testPopulation1;
	boolean[][] testPopulation2;
	@Before
	public void setUp() {
	testSystem = new GameOfLife();
	testPopulation1 = new boolean[5][5];
	testPopulation2 = new boolean[5][5];
	for (int i = 0; i < testPopulation1.length; i++) {
		for (int j = 0; j < testPopulation1[i].length; j++){
			testPopulation1[i][j] = false;
			testPopulation2[i][j] = false;
			}
		}
	
	}
	
	@Test
	public void testDeadPopulation(){
	assertArrayEquals(testSystem.gameOfLife(testPopulation1, 1),testPopulation2);
	assertArrayEquals(testSystem.gameOfLife(testPopulation1, 3),testPopulation2);
	}
	
	@Test
	public void testDeadThroughLowPopulation(){
		testPopulation1[0][0] = true;
		testPopulation1[0][1] = true;
		testPopulation1[1][3] = true;
		assertArrayEquals(testSystem.gameOfLife(testPopulation1, 1),testPopulation2);
		
	}
	
	@Test
	public void testSurvivalofLiving(){
		testPopulation1[0][0] = true;
		testPopulation1[1][1] = true;
		testPopulation1[2][2] = true;
		testPopulation1[3][3] = true;
		testPopulation1[4][4] = true;
		
		testPopulation2[0][0] = true;
		testPopulation2[1][1] = true;
		testPopulation2[2][2] = true;
		testPopulation2[3][3] = true;
		testPopulation2[4][4] = true;
		
		assertArrayEquals(testSystem.gameOfLife(testPopulation1, 1),testPopulation2);
		assertArrayEquals(testSystem.gameOfLife(testPopulation1, 3),testPopulation2);
	}
	
	@Test
	public void testNewLive(){
		testPopulation1[0][1] = true;
		testPopulation1[1][0] = true;
		testPopulation1[2][2] = true;
		
		assertTrue(testSystem.gameOfLife(testPopulation1, 1)[1][1]);
	}
	
	@Test
	public void testDeadThroughHighPopulation(){
		testPopulation1[1][2] = true;
		testPopulation1[3][2] = true;
		testPopulation1[2][1] = true;
		testPopulation1[2][3] = true;
		testPopulation1[2][2] = true;
		
		assertFalse(testSystem.gameOfLife(testPopulation1, 1)[2][2]);
		
	}
	
	@Test
	public void testZeroGenerations(){
		testPopulation1[1][2] = true;
		testPopulation1[3][2] = true;
		testPopulation1[2][1] = true;
		testPopulation1[3][3] = true;
		testPopulation1[4][4] = true;
		
		testPopulation2[1][2] = true;
		testPopulation2[3][2] = true;
		testPopulation2[2][1] = true;
		testPopulation2[3][3] = true;
		testPopulation2[4][4] = true;
		
		assertArrayEquals(testSystem.gameOfLife(testPopulation1, 0),testPopulation2);
	}
}

