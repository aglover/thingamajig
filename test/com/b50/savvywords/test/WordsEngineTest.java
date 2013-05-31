package com.b50.savvywords.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import com.b50.savvywords.TestableWord;
import com.b50.savvywords.Word;
import com.b50.savvywords.WordStudyEngine;
import com.b50.savvywords.WordTestEngine;

public class WordsEngineTest {

	@Test
	public void testTakingTest() throws Exception {
		List<Word> words = this.getABunchOfWords();
		WordTestEngine instance = WordTestEngine.getInstance(words);
		assertNotNull(instance);
		instance.randomizeWords();

		TestableWord testWord1 = instance.getTestableWord();
		assertNotNull(testWord1);

		String word = testWord1.getSpelling();
		assertNotNull(word);
		String definition = testWord1.getValidDefinition();
		assertNotNull(definition);

		List<String> incorrectWords = testWord1.getInvalidWordAnswers();
		assertNotNull(incorrectWords);
		assertTrue(incorrectWords.size() >= 3);
		for(String iword: incorrectWords){
			if(iword.equalsIgnoreCase(word)){
				Assert.fail("incorrect word: " + iword + " equaled word: " + word);
			}
		}
		
		assertNotNull(instance.wordsInTest());
		assertEquals(5, instance.wordsInTest());
	}

	@Test
	public void testEngine() throws Exception {
		List<Word> words = this.getABunchOfWords();
		WordStudyEngine instance = WordStudyEngine.getInstance(words);
		assertNotNull(instance);

		instance.randomizeStudy();
		Word firstWord = instance.getWord();
		assertNotNull(firstWord);
		Word secondWord = instance.getWord();
		assertNotNull(secondWord);
		Word thirdWord = instance.getWord();
		assertNotNull(thirdWord);

		assertEquals(false,
				firstWord.getSpelling().equals(secondWord.getSpelling()));
		assertEquals(false,
				firstWord.getSpelling().equals(thirdWord.getSpelling()));
		assertEquals(false,
				thirdWord.getSpelling().equals(secondWord.getSpelling()));

		for (int x = 0; x < 20; x++) {
			assertNotNull(instance.getWord());
		}

		assertEquals(5, instance.wordsInStudy());

	}

	private List<Word> getABunchOfWords() throws Exception {
		String fileContents = getJSONFromFile();
		JSONObject document = new JSONObject(fileContents);
		JSONArray allWords = document.getJSONArray("words");
		List<Word> words = new ArrayList<Word>();
		for (int i = 0; i < allWords.length(); i++) {
			Word word = Word.manufacture(allWords.getJSONObject(i));
			words.add(word);
		}
		return words;
	}

	private String getJSONFromFile() throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"./etc/words.txt"));
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");

		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append(ls);
		}

		String fileContents = stringBuilder.toString();
		reader.close();
		return fileContents;
	}
}
