package service;

import java.util.List;

import entity.Department;
import entity.Profesor;
import exceptions.DataNotPresent;

public interface ProfesorService {
	
	public void saveProfesor(Profesor profesor, Department department) throws Exception;
	
	List<Profesor> getAll() throws DataNotPresent;
	
	Profesor findByImeAndPrezime(String ime, String prezime) throws Exception;
}
