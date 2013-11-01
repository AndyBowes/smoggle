package com.smart.boggle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class HungarianDiceSet implements LetterGenerator {
	
	String[] letters = { "A", "Á", "B",	"C", "CS", "D", "DZ", "DZS", "E", "É", "F",
	"G","GY","H","I","Í","J","K","L","LY","M","N","NY","O","Ó","Ö","O","P","R",	"S",
	"SZ","T","TY","U","Ú","Ü","U","V","Z","ZS"};
	
	private static final Random rand = new Random(System.currentTimeMillis());
	
	private final List<Dice<String>> dice = new ArrayList<Dice<String>>();
	
	public HungarianDiceSet()
	{
		for ( int dice = 0 ; dice < 16; dice ++){
			addDice(6);
		}
	}

	private void addDice(int sides) {
		List<String> faceValue = new ArrayList<String>(sides);		
		for (int i = 0; i < 6 ; i++){
			 int letterId = rand.nextInt(letters.length);
			 faceValue.add(letters[letterId]);
		}
		dice.add(new Dice<String>(faceValue));
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
