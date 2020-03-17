package main;

import java.util.ArrayList;
import java.util.List;

import dto.KorisnikDTO;
import entity.Department;
import exceptions.DataAlreadyPresent;
import service.DepartmentService;
import service.KorisnickiNalogService;
import service.impl.DepartmentServiceImpl;
import service.impl.KorisnickiNalogServiceImpl;

public class Proba {

	public static void main(String[] args) {
		DepartmentService depServis = new DepartmentServiceImpl();
		KorisnickiNalogService knServis = new KorisnickiNalogServiceImpl();
		
		
		
//			try {
//				depServis.save(new Department("Mehanika"));
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
		
//		Department department = null;
//		try {
//			department = depServis.findByNaziv("Automatizacija");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(department);
		
//		List<Department> lista = null;
//		try {
//			lista = depServis.getAll();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		lista.forEach(System.out::println);
		
//		List<KorisnikDTO> korisnici = new ArrayList<KorisnikDTO>();
//		korisnici = knServis.returnAll();
//		System.out.println(korisnici.get(0));
	}

}
