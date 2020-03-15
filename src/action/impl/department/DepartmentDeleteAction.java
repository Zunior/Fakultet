package action.impl.department;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import action.AbstractAction;
import constants.ViewConstants;

public class DepartmentDeleteAction extends AbstractAction{

	@Override
	public String execute(HttpServletRequest request) {
//		List<City> cities = (List<City>) request.getServletContext().getAttribute("cities");
//		if(cities == null)
//			cities = new ArrayList<City>();
//		
//		Long brojGrada = Long.parseLong((String) request.getParameter("brojGrada"));
//		cities.remove(new City(brojGrada));
//		request.getServletContext().setAttribute("cities", cities);
		
		return ViewConstants.DELETE_CITY;
	}

}
