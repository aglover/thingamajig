package com.b50.savvywords;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class WordStudyEngine {
	private LinkedList<Word> words;

	public static WordStudyEngine getInstance(List<Word> words) {
		return new WordStudyEngine(words);
	}

	private WordStudyEngine(List<Word> words) {
		this.words = new LinkedList<Word>(words);
	}

	public void randomizeStudy() {
		Collections.shuffle(this.words, new Random(System.currentTimeMillis()));
	}

	public Word getWord() {
		Word word = this.words.removeFirst();
		this.words.addLast(word);
		return word;
	}

	public int wordsInStudy() {
		return this.words.size();
	}
}
