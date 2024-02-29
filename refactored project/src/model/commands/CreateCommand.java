package model.commands;

import controller.LatexEditorControllerHandler;

public class CreateCommand implements Command {

	@Override
	public void execute() {
		LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().createCurrentDocument() ;
	}
}
