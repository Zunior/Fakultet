package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import dao.StudentDao;
import entity.Student;

public class StudentDaoImpl implements StudentDao{

	@Override
	public List<Student> getAll() {
		EntityManager em = emf.MyEntityManagerFactory.getInstance()
				.getEntityManagerFactory().createEntityManager();
		try {
			List<Student> studenti = (List<Student>) em.createNamedQuery("Student.findAll").getResultList();
			return studenti;
		}catch(Exception e) {
			return null;
		}finally {
			em.close();
		}
	}
	
}
