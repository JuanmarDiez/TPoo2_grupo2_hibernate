package datos;

import java.util.Set;

public class Lugar {
	private long idLugar;
	private String calle;
	private String localidad;
	private Set<Turno> turnos;
	private Set<Servicio> servicios;
	
	public Lugar() {}

	public Lugar(String calle, String localidad) {
		super();
		this.calle = calle;
		this.localidad = localidad;
	}

	public long getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(long idLugar) {
		this.idLugar = idLugar;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
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
		return "Lugar [idLugar=" + idLugar + ", calle=" + calle + ", localidad=" + localidad + "]";
	}
	
}
