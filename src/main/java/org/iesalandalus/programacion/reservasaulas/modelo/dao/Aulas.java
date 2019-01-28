package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;

/**
 * Clase que guarda y define las operaciones que se pueden realizar sobre un conjunto de aulas.
 * @see {@link Aula}
 * @author Juan Antonio Manzano Plaza
 * @version 0
 * 
 */
public class Aulas {
	private static final int MAX_AULAS = 100;
	private int numAulas;
	private Aula[] coleccionAulas;

	/**
	 * Constructor por defecto. Inicializa el n�mero de aulas a cero
	 */
	public Aulas() {
		this.numAulas = 0;
		coleccionAulas = new Aula[MAX_AULAS];
	}

	/**
	 * Constructor copia. Realiza copia profunda para evitar aliasing
	 * @param aulas el objeto del que obtener los datos para inicializar
	 */
	public Aulas(Aulas aulas) {
		setAulas(aulas);
	}

	/**
	 * Guarda en la colecci�n actual de aulas los que hay en la recibida como par�metro
	 * @param aulas la colecci�n a copiar
	 * @throws IllegalArgumentException si se intenta copiar un conjunto de aulas nulas
	 */
	private void setAulas(Aulas aulas) {
		if(aulas==null)
			throw new IllegalArgumentException("No se pueden copiar aulas nulas.");
		this.coleccionAulas = copiaProfundaAulas(aulas.getAulas());
	}

	/**
	 * Realiza la copia en profundidad de cada profesor para evitar aliasing
	 * @param coleccionAulas la colecci�n de aulas a copiar
	 * @return una copia de la colecci�n
	 */
	private Aula[] copiaProfundaAulas(Aula[] coleccionAulas) {
		Aula[] copia = new Aula[MAX_AULAS];
		for(int i = 0; i<copia.length && coleccionAulas[i]!=null; i++)
			copia[i] = new Aula(coleccionAulas[i]);
		return copia;
	}

	/**
	 * Obtiene todas las aulas de la colecci�n actual
	 * @return una copia de la colecci�n
	 */
	public Aula[] getAulas() {
		return copiaProfundaAulas(this.coleccionAulas);
	}

	/**
	 * Obtiene el n�mero de aulas que existen en la colecci�n actual
	 * @return el n�mero de aulas
	 */
	public int getNumAulas() {
		return numAulas;
	}

	/**
	 * Guarda un aula en la colecci�n
	 * @param aula el aula a guardar
	 * @throws IllegalArgumentException si el aula es nula
	 * @throws OperationNotSupportedException si el aula ya existe o se supera la capacidad
	 */
	public void insertar(Aula aula) throws OperationNotSupportedException {
		if(aula==null)
			throw new IllegalArgumentException("No se puede insertar un aula nula.");
		int indice = buscarIndiceAula(aula);
		if(indiceNoSuperaTamano(indice))
			throw new OperationNotSupportedException("El aula ya existe.");
		if(indiceNoSuperaCapacidad(indice)) {
			coleccionAulas[indice] = aula;
			numAulas++;
		} else
			throw new OperationNotSupportedException("Se ha alcanzado el m�ximo de aulas que se pueden guardar.");

	}

	/**
	 * Busca el �ndice en la colecci�n de un aula indicada
	 * @param aula el aula cuyo �ndice queremos buscar
	 * @return el �ndice del aula buscada
	 */
	private int buscarIndiceAula(Aula aula) {
		for(int i = 0; i < coleccionAulas.length; i++) {
			if(coleccionAulas[i]!=null) {
				if(coleccionAulas[i].equals(aula))
					return i;
			} else
				return i;
		}
		return MAX_AULAS;
	}

	/**
	 * Comprueba que el �ndice no supera el n�mero de aulas existentes
	 * @param indice el �ndice a comprobar
	 * @return True si no supera el tama�o, False si lo supera
	 */
	private boolean indiceNoSuperaTamano(int indice) {
		if(indice<numAulas)
			return true;
		return false;
	}

	/**
	 * Comprueba que el �ndice no supera la cantidad m�xima que se puede guardar
	 * @param indice el �ndice a comprobar
	 * @return True si no supera la capacidad, False si la supera
	 */
	private boolean indiceNoSuperaCapacidad(int indice) {
		if(indice<MAX_AULAS)
			return true;
		return false;
	}

	/**
	 * Busca un aula en la colecci�n
	 * @param aula el aula a buscar
	 * @return el aula buscada o null si no la encuentra
	 */
	public Aula buscar(Aula aula) {
		if(aula==null)
			return null;
		int indice = buscarIndiceAula(aula);
		if(indiceNoSuperaTamano(indice))
			return coleccionAulas[indice];
		return null;
	}

	/**
	 * Borra un aula de la colecci�n
	 * @param aula el aula a borrar
	 * @throws IllegalArgumentException si el aula es nula
	 * @throws OperationNotSupportedException si el aula no existe
	 */
	public void borrar(Aula aula) throws OperationNotSupportedException {
		if(aula==null)
			throw new IllegalArgumentException("No se puede borrar un aula nula.");
		int indice = buscarIndiceAula(aula);
		if(indiceNoSuperaTamano(indice)) {
			coleccionAulas[indice] = null;
			desplazarUnaPosicionHaciaIzquierda(indice);
			numAulas--;
		} else
			throw new OperationNotSupportedException("El aula a borrar no existe.");

	}

	/**
	 * Desplaza las aulas a la posici�n anterior de un �ndice dado
	 * @param indice desde donde hay que mover las aulas
	 */
	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for(int i = indice; i<coleccionAulas.length && coleccionAulas[i+1]!=null; i++)
			coleccionAulas[i] = coleccionAulas[i+1];
		coleccionAulas[numAulas-1] = null;
	}

	/**
	 * Obtiene las salidas de todas las aulas de la colecci�n
	 * @return la salida de las aulas
	 */
	public String[] representar() {
		String[] representar = new String[numAulas];
		for(int i = 0; i < representar.length; i++)
			representar[i] = coleccionAulas[i].toString();
		return representar;
	}

}
