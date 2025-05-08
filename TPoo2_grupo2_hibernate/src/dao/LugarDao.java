package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Lugar;


public class LugarDao {
	private static Session session;
	private Transaction tx;
	private static LugarDao instancia = null; //Singleton
	
	public LugarDao() {}
	public static LugarDao getInstance(){
		if(instancia==null) instancia = new LugarDao();
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
	
	public long agregar(Lugar objeto) {
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
	
	public void actualizar(Lugar objeto) {
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

	public void eliminar(Lugar objeto) {
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
	public Lugar traer(long idLugar) {
		Lugar objeto = null;
		try {
			iniciaOperacion();
			objeto = (Lugar) session.get(Lugar.class, idLugar);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	public List<Lugar> traer() {
		List<Lugar> lista = new ArrayList<Lugar>();
		try {
			iniciaOperacion();
			Query<Lugar> query = session.createQuery("from Lugar l order by l.idLugar asc", Lugar.class);
				lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
}
