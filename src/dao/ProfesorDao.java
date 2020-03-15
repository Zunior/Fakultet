package dao;

import java.util.List;

import entity.Department;
import entity.Profesor;

public interface ProfesorDao {
	void save(Profesor profesor);
	
	List<Profesor> getAll();
	List<Profesor> findByImePrezime(String ime, String prezime);
}
