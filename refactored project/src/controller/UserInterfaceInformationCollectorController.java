package controller;

public class UserInterfaceInformationCollectorController {
	
	private String typeOfTemplate;
	private String typeOfSubtype ;
	
	private String text;
	private String filename;
	private String commandStrategy;
	
	private int editorPaneCaretPosition ;
	private String editorPaneText ;
	
	
	public String getTypeOfTemplate() {
		return typeOfTemplate;
	}

	public void setType(String type) {
		this.typeOfTemplate = type;
	}

	public void setCommandStrategy(String commandStrategy) {
		this.commandStrategy = commandStrategy ;
	}
	
	public String getCommandStrategy() {
		return commandStrategy ;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text ;
	}

	public void setEditorPaneText(String editorPaneText) {
		this.editorPaneText = editorPaneText ;
	}
	
	public String getEditorPaneText() {
		return editorPaneText ;
	}
	
	public void setEditorPaneCaretPosition(int editorPaneCaretPosition) {
		this.editorPaneCaretPosition = editorPaneCaretPosition ;
	}
	
	public int getEditorPaneCaretPosition() {
		return editorPaneCaretPosition ;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public void setTypeOfSubtype(String typeOfSubType) {
		this.typeOfSubtype = typeOfSubType ;
	}
	
	public String getTypeOfSubType() {
		return typeOfSubtype; 
	}
}
