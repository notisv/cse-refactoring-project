package model.save.load.strategies;

import constants.StringConstants;
import controller.UserInterfaceInformationCollectorHandler;

public abstract class LoadStrategy {
	
	public abstract void loadFile() ;
	
	public void setTypeOfTemplate(String fileContents) {
		
		String typeOfTemplate = "emptyTemplate";
		
		fileContents = fileContents.trim();
		
		for(String startContent : StringConstants.TEMPLATES_START_CONTENT_LIST) {
			if(fileContents.startsWith(startContent)) {
				typeOfTemplate = StringConstants.TEMPLATES_START_CONTENT_MAP.get(startContent) ;
			}
		}

		UserInterfaceInformationCollectorHandler.USER_INTERFACE_INFORMATION_COLLECTOR.getInstance().setType(typeOfTemplate);
	}
}
