package com.client;

import com.gargoylesoftware.htmlunit.javascript.host.event.Event;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shared.logindetails;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;


public class Login extends Composite {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	interface LoginUiBinder extends UiBinder<Widget, Login> {
	}
	@UiField
	MaterialButton button,button1;
	@UiField
	MaterialTextBox email;
	@UiField
	MaterialTextBox password;
	@UiField
	MaterialContainer c; 

	GreetingServiceAsync a2 = GWT.create(GreetingService.class);
    public Login() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}


	private void setup() {
     
	
		button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if(email.getText().isEmpty()||password.getText().isEmpty())
				{
					  new MaterialToast().toast("Required Fields Cannot Be Empty.", 1000);
					return;
				}
				logindetails c=new logindetails();
				c.setUsername(email.getText());
				c.setPassword(password.getText());
				c.setId(null);
				
				a2.login(c, new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						if(result!="NO") {
							/*String id = result;
							new MaterialToast().toast("Login Success", 1000);
							CustomerPortal cp=new CustomerPortal(id);
							RootPanel.get().clear();
							RootPanel.get().add(cp);*/
							History.replaceItem("historyToken");
							Singleton.getInstance().id=result;
							History.newItem("cc");
							Singleton.getInstance().function();
							//History.replaceItem("historyToken");
							email.setText("");
							password.setText("");
						}
						else {
							new MaterialToast().toast("Invalid Details", 1000);
						}
				}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert(caught.getMessage());
					}
				});
			}
		});	
		button1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if(email.getText().isEmpty()||password.getText().isEmpty())
				{
					  new MaterialToast().toast("Required Fields Cannot Be Empty.", 1000);
					return;
				}
				logindetails s=new logindetails();
				s.setUsername(email.getText());
				s.setPassword(password.getText());
				s.setId(null);
				
				a2.logind(s, new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						if(result!="NO") {
							new MaterialToast().toast("Login Success", 1000);
							/*String id = result;
							LabourPortal lp=new LabourPortal(id);
							RootPanel.get().clear();
							RootPanel.get().add(lp);*/
							History.replaceItem("historyToken");
							Singleton.getInstance().id=result;
							History.newItem("hh");
							Singleton.getInstance().function();
							//History.replaceItem("historyToken");
							email.setText("");
							password.setText("");
						}
						else {
							new MaterialToast().toast("Invalid Details", 1000);
						}
				}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert(caught.getMessage());
					}
				});
			}
		});

}
}