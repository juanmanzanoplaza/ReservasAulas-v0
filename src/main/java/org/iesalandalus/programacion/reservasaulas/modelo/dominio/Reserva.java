package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import java.util.Objects;

/**
 * Clase que representa la reserva de un aula en un instituto
 * @see Profesor, Aula, Permanencia
 * @author Juan Antonio Manzano Plaza
 * @version 0
 */
public class Reserva {
	Profesor profesor;
	Aula aula;
	Permanencia permanencia;

	/**
	 * Constructor de la clase
	 * @param profesor el profesor que reserva el aula
	 * @param aula el aula que es reservada
	 * @param permanencia el d�a y el tramo en el que es reservada
	 */
	public Reserva(Profesor profesor, Aula aula, Permanencia permanencia) {
		setProfesor(profesor);
		setAula(aula);
		setPermanencia(permanencia);
	}

	/**
	 * Constructor copia de la clase
	 * @param otra la reserva a copiar
	 */
	public Reserva(Reserva otra) {
		if(otra == null)
			throw new IllegalArgumentException("No se puede copiar una reserva nula.");
		setProfesor(otra.getProfesor());
		setAula(otra.getAula());
		setPermanencia(otra.getPermanencia());
	}

	/**
	 * M�todo set para el profesor de la reserva
	 * @param profesor el profesor que realiza la reserva
	 * @throws IllegalArgumentException si el profesor es nulo
	 */
	private void setProfesor(Profesor profesor) {
		if(profesor == null)
			throw new IllegalArgumentException("La reserva debe estar a nombre de un profesor.");
		this.profesor = new Profesor(profesor);
	}

	/**
	 * M�todo get para el profesor de la reserva
	 * @return el profesor de la reserva
	 */
	public Profesor getProfesor() {
		return new Profesor(this.profesor);
	}

	/**
	 * M�todo set para el aula de la reserva
	 * @param aula el aula reservada
	 */
	private void setAula(Aula aula) {
		if(aula == null)
			throw new IllegalArgumentException("La reserva debe ser para un aula concreta.");
		this.aula = new Aula(aula);
	}

	/**
	 * M�todo get para el aula de la reserva
	 * @return el aula de la reserva
	 */
	public Aula getAula() {
		return new Aula(this.aula);
	}

	/**
	 * M�todo set para la permanencia de la reserva
	 * @param permanencia la permanencia de la reserva
	 * @throws IllegalArgumentException si la permanencia es nula
	 */
	private void setPermanencia(Permanencia permanencia) {
		if(permanencia == null)
			throw new IllegalArgumentException("La reserva se debe hacer para una permanencia concreta.");
		this.permanencia = new Permanencia(permanencia);
	}

	/**
	 * M�todo get para la permanencia de la reserva
	 * @return la permanencia de la reserva
	 */
	public Permanencia getPermanencia() {
		return new Permanencia(this.permanencia);
	}

	/**
	 * M�todo hashCode de la clase. Sirve para diferenciar objetos
	 * @return el c�digo hash del objeto
	 */
	public int hashCode() {
		return Objects.hash(profesor, aula, permanencia);
	}

	/**
	 * M�todo equals de la clase
	 * @return True si son iguales, False si no
	 */
	public boolean equals(Object o) {
		if(o==null)
			return false;
		if(!(o instanceof Reserva))
			return false;
		Reserva otra = (Reserva) o;
		if(this.aula.equals(otra.aula) && this.permanencia.equals(otra.permanencia))
			return true;
		return false;
	}

	/**
	 * Representa una reserva como una cadena de caracteres
	 * @return la representaci�n de la reserva
	 */
	public String toString() {
		return "[profesor=" + getProfesor() + ", aula=" + getAula() + ", permanencia=" + getPermanencia() + "]";
	}

}
