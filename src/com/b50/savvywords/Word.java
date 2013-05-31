package com.b50.savvywords;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Word {

	private String spelling;
	private List<Definition> definitions;	
	
	public static Word manufacture(JSONObject json) throws Exception{
		Word word = new Word();
		word.setSpelling(json.getString("spelling"));
		
		JSONArray defs = json.getJSONArray("definitions");
		List<Definition> definitions = new ArrayList<Definition>();
		for (int i = 0; i < defs.length(); i++) {
			definitions.add(Definition.manufacture(defs.getJSONObject(i)));
		}
		word.setDefinitions(definitions);
		return word;
	}
		
	private Word() {
		super();
	}

	public String getSpelling() {
		return spelling;
	}
	
	private void setSpelling(String spelling) {
		this.spelling = spelling;
	}
	
	public List<Definition> getDefinitions() {
		return definitions;
	}
	
	private void setDefinitions(List<Definition> definitions) {
		this.definitions = definitions;
	}	

	public String toString(){
		return this.spelling;
	}
}
