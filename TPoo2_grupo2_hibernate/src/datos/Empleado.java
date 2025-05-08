package datos;

import java.time.LocalDate;
import java.util.Set;

public class Empleado extends Usuario {
	private int legajo;
	private LocalDate fechaDeAlta;
	private boolean esActivo;
	private Set<Turno> turnos;
	private Set<Servicio> servicios;
	
	public Empleado() {}
	
	public Empleado(String email, String contrasena, String nombre, String apellido, int dni,String tipo,int legajo, LocalDate fechaDeAlta, boolean esActivo) {
		super(email,contrasena,nombre,apellido,dni,tipo);
		this.legajo = legajo;
		this.fechaDeAlta = fechaDeAlta;
		this.esActivo = esActivo;
	}


	public int getLegajo() {
		return legajo;
	}


	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}


	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}


	public void setFechaDeAlta(LocalDate fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}


	public boolean isEsActivo() {
		return esActivo;
	}


	public void setEsActivo(boolean esActivo) {
		this.esActivo = esActivo;
	}

	public Set<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(Set<Turno> turnos) {
		this.turnos = turnos;
	}

	public Set<Servicio> getServicios() {
		return servicios;
	}


	public void setServicios(Set<Servicio> servicios) {
		this.servicios = servicios;
	}


	@Override
	public String toString() {
		return "Empleado [ "+super.toString()+" legajo=" + legajo + ", fechaDeAlta=" + fechaDeAlta + ", esActivo=" + esActivo + "]";
	}	
}
