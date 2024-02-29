package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import constants.StringConstants;
import controller.LatexEditorController;
import controller.LatexEditorControllerHandler;
import controller.UserInterfaceInformationCollectorController;
import controller.UserInterfaceInformationCollectorHandler;
import model.Document;

/*
 * Test user story 3
 */

class AdderLatexDocumentTest {
	
	
	LatexEditorController latexEditorController = LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance() ;
	UserInterfaceInformationCollectorController userInterfaceInformationCollectorController = UserInterfaceInformationCollectorHandler.USER_INTERFACE_INFORMATION_COLLECTOR.getInstance() ;

	
	@Test
	void test() {
		
		latexEditorController.setCurrentDocument(new Document());
		
		setEditorPaneProperties();
			
		for(String subTypeTag : StringConstants.CONTENTS_OF_SUBTYPE_MAP.keySet() ) {
				
			userInterfaceInformationCollectorController.setTypeOfSubtype(subTypeTag);
			latexEditorController.executeCommand("addLatex");
			
			assertEquals(StringConstants.CONTENTS_OF_SUBTYPE_MAP.get(subTypeTag).trim(), latexEditorController.getCurrentDocumentContents().trim());			
		}
	}


	private void setEditorPaneProperties() {
		userInterfaceInformationCollectorController.setEditorPaneText("");
		userInterfaceInformationCollectorController.setEditorPaneCaretPosition(0);
	}

}
