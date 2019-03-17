package com.presentation.controller;

/*This class should be additionally tested. Reason: during the implementation class Pair
 * and Command were not included in SearchHost*/

public abstract class Controller {
	private static Controller instance;
	
	public static synchronized Controller getInstance() {
		if(instance == null){
			instance = new ControllerImp();
		}
		return instance;
	}
	
	public abstract Pair<Integer, Object> action(Commands evento, Object transfer);

}
