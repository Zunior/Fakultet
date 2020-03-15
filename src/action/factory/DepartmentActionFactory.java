package action.factory;

import action.AbstractAction;
import action.impl.department.DepartmentAddAction;
import action.impl.department.DepartmentDeleteAction;
import action.impl.department.DepartmentEditAction;
import action.impl.department.DepartmentListAction;
import action.impl.department.DepartmentSaveAction;

public class DepartmentActionFactory {
	public static AbstractAction createActionFactory(String actionName) {
		AbstractAction action = null;
		
		if(actionName.equalsIgnoreCase("list")) {
			action = new DepartmentListAction();
		}
		
		if(actionName.equalsIgnoreCase("add")) {
			action = new DepartmentAddAction();
		}
		
		if(actionName.equalsIgnoreCase("delete")) {
			action = new DepartmentDeleteAction();
		}
		
		if(actionName.equalsIgnoreCase("edit")) {
			action = new DepartmentEditAction();
		}
		
		if(actionName.equalsIgnoreCase("save")) {
			action = new DepartmentSaveAction();
		}
		
		return action;
	}

}
