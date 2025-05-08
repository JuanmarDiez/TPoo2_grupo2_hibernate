package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDao;
import datos.Cliente;
import datos.Empleado;
import datos.Lugar;
import datos.Servicio;
import datos.Turno;
import datos.Usuario;

public class UsuarioAbm {
	private static UsuarioAbm instancia = null; //singleton
	protected UsuarioAbm() {}
	public static UsuarioAbm getInstance() {
		if(instancia == null) instancia = new UsuarioAbm();
		return instancia;
	}
	
	public Usuario traer(long idUsuario) {
		//trae un usuario a partir de su id
		return UsuarioDao.getInstance().traer(idUsuario);
	}	
	
	
	
	public long agregarCliente(String email, String contrasena, String nombre, String apellido, int dni) throws Exception {
		//agregar cliente por parametros
		
		//Busca si existe algun usuario con el mismo dni u email
		for(Usuario u:traer()) {
			if(dni == u.getDni()) {
				throw new Exception("Ya existe un usuario con ese dni:"+dni);
			}
			if (email.equals(u.getEmail())) {
				throw new Exception("Ya existe un usuario con ese email:"+email);
			}
		}
		
		//Añade a una lista todos los usuarios que sean una instancia de cliente
		List<Cliente> aux = new ArrayList<Cliente>();
		for(Usuario u : traer()) {
			if(u instanceof Cliente) {
				Cliente c = (Cliente) u;
				aux.add(c);
			}
		}
		
		//Asigna al cliente su numero de cliente
		int nro = 1;
		if(!aux.isEmpty()) {
			nro=aux.get(aux.size()-1).getNroCliente()+1;
		}
		
		return UsuarioDao.getInstance().agregar(new Cliente(email, contrasena,nombre, apellido,dni,"Cliente",nro));
	}
	
	public long agregarEmpleado(String email, String contrasena, String nombre, String apellido, int dni,LocalDate fechaAlta) throws Exception {
		//agregar empleado por parametros
		
		//Busca si existe algun usuario con el mismo dni u email
		for(Usuario u:traer()) {
			if(dni == u.getDni()) {
				throw new Exception("Ya existe un usuario con ese dni:"+dni);
			}
			if (email.equals(u.getEmail())) {
				throw new Exception("Ya existe un usuario con ese email:"+email);
			}
		}
		
		//Añade a una lista todos los usuarios que sean una instancia de empleado
		List<Empleado> aux = new ArrayList<Empleado>();
		for(Usuario u : traer()) {
			if(u instanceof Empleado) {
				Empleado e = (Empleado) u;
				aux.add(e);
			}
		}
		
		//Asigna al empleado su numero de legajo
		int nro = 1;
		if(!aux.isEmpty()) {
			nro=aux.get(aux.size()-1).getLegajo()+1;
		}
		
		return UsuarioDao.getInstance().agregar(new Empleado(email, contrasena,nombre, apellido,dni,"Empleado",nro,fechaAlta,true));
	}
	
	public void modificar(Usuario u) throws Exception {
		
		for(Usuario aux:traer()) {
			if(aux.getDni() == u.getDni()) {
				throw new Exception("El dni: "+u.getDni()+" pertenece al usuario con id: "+aux.getIdUsuario());
			}
		}
		
		UsuarioDao.getInstance().actualizar(u);
		}
	
	public void eliminar(long idUsuario) throws Exception {
		
		Usuario u = UsuarioDao.getInstance().traer(idUsuario);
		//Comprueba que el usuario a eliminar exista
		if(u == null) {
			throw new Exception("No existe ningun usuario con el id:"+idUsuario);
		}
		
		//Comprueba que el usuario a eliminar no este asignado a un turno
		for(Turno t:TurnoAbm.getInstance().traer()) {
			if(idUsuario == t.getCliente().getIdUsuario()) {
				throw new Exception("El siguiente id de cliente "+ idUsuario +" esta asignado al turno "+t.getIdTurno());
			}
			else if(idUsuario == t.getEmpleado().getIdUsuario()) {
				throw new Exception("El siguiente id de empleado "+ idUsuario +" esta asignado al turno "+t.getIdTurno());
			}
		}
		
		UsuarioDao.getInstance().eliminar(u);
	}

	public List<Usuario> traer() {
		//Trae la lista de todos los usuarios
		return UsuarioDao.getInstance().traer();
	}
	
	
	
	//consulta por atributo de tipo subClase
	public void verTurnos(int nroCliente){
		UsuarioDao.getInstance().verTurnos(nroCliente);

	}

	//consulta por atributo de tipo subClase
	public List<Turno> traerTurnos(Empleado e){
		return UsuarioDao.getInstance().traerTurnos(e);
	}

	//consulta por atributo de tipo subClase
	public List<Turno> traerTurnos(Cliente c){
		return UsuarioDao.getInstance().traerTurnos(c);
	}

	//Consulta por atributo de tipo subClase
	public Cliente traerCliente(int nroCliente) {
		//trae un cliente a partir de su nro
		return UsuarioDao.getInstance().traerCliente(nroCliente);
	}

	//Consulta por atributo de tipo subClase
	public Empleado traerEmpleado(int legajo) {
		//traer empleado a partir de su legajo
		return UsuarioDao.getInstance().traerEmpleado(legajo);
	}

	
	
	//consulta por atributo de tipo Clase
	public List<Turno> traerTurnos(Servicio s){
		return UsuarioDao.getInstance().traerTurnos(s);
	}

	//consulta por atributo de tipo Clase
	public List<Turno> traerTurnos(Lugar l){
		return UsuarioDao.getInstance().traerTurnos(l);
	}
		
		
	
	//consulta por atributo de Clase
	public List<Turno> traerTurnosLugar(int nroCliente,long idLugar){
		return UsuarioDao.getInstance().traerTurnosLugar(nroCliente,idLugar);
	}
	
	//Consulta por atributo de Clase
	public List<Turno> traerTurnosServicio(int nroCliente,long idServicio){
		return UsuarioDao.getInstance().traerTurnosServicio(nroCliente,idServicio);
	}
	
	//Consulta por intervalo de fecha
	public List<Turno> traerTurnos(LocalDate fechaInicio,LocalDate fechaFin) {
		return UsuarioDao.getInstance().traerTurnos(fechaInicio,fechaFin);
	}
	
	//Consulta por intervalo de fechas
	public List<Turno> traerTurnos(LocalDate fechaInicio,LocalDate fechaFin,Servicio s) {
		return UsuarioDao.getInstance().traerTurnos(fechaInicio,fechaFin,s);
	}
	//Consulta por intervalo de fechas
	public List<Turno> traerTurnos(LocalDate fechaInicio,LocalDate fechaFin,Lugar l) {
		return UsuarioDao.getInstance().traerTurnos(fechaInicio,fechaFin,l);
	}
	
	//Consulta por intervalo de fechas
	public List<Turno> traerTurnos(LocalDate fechaInicio,LocalDate fechaFin,Empleado e) {
		return UsuarioDao.getInstance().traerTurnos(fechaInicio,fechaFin,e);
	}

	//Consulta por intervalo de fechas
	public List<Turno> traerTurnos(LocalDate fechaInicio,LocalDate fechaFin,Cliente c) {
		return UsuarioDao.getInstance().traerTurnos(fechaInicio,fechaFin,c);
	}
	
	//Consulta por fecha y atributo
	public List<Turno> traerTurnos(LocalDate fecha, Cliente c){
		return UsuarioDao.getInstance().traerTurnos(fecha,c);
	}

	//Consulta por fecha y atributo
	public List<Turno> traerTurnos(LocalDate fecha, Empleado e){
		return UsuarioDao.getInstance().traerTurnos(fecha,e);
	}

	//Consulta por fecha y atributo
	public List<Turno> traerTurnos(LocalDate fecha, Servicio s){
		return UsuarioDao.getInstance().traerTurnos(fecha,s);
	}

	//Consulta por fecha y atributo
	public List<Turno> traerTurnos(LocalDate fecha, Lugar l){
		return UsuarioDao.getInstance().traerTurnos(fecha,l);
	}

}
