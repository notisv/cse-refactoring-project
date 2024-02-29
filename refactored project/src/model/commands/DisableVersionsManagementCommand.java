package model.commands;

import controller.LatexEditorControllerHandler;

public class DisableVersionsManagementCommand implements Command {

	@Override
	public void execute() {
		LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().setVersionManagerStrategyDisabled();
	}

}
