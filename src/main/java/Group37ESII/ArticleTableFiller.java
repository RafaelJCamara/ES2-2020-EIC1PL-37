package Group37ESII;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.LinkedList;

//Cermine imports
import pl.edu.icm.cermine.ContentExtractor;
import pl.edu.icm.cermine.exception.AnalysisException;
import pl.edu.icm.cermine.metadata.model.DocumentAuthor;
import pl.edu.icm.cermine.metadata.model.DocumentMetadata;


//FTP related imports
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 * @author Group37 ESII
 * @version 1.1
 * @since 22 march 2020
 *
 */


public class ArticleTableFiller {

	//source: https://www.codejava.net/java-se/ftp/java-ftp-list-files-and-directories-example	
	private FTPFile[] files;
	private String server = "ftp.drivehq.com";
	private int port = 21;
	private String user = "rjafc@iscte-iul.pt";
	private String pass = "abc123!@qwertyasdfghj";
	private FTPClient ftpClient;
	
	public ArticleTableFiller() {
		
		boolean success;
		try {
			ftpClient = new FTPClient();
			ftpClient.connect(server, port);
			showServerReply(ftpClient);

			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				System.out.println("Connect failed");
				return;
			}
			success = ftpClient.login(user, pass);
			if (!success) {
				System.out.println("Could not login to the server");
				return;
			}
			files = ftpClient.listFiles("/covid19");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		showServerReply(ftpClient);
	}

	public void showNumberFiles() {

		LinkedList<ArticleInfo> article_info=new LinkedList<ArticleInfo>();

		//	source for getting number of files in a directory in Java: 
		//	https://stackoverflow.com/questions/687444/counting-the-number-of-files-in-a-directory-using-java

		ContentExtractor extractor;
		try {
			extractor = new ContentExtractor();

			//Extract metadata
			//for each file creates an ArticleInfo object			
			for(FTPFile file:files) {		
				ftpClient.connect(server, port);
				ftpClient.login(user, pass);
				
				//mudar isso para ir buscar ao servidor ftp
//				InputStream inputStream = new FileInputStream("C:/Users/rafae/git/ES2-2020-EIC1PL-37/covid19/"+file.getName());
				InputStream inputStream = ftpClient.retrieveFileStream("/covid19/"+file.getName());
				
				
				extractor.setPDF(inputStream);
				DocumentMetadata result = extractor.getMetadata();

				//Article title
				System.out.println("Title");
				System.out.println(result.getTitle());
				//Journal name
				System.out.println("Journal Name");
				System.out.println(result.getJournal());

				//Publication year
				System.out.println("Publication Year");


				//Authors
				System.out.println("Authors");
				LinkedList<String> article_authors=new LinkedList<String>();
				for(DocumentAuthor author:result.getAuthors()) {
					System.out.println(author.getName());
					article_authors.add(author.getName());
				}

				extractor = new ContentExtractor();

				article_info.add(new ArticleInfo(result.getTitle(), result.getJournal(), "2020", article_authors, file.getName()));				
			}

			// creates the HTML table			
			this.createHtmlTable(article_info);

		} catch (AnalysisException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void showServerReply(FTPClient ftpClient) {
		String[] replies = ftpClient.getReplyStrings();
		if (replies != null && replies.length > 0) {
			for (String aReply : replies) {
				System.out.println("SERVER: " + aReply);
			}
		}
	}

	public void createHtmlTable(LinkedList<ArticleInfo> article_info) {
		//source: https://www.youtube.com/watch?v=pV0v_3YRQoM
		String html="<h1>Covid Articles</h1>";
		String table_beginning="<table>";
		String table_header="<tr>"
				+ "<th>Article Title</th>"
				+ "<th>Journal Name</th>"
				+ "<th>Publication Year</th>"
				+ "<th>Authors</th>"
				+ "</tr>";
		String table_content=this.tableContent(article_info);
		String table_ending="</table>";
		String table=table_beginning+table_header+table_content+table_ending;
		//create HTML file
		File f=new File("C:/Users/rafae/OneDrive/Ambiente de Trabalho/ES2_final/html/covid19Discoveries/index.html");

		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(f));
			bw.write(html);
			bw.append(table);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String tableContent(LinkedList<ArticleInfo> article_info) {
		String tableContent="";
		String tableLine_beginning="<tr>";
		String tableLine_ending="</tr>";
		String tableElement_beginning="<td>";
		String tableElement_ending="</td>";

		for(ArticleInfo ai : article_info) {
			String articleTitle=tableElement_beginning+"<a href=./reports/"+ai.getFileName()+">"+ai.getArticle_title()+"</a>"+tableElement_ending;
			String journalName=tableElement_beginning+ai.getJournal_name()+tableElement_ending;
			String publicationYear=tableElement_beginning+ai.getPublication_year()+tableElement_ending;

			//get Authors list string
			String authorsList="";
			for(String author:ai.getArticle_authors()) {
				authorsList=authorsList+author+"\n";
			}

			String authors=tableElement_beginning+authorsList+tableElement_ending;

			tableContent+=tableLine_beginning+articleTitle+journalName+publicationYear+authors+tableLine_ending;
		}

		return tableContent;
	}

	public static void main(String[] args){
		System.out.println("Hello World :) ");
		ArticleTableFiller c1=new ArticleTableFiller();
		c1.showNumberFiles();
		System.out.println("End");
	}
}