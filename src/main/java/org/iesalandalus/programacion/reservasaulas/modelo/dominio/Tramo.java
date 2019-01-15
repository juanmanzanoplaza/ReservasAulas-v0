package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

public enum Tramo {
	MANANA("Ma�ana"),
	TARDE("Tarde");
	private String cadenaAMostrar;

	private Tramo(String cadenaAMostrar) {
		this.cadenaAMostrar = cadenaAMostrar;
	}

	public String toString() {
		return cadenaAMostrar;
	}

}
