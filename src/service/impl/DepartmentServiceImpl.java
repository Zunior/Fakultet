package service.impl;

import java.util.List;

import dao.DepartmentDao;
import dao.impl.DepartmentDaoImpl;
import entity.Department;
import exceptions.DataAlreadyPresent;
import service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{
	private final DepartmentDao departmentDao;

	public DepartmentServiceImpl() {
		this.departmentDao = new DepartmentDaoImpl();
	}

	@Override
	public void save(Department department) throws DataAlreadyPresent {
		if(departmentDao.findByNaziv(department.getNaziv()) == null) {
				departmentDao.save(department);
		}else {
			throw new DataAlreadyPresent("Department vec postoji u bazi!");
		}
		
	}

	@Override
	public List<Department> getAll() throws Exception {
		List<Department> listaDepartmenta = departmentDao.getAll();
		if(listaDepartmenta == null) {
			throw new Exception("Ne postoji ni jedan department!");
		}
		return listaDepartmenta;
	}

	@Override
	public Department findByNaziv(String naziv) throws Exception {
		Department department = departmentDao.findByNaziv(naziv);
		if(department == null) {
			throw new Exception("Ne postoji traženi department!");
		}
		return department;
	}
	
	
	
}
