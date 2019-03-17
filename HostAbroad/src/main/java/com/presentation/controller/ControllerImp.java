package com.presentation.controller;

/*This class should be additionally tested. Reason: during the implementation class Pair
 * and Command were not included in SearchHost*/

public class ControllerImp extends Controller {

	/** Right now this method returns a pair so that the UI will be able to take and use it**/
	@Override
	public Pair<Integer, Object> action(Commands evento, Object transfer){
		FactoryCommand fCommand = FactoryCommand.getInstance();
		Command command = fCommand.parseCommand(evento);	
		
		Pair<Integer, Object> result = command.execute(transfer);
		
		return result;
	}
}
