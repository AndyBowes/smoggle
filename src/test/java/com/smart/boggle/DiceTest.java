package com.smart.boggle;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DiceTest {
	
	// Use a large number of throws to attempt to ensure random distribution
	private static final int NUMBER_OF_THROWS = 900000;

	@Test
	public void checkRandomness()
	{
		List<Integer> sides = Arrays.asList(1,2,3,4,5,6);
		int[] counts = new int[sides.size()];
		Dice<Integer> dice = new Dice<Integer>(sides);
		for ( int i = 0; i < NUMBER_OF_THROWS; i++)
		{
			counts[dice.roll() - 1]++;
		}
		
		final int averageNumberExpected = NUMBER_OF_THROWS / sides.size();
		System.out.println("Expected to roll " + averageNumberExpected + " on each side.");
		for ( int i = 0; i < counts.length; i++)
		{
			System.out.println( i + " : " + counts[i]);
			// Check that each side has approximately the expect number of occurrences to <5%
			assertTrue("Too few rolls for " + i, counts[i] > averageNumberExpected * 0.95);
			assertTrue("Too many rolls for " + i, counts[i] < averageNumberExpected * 1.05);
		}
	}

}
