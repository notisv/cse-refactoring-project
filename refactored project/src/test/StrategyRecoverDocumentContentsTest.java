package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import controller.LatexEditorControllerHandler;
import controller.UserInterfaceInformationCollectorController;
import controller.UserInterfaceInformationCollectorHandler;
import model.Document;

/*
 * Test user story 4 & 5 & 6 & 7
 */

class StrategyRecoverDocumentContentsTest {


	LatexEditorController latexEditorController = LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance() ;
	UserInterfaceInformationCollectorController userInterfaceInformationCollectorController = UserInterfaceInformationCollectorHandler.USER_INTERFACE_INFORMATION_COLLECTOR.getInstance() ;
	
	
	@Test
	void test() {		
		
		shouldRollbackWithStrategy("volatile");
		shouldRollbackWithStrategy("stable");
		
		shouldChangeVerionManagerStrategy("stable", "volatile") ;
		shouldChangeVerionManagerStrategy("volatile", "stable") ;
		
		shouldDisableRollBack();
	}


	private void shouldChangeVerionManagerStrategy(String initialStrategy, String finalStrategy) {
		
		latexEditorController.setCurrentDocument(new Document());
		setStrategyInVerionManager(initialStrategy);
		
		editCurrentDocument() ;
		
		setStrategyInVerionManager(finalStrategy);
		executeRollBack();
	}


	private void shouldDisableRollBack() {
		
		latexEditorController.setVersionManagerStrategyDisabled();
		assertFalse(latexEditorController.isVerionMangerEnabled()) ;
		
		// Notify me that version tracking mechanism is disabled
		executeRollBack();
		
	}


	private void shouldRollbackWithStrategy(String startegyType) {
		
		latexEditorController.setCurrentDocument(new Document());
		
		setStrategyInVerionManager(startegyType);
		editCurrentDocument();

		executeRollBack();
	}


	private void executeRollBack() {
		latexEditorController.executeCommand("rollbackToPreviousVersion");
		assertEquals(latexEditorController.getCurrentDocumentContents().trim(), "First Version") ;
	}


	private void editCurrentDocument() {
		
		latexEditorController.setCurrentDocumentContents("First Version");
		latexEditorController.executeCommand("edit");
		
		assertNotEquals(latexEditorController.getCurrentDocumentContents(), "") ;
		
		latexEditorController.setCurrentDocumentContents("Second Version");
	}


	private void setStrategyInVerionManager(String startegyType) {
		userInterfaceInformationCollectorController.setCommandStrategy(startegyType);
		latexEditorController.executeCommand("enableVersionsManagement");
	}

}
