package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.DetalleTurno;


public class DetalleTurnoDao {
	private static Session session;
	private Transaction tx;
	private static DetalleTurnoDao instancia = null; //Singleton
	
	public DetalleTurnoDao() {}
	public static DetalleTurnoDao getInstance(){
		if(instancia==null) instancia = new DetalleTurnoDao();
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
	
	public long agregar(DetalleTurno objeto) {
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
	
	public void actualizar(DetalleTurno objeto) {
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

	public void eliminar(DetalleTurno objeto) {
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
	public DetalleTurno traer(long idDetalle) {
		DetalleTurno objeto = null;
		try {
			iniciaOperacion();
			objeto = (DetalleTurno) session.get(DetalleTurno.class, idDetalle);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	public List<DetalleTurno> traer() {
		List<DetalleTurno> lista = new ArrayList<DetalleTurno>();
		try {
			iniciaOperacion();
			Query<DetalleTurno> query = session.createQuery("from DetalleTurno dt order by dt.idDetalle asc", DetalleTurno.class);
				lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
}
