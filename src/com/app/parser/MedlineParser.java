package com.app.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.app.model.Article;
import com.app.model.MedlineData;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;


public class MedlineParser {
	
	public static List<Article> parseMedline(File file) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		Gson gson = new Gson();
		MedlineData medlineData = gson.fromJson(new FileReader(file), MedlineData.class);
		return medlineData.getMedlineCitationSet().getArticle();
	}
}
