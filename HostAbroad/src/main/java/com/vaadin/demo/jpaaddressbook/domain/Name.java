package com.vaadin.demo.jpaaddressbook.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Name {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String name;

	public Name(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Name(String name) {
		this.name = name;
	}
	
	public Name() {
		super();
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName() {
		this.name = name; 
	}
}
