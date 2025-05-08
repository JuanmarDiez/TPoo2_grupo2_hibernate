package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import dao.DetalleTurnoDao;
import datos.DetalleTurno;
import datos.Turno;

public class DetalleTurnoAbm {
	private static DetalleTurnoAbm instancia = null; //singleton
	protected DetalleTurnoAbm() {}
	public static DetalleTurnoAbm getInstance() {
		if(instancia == null) instancia = new DetalleTurnoAbm();
		return instancia;
	}
	
	public DetalleTurno traer(long idDetalle) {
		//trae un turno a partir de su id
		return DetalleTurnoDao.getInstance().traer(idDetalle);
	}
	
	public long agregar(String descripcion,LocalDate fecha,LocalTime horaInicio,LocalTime horaFin, Turno turno) throws Exception {
		//agregar turno por parametros
		DetalleTurno detalle = new DetalleTurno(descripcion,fecha,horaInicio, horaFin, turno);
		for(DetalleTurno t:traer()) {
			if((detalle.getFecha() == fecha&& detalle.getHoraInicio()==horaInicio &&detalle.getHoraFin()==horaFin )&& (detalle.getTurno().getCliente().equals(t.getTurno().getCliente()) || detalle.getTurno().getEmpleado().equals(t.getTurno().getEmpleado()) )) {
				TurnoAbm.getInstance().eliminar(turno.getIdTurno());
				throw new Exception("Ya existe un detalle con esas caracteristicas:");
			}
		}

		return DetalleTurnoDao.getInstance().agregar(detalle);
	}
	
	public void modificar(DetalleTurno t) throws Exception {
		
		for(DetalleTurno aux:traer()) {
			if(t.getHoraInicio().equals(aux.getHoraInicio()) && t.getHoraFin().equals(aux.getHoraFin()) && (t.getTurno().getCliente().equals(aux.getTurno().getCliente()) || t.getTurno().getEmpleado().equals(aux.getTurno().getEmpleado()) )) {
				throw new Exception("Ya existe un detalle con esas caracteristicas:");
			}
		}
		
		DetalleTurnoDao.getInstance().actualizar(t);
	}
	
	public void eliminar(long idDetalle) throws Exception {
		
		DetalleTurno t = DetalleTurnoDao.getInstance().traer(idDetalle);
		//Comprueba que el servicio a eliminar exista

		DetalleTurnoDao.getInstance().eliminar(t);
	}

	public List<DetalleTurno> traer() {
		//Trae la lista de todos los turnos
		return DetalleTurnoDao.getInstance().traer();
	}
}
