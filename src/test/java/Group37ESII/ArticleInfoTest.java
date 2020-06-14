package Group37ESII;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArticleInfoTest {

	ArticleInfo  article;

	@BeforeEach
	void init() {
		LinkedList<String> authors=new LinkedList<String>();
		authors.add("Rafael");
		article=new ArticleInfo("Título Artigo","Jornal Ciências","2020",authors,"ficheiro.txt");
	}

	@Test
	void test() {
		assertEquals("Título Artigo",article.getArticle_title()) ;
		assertEquals("Jornal Ciências",article.getJournal_name()) ;
		assertEquals("2020",article.getPublication_year());
		assertEquals("ficheiro.txt",article.getFileName());
		assertEquals("Rafael",article.getArticle_authors().getFirst());		
	}

}
