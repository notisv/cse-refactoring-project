package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import controller.LatexEditorControllerHandler;
import controller.UserInterfaceInformationCollectorController;
import controller.UserInterfaceInformationCollectorHandler;
import model.Document;
import model.DocumentCreator;
/*
 * Test user story 8 & 9
 */

class LoaderLatexDocumentTest {
	
	DocumentCreator documentCreator = new DocumentCreator() ;
	Document document = documentCreator.createDocument("articleTemplate") ;

	LatexEditorController latexEditorController = LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance() ;
	UserInterfaceInformationCollectorController userInterfaceInformationCollectorController = UserInterfaceInformationCollectorHandler.USER_INTERFACE_INFORMATION_COLLECTOR.getInstance() ;
	
	@Test
	void test() {

		latexEditorController.setCurrentDocument(document);
		
		userInterfaceInformationCollectorController.setFilename("FileFromTestSaveAsHTML.html");
		shouldSaveAndLoadFile(".html");

		userInterfaceInformationCollectorController.setFilename("FileFromTestSaveAsLATEX.tex");
		shouldSaveAndLoadFile(".tex");
		
		
	}
	
	public void shouldSaveFileType(String fileType) {
		
		latexEditorController.setSaveStrategy(fileType);
		latexEditorController.executeCommand("save");
	}
	
	public void shouldLoadFileType(String fileType) {
		
		latexEditorController.setLoadStrategy(fileType);
		latexEditorController.executeCommand("load");
	}
	
	public void shouldSaveAndLoadFile(String fileType) {
		
		shouldSaveFileType(fileType);
		shouldLoadFileType(fileType);
		
		assertEquals(document.getContents(), latexEditorController.getCurrentDocumentContents());

	}

}
