package action.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import action.AbstractAction;
import constants.ViewConstants;
import entity.Administrator;
import entity.KorisnickiNalog;
import entity.Korisnik;
import entity.Profesor;
import entity.Student;
import exceptions.DataNotPresent;
import service.AdministratorService;
import service.KorisnickiNalogService;
import service.ProfesorService;
import service.StudentService;
import service.impl.AdministratorServiceImpl;
import service.impl.KorisnickiNalogServiceImpl;
import service.impl.ProfesorServiceImpl;
import service.impl.StudentServiceImpl;
import view.ViewKorisnik;

public class LoginAction extends AbstractAction{
	private final KorisnickiNalogService korisnickiNalogService;
	//U slucaju da nam trebaju specificni podaci o korisniku
	private final AdministratorService administratorService;
	private final ProfesorService profesorService;
	private final StudentService studentService;
	
	public LoginAction(){
		this.korisnickiNalogService = new KorisnickiNalogServiceImpl();
		this.administratorService = new AdministratorServiceImpl();
		this.profesorService = new ProfesorServiceImpl();
		this.studentService = new StudentServiceImpl();
	}
	
	
	@Override
	public String execute(HttpServletRequest request){
		
		String page = ViewConstants.LOGIN;
		String errorMessage = "";
		
		boolean ispavno = false;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String korisnickaUloga = "";
		String ime = "";
		String prezime = "";
		
		List<KorisnickiNalog> nalozi = korisnickiNalogService.getAll();
		for(KorisnickiNalog nalog: nalozi) {
			if(nalog.getUsername().equalsIgnoreCase(username) && nalog.getPassword().equals(password)) {
				korisnickaUloga = nalog.getKorisnickaUloga().toString();
				if(korisnickaUloga.equalsIgnoreCase("administrator")) {
					List<Administrator> administratori = administratorService.getAll();
					for(Administrator administrator: administratori) {
						if(nalog.getId().equals(administrator.getId())) {
							ime = administrator.getIme();
							prezime = administrator.getPrezime();
						}
					}
				}
				if(korisnickaUloga.equalsIgnoreCase("profesor")) {
					List<Profesor> profesori;
					try {
						profesori = profesorService.getAll();
						for(Profesor profesor: profesori) {
							if(nalog.getId().equals(profesor.getId())) {
								ime = profesor.getIme();
								prezime = profesor.getPrezime();
							}
						}
					} catch (DataNotPresent e) {
						e.printStackTrace();
					}
					
				}
				if(korisnickaUloga.equalsIgnoreCase("student")) {
					List<Student> studenti = studentService.getAll();
					for(Student student: studenti) {
						if(nalog.getId().equals(student.getId())) {
							ime = student.getIme();
							prezime = student.getPrezime();
						}
					}
				}
				page = ViewConstants.HOME;//Ovo ispraviti
				
				ViewKorisnik currentUser = new ViewKorisnik(ime, prezime, korisnickaUloga, username, password);
				HttpSession session = request.getSession(true);
				session.setAttribute("currentUser", currentUser);
			}else {
				errorMessage = "Zadati korisnik-sifra ne postoji!";
			}
		}
		request.setAttribute("errorMessage", errorMessage);
		return page;
		
	}
	
}
