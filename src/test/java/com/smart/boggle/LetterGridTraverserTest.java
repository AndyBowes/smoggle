package com.smart.boggle;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Strings;
import com.smart.boggle.LetterGridTraverser.GridPosition;

public class LetterGridTraverserTest {
	
	LetterGridTraverser traverser;
	Dictionary dictionary;
	
	@Before
	public void setUp() throws IOException{
		traverser = new LetterGridTraverser();
		dictionary = new Dictionary(DictionaryTest.TEST_DICTIONARY);
	}
	
	@Test
	public void testNoWordsFound(){
		LetterGrid letterGrid = new LetterGrid(Strings.repeat("x", LetterGrid.GRID_SIZE * LetterGrid.GRID_SIZE));
		Map<String, List<GridPosition>> foundWords = traverser.findWords(letterGrid , dictionary);
		assertNotNull( foundWords );
		assertTrue( "Shouldn't find any words", foundWords.isEmpty() );
	}
	
	@Test
	public void testFindKnownWords(){
		LetterGrid letterGrid = new LetterGrid(Strings.repeat("BOMB", LetterGrid.GRID_SIZE ));
		Map<String, List<GridPosition>> foundWords = traverser.findWords(letterGrid , dictionary);
		assertNotNull( foundWords );
		printWords(foundWords);
		assertFalse( "Should have found some words", foundWords.isEmpty() );
		assertTrue( "Should include 'bomb'", foundWords.containsKey("bomb"));
		assertTrue( "Should include 'mob'", foundWords.containsKey("mob"));
		assertTrue( "Should include 'bob'", foundWords.containsKey("bob"));
		assertTrue( "Should include 'moo'", foundWords.containsKey("moo"));
		assertTrue( "Should include 'boob'", foundWords.containsKey("boob"));
		assertTrue( "Should include 'mom'", foundWords.containsKey("mom"));
	}
	
	@Test 
	public void findWordAtEnd(){
		LetterGrid letterGrid = new LetterGrid("XXXXXXXXXXTXXXOH");
		Map<String, List<GridPosition>> foundWords = traverser.findWords(letterGrid , dictionary);
		assertNotNull( foundWords );
		printWords(foundWords);
		assertFalse( "Should have found some words", foundWords.isEmpty() );
		assertTrue( "Should include 'hot'", foundWords.containsKey("hot"));
	}

	private static void printWords(Map<String, List<GridPosition>> foundWords) {
		Set<String> words = foundWords.keySet();
		for ( String word : words) {
			List<GridPosition> path = foundWords.get(word);
			StringBuilder sb = new StringBuilder();
			for ( GridPosition position : path){
				sb.append(position.toString());
			}
			System.out.println("Found Word: " + word + " : " + sb.toString());
		}
	}

}
