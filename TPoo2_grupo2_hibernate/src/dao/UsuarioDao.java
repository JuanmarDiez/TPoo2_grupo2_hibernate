package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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


}
