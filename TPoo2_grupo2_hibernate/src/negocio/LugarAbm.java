package negocio;

import java.util.List;

import dao.LugarDao;
import datos.Lugar;
import datos.Turno;



public class LugarAbm {
	private static LugarAbm instancia = null; //singleton
	protected LugarAbm() {}
	public static LugarAbm getInstance() {
		if(instancia == null) instancia = new LugarAbm();
		return instancia;
	}
	
	public Lugar traer(long idLugar) {
		//trae un servicio a partir de su id
		return LugarDao.getInstance().traer(idLugar);
	}
	
	
	public long agregarLugar(String calle, String localidad) throws Exception {
		//agregar lugar por parametros
		
		//Busca si existe algun lugar con la misma calle y en la misma localidad
		for(Lugar l:traer()) {
			if(calle.equals(l.getCalle()) && localidad.equals(l.getLocalidad())) {
				throw new Exception("Ya existe un lugar en esa ubicacion:"+calle+", "+ localidad);
			}
		
		}
		
		return LugarDao.getInstance().agregar(new Lugar(calle,localidad));
	}
	
	public void modificar(Lugar l) throws Exception {
		
		for(Lugar aux:traer()) {
			if(aux.getCalle().equals(l.getCalle()) || aux.getLocalidad().equals(l.getLocalidad())) {
				throw new Exception("La direccion: "+l.getCalle()+", "+l.getLocalidad()+" ya le pertenece al lugar con id: "+aux.getIdLugar());
			}
		}
		
		LugarDao.getInstance().actualizar(l);
	}
	
	public void eliminar(long idLugar) throws Exception {
		
		Lugar l = LugarDao.getInstance().traer(idLugar);
		//Comprueba que el lugar a eliminar exista
		if(l == null) {
			throw new Exception("No existe ningun lugar con el id:"+idLugar);
		}
		
		//Comprueba que el lugar a eliminar no este en algun turno
				for(Turno t:TurnoAbm.getInstance().traer()) {
					if(idLugar == t.getLugar().getIdLugar()) {
						throw new Exception("El siguiente id de lugar "+ idLugar +" esta asignado al turno "+t.getIdTurno());
					}
					
				}

		LugarDao.getInstance().eliminar(l);
	}

	public List<Lugar> traer() {
		//Trae la lista de todos los servicios
		return LugarDao.getInstance().traer();
	}
}
