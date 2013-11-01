package com.smart.boggle;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.smart.boggle.LetterGridTraverser.GridPosition;

public class Boggle {
	
	private final LetterGenerator letterGenerator;
	private final LetterGridTraverser traverser;
	private final Dictionary dictionary;

	public Boggle(LetterGenerator letterGenerator, Dictionary dictionary) {
		this.letterGenerator = letterGenerator;
		this.dictionary = dictionary;
		traverser = new LetterGridTraverser();
	}
	
	public void doRound(){
		
		LetterGrid letterGrid = new LetterGrid(letterGenerator.generateLetters());
		Map<String, List<GridPosition>> words = traverser.findWords(letterGrid, dictionary);

		System.out.println(" Letter Grid ");
		System.out.println("=============");
		System.out.println( letterGrid.toString() );
		
		
		System.out.println("");
		System.out.println(String.format(" Found Words: %d", words.size()));
		System.out.println("======================");
		printWords(words);

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
