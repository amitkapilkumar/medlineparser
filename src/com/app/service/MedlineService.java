package com.app.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.app.model.Article;
import com.app.model.Author;
import com.app.parser.MedlineParser;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class MedlineService {
	
	public Map<Author, Map<Author, Integer>> processXML(String filepath) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		List<Article> articles = MedlineParser.parseMedline(new File(filepath));
		Set<Author> authors = new HashSet<Author>();
		Map<Author, Map<Author, Integer>> map = new LinkedHashMap<Author, Map<Author,Integer>>();
		for(Article article : articles) {
			authors.addAll(article.getAuthorList().getAuthor());
		}
		
		List<Author> list = new ArrayList<Author>(authors);
		for(Author a: list) {
			for(Author b: list) {				
				int cnt = 0;
				for(Article article : articles) {
					if(a.equals(b)) {
						break;
					}
					if(article.isAuthors(a, b)) {
						cnt++;
					}
				}
				if(map.get(a) == null) {
					Map<Author, Integer> m = new LinkedHashMap<Author, Integer>();
					m.put(b, cnt);
					map.put(a, m);
				}
				else {
					Map<Author, Integer> m = (Map<Author, Integer>) map.get(a);
					m.put(b, cnt);
					//map.put(list.get(i), m);
				}
			}
		}

		return map;
	}
}
