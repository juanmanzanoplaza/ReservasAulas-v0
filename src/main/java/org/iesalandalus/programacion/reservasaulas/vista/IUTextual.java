package org.iesalandalus.programacion.reservasaulas.vista;



//HACER GESTION DE EXCEPCIONES AQUI!!!

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.ModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

public class IUTextual {

	//Previo al mensaje del error.
	private static final String ERROR = "ERROR: ";
//	private static final String NOMBRE_VALIDO = "Juan";
	private static final String CORREO_VALIDO = "a@a.a";
	protected ModeloReservasAulas modelo;

	public IUTextual() {
		this.modelo = new ModeloReservasAulas();
		Opcion.setVista(this);
	}

	//igual que comenzar de gestionClientes
	public void comenzar() {
		Opcion opcion;
		do {
			Consola.mostrarMenu();
			//Lectura de la opción
			opcion = Opcion.getOpcionSegunOrdinal(Consola.elegirOpcion());
			// Ejecución de la opción
			opcion.ejecutar();
		} while (opcion != Opcion.SALIR);
	}

	public void salir() {
		System.out.println("Fin de la ejecución.");
	}

	public void insertarAula() {
		Consola.mostrarCabecera("INSERTAR AULA");
		try {
			modelo.insertarAula(Consola.leerAula());
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR + e.getMessage());
		}
		System.out.println("Aula insertada.");
	}

	public void borrarAula() {
		Consola.mostrarCabecera("BORRAR AULA");
		try {
			modelo.borrarAula(new Aula(Consola.leerNombreAula()));
			System.out.println("Aula eliminada.");
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void buscarAula() {
		Consola.mostrarCabecera("BUSCAR AULA");
		Aula leida = new Aula(Consola.leerNombreAula());
		Aula buscada = modelo.buscarAula(leida);
		if(buscada==null)
			System.out.println(ERROR + "El aula buscada no existe.");
		else
			System.out.println("Se ha encontrado el aula buscada: " + buscada);
	}

	public void listarAulas() {
		Consola.mostrarCabecera("LISTAR AULAS");
		String[] aulas = modelo.representarAulas();
		if(aulas.length==0)
			System.out.println(ERROR + "No hay ningún aula guardada.");
		for(int i = 0; i<aulas.length && aulas[i]!=null; i++)
			System.out.println(aulas[i]);
	}

	public void insertarProfesor() {
		Consola.mostrarCabecera("INSERTAR PROFESOR");
		try {
			modelo.insertarProfesor(Consola.leerProfesor());
			System.out.println("Profesor insertado.");
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void borrarProfesor() {
		Consola.mostrarCabecera("BORRAR PROFESOR");
		Profesor borrar = new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO);
		try {
			modelo.borrarProfesor(borrar);
			System.out.println("Profesor borrado.");
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void buscarProfesor() {
		Consola.mostrarCabecera("BUSCAR PROFESOR");
		Profesor buscado = new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO);
		Profesor encontrado = modelo.buscarProfesor(buscado);
		if(encontrado == null)
			System.out.println(ERROR + "El profesor buscado no existe.");
		else
			System.out.println("Se ha encontrado el profesor buscado: " + buscado);
	}

	public void listarProfesores() {
		Consola.mostrarCabecera("LISTAR PROFESORES");
		String[] profesores = modelo.representarProfesores();
		if(profesores.length==0)
			System.out.println(ERROR + "No hay ningún profesor guardado.");
		for(int i = 0; i<profesores.length && profesores[i]!=null; i++)
			System.out.println(profesores[i]);
	}

	public void realizarReserva() {
		Consola.mostrarCabecera("REALIZAR RESERVA");
		Profesor profesor = new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO);
		boolean lecturaCorrecta = true;
		if(modelo.buscarProfesor(profesor)==null) {
			System.out.println(ERROR + "El profesor introducido no existe.");
			lecturaCorrecta = false;
		}
		Reserva reserva = null;
		if(lecturaCorrecta) {
			reserva = leerReserva(profesor);
			if(reserva==null)
				System.out.println(ERROR + "El aula introducida no existe.");
		}
		if(reserva==null)
			System.out.println(ERROR + "La reserva no se pudo realizar.");
		else {
			try {
				modelo.realizarReserva(reserva);
				System.out.println("Reserva realizada correctamente.");
			} catch (OperationNotSupportedException e) {
				System.out.println(ERROR + e.getMessage());
			}
		}
	}

	private Reserva leerReserva(Profesor profesor) {
		Profesor buscado = modelo.buscarProfesor(profesor);
		if(buscado == null)
			return null;
		Aula buscada = modelo.buscarAula(new Aula(Consola.leerNombreAula()));
		if(buscada==null)
			return null;
		return new Reserva(buscado, buscada, new Permanencia(Consola.leerDia(), Consola.leerTramo()));
	}

	public void anularReserva() {
		Consola.mostrarCabecera("ANULAR RESERVA");
		Profesor buscado = new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO);
		boolean lecturaCorrecta = true;
		if(modelo.buscarProfesor(buscado)==null) {
			System.out.println("El profesor introducido no existe.");
			lecturaCorrecta = false;
		}
		Reserva reserva = null;
		if(lecturaCorrecta) {
			reserva = leerReserva(buscado);
			if(reserva==null)
				System.out.println("El aula introducida no existe.");
		}
		if(reserva==null)
			System.out.println("La reserva no se pudo anular.");
		else {
			try {
				modelo.anularReserva(reserva);
			} catch (OperationNotSupportedException e) {
				System.out.println(ERROR + e.getMessage());
			}
			System.out.println("Reserva anulada correctamente.");
		}
	}

	public void listarReservas() {
		Consola.mostrarCabecera("LISTAR RESERVAS");
		String[] reservas = modelo.representarReservas();
		if(reservas.length==0)
			System.out.println("No hay ninguna reserva hecha.");
		for(int i = 0; i<reservas.length && reservas[i]!=null; i++)
			System.out.println(reservas[i]);
	}

	//CORREGIR A PARTIR DE AQUI
	/*
	 *
		Profesor profesor = new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO);
		boolean lecturaCorrecta = true;
		if(modelo.buscarProfesor(profesor)==null) {
			System.out.println(ERROR + "El profesor introducido no existe.");
			lecturaCorrecta = false;
		}
		Reserva reserva = null;
		if(lecturaCorrecta) {
			reserva = leerReserva(profesor);
			if(reserva==null)
				System.out.println(ERROR + "El aula introducida no existe.");
		}
		if(reserva==null)
			System.out.println(ERROR + "La reserva no se pudo realizar.");
		else {
			try {
				modelo.realizarReserva(reserva);
				System.out.println("Reserva realizada correctamente.");
			} catch (OperationNotSupportedException e) {
				System.out.println(ERROR + e.getMessage());
			}
		}
	}
	 */
	public void listarReservasAula() {
		Consola.mostrarCabecera("LISTAR RESERVAS AULA");
		Aula aula = new Aula(Consola.leerNombreAula());
		boolean lecturaCorrecta = true;
		if(modelo.buscarAula(aula)==null){
			System.out.println(ERROR + "El aula introducida no existe.");
			lecturaCorrecta = false;
		}
		Reserva[] reservas = modelo.getReservasAula(aula);
		if(lecturaCorrecta && reservas[0] == null)
			System.out.println("El aula indicada no está reservada.");
		if(lecturaCorrecta) {
			for(int i = 0; i<reservas.length && reservas[i]!=null; i++)
				System.out.println(reservas[i]);
		}
	}

	public void listarReservasProfesor() {
		Consola.mostrarCabecera("LISTAR RESERVAS PROFESOR");
		Profesor profesor = new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO);
		boolean lecturaCorrecta = true;
		if(modelo.buscarProfesor(profesor)==null){
			System.out.println(ERROR + "El profesor introducida no existe.");
			lecturaCorrecta = false;
		}
		Reserva[] reservas = modelo.getReservasProfesor(profesor);
		if(lecturaCorrecta && reservas[0]==null)
			System.out.println("El profesor indicado no tiene ningún aula reservada.");
		if(lecturaCorrecta) {
			for(int i = 0; i<reservas.length && reservas[i]!=null; i++)
				System.out.println(reservas[i]);
		}
	}

	public void listarReservasPermanencia() {
		Consola.mostrarCabecera("LISTAR RESERVAS PERMANENCIA");
		Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
		Reserva[] reservas = modelo.getReservasPermanencia(permanencia);
		if(reservas[0]==null)
			System.out.println("En ese tramo no hay ningún aula reservada.");
		for(int i = 0; i<reservas.length && reservas[i]!=null; i++)
			System.out.println(reservas[i]);
	}

	public void consultarDisponibilidad() {
		Consola.mostrarCabecera("CONSULTAR DISPONIBILIDAD");
		Aula aula = new Aula(Consola.leerNombreAula());
		boolean lecturaCorrecta = true;
		if(modelo.buscarAula(aula) == null) {
			System.out.println(ERROR + "El aula indicada no existe.");
			lecturaCorrecta = false;
		}
		if(lecturaCorrecta) {
			Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
			boolean disponible = modelo.consultarDisponibilidad(aula, permanencia);
			if(disponible)
				System.out.println("El aula consultada está disponible para el tramo especificado.");
			else
				System.out.println("El aula consultada no está disponible para el tramo especificado.");
		}
	}

}
