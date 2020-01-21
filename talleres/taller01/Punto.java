package taller01;

public class Punto {
	
	private double x, y; 
	
	
	public Punto (double x, double y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public double x() {
		return x;
	}
	
	public double y() {
		return y; 	
	}
	
	public double radioPolar() {
		return Math.sqrt((x * x) + (y * y));
	}
	
	public double anguloPolar() {
		double angulo = Math.atan(y/x);
		
		if (angulo >= 0) {
			return angulo;
		}
		else return angulo * -1;
	}
	
	public double distanciaEuclidiana(Punto otro) {
		double x1 = x - otro.x();
		double y1 = y - otro.y();
		
		return Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
	}

}
