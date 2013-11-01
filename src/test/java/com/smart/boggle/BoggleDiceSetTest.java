package com.smart.boggle;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class BoggleDiceSetTest {
	
	BoggleDiceSet diceSet = new BoggleDiceSet();
	
	@Test
	public void testLetterGeneration(){
		List<String> letters = diceSet.generateLetters();
		assertEquals(16, letters.size());
	}

}
