package com.smart.boggle;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class HungarianDiceSetTest {
	
	HungarianDiceSet diceSet = new HungarianDiceSet();
	
	@Test
	public void testLetterGeneration(){
		List<String> letters = diceSet.generateLetters();
		assertEquals(16, letters.size());
		System.out.println( (int)'ő');
		System.out.println( (int)'ű');
	}

}
