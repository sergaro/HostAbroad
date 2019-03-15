package com.vaadin.demo.jpaaddressbook;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vaadin.demo.jpaaddressbook.domain.Name;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;


public class OnePage extends Window{
	
	TextArea textA;

	public OnePage() {
		HorizontalLayout horizontalLayout_init = new HorizontalLayout();
		horizontalLayout_init.setMargin(true);
		horizontalLayout_init.setSizeFull();
		HorizontalLayout layout_1 = new HorizontalLayout();
		horizontalLayout_init.addComponent(layout_1);
		
		//layout for grid
		VerticalLayout layout_2 = new VerticalLayout();
		layout_1.addComponent(layout_2);
		
		//label text 
		Label insertName = new Label("Insert a name");
		insertName.setVisible(true);
		layout_2.addComponent(insertName);
		
		TextField text = new TextField();
		text.setVisible(true);
		layout_2.addComponent(text);
		
		Button but = new Button();
		but.setCaption("Save");
		but.setVisible(true);
		layout_2.addComponent(but);
		
		but.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
               String name = (String)text.getValue();
               System.out.println(name);
               createName(name);
               text.setValue("");
            }
        });
		
		HorizontalLayout layout_3 = new HorizontalLayout();
		layout_1.addComponent(layout_3);
		
		VerticalLayout layout_4 = new VerticalLayout();
		layout_3.addComponent(layout_4);
		
		TextArea textA = new TextArea("Inserted names");
		textA.setReadOnly(true);
		textA.setVisible(true);
		textA.setWidth("300px");
		textA.setHeight("300px");
		layout_4.addComponent(textA);
		
		Button but2 = new Button();
		but2.setCaption("Show all inserted names");
		but.setVisible(true);
		but2.setSizeFull();
		layout_4.addComponent(but2);
		
		but2.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				textA.setValue("");
				List<Name> names = readAllNames();
				for(Name st: names) {
	               textA.setValue(textA.getValue() + st.getName() + "\n");
	            }}
        });
		this.setContent(horizontalLayout_init);
		this.setSizeFull();
	}
	
	public void createName(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("addressbook");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Name nameR = new Name(name);
        
        em.persist( nameR );
        em.getTransaction( ).commit( );
        
        System.out.println(nameR.getName() + "  created.");
        em.close( );
        emf.close( );
	}

	public List<Name> readAllNames(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("addressbook");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        List<Name> ar = em.createNativeQuery("SELECT * FROM Name", Name.class).getResultList();
        
        em.close( );
        emf.close( );
        
        return ar;
	} 
}