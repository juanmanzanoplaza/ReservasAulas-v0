package org.iesalandalus.programacion.reservasaulas;

import org.iesalandalus.programacion.reservasaulas.vista.IUTextual;

/**
 * 
 * Clase principal del programa. Se encarga de hacer la primera llamada y comenzar la ejecución.
 * @see IUTextual
 * @author Juan Antonio Manzano Plaza
 * @version 0
 *
 */
public class MainApp {

	public static void main(String[] args) {
		System.out.println("Programa para la gestión de reservas de espacios del IES Al-�ndalus.");
		IUTextual a = new IUTextual();
		a.comenzar();
	}

}
