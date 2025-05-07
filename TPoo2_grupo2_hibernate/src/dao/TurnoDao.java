package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Turno;

public class TurnoDao {
	private static Session session;
	private Transaction tx;
	private static TurnoDao instancia = null; // Singleton

	protected TurnoDao() {}

	public static TurnoDao getInstance() {
		if (instancia == null) instancia = new TurnoDao();
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

	public long agregar(Turno objeto) {
		long id = 0;
		try {
			iniciaOperacion();
			id = Long.parseLong(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(Turno objeto) {
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

	public void eliminar(Turno objeto) {
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

	public Turno traer(long idTurno) {
		Turno objeto = null;
		try {
			iniciaOperacion();
			objeto = session.get(Turno.class, idTurno);
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Turno> traer() {
		List<Turno> lista = new ArrayList<Turno>();
		try {
			iniciaOperacion();
			Query<Turno> query = session.createQuery("from Turno t order by t.idTurno asc", Turno.class);
			lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
}
