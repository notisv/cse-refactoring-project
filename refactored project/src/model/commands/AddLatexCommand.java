package model.commands;

import constants.StringConstants;
import controller.LatexEditorControllerHandler;
import controller.UserInterfaceInformationCollectorHandler;

public class AddLatexCommand implements Command  {

	@Override
	public void execute() {
		addContents(); 
		LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().executeCommand("edit");
	}

	public void addContents() {
		
		String contents = UserInterfaceInformationCollectorHandler.USER_INTERFACE_INFORMATION_COLLECTOR.getInstance().getEditorPaneText() ;
		String before = contents.substring(0,  UserInterfaceInformationCollectorHandler.USER_INTERFACE_INFORMATION_COLLECTOR.getInstance().getEditorPaneCaretPosition());		
		String after = contents.substring( UserInterfaceInformationCollectorHandler.USER_INTERFACE_INFORMATION_COLLECTOR.getInstance().getEditorPaneCaretPosition());
		
		contents = before + StringConstants.CONTENTS_OF_SUBTYPE_MAP.get( UserInterfaceInformationCollectorHandler.USER_INTERFACE_INFORMATION_COLLECTOR.getInstance().getTypeOfSubType()) +after;

		UserInterfaceInformationCollectorHandler.USER_INTERFACE_INFORMATION_COLLECTOR.getInstance().setText(contents);
	}
}

