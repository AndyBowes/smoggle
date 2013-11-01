package com.smart.boggle;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.NavigableSet;
import java.util.TreeSet;

import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import com.google.common.io.InputSupplier;
import com.google.common.io.LineProcessor;
import com.google.common.io.Resources;

public class Dictionary {

	private final NavigableSet<String> words;

	/**
	 * Instantiate a Dictionary which contains a given set of words.
	 * @param words The {@link NavigableSet} which contains a fragment of a full Dictionary.
	 */
	private Dictionary(NavigableSet<String> words) {
		this.words = words;
	}

	/**
	 * Create a Dictionary from a Text file.
	 * 
	 * @param dictionaryFile The Text file containing the words, each word should be on a separate line.
	 * @throws IOException thrown if there is a problem accessing the file.
	 */
	public Dictionary(final File dictionaryFile) throws IOException {
		this(Files.newInputStreamSupplier(dictionaryFile));
	}

	public Dictionary(final String resourceName) throws IOException {
		this(Resources.newInputStreamSupplier(Dictionary.class.getClassLoader().getResource(resourceName)));
	}
	
	public Dictionary(InputSupplier supplier) throws IOException {
		words = CharStreams.readLines(
				CharStreams.newReaderSupplier(supplier,	Charset.defaultCharset()),
				new LineProcessor<NavigableSet<String>>() {
					final NavigableSet<String> lines = new TreeSet<String>();
					public NavigableSet<String> getResult() {
						return lines;
					}

					public boolean processLine(String line) throws IOException {
						lines.add(line.toLowerCase());
						return true;
					}
				});

	}

	/**
	 * Check if a specific sequence of letters appears in the dictionary. 
	 * 
	 * @param possibleWord The string whose existence in the Dictionary is being queried.
	 * @return true if this is a known word, otherwise false.
	 */
	public boolean containsWord(final String possibleWord) {
		return words.contains(possibleWord.toLowerCase());
	}

	/**
	 * Find all of the words in the Dictionary which start with a given sequence of letters.
	 * 
	 * @param prefix
	 * @return A Dictionary which contains only those known words which start with the supplied prefix.
	 */
	public Dictionary getChildWords(String prefix) {
		prefix = prefix.toLowerCase();
		return new Dictionary(words.subSet(prefix, false, prefix + Character.toString((char)255), true));
	}

	/**
	 * Check if the Dictionary is Empty.
	 * 
	 * @return true if there are no words in the Dictionary, otherwise false.
	 */
	public boolean isEmpty() {
		return words.isEmpty();
	}

}
