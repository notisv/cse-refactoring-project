package model.commands;

import controller.LatexEditorControllerHandler;

public class ChangeVersionsStrategyCommand implements Command {
	
	@Override
	public void execute() {
		LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().changeVersionStrategy();
	}

}
