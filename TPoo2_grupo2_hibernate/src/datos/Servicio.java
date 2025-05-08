package datos;

import java.util.Set;

public class Servicio {
	private long idServicio;
	private String nombreServicio;
	private String detalle;
	private Set<Turno> turnos;
	private Set<Lugar> lugares;
	private Set<Empleado> empleados;
	
	public Servicio() {}
	
	public Servicio(String nombreServicio, String detalle) {
		super();
		this.nombreServicio = nombreServicio;
		this.detalle = detalle;
	}

	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Set<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(Set<Turno> turnos) {
		this.turnos = turnos;
	}

	public Set<Lugar> getLugares() {
		return lugares;
	}

	public void setLugares(Set<Lugar> lugares) {
		this.lugares = lugares;
	}

	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", nombreServicio=" + nombreServicio + ", detalle=" + detalle
				+ "]";
	}
	
}
