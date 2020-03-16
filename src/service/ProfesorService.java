package service;

import java.util.List;

import entity.Department;
import entity.Profesor;

public interface ProfesorService {
	
	public void saveProfesor(Profesor profesor, Department department) throws Exception;
	
	List<Profesor> getAll() throws Exception;
	
	Profesor findByImeAndPrezime(String ime, String prezime) throws Exception;
}
