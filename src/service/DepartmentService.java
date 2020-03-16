package service;

import java.util.List;

import entity.Department;

public interface DepartmentService {
	
	public void save(Department department) throws Exception;
	
	List<Department> getAll() throws Exception;
	
	Department findByNaziv(String naziv) throws Exception;
}
