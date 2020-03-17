package service.impl;

import java.util.List;

import dao.KorisnickiNalogDao;
import dao.impl.KorisnickiNalogDaoImpl;
import dto.KorisnikDTO;
import entity.KorisnickiNalog;
import service.KorisnickiNalogService;

public class KorisnickiNalogServiceImpl implements KorisnickiNalogService{
	private final KorisnickiNalogDao korisnickiNalogDao;
	
	public KorisnickiNalogServiceImpl() {
		this.korisnickiNalogDao = new KorisnickiNalogDaoImpl();
	}

	@Override
	public List<KorisnickiNalog> getAll() {
		return korisnickiNalogDao.getAll();
	}
	

}
