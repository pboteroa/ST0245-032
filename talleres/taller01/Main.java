package taller01;

public class Main {

	public static void main(String[] args) {
		
		//variables punto 1
		Punto p1 = new Punto (0, 20);
		Punto p2 = new Punto (5, 10);
		
		//variables punto 2
		Fecha f1 = new Fecha (20, 1, 2020);
		Fecha f2 = new Fecha (1, 1, 2020);
		
		System.out.println("PUNTO 1:");
		System.out.println("Coordenada X: " + p1.x());
		System.out.println("Coordenada Y: " + p1.y());
		System.out.println("Radio: " + p1.radioPolar());
		System.out.println("Angulo: " + p1.anguloPolar());
		System.out.println("Distancia euclidiana: " + p1.distanciaEuclidiana(p2));
		
		System.out.println();
		
		System.out.println("PUNTO 2:");
		System.out.println(f1.compararFecha(f2));
		
		
		

	}

}
