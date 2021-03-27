package NAI01;

public class Pomiar {
		double dlLiscia;
		double szerLiscia;
		double dlPlatka;
		double szerPlatka;
		String gatunek;
		
		public Pomiar(double dL, double sL,double dP, double sP, String g) {
			this.dlLiscia = dL;
			this.szerLiscia = sL;
			this.dlPlatka = dP;
			this.szerPlatka = sP;
			this.gatunek =g;
		}
		
		public double getDlLiscia() {
			return this.dlLiscia;
		}
		public double getSzerLiscia() {
			return this.szerLiscia;
		}
		public double getDlPlatka() {
			return this.dlPlatka;
		}
		public double getSzerPlatka() {
			return this.szerPlatka;
		}
		public String getGatunek() {
			return this.gatunek;
		}
		
		public void wyswietlDane() {
			System.out.println(this.dlLiscia+" : "+this.szerLiscia+" : "+this.dlPlatka+" : "+this.szerPlatka+" : "+this.gatunek);
		}
		
		public double obliczOdlegloscKwadrat(double d1,double d2,double d3, double d4) {
			double odlX1 = Math.abs(this.dlLiscia - d1);
			double odlX2 = Math.abs(this.szerLiscia - d2);
			double odlX3 = Math.abs(this.dlPlatka - d3);
			double odlX4 = Math.abs(this.szerPlatka - d4);
			
			double suma = odlX1*odlX1 + odlX2*odlX2 + odlX3*odlX3 + odlX4*odlX4;
			
			return suma;
		}
}
