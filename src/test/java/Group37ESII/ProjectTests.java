package Group37ESII;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import junit.framework.Assert;

class ProjectTests {

	ArticleTableFiller  articleFiller;

	@BeforeEach
	void init() {
		articleFiller=new ArticleTableFiller();
		articleFiller.showNumberFiles();
	}

	@Test
	void test() {
		assertNotNull(articleFiller.getClient());
		assertNotEquals(0,articleFiller.getFiles().length);
		assertTrue(articleFiller.checkMetadataFile("178-1-53.pdf"));
		assertFalse(articleFiller.checkMetadataFile("somefile.pdf"));
	}

}
