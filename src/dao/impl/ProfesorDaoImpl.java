package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import dao.ProfesorDao;
import entity.Department;
import entity.Profesor;

public class ProfesorDaoImpl implements ProfesorDao{

//	@Override
//	public void save(Profesor profesor) {
//		EntityManager em = emf.MyEntityManagerFactory.getInstance()
//				.getEntityManagerFactory().createEntityManager();
//		
//		em.getTransaction().begin();
//		em.persist(profesor);
//		em.getTransaction().commit();
//		em.close();
//		
//	}

	@Override
	public List<Profesor> getAll() {
		EntityManager em = emf.MyEntityManagerFactory.getInstance()
				.getEntityManagerFactory().createEntityManager();
		try {
			@SuppressWarnings("unchecked")
			List<Profesor> profesori = (List<Profesor>) em.createNamedQuery("Profesor.findAll")
					.getResultList();
			return profesori;
		}catch(Exception e) {
			return null;
		}finally {
			em.close();
		}
	}

	@Override
	public List<Profesor> findByImePrezime(String ime, String prezime) {
		EntityManager em = emf.MyEntityManagerFactory.getInstance()
				.getEntityManagerFactory().createEntityManager();
		
		try {
			@SuppressWarnings("unchecked")
			List<Profesor> profesori = (List<Profesor>) em.createNamedQuery("Profesor.findImePrezime")
					.setParameter("ime", ime)
					.setParameter("prezime", prezime)
					.getResultList();
			return profesori;
		}catch(Exception e) {
			return null;
		}finally {
			em.close();
		}
	}
	
}
