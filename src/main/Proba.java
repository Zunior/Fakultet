package main;

import java.util.List;

import entity.Department;
import exceptions.DataAlreadyPresent;
import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

public class Proba {

	public static void main(String[] args) {
		DepartmentService depServis = new DepartmentServiceImpl();
		
//			try {
//				depServis.save(new Department("Mehanika"));
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
		
		Department department = null;
		try {
			department = depServis.findByNaziv("Automatizacija");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(department);
		
//		List<Department> lista = null;
//		try {
//			lista = depServis.getAll();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		lista.forEach(System.out::println);
	}

}
