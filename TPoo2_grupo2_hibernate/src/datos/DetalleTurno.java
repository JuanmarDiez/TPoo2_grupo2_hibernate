package datos;

import java.time.LocalDate; 
import java.time.LocalTime;

public class DetalleTurno {
	private long idDetalle;
	private String descripcion;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private Turno turno;
	
	public DetalleTurno() {}

	public DetalleTurno(String descripcion, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, Turno turno) {
		super();
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.turno = turno;
	}

	public long getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(long idDetalle) {
		this.idDetalle = idDetalle;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}
	
	

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "DetalleTurno [idDetalle=" + idDetalle + ", descripcion=" + descripcion + ", fecha=" + fecha
				+ ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + "]";
	}


	
	
}
