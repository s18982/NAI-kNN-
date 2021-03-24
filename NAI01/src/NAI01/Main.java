package NAI01;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static String strTrain;
	static String strTest;
	static int k;
	
	public static void main(String[] args) throws IOException {
		
		// wczytanie z plikow ================================
		
		try {
			FileReader frTrain = new FileReader(args[0]);
			FileReader frTest = new FileReader(args[1]);
			k = Integer.parseInt(args[2]);
						
			StringBuilder sbTrain = new StringBuilder();
			StringBuilder sbTest = new StringBuilder();
			
			int a = 0;
			while((a=frTrain.read())!=-1) {
				sbTrain.append((char)a);
			}
			
			frTrain.close();
			strTrain = sbTrain.toString();
			
			// =============
			
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
		/*
		for(Pomiar p:pomiary) {
			p.wyswietlDane();
		}*/
		
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
		
		/*		
		for(Pomiar p:daneTest) {
			p.wyswietlDane();
		}*/
		
		// ================================================================
		
		HashMap<Pomiar, Double> hm = new HashMap<>();
		
		
		double tab[] = {1.0,2.0,3.0,4.0}; // Podanie roboczego wektora
		
		
		for(Pomiar p:pomiary) {
			double x = p.obliczOdlegloscKwadrat(tab[0],tab[1], tab[2], tab[3]);
			hm.put(p, x);
		}
		
		/*
		// wyswietlenie danych razem z wyliczona odlegloscia
		for(Pomiar p:pomiary) {
			System.out.print(" : "+hm.get(p)+"   HM   ");
			p.wyswietlDane();
		}
		*/
		
		// Znajdowanie najmniejszych odleglosci od podanego wektora
		
		Pomiar min = pomiary.get(0);
		
		double minDoubles[] = new double[k];
		Pomiar[] minPoms = new Pomiar[k];
		
		for(int j = 0;j<k; j++) {
			min = pomiary.get(0);
		for(int i = 1;i<pomiary.size();i++) {
			double op = hm.get(pomiary.get(i));
			double minX = hm.get(min);
			if(op<minX) {
				min = pomiary.get(i);
			}
		}
		
		minDoubles[j] = hm.get(min);
		minPoms[j] = min;
		
		hm.remove(min);
		pomiary.remove(min);
		
		}
		
		// Z powrotem dodaje do listy i hashmapy wyrzucone na moment elementy
		for(int i = 0; i<k; i++) {
			pomiary.add(minPoms[i]);
			hm.put(minPoms[i], minDoubles[i]);
		}
		
		// wyswietlenie najmniejszych odleglosci
		for(int i = 0; i<k; i++) {
			System.out.print("Min"+i+": "+minDoubles[i]+" : ");
			minPoms[i].wyswietlDane();
		}
		
		//new Window();*/
	}
}
