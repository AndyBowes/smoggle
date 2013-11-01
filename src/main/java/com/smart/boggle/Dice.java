package com.smart.boggle;

import java.util.List;
import java.util.Random;

public final class Dice<E> {
	
	private final List<E> sides;
	
	private static final Random rand = new Random(System.currentTimeMillis());
	
	/**
	 * Initialise the dice with the list of face values
	 * 
	 * @param sides A List containing an entry for each face on the dice.
	 */
	public Dice( final List<E> sides )
	{
		this.sides = sides;
	}
	
	
	/**
	 * Perform a roll of the dice.
	 * 
	 * @return The value from the top side of the dice.
	 */
	public E roll()
	{
		return sides.get( rand.nextInt(sides.size()) );
	}

}
