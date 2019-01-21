package org.iesalandalus.programacion.reservasaulas.vista;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.ModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

public class IUTextual {

	private static final String ERROR = "Mensaje de error";
	private static final String NOMBRE_VALIDO = "Nombre valido";
	private static final String CORREO_VALIDO = "Correo valido";
	protected ModeloReservasAulas modelo;

	public IUTextual() {
		this.modelo = new ModeloReservasAulas();
	}

	public void comenzar() {
		Consola.mostrarMenu();
	}

	public void salir() {

	}

	public void insertarAula() throws OperationNotSupportedException {
		modelo.insertarAula(Consola.leerAula());
	}

	public void borrarAula() throws OperationNotSupportedException {
		modelo.borrarAula(Consola.leerAula());
	}

	public void buscarAula() {
		modelo.buscarAula(Consola.leerAula());
	}

	public void listarAulas() {
		System.out.println(modelo.getAulas().toString());
	}

	public void insertarProfesor() throws OperationNotSupportedException {
		modelo.insertarProfesor(Consola.leerProfesor());
	}

	public void borrarProfesor() throws OperationNotSupportedException {
		modelo.borrarProfesor(Consola.leerProfesor());
	}

	public void buscarProfesor() {
		modelo.buscarProfesor(Consola.leerProfesor());
	}

	public void listarProfesores() {
		System.out.println(modelo.getProfesores().toString());
	}

	public void realizarReserva() throws OperationNotSupportedException {
		modelo.realizarReserva(leerReserva(Consola.leerProfesor()));
	}

	private Reserva leerReserva(Profesor profesor) {
		return new Reserva(profesor, Consola.leerAula(), new Permanencia(Consola.leerDia(), Consola.leerTramo()));
	}

	public void anularReserva() throws OperationNotSupportedException {
		modelo.anularReserva(leerReserva(Consola.leerProfesor()));
	}

	public void listarReservas() {
		System.out.println(modelo.getReservas().toString());
	}

	public void listarReservasAula() {
		System.out.println(modelo.getReservasAula(Consola.leerAula()).toString());
	}

	public void listarReservasProfesor() {
		System.out.println(modelo.getReservasProfesor(Consola.leerProfesor()).toString());
	}

	public void listarReservasPermanencia() {
		System.out.println(modelo.getReservasPermanencia(new Permanencia(Consola.leerDia(), Consola.leerTramo())).toString());
	}

	public void consultarDisponibilidad() {
		boolean disponible = modelo.consultarDisponibilidad(Consola.leerAula(), new Permanencia(Consola.leerDia(), Consola.leerTramo()));
		if(disponible)
			System.out.println("El aula consultada está disponible para el tramo especificado.");
		else
			System.out.println("El aula consultada no está disponible para el tramo especificado.");
	}

}
