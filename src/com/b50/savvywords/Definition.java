package com.b50.savvywords;

import org.json.JSONObject;

public class Definition {

	private String partOfSpeech;
	private String definition;

	public static Definition manufacture(JSONObject json) throws Exception {
		return new Definition(json.getString("part_of_speech"),
				json.getString("definition"));
	}

	private Definition(String partOfSpeech, String definition) {
		super();
		this.partOfSpeech = partOfSpeech;
		this.definition = definition;
	}

	public String getPartOfSpeech() {
		return partOfSpeech;
	}

	public String getDefinition() {
		return definition;
	}

}
