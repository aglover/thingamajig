package com.b50.savvywords.test;

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

import com.b50.savvywords.Definition;
import com.b50.savvywords.Word;

public class WordsJSONParsingTest {
	@Test
	public void testParsingRawJSON() throws Exception {
		String fileContents = getJSONFromFile();
		
		Assert.assertNotNull(fileContents);

		JSONObject document = new JSONObject(fileContents);
		Assert.assertNotNull(document);

		JSONArray allWords = document.getJSONArray("words");
		Assert.assertNotNull(allWords);
		Assert.assertEquals("should have at least 1 word", true, allWords.length() >= 3);
		for (int i = 0; i < allWords.length(); i++) {
			JSONObject word = allWords.getJSONObject(i);
			String spelling = word.getString("spelling");
			Assert.assertNotNull(spelling);
		}
	}
	
	@Test
	public void testParsingRawJSONIntoObjs() throws Exception {
		String fileContents = getJSONFromFile();		
		Assert.assertNotNull(fileContents);
		JSONObject document = new JSONObject(fileContents);
		Assert.assertNotNull(document);
		JSONArray allWords = document.getJSONArray("words");
		Assert.assertNotNull(allWords);
		Assert.assertEquals("should have at least 1 word", true, allWords.length() >= 3);
		List<Word> words = new ArrayList<Word>();
		for (int i = 0; i < allWords.length(); i++) {
			Word word = Word.manufacture(allWords.getJSONObject(i));
			words.add(word);
			Assert.assertNotNull(word);
			Assert.assertNotNull(word.getSpelling());
			Assert.assertNotNull(word.getDefinitions());
			Assert.assertEquals("should have at least 1 def", true, word.getDefinitions().size() >= 1);
			for(Definition def : word.getDefinitions()){
				Assert.assertNotNull(def.getDefinition());
				Assert.assertNotNull(def.getPartOfSpeech());
			}
		}
		Assert.assertEquals(true, words.size() >= 3);	
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
