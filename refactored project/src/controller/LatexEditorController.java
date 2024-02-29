package controller;

import model.Document;
import model.DocumentCreator;
import model.VersionManager;

import model.commands.CommandsManager;
import model.save.load.strategies.LoadHtmlFile;
import model.save.load.strategies.LoadLatexFile;
import model.save.load.strategies.LoadStrategy;
import model.save.load.strategies.SaveHtmlFile;
import model.save.load.strategies.SaveLatexFile;
import model.save.load.strategies.SaveStrategy;
import model.version.strategies.VolatileVersionsStrategy;

public class LatexEditorController {

	private VersionManager versionsManager;
	private Document currentDocument;
	private DocumentCreator documentCreator ;
	
	private SaveStrategy saveStrategy ;
	private LoadStrategy loadStrategy ;

	private CommandsManager commandsManager ;
	
	private UserInterfaceInformationCollectorController userInterfaceInformationCollectorController ;
	
	public LatexEditorController() {
		versionsManager = new VersionManager(new VolatileVersionsStrategy());
		commandsManager = new CommandsManager() ;
		currentDocument = new Document();
		documentCreator = new DocumentCreator(); 
		
		userInterfaceInformationCollectorController = UserInterfaceInformationCollectorHandler.USER_INTERFACE_INFORMATION_COLLECTOR.getInstance() ;
	}
	
	public void executeCommand(String nameOfCommand) {
		commandsManager.enact(nameOfCommand);
	}
	
	public void setLoadStrategy(String fileFormat) {
		if(fileFormat.equals(".tex")) {
			loadStrategy = new LoadLatexFile() ;
		}else if(fileFormat.contentEquals(".html")) {
			loadStrategy = new LoadHtmlFile() ;
		}
	}
	
	public LoadStrategy getLoadStrategy() {
		return loadStrategy ;
	}

	public void setSaveStrategy(String fileFormat) {
		if(fileFormat.equals(".tex")) {
			saveStrategy = new SaveLatexFile() ;
		}else if(fileFormat.contentEquals(".html")) {
			saveStrategy = new SaveHtmlFile() ;
		}
	}

	public SaveStrategy getSaveStrategy() {
		return saveStrategy ;
	}
	
	public void setCurrentDocumentContents(String fileContents) {
		currentDocument.setContents(fileContents);
	}
	
	public void setCurrentDocument(Document currentDocument) {
		this.currentDocument = currentDocument ;
	}
	
	public String getCurrentDocumentContents() {
		return currentDocument.getContents() ;
	}
	
	public boolean isVerionMangerEnabled() {
		return versionsManager.isVersionManagerStrategyEnabled() ;
	}

	public void enableVersionManagement() {
		versionsManager.enableVersionStrategy(userInterfaceInformationCollectorController.getCommandStrategy());
	}

	public void changeVersionStrategy() {
		versionsManager.changeVersionStrategy(userInterfaceInformationCollectorController.getCommandStrategy());
	}

	public void setVersionManagerStrategyDisabled() {
		versionsManager.disableVersionManagerStrategy();
	}
	
	public Document createCurrentDocument() {
		currentDocument = documentCreator.createDocument(userInterfaceInformationCollectorController.getTypeOfTemplate());
		return currentDocument ;
	}
	
	public Document getDocumentLastVersion() {
		return versionsManager.getVersionManagerStrategy().getDocumentOfLastVersion() ;
	}
	
	public void removeLastDocumentVersion() {
		versionsManager.getVersionManagerStrategy().removeVersion();
	}
	
	public void insertDocumentInVerionManagerStrategy() {
		versionsManager.putVersionManagerStrategy(currentDocument);
	}
	
	public void setNextVersion() {
		currentDocument.setNextVersionID();
	}
}
