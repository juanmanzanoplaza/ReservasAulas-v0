package org.iesalandalus.programacion.reservasaulas.vista;

import javax.naming.OperationNotSupportedException;

public enum Opcion {
	SALIR("Salir.") {
		@Override
		public void ejecutar() {
			vista.salir();
		}
	}
	, INSERTAR_AULA("Insertar aula:") {
		@Override
		public void ejecutar() throws OperationNotSupportedException {
			vista.insertarAula();
		}
	}
	, BORRAR_AULA("Borrar aula:") {
		@Override
		public void ejecutar() throws OperationNotSupportedException {
			vista.borrarAula();
		}
	}
	, BUSCAR_AULA("Buscar aula:") {
		@Override
		public void ejecutar() {
			vista.buscarAula();
		}
	}
	, LISTAR_AULAS("Listar aulas:") {
		@Override
		public void ejecutar() {
			vista.listarAulas();
		}
	}
	, INSERTAR_PROFESOR("Insertar profesor:") {
		@Override
		public void ejecutar() throws OperationNotSupportedException {
			vista.insertarProfesor();
		}
	}
	, BORRAR_PROFESOR("Borrar profesor:") {
		@Override
		public void ejecutar() throws OperationNotSupportedException {
			vista.borrarProfesor();
		}
	}
	, BUSCAR_PROFESOR("Buscar profesor:") {
		@Override
		public void ejecutar() {
			vista.buscarProfesor();
		}
	}
	, LISTAR_PROFESORES("Listar profesores:") {
		@Override
		public void ejecutar() {
			vista.listarProfesores();
		}
	}
	, INSERTAR_RESERVA("Insertar reserva:") {
		@Override
		public void ejecutar() throws OperationNotSupportedException {
			vista.realizarReserva();
		}
	}
	, BORRAR_RESERVA("Borrar reserva:") {
		@Override
		public void ejecutar() throws OperationNotSupportedException {
			vista.anularReserva();
		}
	}
	, LISTAR_RESERVAS("Listar reservas:") {
		@Override
		public void ejecutar() {
			vista.listarReservas();
		}
	}
	, LISTAR_RESERVAS_AULA("Listar reservas por aula:") {
		@Override
		public void ejecutar() {
			vista.listarReservasAula();
		}
	}
	, LISTAR_RESERVAS_PROFESOR("Listar reservas por profesor:") {
		@Override
		public void ejecutar() {
			vista.listarReservasProfesor();
		}
	}
	, LISTAR_RESERVAS_PERMANENCIA("Listar reservas por permanencia:") {
		@Override
		public void ejecutar() {
			vista.listarReservasPermanencia();
		}
	}
	, CONSULTAR_DISPONIBILIDAD("Consultar disponibilidad:") {
		@Override
		public void ejecutar() {
			vista.consultarDisponibilidad();
		}
	};
	private String mensajeAMostrar;
	private static IUTextual vista;

	private Opcion(String mensajeAMostrar) {
		this.mensajeAMostrar = mensajeAMostrar;
		setVista(new IUTextual());
	}

	public String getMensaje() {
		return mensajeAMostrar;
	}

	public abstract void ejecutar() throws OperationNotSupportedException;

	protected static void setVista(IUTextual iutextual) {
		vista = iutextual;
	}

	public String toString() {
		return mensajeAMostrar;
	}

	public static Opcion getOpcionSegunOrdinal(int ordinal) {
		return Opcion.values()[ordinal];
	}

	public static boolean esOrdinalValido(int ordinal) {
		if(ordinal>=0 && ordinal<Opcion.values().length)
			return true;
		return false;
	}

}
