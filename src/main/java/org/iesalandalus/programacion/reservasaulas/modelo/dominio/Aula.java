package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import java.util.Objects;

public class Aula {

	private String nombre;
	
	public Aula(String nombre) {
		setNombre(nombre);
	}
	
	public Aula(Aula otra) {
		if(otra==null)
			throw new IllegalArgumentException("No se puede copiar un aula nula.");
		setNombre(otra.getNombre());
	}
	
	private void setNombre(String nombre) {
		if(nombre==null)
			throw new IllegalArgumentException("El nombre del aula no puede ser nulo.");
		if(nombre.equals(""))
			throw new IllegalArgumentException("El nombre del aula no puede estar vacío.");
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int hashCode() {
		return Objects.hash(nombre);
	}
	
	public boolean equals(Object o) {
		if(o==null)
			return false;
		if(!(o instanceof Aula))
			return false;
		Aula otra = (Aula) o;
		if(this.getNombre().equals(otra.getNombre()) && this.hashCode()==otra.hashCode())
			return true;
		return false;
	}
	
	public String toString() {
		return "[nombre=" + nombre + "]";
	}
}
