package negocio;

//import java.time.LocalDate;
///import java.time.LocalTime;
import java.util.List;

import dao.TurnoDao;
import datos.Cliente;
import datos.Empleado;
import datos.Lugar;
import datos.Servicio;
import datos.DetalleTurno;
import datos.Turno;

public class TurnoAbm {
	private static TurnoAbm instancia = null;

	protected TurnoAbm() {}

	public static TurnoAbm getInstance() {
		if (instancia == null) instancia = new TurnoAbm();
		return instancia;
	}

	public Turno traer(long idTurno) {
		return TurnoDao.getInstance().traer(idTurno);
	}

	public List<Turno> traer() {
		return TurnoDao.getInstance().traer();
	}

	public long agregar(Cliente cliente, Empleado empleado, Lugar lugar, Servicio servicio, DetalleTurno detalle)
			throws Exception {

		// Validaciones básicas (podés expandirlas según necesidad)
		if (cliente == null || empleado == null || lugar == null || servicio == null || detalle == null) {
			throw new Exception("Faltan datos obligatorios para crear el turno.");
		}

		Turno turno = new Turno(cliente, empleado, lugar, servicio, detalle);
		return TurnoDao.getInstance().agregar(turno);
	}

	public void eliminar(long idTurno) throws Exception {
		Turno turno = TurnoDao.getInstance().traer(idTurno);
		if (turno == null) {
			throw new Exception("No existe ningún turno con el ID: " + idTurno);
		}

		TurnoDao.getInstance().eliminar(turno);
	}

	public void modificar(Turno turno) throws Exception {
		// Se puede agregar validación aquí también si es necesario
		TurnoDao.getInstance().actualizar(turno);
	}
}
