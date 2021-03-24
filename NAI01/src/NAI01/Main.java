package NAI01;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static String strTrain;
	static String strTest;
	
	public static void main(String[] args) throws IOException {
		
		try {
			FileReader frTrain = new FileReader(args[0]);
			FileReader frTest = new FileReader(args[1]);
						
			StringBuilder sbTrain = new StringBuilder();
			StringBuilder sbTest = new StringBuilder();
			
			int a = 0;
			while((a=frTrain.read())!=-1) {
				sbTrain.append((char)a);
			}
			
			frTrain.close();
			strTrain = sbTrain.toString();
			
			// ===================================
			
			int b = 0;
			while((b=frTest.read())!=-1) {
				sbTest.append((char)b);
			}
			
			frTest.close();
			strTest = sbTest.toString();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// wprowadzenie pomiarow zbioru treningowego ===================
		
		StringTokenizer stTrain = new StringTokenizer(strTrain);
		ArrayList<String> linesTrain = new ArrayList<String>();
		
		while(stTrain.hasMoreTokens()) {
			linesTrain.add(stTrain.nextToken().toString());
		}
		
		ArrayList<Pomiar> pomiary = new ArrayList<Pomiar>();
		
		for(String lineTrain:linesTrain) {
			String[] w = lineTrain.split(";");			
			pomiary.add(new Pomiar(Double.parseDouble(w[0]),Double.parseDouble(w[1]),Double.parseDouble(w[2]),Double.parseDouble(w[3]),w[4]));
		}
		
		for(Pomiar p:pomiary) {
			p.wyswietlDane();
		}
		
		// wprowadzenie pomiarow zbioru testowego =========================
		
		StringTokenizer stTest = new StringTokenizer(strTest);
		ArrayList<String> linesTest = new ArrayList<String>();
		
		while(stTest.hasMoreTokens()) {
			linesTest.add(stTest.nextToken().toString());
		}
		
		ArrayList<Pomiar> daneTest = new ArrayList<Pomiar>();
		
		for(String lineTest:linesTest) {
			String[] w = lineTest.split(";");			
			daneTest.add(new Pomiar(Double.parseDouble(w[0]),Double.parseDouble(w[1]),Double.parseDouble(w[2]),Double.parseDouble(w[3]),w[4]));
		}
		
		for(Pomiar p:daneTest) {
			p.wyswietlDane();
		}
		
		// ================================================================
		
		//new Window();
	}
}
