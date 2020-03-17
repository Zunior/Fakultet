package controller;

import javax.servlet.http.HttpServletRequest;

import action.AbstractAction;
import action.factory.ActionFactory;
import action.factory.DepartmentActionFactory;
import action.impl.LoginAction;
import action.impl.LogoutAction;

public class ApplicationController {
	
	public String processRequest(String pathInfo, HttpServletRequest request){
		/* u zavisnosti od pathinfo, kreirati klasu koja je potrebna za obradu zahteva*/
		
		String page ="/WEB-INF/pages/error/DefaultErrorPage.jsp";//default error page
		AbstractAction action = null;
		
		if(pathInfo.equalsIgnoreCase("/login") || pathInfo.equalsIgnoreCase("/logout"))
			action = ActionFactory.createActionFactory(pathInfo);
		
		//priprema stringa za entitije
		String[] path = pathInfo.substring(1, pathInfo.length()).split("/");
		if(path[0].equalsIgnoreCase("department")) {
			action = DepartmentActionFactory.createActionFactory(path[1]);
		}
		if(path[0].equalsIgnoreCase("profesor")) {
			action = ActionFactory.createActionFactory(path[1]);
		}
		
		//if action = null, nije mapiran url na akciju
		if(action != null) {
			page = action.execute(request);
		}else {
			request.setAttribute("error", "Action " + request.getPathInfo() + " is not mapped to action!");
		}
		
		return page;
	}

}
