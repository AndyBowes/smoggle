package com.smart.boggle;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class DictionaryTest {

//	private static final String TEST_DICTIONARY_PATH = "D:\\eclipse\\workspace\\boggle\\src\\resources\\shortdictionary.txt";
	public static final String TEST_DICTIONARY = "2of4brif.txt";
	public static final String HUNGARIAN_DICTIONARY = "freedict_hu.txt";

	@Test
	public void testLoadDictionary() throws IOException
	{
		Dictionary dictionary = new Dictionary(TEST_DICTIONARY);
		assertTrue(dictionary.containsWord("ballad"));
		assertTrue(dictionary.containsWord("dog"));
		assertTrue("Dictionary should not be case-sensitive.", dictionary.containsWord("DOG"));
		assertFalse(dictionary.containsWord("LLLL"));
	}
	
	@Test
	public void testFetchChildWords() throws IOException
	{
		final Dictionary dictionary = new Dictionary(TEST_DICTIONARY);
		assertTrue(dictionary.containsWord("ballad"));
		assertTrue(dictionary.containsWord("dog"));
		assertTrue(dictionary.containsWord("fab"));
		
		final Dictionary childDictionary = dictionary.getChildWords("dog");
		assertFalse(childDictionary.isEmpty());
		assertFalse(childDictionary.containsWord("ballad"));
		assertFalse("Root element should not appear in Child Dictionary", childDictionary.containsWord("dog"));
		assertTrue(childDictionary.containsWord("dogfight"));
		assertFalse(childDictionary.containsWord("fab"));
	}	
	
	
	
	
	
}
