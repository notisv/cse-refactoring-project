package model.commands;

import controller.LatexEditorControllerHandler;
import controller.UserInterfaceInformationCollectorHandler;

public class EditCommand implements Command {
	
	@Override
	public void execute() {
		editContents();
	}
	
	public void editContents() {
		
		if(LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().isVerionMangerEnabled()) {
			
			LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().insertDocumentInVerionManagerStrategy() ;
			LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().setNextVersion();
		}
		
		String userInterfaceText = UserInterfaceInformationCollectorHandler.USER_INTERFACE_INFORMATION_COLLECTOR.getInstance().getText() ;
		LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().setCurrentDocumentContents(userInterfaceText);
	}
}
