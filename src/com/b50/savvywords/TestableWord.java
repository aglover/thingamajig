package com.b50.savvywords;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestableWord  {

	private Word targetWord; 
	private List<Word> throwOffWords;
		
	private TestableWord(){}
	
	private TestableWord(Word word, List<Word> throwOffWords){
		super();
		this.targetWord = word;
		this.throwOffWords = throwOffWords;
	}
	
	public String getValidDefinition(){
		List<Definition> definitions = this.targetWord.getDefinitions();
		Collections.shuffle(definitions, new Random(System.currentTimeMillis()));
		return definitions.get(0).getDefinition();
	}
	
	public String getSpelling(){
		return this.targetWord.getSpelling();
	}

	public static TestableWord manufacture(Word targetWord, List<Word> throwOffWords) {		
		return new TestableWord(targetWord, throwOffWords);
	}

	public List<String> getInvalidWordAnswers() {
		List<String> invalidWords = new LinkedList<String>();
		for(int x = 0; x <= 3; x++){
			invalidWords.add(this.throwOffWords.get(x).getSpelling());
		}
		return invalidWords;
	}
}
