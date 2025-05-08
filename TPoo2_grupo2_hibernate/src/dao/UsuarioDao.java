package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Cliente;
import datos.Empleado;
import datos.Lugar;
import datos.Servicio;
import datos.Turno;
import datos.Usuario;

public class UsuarioDao {
	private static Session session;
	private Transaction tx;
	private static UsuarioDao instancia = null; //Singleton
	
	protected UsuarioDao() {}
	public static UsuarioDao getInstance(){
		if(instancia==null) instancia = new UsuarioDao();
		return instancia;
	}
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public long agregar(Usuario objeto) {
		long id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}
	
	public void actualizar(Usuario objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public void eliminar(Usuario objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}
	public Usuario traer(long idUsuario) {
		Usuario objeto = null;
		try {
			iniciaOperacion();
			objeto = (Usuario) session.get(Usuario.class, idUsuario);
		} finally {
			session.close();
			
		}
		return objeto;
	}
	
	public Cliente traerCliente(int nroCliente) {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.createQuery("from Cliente c where c.nroCliente =:nroCliente").setParameter("nroCliente", nroCliente).uniqueResult();
		} finally {
			session.close();
			
		}
		return objeto;
	}
	
	public Empleado traerEmpleado(int legajo) {
		Empleado objeto = null;
		try {
			iniciaOperacion();
			objeto = (Empleado) session.createQuery("from Empleado e where e.legajo =:legajo").setParameter("legajo", legajo).uniqueResult();
		} finally {
			session.close();
			
		}
		return objeto;
	}
	
	
	public List<Usuario> traer() {
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			iniciaOperacion();
			Query<Usuario> query = session.createQuery("from Usuario u order by u.idUsuario asc", Usuario.class);
				lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public void verTurnos(int nroCliente) {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Turno t inner join fetch t.cliente c where c.nroCliente =:nroCliente",Turno.class).setParameter("nroCliente", nroCliente).getResultList();
			
			for(Turno t:lista) {
				System.out.println(t.toString());
			}
			
		} finally {
			session.close();
		}
		
	}
	
	public List<Turno> traerTurnos(Empleado e) {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Turno t inner join fetch t.empleado e where e.legajo =:legajo",Turno.class).setParameter("legajo", e.getLegajo()).getResultList();
			
			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Turno> traerTurnos(Cliente c) {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Turno t inner join fetch t.cliente c where c.nroCliente =:nroCliente",Turno.class).setParameter("nroCliente", c.getNroCliente()).getResultList();
			
			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Turno> traerTurnos(Servicio s) {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Turno t inner join fetch t.servicio s where s.idServicio =:idServicio",Turno.class).setParameter("idServicio", s.getIdServicio()).getResultList();
			
			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Turno> traerTurnos(Lugar l) {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Turno t inner join fetch t.lugar l where l.idLugar =:idLugar",Turno.class).setParameter("idLugar", l.getIdLugar()).getResultList();
			
			
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Turno> traerTurnosLugar(int nroCliente,long idLugar) {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Turno t inner join fetch t.cliente c where c.nroCliente =:nroCliente AND t.lugar.idLugar =:idLugar ",Turno.class).setParameter("nroCliente", nroCliente).setParameter("idLugar", idLugar).getResultList();
			
			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Turno> traerTurnosServicio(int nroCliente,long idServicio) {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Turno t inner join fetch t.cliente c where c.nroCliente =:nroCliente AND t.servicio.idServicio =:idServicio ",Turno.class).setParameter("nroCliente", nroCliente).setParameter("idServicio", idServicio).getResultList();
			
			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Turno> traerTurnos(LocalDate fechaInicio,LocalDate fechaFin) {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Turno t inner join fetch t.detalle d where d.fecha >=:fechaInicio AND d.fecha <=:fechaFin",Turno.class).setParameter("fechaInicio", fechaInicio).setParameter("fechaFin", fechaFin).getResultList();

			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Turno> traerTurnos(LocalDate fechaInicio,LocalDate fechaFin,Servicio s) {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Turno t inner join fetch t.detalle d where d.fecha >=:fechaInicio AND d.fecha <=:fechaFin AND t.servicio.idServicio =:idServicio",Turno.class).setParameter("fechaInicio", fechaInicio).setParameter("fechaFin", fechaFin).setParameter("idServicio",s.getIdServicio()).getResultList();

			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Turno> traerTurnos(LocalDate fechaInicio,LocalDate fechaFin, Lugar l) {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Turno t inner join fetch t.detalle d where d.fecha >=:fechaInicio AND d.fecha <=:fechaFin AND t.lugar.idLugar =:idLugar",Turno.class).setParameter("fechaInicio", fechaInicio).setParameter("fechaFin", fechaFin).setParameter("idLugar", l.getIdLugar()).getResultList();

			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Turno> traerTurnos(LocalDate fechaInicio,LocalDate fechaFin, Empleado e) {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Turno t inner join fetch t.detalle d where d.fecha >=:fechaInicio AND d.fecha <=:fechaFin AND t.empleado.idUsuario =:idUsuario",Turno.class).setParameter("fechaInicio", fechaInicio).setParameter("fechaFin", fechaFin).setParameter("idUsuario", e.getIdUsuario()).getResultList();

			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Turno> traerTurnos(LocalDate fechaInicio,LocalDate fechaFin, Cliente c) {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Turno t inner join fetch t.detalle d where d.fecha >=:fechaInicio AND d.fecha <=:fechaFin AND t.cliente.idUsuario =:idUsuario",Turno.class).setParameter("fechaInicio", fechaInicio).setParameter("fechaFin", fechaFin).setParameter("idUsuario",c.getIdUsuario()).getResultList();

			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Turno> traerTurnos(LocalDate fecha, Cliente c) {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Turno t inner join fetch t.detalle d where d.fecha =:fecha AND t.cliente.idUsuario =:idUsuario",Turno.class).setParameter("fecha", fecha).setParameter("idUsuario",c.getIdUsuario()).getResultList();

			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Turno> traerTurnos(LocalDate fecha, Empleado e) {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Turno t inner join fetch t.detalle d where d.fecha =:fecha AND t.empleado.idUsuario =:idUsuario",Turno.class).setParameter("fecha", fecha).setParameter("idUsuario",e.getIdUsuario()).getResultList();

			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Turno> traerTurnos(LocalDate fecha,Lugar l) {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Turno t inner join fetch t.detalle d where d.fecha =:fecha AND t.lugar.idLugar =:idLugar",Turno.class).setParameter("fecha", fecha).setParameter("idLugar",l.getIdLugar()).getResultList();

			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Turno> traerTurnos(LocalDate fecha,Servicio s) {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Turno t inner join fetch t.detalle d where d.fecha =:fecha AND t.servicio.idServicio =:idServicio",Turno.class).setParameter("fecha", fecha).setParameter("idServicio",s.getIdServicio()).getResultList();

			
		} finally {
			session.close();
		}
		return lista;
	}

}
