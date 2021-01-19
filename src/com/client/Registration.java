package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialContainer;

public class Registration extends Composite {

	private static RegistrationUiBinder uiBinder = GWT.create(RegistrationUiBinder.class);

	interface RegistrationUiBinder extends UiBinder<Widget, Registration> {
	}

	public Registration() {
		initWidget(uiBinder.createAndBindUi(this));
	}

   
	@UiField
	RadioButton skillmen,customer;
	
	@UiField
	MaterialContainer rr;
	
	
	
	@UiHandler("skillmen")
		void onClick(ClickEvent e) {
			/*rr.clear();
			Skillmen s = new Skillmen();
			rr.add(s);*/
		History.newItem("nn");
		Singleton.getInstance().function();
		History.replaceItem("historyToken");
		}
	
	@UiHandler("customer")
	void onClick1(ClickEvent e) {
		
		/*rr.clear();
		Customer c = new Customer();
		rr.add(c);*/
		History.newItem("aa");
		Singleton.getInstance().function();
		History.replaceItem("historyToken");
	}
	
	
	


}