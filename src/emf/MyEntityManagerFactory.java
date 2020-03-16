package emf;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEntityManagerFactory {
	private static MyEntityManagerFactory instance;
	private EntityManagerFactory emf;
	
	private MyEntityManagerFactory() {
		emf = Persistence.createEntityManagerFactory("Fakultet");
	}
	
	public static MyEntityManagerFactory getInstance() {
		if(instance == null)
			instance = new MyEntityManagerFactory();
		return instance;
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
}
