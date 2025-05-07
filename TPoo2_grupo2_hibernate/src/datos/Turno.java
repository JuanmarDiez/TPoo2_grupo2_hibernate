package datos;

public class Turno {
	private long idTurno;
	private Cliente cliente;
	private Empleado empleado;
	private Lugar lugar;
	private Servicio servicio;
	private DetalleTurno detalle;

	public Turno() {}

	public Turno(Cliente cliente, Empleado empleado, Lugar lugar, Servicio servicio, DetalleTurno detalle) {
		this.cliente = cliente;
		this.empleado = empleado;
		this.lugar = lugar;
		this.servicio = servicio;
		this.detalle = detalle;
	}

	public long getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(long idTurno) {
		this.idTurno = idTurno;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public DetalleTurno getDetalle() {
		return detalle;
	}

	public void setDetalle(DetalleTurno detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Turno [idTurno=" + idTurno +
				", cliente=" + cliente +
				", empleado=" + empleado +
				", lugar=" + lugar +
				", servicio=" + servicio +
				", detalle=" + detalle + "]";
	}
}
