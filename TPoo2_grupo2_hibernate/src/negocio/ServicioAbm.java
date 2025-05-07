package negocio;

import java.util.List;

import dao.ServicioDao;
import datos.Servicio;

public class ServicioAbm {
	private static ServicioAbm instancia = null;

	protected ServicioAbm() {}

	public static ServicioAbm getInstance() {
		if (instancia == null) instancia = new ServicioAbm();
		return instancia;
	}

	public Servicio traer(long idServicio) {
		return ServicioDao.getInstance().traer(idServicio);
	}

	public List<Servicio> traer() {
		return ServicioDao.getInstance().traer();
	}

	public long agregar(String nombreServicio, String detalle) throws Exception {
		// Se podría validar si ya existe un servicio con el mismo nombre
		for (Servicio s : traer()) {
			if (s.getNombreServicio().equalsIgnoreCase(nombreServicio)) {
				throw new Exception("Ya existe un servicio con el nombre: " + nombreServicio);
			}
		}
		Servicio servicio = new Servicio(nombreServicio, detalle);
		return ServicioDao.getInstance().agregar(servicio);
	}

	public void actualizar(Servicio servicio) throws Exception {
		if (traer(servicio.getIdServicio()) == null) {
			throw new Exception("No existe el servicio con id: " + servicio.getIdServicio());
		}
		ServicioDao.getInstance().actualizar(servicio);
	}

	public void eliminar(long idServicio) throws Exception {
		Servicio servicio = traer(idServicio);
		if (servicio == null) {
			throw new Exception("No existe el servicio con id: " + idServicio);
		}
		ServicioDao.getInstance().eliminar(servicio);
	}
}
