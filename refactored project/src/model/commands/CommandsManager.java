package model.commands;

import java.util.HashMap;

import constants.StringConstants;

public class CommandsManager{
	
	private HashMap<String, Command> commandsMap;
	
	public CommandsManager() {
		
		CommandFactory commandFactory = new CommandFactory();
		commandsMap = new HashMap<String, Command>();
		
		initCommandsMap(commandFactory);
	}

	private void initCommandsMap(CommandFactory commandFactory) {
		
		for(String commandName : StringConstants.NAMES_OF_COMMANDS) {
			commandsMap.put(commandName,commandFactory.createCommand(commandName)) ;
		}
	}
	
	public void enact(String command) {
		commandsMap.get(command).execute();
	}
}
