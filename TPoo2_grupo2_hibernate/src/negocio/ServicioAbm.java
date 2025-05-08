package negocio;

import java.util.List;

import dao.ServicioDao;
import datos.Servicio;
import datos.Turno;



public class ServicioAbm {
	private static ServicioAbm instancia = null; //singleton
	protected ServicioAbm() {}
	public static ServicioAbm getInstance() {
		if(instancia == null) instancia = new ServicioAbm();
		return instancia;
	}
	
	public Servicio traer(long idServicio) {
		//trae un servicio a partir de su id
		return ServicioDao.getInstance().traer(idServicio);
	}
	
	
	public long agregarServicio(String nombreServicio, String detalle) throws Exception {
		//agregar servicio por parametros
		
		//Busca si existe algun servicio con el mismo nombre
		for(Servicio s:traer()) {
			if(nombreServicio.equals(s.getNombreServicio())) {
				throw new Exception("Ya existe un servicio con ese nombre:"+nombreServicio);
			}
		
		}
		
		return ServicioDao.getInstance().agregar(new Servicio(nombreServicio,detalle));
	}
	
	public void modificar(Servicio s) throws Exception {
		
		for(Servicio aux:traer()) {
			if(aux.getNombreServicio().equals(s.getNombreServicio())) {
				throw new Exception("El nombre: "+aux.getNombreServicio()+" pertenece al servicio con id: "+aux.getIdServicio());
			}
		}
		
		ServicioDao.getInstance().actualizar(s);
	}
	
	public void eliminar(long idServicio) throws Exception {
		
		Servicio s = ServicioDao.getInstance().traer(idServicio);
		//Comprueba que el servicio a eliminar exista
		if(s == null) {
			throw new Exception("No existe ningun servicio con el id:"+idServicio);
		}
		
		
		//Comprueba que el servicio a eliminar no este en algun turno
		for(Turno t:TurnoAbm.getInstance().traer()) {
			if(idServicio == t.getServicio().getIdServicio()) {
				throw new Exception("El siguiente id de servicio "+ idServicio +" esta asignado al turno "+t.getIdTurno());
			}
			
		}

		ServicioDao.getInstance().eliminar(s);
	}

	public List<Servicio> traer() {
		//Trae la lista de todos los servicios
		return ServicioDao.getInstance().traer();
	}
}
