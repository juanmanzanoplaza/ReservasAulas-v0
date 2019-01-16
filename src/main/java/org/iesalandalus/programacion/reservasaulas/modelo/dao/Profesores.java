package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;

public class Profesores {

	private static final int MAX_PROFESORES = 100;
	private int numProfesores;
	private Profesor[] coleccionProfesores;

	public Profesores() {
		this.numProfesores = 0;
		coleccionProfesores = new Profesor[MAX_PROFESORES];
	}

	public Profesores(Profesores profesores) {
		setProfesores(profesores);
	}

	private void setProfesores(Profesores profesores) {
		if(profesores==null)
			throw new IllegalArgumentException("No se pueden copiar profesores nulos.");
		this.coleccionProfesores = copiaProfundaProfesores(profesores.getProfesores());
	}

	private Profesor[] copiaProfundaProfesores(Profesor[] coleccionProfesores) {
		Profesor[] copia = new Profesor[MAX_PROFESORES];
		for(int i = 0; i<copia.length && coleccionProfesores[i]!=null; i++)
			copia[i] = new Profesor(coleccionProfesores[i]);
		return copia;
	}

	public Profesor[] getProfesores() {
		return copiaProfundaProfesores(this.coleccionProfesores);
	}

	public int getNumProfesores() {
		return numProfesores;
	}

	public void insertar(Profesor profesor) throws OperationNotSupportedException {
		if(profesor==null)
			throw new IllegalArgumentException("No se puede insertar un profesor nulo.");
		int indice = buscarIndiceProfesor(profesor);
		if(indiceNoSuperaTamano(indice))
			throw new OperationNotSupportedException("El profesor ya existe.");
		if(indiceNoSuperaCantidad(indice)) {
			coleccionProfesores[indice] = profesor;
			numProfesores++;
		} else
			throw new OperationNotSupportedException("Se ha alcanzado el máximo de profesores que se pueden guardar.");
	}

	private int buscarIndiceProfesor(Profesor profesor) {
		for(int i = 0; i < coleccionProfesores.length; i++) {
			if(coleccionProfesores[i]!=null) {
				if(coleccionProfesores[i].equals(profesor))
					return i;
			} else
				return i;
		}
		return MAX_PROFESORES;
	}

	private boolean indiceNoSuperaTamano(int indice) {
		if(indice<numProfesores)
			return true;
		return false;
	}

	private boolean indiceNoSuperaCantidad(int indice) {
		if(indice<MAX_PROFESORES)
			return true;
		return false;
	}

	public Profesor buscar(Profesor profesor) {
		if(profesor==null)
			return null;
		int indice = buscarIndiceProfesor(profesor);
		if(indiceNoSuperaTamano(indice))
			return coleccionProfesores[indice];
		return null;
	}

	public void borrar(Profesor profesor) throws OperationNotSupportedException {
		if(profesor==null)
			throw new IllegalArgumentException("No se puede borrar un profesor nulo.");
		int indice = buscarIndiceProfesor(profesor);
		if(indiceNoSuperaTamano(indice)) {
			coleccionProfesores[indice] = null;
			desplazarUnaPosicionHaciaIzquierda(indice);
			numProfesores--;
		} else
			throw new OperationNotSupportedException("El profesor a borrar no existe.");
	}

	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for(int i = indice; i<coleccionProfesores.length && coleccionProfesores[i+1]!=null; i++)
			coleccionProfesores[i] = coleccionProfesores[i+1];
		coleccionProfesores[numProfesores-1] = null;
	}

	public String[] representar() {
		String[] representar = new String[numProfesores];
		for(int i = 0; i < representar.length; i++)
			representar[i] = coleccionProfesores[i].toString();
		return representar;
	}

}
