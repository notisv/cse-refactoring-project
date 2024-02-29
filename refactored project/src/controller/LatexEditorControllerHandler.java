package controller;

public enum LatexEditorControllerHandler {
	
	LATEX_EDITOR_CONTROLLER ;
	
	private LatexEditorController latexEditorController = new LatexEditorController() ;
	
	public LatexEditorController getInstance() {
		return latexEditorController ;
	}
}
