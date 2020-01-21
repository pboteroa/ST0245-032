package taller01;

public class Fecha {
	
	int dia;
	int mes;
	int año;
	
	public Fecha (int dia, int mes, int año) {
		
		this.dia = dia;
		this.mes = mes;
		this.año = año;
	}
	
	public int dia() {
		return dia;
	}
	
	public int mes() {
		return mes;
	}
	
	public int año() {
		return año;
	}
	
	public String obtenerFecha() {
		return (dia + "/" + mes + "/" + año);
	}
	
	public boolean igual (Fecha otra) {
		if ((dia == otra.dia()) && (mes == otra.mes()) && (año == otra.año())) {
			return true;
		}
		else return false;
	}
	
	public String compararFecha(Fecha otra) {
		if (año > otra.año()) {
			return "La fecha " + obtenerFecha() + " esta despues que " + otra.obtenerFecha();
		}
		else if (año < otra.año()) {
			return "La fecha " + obtenerFecha() + " esta antes que " + otra.obtenerFecha();
		}
		else if (año == otra.año() && mes > otra.mes()) {
			return "La fecha " + obtenerFecha() + " esta despues que " + otra.obtenerFecha();
		}
		else if (año == otra.año() && mes < otra.mes()) {
			return "La fecha " + obtenerFecha() + " esta antes que " + otra.obtenerFecha();
		}
		else if (año == otra.año() && mes == otra.mes() && dia > otra.dia()) {
			return "La fecha " + obtenerFecha() + " esta despues que " + otra.obtenerFecha();
		}
		else if (año == otra.año() && mes == otra.mes() && dia < otra.dia()) {
			return "La fecha " + obtenerFecha() + " esta antes que " + otra.obtenerFecha();
		}
		else if ((dia == otra.dia()) && (mes == otra.mes()) && (año == otra.año())) {
			return "Las fechas son iguales";
		}
		else return null;
			
	}
}


