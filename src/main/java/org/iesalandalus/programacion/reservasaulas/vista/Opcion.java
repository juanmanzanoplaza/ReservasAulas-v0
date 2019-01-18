package org.iesalandalus.programacion.reservasaulas.vista;

public enum Opcion {
	SALIR("") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub
			
		}
	}
	, INSERTAR_AULA("") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub
			
		}
	}
	, BORRAR_AULA("") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub
			
		}
	}
	, BUSCAR_AULA("") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub
			
		}
	}
	, LISTAR_AULAS("") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub
			
		}
	}
	, INSERTAR_PROFESOR("") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub
			
		}
	}
	, BORRAR_PROFESOR("") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub
			
		}
	}
	, BUSCAR_PROFESOR("") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub
			
		}
	}
	, LISTAR_PROFESORES("") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub
			
		}
	}
	, INSERTAR_RESERVA("") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub
			
		}
	}
	, BORRAR_RESERVA("") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub
			
		}
	}
	, LISTAR_RESERVAS("") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub
			
		}
	}
	, LISTAR_RESERVAS_AULA("") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub
			
		}
	}
	, LISTAR_RESERVAS_PROFESOR("") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub
			
		}
	}
	, LISTAR_RESERVAS_PERMANENCIA("") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub
			
		}
	}
	, CONSULTAR_DISPONIBILIDAD("") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub
			
		}
	};
	private String mensajeAMostrar;
//	private static IUTextual vista;
	
	private Opcion(String mensajeAMostrar) {
		this.mensajeAMostrar = mensajeAMostrar;
	}
	
	public String getMensaje() {
		return mensajeAMostrar;
	}
	
	public abstract void ejecutar();
	
//	protected static void setVista(IUTextual iutextual) {
		
//	}
	
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
