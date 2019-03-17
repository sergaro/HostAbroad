package com.presentation.controller;
/**
 * This class is created to dynamically load all of the available commands written 
 * in the CommandEnum.
 * 
 *<pre>
 * Before any modifications contact the author.
 *</pre> 
 *
 * @author Gasan Nazer
 */

/*This class should be additionally tested. Reason: during the implementation class Pair
 * and Command were not included in SearchHost*/
public class FactoryCommandImp extends FactoryCommand {

	@Override
	public Command parseCommand(Commands command) {
		Command com = null;
		try {
			  Class c = Class.forName("Commands." + command);  // Dynamically load every command
			  Object o = c.newInstance(); // Dynamically instantiate it
			  Command com = (Command)o;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Exeption in FactoryCommandImp parseCommand().");
			}
		
		return com;
	}

}
