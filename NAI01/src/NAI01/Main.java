package NAI01;

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		try {
			FileReader fr = new FileReader("C:\\Users\\Fifi\\Desktop\\knn\\iris.csv");
			StringReader sr = new StringReader("C:\\Users\\Fifi\\Desktop\\knn\\iris.csv");
			
			StringBuilder sb = new StringBuilder();
			int c = 0;
			while((c=fr.read())!=-1) {
				sb.append((char)c);
			}
			fr.close();
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		//new Window();
	}
}
