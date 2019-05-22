package org.iesalandalus.programacion.reservasaulas.modelo;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dao.Aulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Profesores;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Reservas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.vista.IUTextual;

/**
 * 
 * Clase modelo utilizada como intermediaria entre IUTextual, que accede a todas las funciones de la aplicación.
 * @see IUTextual
 * @see Profesores
 * @see Aulas
 * @see Reservas
 * @author Juan Antonio Manzano Plaza
 * @version 0
 *
 */
public class ModeloReservasAulas {
	
	private Profesores profesores;
	private Aulas aulas;
	private Reservas reservas;
	
	/**
	 * Constructor de la clase. Crea los distintos atributos de la clase.
	 */
	public ModeloReservasAulas() {
		this.profesores = new Profesores();
		this.aulas = new Aulas();
		this.reservas = new Reservas();
	}

	/**
	 * Obtiene todas las aulas registradas. Llama al método getAulas de Aulas
	 * @return todas las aulas guardadas
	 */
	public Aula[] getAulas() {
		return aulas.getAulas();
	}

	/**
	 * Obtiene el número de aulas registradas. Llama al método getNumAulas de Aulas
	 * @return el número de aulas guardadas
	 */
	public int getNumAulas() {
		return aulas.getNumAulas();
	}
	
	/**
	 * Obtiene la salida de todas las aulas registradas. Llama al método representar de Aulas
	 * @return un array con la representación de cada aula en forma de cadena
	 */
	public String[] representarAulas() {
		return aulas.representar();
	}
	
	/**
	 * Busca el aula indicada entre las que han sido registradas. Llama al método buscar de Aulas
	 * @param buscar el aula que estamos buscando
	 * @return el aula buscada o null si no la encuentra
	 */
	public Aula buscarAula(Aula buscar) {
		return aulas.buscar(buscar);
	}
	
	/**
	 * Guarda el aula indicada. Llama al método insertar de Aulas
	 * @param insertar el aula que queremos guardar
	 * @throws OperationNotSupportedException si se intenta insertar un aula nula, ya existente o se ha superado la capacidad
	 */
	public void insertarAula(Aula insertar) throws OperationNotSupportedException, IllegalArgumentException {
		aulas.insertar(insertar);
	}
	
	/**
	 * Borra el aula indicada si existe entre las guardadas. Llama al método borrar de Aulas
	 * @param borrar el aula que queremos borrar
	 * @throws OperationNotSupportedException si se intenta borrar un aula nula o que no existe
	 */
	public void borrarAula(Aula borrar) throws OperationNotSupportedException, IllegalArgumentException {
		aulas.borrar(borrar);
	}
	
	/**
	 * Obtiene todos los profesores registrados. Llama al método getProfesores de Profesores
	 * @return todos los profesores guardados
	 */
	public Profesor[] getProfesores() {
		return profesores.getProfesores();
	}
	
	/**
	 * Obtiene el número de profesores registrados. Llama al método getNumProfesores de Profesores
	 * @return el número de profesores guardados
	 */
	public int getNumProfesores() {
		return profesores.getNumProfesores();
	}
	
	/**
	 * Obtiene la salida de todos los profesores registrados. Llama al método representar de Profesores
	 * @return un array con la representación de cada profesor en forma de cadena
	 */
	public String[] representarProfesores() {
		return profesores.representar();
	}
	
	/**
	 * Busca el profesor indicado entre los que han sido registrados. Llama al método buscar de Profesores
	 * @param buscar el profesor que buscamos
	 * @return el profesor buscado o null si no lo encuentra
	 */
	public Profesor buscarProfesor(Profesor buscar) {
		return profesores.buscar(buscar);
	}
	
	/**
	 * Guarda el profesor indicado. Llama al método insertar de Profesores
	 * @param insertar el profesor que queremos guardar
	 * @throws OperationNotSupportedException si se intenta insertar un profesor nulo, ya existente o se ha superado la capacidad
	 */
	public void insertarProfesor(Profesor insertar) throws OperationNotSupportedException, IllegalArgumentException {
		profesores.insertar(insertar);
	}
	
	/**
	 * Borra el profesor indicado si existe entre los que han sido registrados. Llama al método borrar de Profesores
	 * @param borrar el profesor que queremos borrar
	 * @throws OperationNotSupportedException si se intenta borrar un profesor nulo o que no existe
	 */
	public void borrarProfesor(Profesor borrar) throws OperationNotSupportedException, IllegalArgumentException {
		profesores.borrar(borrar);
	}
	
	/**
	 * Obtiene todas las reservas realizadas. Llama al método getReservas de Reservas
	 * @return todas las reservas realizadas
	 */
	public Reserva[] getReservas() {
		return reservas.getReservas();
	}
	
	/**
	 * Obtiene el número de reservas realizadas. Llama al método getNumReservas de Reservas
	 * @return el número de reservas guardadas
	 */
	public int getNumReservas() {
		return reservas.getNumReservas();
	}
	
	/**
	 * Obtiene la salida de todas las reservas realizadas. Llama al método representar de Reservas
	 * @return un array con la representación de cada reserva en forma de cadena
	 */
	public String[] representarReservas() {
		return reservas.representar();
	}
	
	/**
	 * Busca la reserva indicada entre las que se han realizado. Llama al método buscar de Reservas
	 * @param buscar la reserva que buscamos
	 * @return la reserva buscada o null si no la encuentra
	 */
	public Reserva buscarReserva(Reserva buscar) {
		return reservas.buscar(buscar);
	}
	
	/**
	 * Guarda la reserva indicada. Llama al método insertar de Reservas
	 * @param realizar la reserva a realizar
	 * @throws OperationNotSupportedException si se intenta realizar una reserva nula, ya existente o se ha superado la capacidad
	 */
	public void realizarReserva(Reserva realizar) throws OperationNotSupportedException, IllegalArgumentException {
		reservas.insertar(realizar);
	}
	
	/**
	 * Borra la reserva indicada si existe entre las realizadas. Llama al método borrar de Reserva
	 * @param anular la reserva a anular
	 * @throws OperationNotSupportedException si se intenta anular una reserva nula o que no existe
	 */
	public void anularReserva(Reserva anular) throws OperationNotSupportedException, IllegalArgumentException {
		reservas.borrar(anular);
	}
	
	/**
	 * Obtiene todas las reservas correspondientes al aula indicada. Llama al método getReservasAula de Reservas
	 * @param aula el aula sobre la que están hechas las reservas
	 * @return un array con todas las reservas sobre el aula indicada
	 */
	public Reserva[] getReservasAula(Aula aula) throws IllegalArgumentException {
		return reservas.getReservasAula(aula);
	}
	
	/**
	 * Obtiene todas las reservas realizadas por el profesor indicado. Llama al método getReservasProfesor de Reservas
	 * @param profesor el profesor a nombre del que están hechas las reservas
	 * @return un array con todas las reservas a nombre del profesor indicado
	 */
	public Reserva[] getReservasProfesor(Profesor profesor) throws IllegalArgumentException {
		return reservas.getReservasProfesor(profesor);
	}
	
	/**
	 * Obtiene todas las reservas realizadas en un día y tramo indicados. Llama al método getReservasPermanencia de Reservas
	 * @param permanencia la fecha de las reservas
	 * @return un array con todas las reservas de ese día y tramo
	 */
	public Reserva[] getReservasPermanencia(Permanencia permanencia) throws IllegalArgumentException {
		return reservas.getReservasPermanencia(permanencia);
	}
	
	/**
	 * Comprueba si hay alguna reserva realizada sobre un aula en una permanencia indicadas. Llama al método consultarDisponibilidad de Reservas
	 * @param aula el aula sobre la que queremos consultar la disponibilidad
	 * @param permanencia el día que queremos comprobar si está reservada el aula
	 * @return True si está disponible (no está reservada) y False si no está disponible (está reservada)
	 */
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) throws IllegalArgumentException {
		return reservas.consultarDisponibilidad(aula, permanencia);
	}

}
