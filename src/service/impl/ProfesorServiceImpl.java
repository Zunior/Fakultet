package service.impl;

import java.util.List;

import dao.ProfesorDao;
import dao.impl.ProfesorDaoImpl;
import entity.Department;
import entity.Profesor;
import service.ProfesorService;

public class ProfesorServiceImpl implements ProfesorService{
	private final ProfesorDao profesorDao;
	
	public ProfesorServiceImpl() {
		profesorDao = new ProfesorDaoImpl();
	}
	
	@Override
	public void save(Profesor profesor, Department department) throws Exception {
		
		
	}

	@Override
	public List<Profesor> getAll() throws Exception {
		List<Profesor> profesori = profesorDao.getAll();
		if(profesori == null)
			throw new Exception("Ne postoji ni jedan profesor");
		else
			return profesori;
	}

	@Override
	public Profesor findByImeAndPrezime(String ime, String prezime) throws Exception {
		List<Profesor> profesori = profesorDao.findByImePrezime(ime, prezime);
		if(profesori == null)
			throw new Exception("Ne postoji ni jedan profesor u bazi!");
		else if(profesori.get(1) != null)
			throw new Exception("U bazi postoji više profesora pod zadatim podacima");
		else
			return profesori.get(0);
	}

}
