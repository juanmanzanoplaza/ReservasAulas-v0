package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import java.util.Objects;

public class Reserva {
	Profesor profesor;
	Aula aula;
	Permanencia permanencia;
	
	public Reserva(Profesor profesor, Aula aula, Permanencia permanencia) {
		setProfesor(profesor);
		setAula(aula);
		setPermanencia(permanencia);
	}
	
	public Reserva(Reserva otra) {
		if(otra == null)
			throw new IllegalArgumentException("No se puede copiar una reserva nula.");
		setProfesor(otra.getProfesor());
		setAula(otra.getAula());
		setPermanencia(otra.getPermanencia());
	}
	
	private void setProfesor(Profesor profesor) {
		if(profesor == null) 
			throw new IllegalArgumentException("La reserva debe estar a nombre de un profesor.");
		this.profesor = new Profesor(profesor);
	}
	
	public Profesor getProfesor() {
		return new Profesor(this.profesor);
	}
	
	private void setAula(Aula aula) {
		if(aula == null)
			throw new IllegalArgumentException("La reserva debe ser para un aula concreta.");
		this.aula = new Aula(aula);
	}
	
	public Aula getAula() {
		return new Aula(this.aula);
	}
	
	private void setPermanencia(Permanencia permanencia) {
		if(permanencia == null)
			throw new IllegalArgumentException("La reserva se debe hacer para una permanencia concreta.");
		this.permanencia = new Permanencia(permanencia);
	}
	
	public Permanencia getPermanencia() {
		return new Permanencia(this.permanencia);
	}
	
	public int hashCode() {
		return Objects.hash(profesor, aula, permanencia);
	}
	
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
	
	public String toString() {
		return "[profesor=" + getProfesor() + ", aula=" + getAula() + ", permanencia=" + getPermanencia() + "]";
	}

}
