package controller;

public enum UserInterfaceInformationCollectorHandler {

	USER_INTERFACE_INFORMATION_COLLECTOR ;
	
	private UserInterfaceInformationCollectorController userInterfaceInformationCollector = new UserInterfaceInformationCollectorController() ;
	
	public UserInterfaceInformationCollectorController getInstance() {
		return userInterfaceInformationCollector ;
	}
	
}
