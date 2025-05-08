package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import dao.TurnoDao;
import datos.Cliente;
import datos.DetalleTurno;
import datos.Empleado;
import datos.Turno;



public class TurnoAbm {
	private static TurnoAbm instancia = null; //singleton
	protected TurnoAbm() {}
	public static TurnoAbm getInstance() {
		if(instancia == null) instancia = new TurnoAbm();
		return instancia;
	}
	
	public Turno traer(long idTurno) {
		//trae un turno a partir de su id
		return TurnoDao.getInstance().traer(idTurno);
	}
		
	
	public long agregar(long cliente, long empleado, long lugar, long servicio,DetalleTurno detalle) throws Exception {
		
		

		return TurnoDao.getInstance().agregar(new Turno((Cliente) UsuarioAbm.getInstance().traer(cliente),(Empleado) UsuarioAbm.getInstance().traer(empleado),LugarAbm.getInstance().traer(lugar),ServicioAbm.getInstance().traer(servicio),detalle));
	}
	
	public void agregarTurnoYDetalle(long cliente, long empleado, long lugar, long servicio, String descripcion,LocalDate fecha,LocalTime horaInicio,LocalTime horaFin) {
		try {
			TurnoAbm.getInstance().agregar(cliente, empleado, lugar, servicio, null);
			
			List<Turno> aux = traer();
			
			DetalleTurnoAbm.getInstance().agregar(descripcion, fecha, horaInicio, horaFin, aux.get(aux.size()-1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modificar(Turno t) throws Exception {
		if (t.getCliente() == null || t.getEmpleado() == null || t.getLugar() == null || t.getServicio() == null || t.getDetalle() == null) {
			throw new Exception("Faltan datos obligatorios para crear el turno.");
		}
		TurnoDao.getInstance().actualizar(t);
	}
	
	public void eliminar(long idTurno) throws Exception {
		
		Turno t = TurnoDao.getInstance().traer(idTurno);
		//Comprueba que el servicio a eliminar exista
		if(t == null) {
			throw new Exception("No existe ningun turno con el id:"+idTurno);
		}

		TurnoDao.getInstance().eliminar(t);
	}
	
	public void eliminarTurnoYDetalle(long id) {
		try {
			DetalleTurnoAbm.getInstance().eliminar(id);
			TurnoAbm.getInstance().eliminar(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Turno> traer() {
		//Trae la lista de todos los turnos
		return TurnoDao.getInstance().traer();
	}
	
	public void mostrarListaTurnos(List<Turno> lista) {
		TurnoDao.getInstance().mostrarListaTurnos(lista);
	}
	
}
