package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDao;
import datos.Cliente;
import datos.Usuario;

public class UsuarioAbm {
	private static UsuarioAbm instancia = null; //singleton
	protected UsuarioAbm() {}
	public static UsuarioAbm getInstance() {
		if(instancia == null) instancia = new UsuarioAbm();
		return instancia;
	}
	
	public Usuario traer(long idUsuario) {
		return UsuarioDao.getInstance().traer(idUsuario);
	}
	
	
	public long agregarCliente(String email, String contrasena, String nombre, String apellido, int dni) throws Exception {
		
		for(Usuario u:traer()) {
			if(dni == u.getDni()) {
				throw new Exception("Ya existe un cliente con ese dni:"+dni);
			}
			if (email.equals(u.getEmail())) {
				throw new Exception("Ya existe un cliente con ese email:"+email);
			}
		}
		
		List<Cliente> aux = new ArrayList<Cliente>();
		for(Usuario u : traer()) {
			if(u instanceof Cliente) {
				Cliente c = (Cliente) u;
				aux.add(c);
			}
		}
		int nro = 1;
		if(!aux.isEmpty()) {
			nro=aux.get(aux.size()-1).getNroCliente()+1;
		}
		return UsuarioDao.getInstance().agregar(new Cliente(email, contrasena,nombre, apellido,dni,nro));
	}
	
	public void eliminar(long idUsuario) throws Exception {
		//Una vez hecho la clase turnos hay que implementar no poder borrar el cliente o empleado si tiene un turno
		Usuario u = UsuarioDao.getInstance().traer(idUsuario);
		if(u == null) {
			throw new Exception("No existe ningun usuario con el id:"+idUsuario);
		}

		UsuarioDao.getInstance().eliminar(u);
	}

	public List<Usuario> traer() {
		return UsuarioDao.getInstance().traer();
	}

}
