package com.presentation;

public abstract class Command {

	private int eventReturn;
	
	//Execute devolvera un Pair con un Integer(0 si hay error, 1 si no hay error) y el transfer para
	//ser usado en presentacion
	public abstract Pair<Integer, Object> execute(Object transfer);
	
	public int getEventReturn() {
		return eventReturn;
	}
	
	public void setEventReturn(int eventReturn) {
		this.eventReturn = eventReturn;
	}
	
}
