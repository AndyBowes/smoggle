package com.smart.boggle;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class BoggleTest {
		
	private Boggle boggle;
	
	@Before
	public void setUp() throws IOException{
		boggle = new Boggle(new BoggleDiceSet(), new Dictionary(DictionaryTest.TEST_DICTIONARY));
	}
	
	@Test
	public void testPlay(){
		boggle.doRound();
	}
}
