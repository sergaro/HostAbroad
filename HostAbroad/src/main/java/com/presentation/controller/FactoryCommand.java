package com.presentation.controller;

/*This class should be additionally tested. Reason: during the implementation class Pair
 * and Command were not included in SearchHost*/

public abstract class FactoryCommand {
	
private static FactoryCommand instance;
	
	public static synchronized FactoryCommand getInstance() {
		
		if(instance == null)
			instance = new FactoryCommandImp();
		
		return instance;
	}
	
	public abstract Command parseCommand(Commands command);
}
