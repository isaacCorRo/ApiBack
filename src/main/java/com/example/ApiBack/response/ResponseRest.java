package com.example.ApiBack.response;

import java.util.ArrayList;
import java.util.HashMap;

public class ResponseRest {
	
	private ArrayList<HashMap<String, String>> metadata = new ArrayList<>();

	public ArrayList<HashMap<String, String>> getMetadata() {
		return metadata;
	}

	public void setMetadata (String cod , String desc) {
		HashMap<String, String> mapa = new HashMap<>();
		mapa.put("code error ", cod);
		mapa.put("description", desc);
		metadata.add(mapa);
	}
	
	
}
