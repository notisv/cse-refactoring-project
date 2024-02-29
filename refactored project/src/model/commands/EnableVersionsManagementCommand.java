package model.commands;

import controller.LatexEditorControllerHandler;

public class EnableVersionsManagementCommand implements Command {
	
	@Override
	public void execute() {
		LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().enableVersionManagement();
	}
}
