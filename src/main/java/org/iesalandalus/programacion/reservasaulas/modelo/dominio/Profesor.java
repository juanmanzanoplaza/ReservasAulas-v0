package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Profesor {

	private static final String ER_TELEFONO = "^[69][0-9]{8}$";
	private static final String ER_CORREO = "^[a-z0-9]+(\\.[a-z0-9]+)*@[a-z]+(\\.[a-z]+)*(\\.[a-z]{1,4})$";
	private String nombre;
	private String correo;
	private String telefono;

	public Profesor(String nombre, String correo) {
		setNombre(nombre);
		setCorreo(correo);
	}

	public Profesor(String nombre, String correo, String telefono) {
		setNombre(nombre);
		setCorreo(correo);
		setTelefono(telefono);
	}

	public Profesor(Profesor otro) {
		if(otro==null)
			throw new IllegalArgumentException("No se puede copiar un profesor nulo.");
		setNombre(otro.getNombre());
		setCorreo(otro.getCorreo());
		setTelefono(otro.getTelefono());
			
	}

	private void setNombre(String nombre) {
		if(nombre==null)
			throw new IllegalArgumentException("El nombre del profesor no puede ser nulo.");
		if(nombre.equals(""))
			throw new IllegalArgumentException("El nombre del profesor no puede estar vacío.");
		this.nombre = nombre;

	}

	public void setCorreo(String correo) {
		if(correo==null)
			throw new IllegalArgumentException("El correo del profesor no puede ser nulo.");
		Pattern p = Pattern.compile(ER_CORREO);
		Matcher m = p.matcher(correo);
		if(m.matches())
			this.correo = correo;
		else
			throw new IllegalArgumentException("El correo del profesor no es válido.");

	}

	public void setTelefono(String telefono) {
		if(telefono==null) {
			this.telefono = null;
		} else {
			Pattern p = Pattern.compile(ER_TELEFONO);
			Matcher m = p.matcher(telefono);
			if(m.matches())
				this.telefono = telefono;
			else
				throw new IllegalArgumentException("El teléfono del profesor no es válido.");
		}
	}

	public String getNombre() {
		return nombre;

	}

	public String getCorreo() {
		return correo;

	}

	public String getTelefono() {
		return telefono;

	}

	public int hashCode() {
		return Objects.hash(nombre, correo, telefono);
	}

	public boolean equals(Object o) {
		if(o==null)
			return false;
		if(!(o instanceof Profesor))
			return false;
		Profesor otro = (Profesor) o;
		if(this.getNombre().equals(otro.getNombre()))
			return true;
		return false;

	}

	public String toString() {
		String devolver = "[nombre=" + getNombre() + ", correo=" + getCorreo();
		if(getTelefono()==null)
			devolver += "]";
		else
			devolver += ", telefono=" + getTelefono() + "]";
		return devolver;

	}
}
