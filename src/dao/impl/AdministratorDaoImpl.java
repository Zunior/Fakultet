package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import dao.AdministratorDao;
import entity.Administrator;

public class AdministratorDaoImpl implements AdministratorDao{

	@Override
	public List<Administrator> getAll() {
		EntityManager em = emf.MyEntityManagerFactory.getInstance()
				.getEntityManagerFactory().createEntityManager();
		
		try {
			List<Administrator> administratori = (List<Administrator>) em.createNamedQuery("Administrator.findAll").getResultList();
			return administratori;
		}catch(Exception e) {
			return null;
		}finally {
			em.close();
		}
	}
	
}
