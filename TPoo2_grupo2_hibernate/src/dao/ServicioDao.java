package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Servicio;

public class ServicioDao {
	private static Session session;
	private Transaction tx;
	private static ServicioDao instancia = null; // Singleton

	protected ServicioDao() {}
	public static ServicioDao getInstance() {
		if (instancia == null) instancia = new ServicioDao();
		return instancia;
	}

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		if (tx != null) tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public long agregar(Servicio servicio) {
		long id = 0;
		try {
			iniciaOperacion();
			id = (Long) session.save(servicio);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(Servicio servicio) {
		try {
			iniciaOperacion();
			session.update(servicio);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public void eliminar(Servicio servicio) {
		try {
			iniciaOperacion();
			session.delete(servicio);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public Servicio traer(long idServicio) {
		Servicio servicio = null;
		try {
			iniciaOperacion();
			servicio = session.get(Servicio.class, idServicio);
		} finally {
			session.close();
		}
		return servicio;
	}

	public List<Servicio> traer() {
		List<Servicio> lista = new ArrayList<>();
		try {
			iniciaOperacion();
			Query<Servicio> query = session.createQuery("from Servicio s order by s.idServicio asc", Servicio.class);
			lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
}
