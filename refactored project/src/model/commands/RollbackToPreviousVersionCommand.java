package model.commands;

import javax.swing.JOptionPane;

import controller.LatexEditorControllerHandler;
import model.Document;

public class RollbackToPreviousVersionCommand implements Command {

	@Override
	public void execute() {
		rollback();
	}
	
	public void rollback() {
		
		if(!LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().isVerionMangerEnabled()) {
			JOptionPane.showMessageDialog(null, "Strategy is not enabled", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			
			Document doc = LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().getDocumentLastVersion() ;
			
			if(doc == null) {
				JOptionPane.showMessageDialog(null, "No version available", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().removeLastDocumentVersion();
				LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().setCurrentDocument(doc);
			}
		}
	}

}
