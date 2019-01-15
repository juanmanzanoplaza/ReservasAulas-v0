package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Permanencia {

	private LocalDate dia;
	private static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/uuuu");
	private Tramo tramo;

	public Permanencia(LocalDate dia, Tramo tramo) {
		setDia(dia);
		setTramo(tramo);
	}

	public Permanencia(Permanencia p) {
		if(p==null)
			throw new IllegalArgumentException("No se puede copiar una permanencia nula.");
		setDia(p.getDia());
		setTramo(p.getTramo());
	}

	public LocalDate getDia() {
		return LocalDate.of(dia.getYear(), dia.getMonth(), dia.getDayOfMonth());
	}

	
	private void setDia(LocalDate dia) {
		if(dia==null)
			throw new IllegalArgumentException("El día de una permanencia no puede ser nulo.");
		this.dia = LocalDate.of(dia.getYear(), dia.getMonth(), dia.getDayOfMonth());
	}

	public Tramo getTramo() {
		return tramo;
	}

	private void setTramo(Tramo tramo) {
		if(tramo == null)
			throw new IllegalArgumentException("El tramo de una permanencia no puede ser nulo.");
		this.tramo = tramo;
	}

	public int hashCode() {
		return Objects.hash(dia, tramo);
	}

	public boolean equals(Object o) {
		if(o==null)
			return false;
		if(!(o instanceof Permanencia))
			return false;
		Permanencia otra = (Permanencia) o;
		if(this.getDia().equals(otra.getDia()) && this.getTramo().equals(otra.getTramo()))
			return true;
		return false;
	}

	public String toString() {
		return "[dia=" + getDia().format(FORMATO_DIA) + ", tramo=" + getTramo() + "]";
	}
}
