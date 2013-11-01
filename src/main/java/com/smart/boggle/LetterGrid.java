package com.smart.boggle;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class LetterGrid {
	
	private final String NEWLINE = System.getProperty("line.separator");
	
	public static final int GRID_SIZE = 4;
	final String[][] grid = new String[GRID_SIZE][GRID_SIZE];
	
	public LetterGrid(String letters){
		List<String> listOfletters = new ArrayList<String>();
		for ( int i = 0; i < letters.length(); i++){
			listOfletters.add(""+ letters.charAt(i));
		}
		populateFromList(listOfletters);
	}

	public LetterGrid(List<String> letters)
	{
		populateFromList(letters);
	}

	private void populateFromList(List<String> letters) {
		if ( letters.size() != GRID_SIZE * GRID_SIZE ){
			throw new IllegalArgumentException("");
		}
		for (int i = 0; i < GRID_SIZE; i++ )
		{
			for ( int j = 0; j < GRID_SIZE; j++)
			{
				String character = letters.get((i * GRID_SIZE ) + j ).toLowerCase();
				grid[i][j] = "" + ( "q".equals(character) ? "qu" : character );
			}
		}
	}
	
	public String getLetterAt(int i, int j)
	{
		return grid[i][j];
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < GRID_SIZE; i++ )
		{
			for ( int j = 0; j < GRID_SIZE; j++)
			{
				sb.append("[ ");
				sb.append( StringUtils.rightPad(getLetterAt(i, j), 3) );
				sb.append("]");
			}
			sb.append(NEWLINE);
		}
		return sb.toString();
	}

}
