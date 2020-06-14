package Group37ESII;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class TestesR {

	LinkedList<ArticleInfo> lists=new LinkedList<ArticleInfo>();

	public void checkFile() {
		File myObj = new File("filename.txt");
		try {
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
				System.out.println("*******************************************************************");
				this.readFileContent();
				System.out.println("*******************************************************************");
				this.writeToFile("Djo");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeToFile(String name) {
		LinkedList<String> authors=new LinkedList<String>();
		authors.add(name);
		ArticleInfo ai=new ArticleInfo("s1:"+name,"s2:"+name,"s3:"+name,authors,"s5:+name");
		lists.add(ai);
		//write to file
		FileOutputStream f;
		try {
			f = new FileOutputStream(new File("filename.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(lists);

			o.close();
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void readFileContent() {
		FileInputStream fi;
		try {
			fi = new FileInputStream(new File("filename.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			LinkedList<ArticleInfo> list = (LinkedList<ArticleInfo>) oi.readObject();
			
			System.out.println("NOVO TAMANHO: "+list.size());
			
			for(ArticleInfo ai:list) {
				System.out.println(ai.getArticle_authors().getFirst());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public LinkedList<ArticleInfo> getLst(){
		return this.lists;
	}
	
	public static void main(String[] args) {
		TestesR tr=new TestesR();
		tr.checkFile();
		tr.writeToFile("Andreia");
		tr.writeToFile("Rafael");
		System.out.println(tr.getLst().size());
		tr.readFileContent();
	}

}
