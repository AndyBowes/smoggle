package com.smart.boggle;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class HungarianBoggleTest {
		
	private Boggle boggle;
	
	@Before
	public void setUp() throws IOException{
		boggle = new Boggle(new HungarianDiceSet(), new Dictionary(DictionaryTest.HUNGARIAN_DICTIONARY));
	}
	
	@Test
	public void testPlay(){
		boggle.doRound();
	}
}
