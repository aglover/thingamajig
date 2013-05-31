package com.b50.savvywords;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class WordTestEngine {
	private LinkedList<Word> words;
	
	public static WordTestEngine getInstance(List<Word> words){
		return new WordTestEngine(words);
	}
	
	private WordTestEngine(List<Word> words) {
		this.words = new LinkedList<Word>(words);
	}
	
	public void randomizeWords(){
		Collections.shuffle(this.words, new Random(System.currentTimeMillis()));
	}
	
	public TestableWord getTestableWord(){
		Word word = this.words.removeFirst();
		List<Word> tempWords = randomizedCopyOfWords();
		
		List<Word> throwOffs = new LinkedList<Word>();
		for(int x = 0; x <= 3; x++){
			throwOffs.add(tempWords.get(x));
		}
		this.words.addLast(word);
		return TestableWord.manufacture(word, throwOffs);
	}

	private List<Word> randomizedCopyOfWords() {
		List<Word> tempWords = new LinkedList<Word>(this.words);
		Collections.shuffle(tempWords, new Random(System.currentTimeMillis()));
		return tempWords;
	}

	public int wordsInTest() {
		return this.words.size();
	}
}
