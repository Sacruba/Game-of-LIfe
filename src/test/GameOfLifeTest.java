package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.GameOfLife;

public class GameOfLifeTest {

	GameOfLife testSystem;
	boolean[][] testPopulation1;
	boolean[][] testPopulation2;

	/**
	 * creates two dead populations
	 */
	@Before
	public void setUp() {
		testSystem = new GameOfLife();
		testPopulation1 = new boolean[5][5];
		testPopulation2 = new boolean[5][5];
		for (int i = 0; i < testPopulation1.length; i++) {
			for (int j = 0; j < testPopulation1[i].length; j++) {
				testPopulation1[i][j] = false;
				testPopulation2[i][j] = false;
			}
		}

	}

	/**
	 * Tests if a complete dead population stays dead
	 */
	@Test
	public void testDeadPopulation() {
		assertArrayEquals(testSystem.gameOfLife(testPopulation1, 1), testPopulation2);
		assertArrayEquals(testSystem.gameOfLife(testPopulation1, 3), testPopulation2);
	}

	/**
	 * Tests if a cell dies, when less then three neighbours are alive. The
	 * Tested Population looks like:
	 * 
	 * 1 1 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
	 * 
	 * All living cells shall die.
	 */
	@Test
	public void testDeadThroughLowPopulation() {
		testPopulation1[0][0] = true;
		testPopulation1[0][1] = true;
		testPopulation1[1][3] = true;
		assertArrayEquals(testSystem.gameOfLife(testPopulation1, 1), testPopulation2);

	}

	/**
	 * Tests if a cell survives, when it has 2 living neighbours The Tested
	 * Population looks like:
	 * 
	 * 1 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 1
	 * 
	 * Its is expeted that all living cells survive and that no new cell lives.
	 */
	@Test
	public void testSurvivalofLiving() {
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

		assertArrayEquals(testSystem.gameOfLife(testPopulation1, 1), testPopulation2);
		assertArrayEquals(testSystem.gameOfLife(testPopulation1, 3), testPopulation2);
	}

	/**
	 * Tests if a cell starts living, when it has three living neighbours The
	 * Tested Population looks like:
	 * 
	 * 0 1 0 0 0 1 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0
	 * 
	 * Its is expeted that the cell 1/1 lives after one generation
	 */
	@Test
	public void testNewLive() {
		testPopulation1[0][1] = true;
		testPopulation1[1][0] = true;
		testPopulation1[2][2] = true;

		assertTrue(testSystem.gameOfLife(testPopulation1, 1)[1][1]);
	}

	/**
	 * Tests if a cell dies when it has more then three living neighbours. The
	 * Tested Population looks like:
	 * 
	 * 0 0 0 0 0 0 0 1 0 0 0 1 1 1 0 0 0 1 0 0 0 0 0 0 0
	 * 
	 * Its is expeted that the cell 2/2 is dead after one generation
	 */
	@Test
	public void testDeadThroughHighPopulation() {
		testPopulation1[1][2] = true;
		testPopulation1[3][2] = true;
		testPopulation1[2][1] = true;
		testPopulation1[2][3] = true;
		testPopulation1[2][2] = true;

		assertFalse(testSystem.gameOfLife(testPopulation1, 1)[2][2]);

	}

	/**
	 * Tests if a the population doesn't change when 0 generation shall be
	 * calculated
	 */
	@Test
	public void testZeroGenerations() {
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

		assertArrayEquals(testSystem.gameOfLife(testPopulation1, 0), testPopulation2);
	}

	/**
	 * Tests if a population does look like expected when multiple generations
	 * pass The Tested Population looks like:
	 * 
	 * 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 0 1 1 0 0 0 0 0 1
	 * 
	 * This is how the population changes after one and two generations:
	 * 
	 * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 1 0 0 0 1 1 0 0 0
	 * 0 1 1 0 0 0 1 0 0 0 1 1 0
	 */
	@Test
	public void testMultipleGenerations() {

		testPopulation1[1][2] = true;
		testPopulation1[3][2] = true;
		testPopulation1[2][1] = true;
		testPopulation1[3][3] = true;
		testPopulation1[4][4] = true;

		testPopulation2[4][2] = true;
		testPopulation2[2][3] = true;
		testPopulation2[3][3] = true;
		testPopulation2[4][3] = true;
		testPopulation2[3][4] = true;

		assertArrayEquals(testSystem.gameOfLife(testPopulation1, 2), testPopulation2);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testNoPopulation() {
		testSystem.gameOfLife(null, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeGeneration() {
		testSystem.gameOfLife(testPopulation1, -3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIncompatiblePopulationSize() {
		boolean[][] testPopulation3 = { { true, true, true }, { false, true, false },
				{ false, false, false, false, false } };
		testSystem.gameOfLife(testPopulation3, 1);
	}
}
