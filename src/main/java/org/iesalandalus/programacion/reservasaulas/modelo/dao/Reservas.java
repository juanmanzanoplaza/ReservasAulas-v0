package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

public class Reservas {
	private static final int MAX_RESERVAS = 100;
	private int numReservas;
	private Reserva[] coleccionReservas;
	
	public Reservas() {
		this.numReservas = 0;
		coleccionReservas = new Reserva[MAX_RESERVAS];
	}
	
	public Reservas(Reservas reservas) {
		setReservas(reservas);
	}
	
	private void setReservas(Reservas reservas) {
		if(reservas==null)
			throw new IllegalArgumentException("No se pueden copiar reservas nulas.");
		this.coleccionReservas = copiaProfundaReservas(reservas.coleccionReservas);
	}
	
	private Reserva[] copiaProfundaReservas(Reserva[] reservas) {
		Reserva[] copia = new Reserva[MAX_RESERVAS];
		for(int i = 0; i<copia.length && reservas[i]!=null; i++)
			copia[i] = new Reserva(reservas[i]);
		return copia;
	}
	
	public Reserva[] getReservas() {
		return copiaProfundaReservas(this.coleccionReservas);
	}
	
	public int getNumReservas() {
		return numReservas;
	}
	
	public void insertar(Reserva reserva) throws OperationNotSupportedException {
		if(reserva==null)
			throw new IllegalArgumentException("No se puede realizar una reserva nula.");
		int indice = buscarIndiceReserva(reserva);
		if(indiceNoSuperaTamano(indice))
			throw new OperationNotSupportedException("La reserva ya existe.");
		if(indiceNoSuperaCapacidad(indice)) {
			coleccionReservas[indice] = reserva;
			numReservas++;
		} else
			throw new OperationNotSupportedException("Se ha alcanzado el máximo de reservas que se pueden guardar.");
	}
	
	private int buscarIndiceReserva(Reserva reserva) {
		for(int i = 0; i < coleccionReservas.length; i++) {
			if(coleccionReservas[i]!=null) {
				if(coleccionReservas[i].equals(reserva))
					return i;
			} else
				return i;
		}
		return MAX_RESERVAS;
	}
	
	private boolean indiceNoSuperaTamano(int indice) {
		if(indice<numReservas)
			return true;
		return false;
	}
	
	private boolean indiceNoSuperaCapacidad(int indice) {
		if(indice<MAX_RESERVAS)
			return true;
		return false;
	}
	
	public Reserva buscar(Reserva reserva) {
		if(reserva==null)
			return null;
		int indice = buscarIndiceReserva(reserva);
		if(indiceNoSuperaTamano(indice))
			return coleccionReservas[indice];
		return null;
	}
	
	public void borrar(Reserva reserva) throws OperationNotSupportedException {
		if(reserva==null)
			throw new IllegalArgumentException("No se puede anular una reserva nula.");
		int indice = buscarIndiceReserva(reserva);
		if(indiceNoSuperaTamano(indice)) {
			coleccionReservas[indice] = null;
			desplazarUnaPosicionHaciaIzquierda(indice);
			numReservas--;
		} else
			throw new OperationNotSupportedException("La reserva a anular no existe.");
	}
	
	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for(int i = indice; i<coleccionReservas.length && coleccionReservas[i+1]!=null; i++)
			coleccionReservas[i] = coleccionReservas[i+1];
		coleccionReservas[numReservas-1] = null;
	}
	
	public String[] representar() {
		String[] representar = new String[numReservas];
		for(int i = 0; i < representar.length; i++)
			representar[i] = coleccionReservas[i].toString();
		return representar;
	}
	
	public Reserva[] getReservasProfesor(Profesor profesor) {
		//Necesaria?
		if(profesor==null)
			throw new IllegalArgumentException("No se pueden comprobar las reservas de un profesor nulo.");
		Reserva[] devolver = new Reserva[MAX_RESERVAS];
		int indice = 0;
		for(int i = 0; i<numReservas; i++) {
			if(coleccionReservas[i].getProfesor().equals(profesor)) {
				devolver[indice] = new Reserva(coleccionReservas[i]);
				indice++;
			}
		}
		return devolver;
	}
	
	public Reserva[] getReservasAula(Aula aula) {
		if(aula==null)
			throw new IllegalArgumentException("No se pueden comprobar las reservas realizadas sobre un aula nula.");
		Reserva[] devolver = new Reserva[MAX_RESERVAS];
		int indice = 0;
		for(int i = 0; i<numReservas; i++) {
			if(coleccionReservas[i].getAula().equals(aula)) {
				devolver[indice] = new Reserva(coleccionReservas[i]);
				indice++;
			}
		}
		return devolver;
	}
	
	public Reserva[] getReservasPermanencia(Permanencia permanencia) {
		if(permanencia==null)
			throw new IllegalArgumentException("No se pueden consultar las reservas de una permanencia nula.");
		Reserva[] devolver = new Reserva[MAX_RESERVAS];
		int indice = 0;
		for(int i = 0; i<numReservas; i++) {
			if(coleccionReservas[i].getPermanencia().equals(permanencia)) {
				devolver[indice] = new Reserva(coleccionReservas[i]);
				indice++;
			}
		}
		return devolver;
	}
	
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		if(aula==null)
			throw new IllegalArgumentException("No se puede consultar la disponibilidad de un aula nula.");
		if(permanencia==null)
			throw new IllegalArgumentException("No se puede consultar la disponibilidad de una permanencia nula.");
		for(int i = 0; i<coleccionReservas.length && coleccionReservas[i]!=null; i++) {
			if(coleccionReservas[i].getAula().equals(aula) && coleccionReservas[i].getPermanencia().equals(permanencia))
				return false;
		}
		return true;
	}

}
