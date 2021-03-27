package NAI01;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.swing.SwingUtilities;

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
		
		// Testy ================================================================
		
		int z = 0;	
		int dobreOdp = 0;
		
		for(Pomiar p: daneTest) {
			double wek[] = {p.getDlLiscia(),p.getSzerLiscia(),p.getDlPlatka(),p.getSzerPlatka()};
			
			//System.out.println(z+1+": "+jakiGatunek(wek,pomiary));
			
			if(jakiGatunek(wek,pomiary).equals(daneTest.get(z).getGatunek()))
				dobreOdp++;			
			
			z++;
		}

		// Reakcja na przycisk "sprawdz" ==========================================================================
		
		int dO = dobreOdp;
		
		Window w =new Window("","");		
		SwingUtilities.invokeLater(()->{
			
			
			w.but.addActionListener(e->{
				
				try{
				double d1 = Double.parseDouble(w.tp1.getText());
				double d2 = Double.parseDouble(w.tp2.getText());
				double d3 = Double.parseDouble(w.tp3.getText());
				double d4 = Double.parseDouble(w.tp4.getText());
				double tab[] = {d1,d2,d3,d4};
				
				
				System.out.println(jakiGatunek(tab,pomiary));
				String s = String.valueOf(dO);	
				s=s+"/45";
				
				
				new ResultWindow(jakiGatunek(tab,pomiary),s);
				}catch(Exception ex) {
					System.err.println("Niepoporawne dane");
					new ResultWindow("Niepoporawne dane","");
				}
			});
		});
		
	
	
	}
	
	
	
	
	
	
	
	
	
	
	public static String jakiGatunek(double[] wektor, ArrayList<Pomiar> pomiary) {
		HashMap<Pomiar, Double> hm = new HashMap<>();
		
		for(Pomiar p:pomiary) {
			double x = p.obliczOdlegloscKwadrat(wektor[0],wektor[1], wektor[2], wektor[3]);
			hm.put(p, x);
		}
		
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
								
				// Okreslenie gatunku
				
				int counterSetosa = 0;
				int counterVersicolor = 0;
				int counterVirginica = 0;
				
				
				for (int i = 0; i<minPoms.length; i++) {
					switch(minPoms[i].getGatunek()) {
						case "Iris-setosa":
							counterSetosa++;
							break;
						case "Iris-versicolor":
							counterVersicolor++;
							break;
						case "Iris-virginica":
							counterVirginica++;
							break;
					
					}
				}
						
				if(counterSetosa>counterVersicolor && counterSetosa>counterVirginica) {
					//System.out.println("Iris-setosa");
					return "Iris-setosa";
				}else
					if(counterVersicolor>counterSetosa && counterVersicolor>counterVirginica){
						//System.out.println("Iris-versicolor");
						return "Iris-versicolor";
					}else
						if(counterVirginica>counterSetosa && counterVersicolor<counterVirginica){
							//System.out.println("Iris-virginica");
							return "Iris-virginica";
						}else
							//System.out.println("Nie mo�na okre�li� gatunku");
							return "Nie mo�na okreslic gatunku";
	}
}
