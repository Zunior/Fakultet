package view;

import java.util.HashMap;
import java.util.Map;

import constants.PageConstants;
import constants.ViewConstants;

public class ViewResolver {
	
		private Map<String, String> pages;
		
		public ViewResolver() {
			pages = new HashMap<String, String>()
			{{
				put(ViewConstants.DEFAULT_ERROR, PageConstants.PAGE_DEFAULT_ERROR);
				put(ViewConstants.LOGIN, PageConstants.PAGE_LOGIN);
				put(ViewConstants.LOGOUT, PageConstants.PAGE_LOGOUT);
				
				put(ViewConstants.ADD_CITY, PageConstants.PAGE_ADD_CITY);
				put(ViewConstants.DELETE_CITY, PageConstants.PAGE_DELETE_CITY);
				put(ViewConstants.EDIT_CITY, PageConstants.PAGE_EDIT_CITY);
				put(ViewConstants.HOME, PageConstants.PAGE_HOME);
				put(ViewConstants.LIST_CITY, PageConstants.PAGE_LIST_CITY);
				
			}};
		}
		
		public String getPage(String view) {
			if(pages.containsKey(view))
				return pages.get(view);
			//return default error page
			return null;
		}
		
		
	
}
