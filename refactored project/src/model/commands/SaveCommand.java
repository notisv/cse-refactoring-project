package model.commands;

import controller.LatexEditorControllerHandler;

public class SaveCommand implements Command {
	
	@Override
	public void execute() {
		LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().getSaveStrategy().saveFile();
	}

}
