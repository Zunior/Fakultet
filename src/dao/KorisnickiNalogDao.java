package dao;

import java.util.List;

import dto.KorisnikDTO;
import entity.KorisnickiNalog;
import entity.Korisnik;

public interface KorisnickiNalogDao {
	List<KorisnickiNalog> getAll();

	//probni
	List<KorisnikDTO> returnAll();
}
