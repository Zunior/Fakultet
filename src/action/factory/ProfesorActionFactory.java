package action.factory;

import action.AbstractAction;
import action.impl.profesor.ProfesorAddAction;
import action.impl.profesor.ProfesorDeleteAction;
import action.impl.profesor.ProfesorEditAction;
import action.impl.profesor.ProfesorListAction;
import action.impl.profesor.ProfesorSaveAction;

public class ProfesorActionFactory {
	public static AbstractAction createActionFactory(String actionName) {
		AbstractAction action = null;
		
		if(actionName.equalsIgnoreCase("list")) {
			action = new ProfesorListAction();
		}
		
		if(actionName.equalsIgnoreCase("add")) {
			action = new ProfesorAddAction();
		}
		
		if(actionName.equalsIgnoreCase("delete")) {
			action = new ProfesorDeleteAction();
		}
		
		if(actionName.equalsIgnoreCase("edit")) {
			action = new ProfesorEditAction();
		}
		
		if(actionName.equalsIgnoreCase("save")) {
			action = new ProfesorSaveAction();
		}
		
		return action;
	}
}
