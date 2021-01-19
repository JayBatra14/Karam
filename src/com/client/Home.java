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
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialHeader;
import gwt.material.design.client.ui.MaterialLink;

public class Home extends Composite{

	private static HomeUiBinder uiBinder = GWT.create(HomeUiBinder.class);

	interface HomeUiBinder extends UiBinder<Widget, Home> {
	}

	public Home() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	/*@UiField
	Button button;

	public Home(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}*/
	@UiField
	MaterialHeader header;
	
	@UiField
	MaterialLink home,login,registration;
	
	@UiHandler("home")
	void onClick(ClickEvent e) {
		RootPanel.get().clear();
		RootPanel.get().add(new Home());
	}

	
	@UiHandler("login")
	void onClick1(ClickEvent e)
	{
		/*RootPanel.get().clear();
		RootPanel.get().add(header);
		RootPanel.get().add(new Login());*/
		History.replaceItem("historyToken");
		History.newItem("ii");
		Singleton.getInstance().function();
		History.replaceItem("historyToken");
		//History.replaceItem("historyToken");
	}
	
    @UiHandler("registration")
    void onClick2(ClickEvent e) {
    	/*RootPanel.get().clear();
    	RootPanel.get().add(header);
    	RootPanel.get().add(new Registration());*/
    	History.replaceItem("historyToken");
		History.newItem("kk");
		Singleton.getInstance().function();
    }
    
	
}
