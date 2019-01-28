package org.iesalandalus.programacion.reservasaulas;

import org.iesalandalus.programacion.reservasaulas.vista.IUTextual;

/**
 * 
 * Clase principal del programa. Se encarga de hacer la primera llamada y comenzar la ejecuci�n.
 * @see org.iesalandalus.programacion.reservasaulas.vista.IUTextual
 * @author Juan Antonio Manzano Plaza
 * @version 0
 *
 */
public class MainApp {

	public static void main(String[] args) {
		System.out.println("Programa para la gesti�n de reservas de espacios del IES Al-�ndalus.");
		IUTextual a = new IUTextual();
		a.comenzar();
	}

}
