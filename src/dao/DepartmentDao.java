package dao;

import java.util.List;

import entity.Department;
import exceptions.DataAlreadyPresent;

public interface DepartmentDao {
	void save(Department department) throws DataAlreadyPresent;
	
	List<Department> getAll();
	
	Department findByNaziv(String naziv);
}
