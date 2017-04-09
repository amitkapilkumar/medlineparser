package com.app.execute;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

import com.app.model.Author;
import com.app.service.MedlineService;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class Main {	
	public static void main(String[] args) {		
		Map<Author, Map<Author, Integer>> map = null;
		try {
			map = new MedlineService().processXML(System.getProperty("user.dir") + "/medline.json");
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<Author> set = map.keySet();
		for(Author author : set) {
			System.out.print("\t" + author.getFullName());
			Map<Author, Integer> m = map.get(author);
			int n = 0;
			for(Integer i : m.values()) {
				n = n + i;
			}
			m.put(author, n);
		}
		System.out.print("\n");
		
		for(Author author : map.keySet()) {
			Map<Author, Integer> m = map.get(author);
			System.out.print(author.getFullName() + "\t");
			for(Integer i : m.values()) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}
}
