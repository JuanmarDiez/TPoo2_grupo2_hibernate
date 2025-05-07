package datos;

public class Servicio {
	private long idServicio;
	private String nombreServicio;
	private String detalle;

	public Servicio() {}

	public Servicio(String nombreServicio, String detalle) {
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

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio +
				", nombreServicio=" + nombreServicio +
				", detalle=" + detalle + "]";
	}
}
