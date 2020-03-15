package action.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import action.AbstractAction;
import constants.ViewConstants;
import entity.Korisnik;

public class LoginAction extends AbstractAction{

	@Override
	public String execute(HttpServletRequest request) {
		List<Korisnik> korisnici = (List<Korisnik>) request.getServletContext().getAttribute("array");
		if(korisnici == null) {
			korisnici = new ArrayList<Korisnik>();
		}
		
		String page = ViewConstants.LOGIN;
		String errorMessage = "Podaci nisu ispravni!";
		
		boolean ispavno = false;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		for (Korisnik korisnik : korisnici) {
			if(korisnik.getKorisnickiNalog().getUsername().equalsIgnoreCase(username) && korisnik.getKorisnickiNalog().getPassword().equals(password)) {
				HttpSession session = request.getSession(true);
				page = ViewConstants.HOME;
				session.setAttribute("currentUser", korisnik);
				ispavno = true;
				break;
			}else {
				
			}
		}
		if (ispavno)	
			request.setAttribute("errorMessage", errorMessage);
	
		return page;
	}
	
}
