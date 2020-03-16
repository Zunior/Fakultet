package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.DepartmentDao;
import entity.Department;
import exceptions.DataAlreadyPresent;

public class DepartmentDaoImpl implements DepartmentDao{

	@Override
	public void save(Department department) throws DataAlreadyPresent {
		EntityManager em = emf.MyEntityManagerFactory.getInstance()
				.getEntityManagerFactory().createEntityManager();
		
//		try {
			em.getTransaction().begin();
			em.persist(department);
			em.getTransaction().commit();
//		}catch(Exception e) {
//			if(em.getTransaction().isActive()) {
//				em.getTransaction().rollback();
//			}
//			throw new DataAlreadyPresent("Zadato odeljenje vec postoji!");
//		}finally {
			em.close();
//		}
		
	}

	@Override
	public List<Department> getAll() {
		EntityManager em = emf.MyEntityManagerFactory.getInstance()
				.getEntityManagerFactory().createEntityManager();
		try {
			@SuppressWarnings("unchecked")
			List<Department> odeljenja = (List<Department>) em.createNamedQuery("Department.findAll")
					.getResultList();
			return odeljenja;
		}catch(Exception e) {
			return null;
		}finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Department findByNaziv(String naziv) {
		EntityManager em = emf.MyEntityManagerFactory.getInstance()
				.getEntityManagerFactory().createEntityManager();
		
		try {
			Department department = (Department) em.createNamedQuery("Department.findNaziv").setParameter("naziv", naziv).getSingleResult();
			return department;
		}catch(Exception e) {
			return null;
		}finally {
			em.close();
		}
	}
	
}
