package com.smart.boggle;

import static org.junit.Assert.*;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

public class LetterGridTest {
	
	private static final String VALID_TEST_LETTER_GRID = "ABCDEFGHIJKLMNOQ";
	private LetterGrid letterGrid;
	
	@Before
	public void setUp()
	{
		letterGrid = new LetterGrid(VALID_TEST_LETTER_GRID);
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void testCreateWithTooFewLetters()
	{
		letterGrid = new LetterGrid( RandomStringUtils.randomAlphabetic(15));
	}

	
	@Test( expected = IllegalArgumentException.class )
	public void testCreateWithTooManyLetters()
	{
		letterGrid = new LetterGrid( RandomStringUtils.randomAlphabetic(17));
	}
	
	@Test
	public void testGridIsPopulated()
	{	
		// Check that the 4 corners of the grid are populate correctly
		assertEquals("a", letterGrid.getLetterAt(0, 0));
		assertEquals("d", letterGrid.getLetterAt(0, 3));
		assertEquals("m", letterGrid.getLetterAt(3, 0));
		assertEquals("qu", letterGrid.getLetterAt(3, 3));
	}

}
