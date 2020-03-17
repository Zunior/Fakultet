package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import dao.KorisnickiNalogDao;
import dto.KorisnikDTO;
import entity.KorisnickiNalog;

public class KorisnickiNalogDaoImpl implements KorisnickiNalogDao{
	
	public List<KorisnickiNalog> getAll(){
		EntityManager em = emf.MyEntityManagerFactory.getInstance()
				.getEntityManagerFactory().createEntityManager();
		
		try {
			@SuppressWarnings("unchecked")
			List<KorisnickiNalog> korisnici = (List<KorisnickiNalog>) em.createNamedQuery("KorisnickiNalog.findAll")
					.getResultList();
			return korisnici;
		}catch(Exception e) {
			return null;
		}finally {
			em.close();
		}
		
	}
	
	
	
	
	
	
	
	
	//proba
	@Override
	public List<KorisnikDTO> returnAll() {
		EntityManager em = emf.MyEntityManagerFactory.getInstance()
				.getEntityManagerFactory().createEntityManager();
		
		
		String sqlSelect = "SELECT ";
		String sqlAttributes = "kn.id, kn.username, kn.password, a.id, p.id, s.id";
		String sqlFrom = "			\"FROM KorisnickiNalog KN\r\n" + 
				"					\"LEFT JOIN Administrator A ON A.KORISNICKI_NALOG_ID = KN.KORISNICKI_NALOG_ID\r\n" + 
				"					\"LEFT JOIN Profesor P ON P.KORISNICKI_NALOG_ID = KN.KORISNICKI_NALOG_ID\r\n" + 
				"					\"LEFT JOIN Student S ON S.KORISNICKI_NALOG_ID = KN.KORISNICKI_NALOG_ID\r\n" + 
				"					\"UNION ALL\r\n" + 
				"					\"SELECT kn.id, kn.username, kn.password, a.id, p.id, s.id\r\n" + 
				"					\"FROM Administrator A\\r\\n\" + \r\n" + 
				"					\"LEFT JOIN KorisnickiNalog KN ON A.KORISNICKI_NALOG_ID = KN.KORISNICKI_NALOG_ID\r\n" + 
				"					\"LEFT JOIN Profesor P ON P.KORISNICKI_NALOG_ID = A.KORISNICKI_NALOG_ID\r\n" + 
				"					\"LEFT JOIN Student S ON S.KORISNICKI_NALOG_ID = A.KORISNICKI_NALOG_ID\r\n" + 
				"					\"WHERE kn.id IS NULL AND kn.username IS NULL AND kn.password IS NULL\r\n" + 
				"					\"UNION ALL\r\n" + 
				"					\"SELECT kn.id, kn.username, kn.password, a.id, p.id, s.id\r\n" + 
				"					\"FROM Profesor P\r\n" + 
				"					\"LEFT JOIN KorisnickiNalog KN ON P.KORISNICKI_NALOG_ID = KN.KORISNICKI_NALOG_ID\r\n" + 
				"					\"LEFT JOIN Administrator A ON P.KORISNICKI_NALOG_ID = A.KORISNICKI_NALOG_ID\r\n" + 
				"					\"LEFT JOIN Student S ON P.KORISNICKI_NALOG_ID = S.KORISNICKI_NALOG_ID\r\n" + 
				"					\"WHERE kn.id IS NULL AND kn.username IS NULL AND kn.password IS NULL AND a.id IS NULL\r\n" + 
				"					\"UNION ALL\r\n" + 
				"					\"SELECT kn.id, kn.username, kn.password, a.id, p.id, s.id\r\n" + 
				"					\"FROM Student S\r\n" + 
				"					\"LEFT JOIN KorisnickiNalog KN ON S.KORISNICKI_NALOG_ID = KN.KORISNICKI_NALOG_ID\r\n" + 
				"					\"LEFT JOIN Administrator A ON S.KORISNICKI_NALOG_ID = A.KORISNICKI_NALOG_ID\r\n" + 
				"					\"LEFT JOIN Profesor P ON S.KORISNICKI_NALOG_ID = P.KORISNICKI_NALOG_ID\r\n" + 
				"					\"WHERE kn.id IS NULL AND kn.username IS NULL AND kn.password IS NULL AND a.id IS NULL AND p.id IS NULL";
		
		try {
		List<KorisnikDTO> korisnici = em.createQuery(
			    "select new dto.KorisnikDTO(" +
			    		sqlAttributes +
			    		") " +
			    		sqlFrom
			    , KorisnikDTO.class).getResultList();
			return korisnici;
		}catch(Exception e) {
			return null;
		}finally {
			em.close();
		}
			
	}

}
