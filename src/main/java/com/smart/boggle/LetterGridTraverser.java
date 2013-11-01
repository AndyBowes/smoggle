package com.smart.boggle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class LetterGridTraverser {

	private static final int MINIMUM_WORD_LENGTH = 3;
	
	private static final Logger LOG = Logger.getLogger(LetterGridTraverser.class);

	public LetterGridTraverser() {
	}

	private void addFoundWord(final Map<String, List<GridPosition>> foundWords, final String word, final List<GridPosition> path) {
		if (StringUtils.length(word) >= MINIMUM_WORD_LENGTH && ! foundWords.containsKey(word)) {
			foundWords.put(word, path);
		}
	}

	public Map<String, List<GridPosition>> findWords(LetterGrid letterGrid, Dictionary dictionary)
	{
		final Stack<GridPosition> visitedLetters = new Stack<GridPosition>();
//		final Set<String> foundWords = new TreeSet<String>();
		final Map<String, List<GridPosition>> foundWords = new HashMap<String, List<GridPosition>>();
		
		for (int i = 0 ; i < LetterGrid.GRID_SIZE; i++ )
		{
			for ( int j = 0; j < LetterGrid.GRID_SIZE; j++ )
			{
				LOG.info("Starting at Letter : " + i + "," + j);
				findWords(i, j, "", letterGrid, visitedLetters, dictionary, foundWords );
			}
		}
		return foundWords;
	}

	private void findWords(int i, int j, String prefix, LetterGrid letterGrid,
			Stack<GridPosition> visitedLetters, Dictionary dictionary,
			Map<String, List<GridPosition>> foundWords) {
		GridPosition gridPosition = new GridPosition(i,j);
		visitedLetters.push(gridPosition);

		LOG.debug("Visiting Letter At " + i + "," + j);
		String possibleWord = prefix + letterGrid.getLetterAt(i, j);
		if (dictionary.containsWord(possibleWord)) {
			addFoundWord(foundWords, possibleWord, new ArrayList<GridPosition>(visitedLetters));
		}
		Dictionary childDictionary = dictionary.getChildWords(possibleWord);

		if (!childDictionary.isEmpty()) {
			for (int x = Math.max(0, i - 1); x < Math.min(i + 2,
					LetterGrid.GRID_SIZE); x++) {
				LOG.debug("x : " + x );
				for (int y = Math.max(0, j - 1); y < Math.min(j + 2,
						LetterGrid.GRID_SIZE); y++) {
					if (!visitedLetters.contains(new GridPosition(x,y))) {
						findWords(x, y, possibleWord, letterGrid,
								visitedLetters, childDictionary,
								foundWords);
					} else {
						LOG.debug("Letter has been already visited: " + x + "," + y);
					}
				}
			}
		} else {
				LOG.debug("Dictionary is empty: " + possibleWord);
		}
		visitedLetters.pop();
	}
	
	public static class GridPosition 
	{
		private final int x;
		private final int y;
		
		public GridPosition(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object obj) {
			if ( ! (obj instanceof GridPosition) ){
				return false;
			}
			GridPosition that = (GridPosition) obj;
			return (this.x == that.x) && (this.y == that.y);
		}

		@Override
		public int hashCode() {
			return (37 * x) + y;
		}

		@Override
		public String toString() {
			return "(" + y + "," + x + ")";
		}
		
	}

}
