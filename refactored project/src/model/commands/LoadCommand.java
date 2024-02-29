package model.commands;

import controller.LatexEditorControllerHandler;

public class LoadCommand implements Command {
	
	@Override
	public void execute() {
		LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().getLoadStrategy().loadFile();
	}
}
