package com.enchere.utils;
import java.util.List;

import org.json.JSONArray;
import com.enchere.entities.Rubrique;
public class JsonConverter {
    
    public JsonConverter() {
        
    }

    public String convertToJson(List<Rubrique> rubriques) {
        
    	JSONArray ja = new JSONArray(rubriques);
        return ja.toString();
    }
}
