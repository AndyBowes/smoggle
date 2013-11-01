package com.smart.boggle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BoggleDiceSet implements LetterGenerator {
	
	private final List<Dice<String>> dice = new ArrayList<Dice<String>>();
	
	public BoggleDiceSet()
	{
		addDice("AAEEGN");
		addDice("ELRTTY");
		addDice("AOOTTW");
		addDice("ABBJOO");
		addDice("EHRTVW");
		addDice("CIMOTU");
		addDice("DISTTY");
		addDice("EIOSST");
		addDice("DELRVY");
		addDice("ACHOPS");
		addDice("HIMNQU");
		addDice("EEINSU");
		addDice("EEGHNW");
		addDice("AFFKPS");
		addDice("HLNNRZ");
		addDice("DEILRX");
	}

	private void addDice(String sides) {
		List<String> letters = new ArrayList<String>(sides.length());
		for ( int i = 0; i < sides.length(); i++){
			letters.add(String.valueOf(sides.charAt(i)));
		}
		dice.add(new Dice<String>(letters));
	}
	
	private List<Dice<String>> shuffleDice(){
		Collections.shuffle(dice);
		return dice;
	}
	
	public List<String> generateLetters(){
		List<String> letters = new ArrayList<String>();
		for (Dice<String> die : shuffleDice()) {
			letters.add(die.roll());
		}
		return letters;
	}

}
