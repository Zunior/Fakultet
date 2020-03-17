package service.impl;

import java.util.List;

import dao.DepartmentDao;
import dao.ProfesorDao;
import dao.impl.DepartmentDaoImpl;
import dao.impl.ProfesorDaoImpl;
import entity.Department;
import entity.Profesor;
import exceptions.DataAlreadyPresent;
import exceptions.DataNotPresent;
import service.ProfesorService;

public class ProfesorServiceImpl implements ProfesorService{
	private final ProfesorDao profesorDao;
	
	public ProfesorServiceImpl() {
		profesorDao = new ProfesorDaoImpl();
	}
	
	@Override
	public void saveProfesor(Profesor profesor, Department department) throws DataAlreadyPresent, DataNotPresent {
		DepartmentDao departmentDao = new DepartmentDaoImpl();
		
		if(departmentDao.findByNaziv(department.getNaziv()) != null) {
			if(profesorDao.findByImePrezime(profesor.getIme(), profesor.getPrezime()) == null) {
				departmentDao.saveProfesor(department, profesor);
			}else {
				throw new DataAlreadyPresent("Zadati profesor vec postoji u bazi!");
			}
		}else {
			throw new DataNotPresent("Navedeni department ne postoji u bazi");
		}
				
		
	}

	@Override
	public List<Profesor> getAll() throws DataNotPresent {
		List<Profesor> profesori = profesorDao.getAll();
		if(profesori == null)
			throw new DataNotPresent("Ne postoji ni jedan profesor");
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
