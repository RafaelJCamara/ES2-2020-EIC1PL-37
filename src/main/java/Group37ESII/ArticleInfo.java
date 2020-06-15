package Group37ESII;

import java.io.Serializable;
import java.util.LinkedList;



/**
 * @author Rafael Câmara, student number 82036
 * @version 1.1
 * @since june 2020
 */

public class ArticleInfo implements Serializable{

	private String article_title;
	private String journal_name;
	private String publication_year;
	private LinkedList<String> article_authors=new LinkedList<String>();
	private String filename;

	/**
	 * Constructor
	 * 
	 * @param article_title The name of the article
	 * @param journal_name The name of the Journal the article was published at
	 * @param publication_year The year the article was published
	 * @param article_authors The authors who wrote the article
	 * @param filename The name of the file the article is stored under
	 */
	public ArticleInfo(String article_title, String journal_name, String publication_year, LinkedList<String> article_authors, String filename) {
		this.article_title = article_title;
		this.journal_name = journal_name;
		this.publication_year = publication_year;
		this.article_authors = article_authors;
		this.filename=filename;
	}

	/**
	 * @return The title of this article
	 */
	public String getArticle_title() {
		return article_title;
	}

	/**
	 * @return The narme of the Journal the article was published at
	 */
	public String getJournal_name() {
		return journal_name;
	}

	/**
	 * @return The year the article was published
	 */
	public String getPublication_year() {
		return publication_year;
	}

	/**
	 * @return The authors who wrote this article
	 */
	public LinkedList<String> getArticle_authors() {
		return article_authors;
	}

	/**
	 * @return The name of the file where the article is stored under
	 */
	public String getFileName() {
		return filename;
	}

}
