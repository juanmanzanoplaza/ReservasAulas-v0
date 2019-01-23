package org.iesalandalus.programacion.reservasaulas.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Tramo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/uuuu");

	private Consola() {

	}

	//REVISAR EJEMPLO GESTIONCLIENTES PARA RECORRER EL ENUM
	public static void mostrarMenu() {
		System.out.println("*************************************************************");
		System.out.println("*           RESERVAS DE AULAS DEL IES AL-ÁNDALUS            *");
		System.out.println("*************************************************************");
		System.out.println("* 0 - Salir.                                                *");
		System.out.println("* 1 - Insertar aula.                                        *");
		System.out.println("* 2 - Borrar aula.                                          *");
		System.out.println("* 3 - Buscar aula.                                          *");
		System.out.println("* 4 - Listar aulas.                                         *");
		System.out.println("* 5 - Insertar profesor.                                    *");
		System.out.println("* 6 - Borrar profesor.                                      *");
		System.out.println("* 7 - Buscar profesor.                                      *");
		System.out.println("* 8 - Listar profesores.                                    *");
		System.out.println("* 9 - Insertar reserva.                                     *");
		System.out.println("* 10- Borrar reserva.                                       *");
		System.out.println("* 11- Listar reservas.                                      *");
		System.out.println("* 12- Listar reservas de un aula determinada.               *");
		System.out.println("* 13- Listar reservas hechas por un profesor determinado.   *");
		System.out.println("* 14- Listar reservas en una fecha concreta.                *");
		System.out.println("* 15- Consultar disponibilidad.                             *");
		System.out.println("*************************************************************");
	}

	public static void mostrarCabecera(String cabecera) {
		System.out.println(cabecera);
	}

	public static int elegirOpcion() {
		int opcion;
		do {
			System.out.print("¿Qué opción desea elegir?:");
			opcion = Entrada.entero();
		} while(!Opcion.esOrdinalValido(opcion));
		return opcion;
	}

	public static Aula leerAula() {
		Aula leida = null;
		do {
			try {
				leida = new Aula(leerNombreAula());
				System.out.println("Aula leída correctamente.");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		} while(leida==null);
		return leida;
	}

	public static String leerNombreAula() {
		String nombre;
		do {
			System.out.print("Introduzca el nombre del aula:");
			nombre = Entrada.cadena();
		}while(nombre.equals(""));
		return nombre;
	}

	public static Profesor leerProfesor() {
		Profesor leido = null;
		do {
			try {
				String nombre = leerNombreProfesor();
				System.out.print("Introduzca el correo electrónico del profesor:");
				String correo = Entrada.cadena();
				System.out.print("Introduzca el teléfono del profesor (Puede dejarse vacío):");
				String telefono = Entrada.cadena();
				if(telefono.equals(""))
					leido = new Profesor(nombre, correo);
				else
					leido = new Profesor(nombre, correo, telefono);
				System.out.println("Profesor leído correctamente.");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		} while(leido==null);
		return leido;
	}

	public static String leerNombreProfesor() {
		String nombre;
		do {
			System.out.print("Introduzca el nombre del profesor:");
			nombre = Entrada.cadena();
		} while(nombre.equals(""));
		return nombre;
	}

	//Corregir para que recorra el enum
	public static Tramo leerTramo() {
		int opcion;
		do {
			System.out.print("¿Tramo de mañana(0) o de tarde(1)?:");
			opcion = Entrada.entero();
		} while(opcion<0 || opcion>Tramo.values().length);
		return Tramo.values()[opcion];

	}

	public static LocalDate leerDia() {
		LocalDate leido = null;
		do {
			System.out.print("Introduzca una fecha en el formato dd/mm/aaaa: ");
			try {
				leido = LocalDate.parse(Entrada.cadena(), FORMATO_DIA);
			} catch (DateTimeParseException e) {
				System.out.println("La fecha introducida no está en el formato correcto o no es válida.");
			}
		} while (leido == null);
		return leido;
	}

}
