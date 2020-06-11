package Group37ESII;

import java.util.LinkedList;

public class ArticleInfo {

	private String article_title;
	private String journal_name;
	private String publication_year;
	private LinkedList<String> article_authors=new LinkedList<String>();
	private String filename;
	
	public ArticleInfo(String article_title, String journal_name, String publication_year, LinkedList<String> article_authors, String filename) {
		this.article_title = article_title;
		this.journal_name = journal_name;
		this.publication_year = publication_year;
		this.article_authors = article_authors;
		this.filename=filename;
	}

	public String getArticle_title() {
		return article_title;
	}

	public String getJournal_name() {
		return journal_name;
	}

	public String getPublication_year() {
		return publication_year;
	}

	public LinkedList<String> getArticle_authors() {
		return article_authors;
	}
	
	public String getFileName() {
		return filename;
	}
}
