package action.impl;

import javax.servlet.http.HttpServletRequest;

import action.AbstractAction;
import constants.ViewConstants;

public class LogoutAction extends AbstractAction{

	@Override
	public String execute(HttpServletRequest request) {
		request.getSession().invalidate();
		
		return ViewConstants.LOGOUT;
	}

}
