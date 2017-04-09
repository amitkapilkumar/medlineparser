package com.app.model;

public class Article {
	private String articleTitle;
	private AuthorList authorList;

	public Article(String title, AuthorList authors) {
		super();
		this.articleTitle = title;
		this.authorList = authors;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public AuthorList getAuthorList() {
		return authorList;
	}

	public void setAuthorList(AuthorList authorList) {
		this.authorList = authorList;
	}

	public boolean isAuthors(Author a, Author b) {
		if(a.equals(authorList.getAuthor().get(0)) || a.equals(authorList.getAuthor().get(1))) {
			if(b.equals(authorList.getAuthor().get(0)) || b.equals(authorList.getAuthor().get(1))) {
				return true;
			}
		}
		return false;
	}
}
