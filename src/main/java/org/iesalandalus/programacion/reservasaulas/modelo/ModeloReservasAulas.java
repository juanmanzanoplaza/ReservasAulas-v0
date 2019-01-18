package org.iesalandalus.programacion.reservasaulas.modelo;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dao.Aulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Profesores;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Reservas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

public class ModeloReservasAulas {
	
	private Profesores profesores;
	private Aulas aulas;
	private Reservas reservas;
	
	public ModeloReservasAulas() {
		this.profesores = new Profesores();
		this.aulas = new Aulas();
		this.reservas = new Reservas();
	}
	
	public Aula[] getAulas() {
		return aulas.getAulas();
	}
	
	public int getNumAulas() {
		return aulas.getNumAulas();
	}
	
	public String[] representarAulas() {
		return aulas.representar();
	}
	
	public Aula buscarAula(Aula buscar) {
		return aulas.buscar(buscar);
	}
	
	public void insertarAula(Aula insertar) throws OperationNotSupportedException {
		aulas.insertar(insertar);
	}
	
	public void borrarAula(Aula borrar) throws OperationNotSupportedException {
		aulas.borrar(borrar);
	}
	
	public Profesor[] getProfesores() {
		return profesores.getProfesores();
	}
	
	public int getNumProfesores() {
		return profesores.getNumProfesores();
	}
	
	public String[] representarProfesores() {
		return profesores.representar();
	}
	
	public Profesor buscarProfesor(Profesor buscar) {
		return profesores.buscar(buscar);
	}
	
	public void insertarProfesor(Profesor insertar) throws OperationNotSupportedException {
		profesores.insertar(insertar);
	}
	
	public void borrarProfesor(Profesor borrar) throws OperationNotSupportedException {
		profesores.borrar(borrar);
	}
	
	public Reserva[] getReservas() {
		return reservas.getReservas();
	}
	
	public int getNumReservas() {
		return reservas.getNumReservas();
	}
	
	public String[] representarReservas() {
		return reservas.representar();
	}
	
	public Reserva buscarReserva(Reserva buscar) {
		return reservas.buscar(buscar);
	}
	
	public void realizarReserva(Reserva realizar) throws OperationNotSupportedException {
		reservas.insertar(realizar);
	}
	
	public void anularReserva(Reserva anular) throws OperationNotSupportedException {
		reservas.borrar(anular);
	}
	
	public Reserva[] getReservasAula(Aula aula) {
		return reservas.getReservasAula(aula);
	}
	
	public Reserva[] getReservasProfesor(Profesor profesor) {
		return reservas.getReservasProfesor(profesor);
	}
	
	public Reserva[] getReservasPermanencia(Permanencia permanencia) {
		return reservas.getReservasPermanencia(permanencia);
	}
	
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		return reservas.consultarDisponibilidad(aula, permanencia);
	}

}
