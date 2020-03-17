package service.impl;

import java.util.List;

import dao.AdministratorDao;
import dao.impl.AdministratorDaoImpl;
import entity.Administrator;
import service.AdministratorService;

public class AdministratorServiceImpl implements AdministratorService{
	private final AdministratorDao administratorDao;
	
	public AdministratorServiceImpl() {
		this.administratorDao = new AdministratorDaoImpl();
	}
	
	@Override
	public List<Administrator> getAll() {
		return administratorDao.getAll();
	}
	
}
