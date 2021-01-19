package com.client;

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
import com.shared.registration;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class Skillmen extends Composite {

	private static SkillmenUiBinder uiBinder = GWT.create(SkillmenUiBinder.class);

	interface SkillmenUiBinder extends UiBinder<Widget, Skillmen> {
	}


     @UiField
     MaterialContainer aa;
     @UiField
     MaterialTextBox name;
     @UiField
     MaterialTextBox add;
     @UiField
     MaterialTextBox mob;
     @UiField
     MaterialTextBox aadhar;
     @UiField
     MaterialListBox gen;
     @UiField
     MaterialListBox city;
     @UiField
     MaterialListBox dis;
     @UiField
     MaterialListBox state;
     @UiField
     MaterialTextBox email;
     @UiField
     MaterialTextBox pass;
     @UiField
     MaterialButton submit;
     GreetingServiceAsync a2 = GWT.create(GreetingService.class);
 	public Skillmen() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
     
     private void setup() {
    	 
    	 submit.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
		if(email.getText().isEmpty()||pass.getText().isEmpty()||state.getValue().isEmpty()||gen.getValue().isEmpty()||city.getValue()
	    .isEmpty()||dis.getValue().isEmpty()||name.getText().isEmpty()||add.getText().isEmpty()||mob.getText().isEmpty()||aadhar.getText().isEmpty())
				{
					  new MaterialToast().toast("Required Fields Cannot Be Empty.", 1000);
					return;
				}
		registration ss=new registration();
		ss.setUsername(email.getText());
		ss.setPassword(pass.getText());
		ss.setName(name.getText());
		ss.setAddress(add.getText());
		ss.setMob(mob.getText());
		ss.setAadhar(aadhar.getText());
		ss.setGender(gen.getValue());
		ss.setCity(city.getValue());
		ss.setDistrict(dis.getValue());
		ss.setState(state.getValue());
		a2.registrations(ss,new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert(caught.getMessage());
			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				if(result.equals("success")) {
					new MaterialToast().toast("registration successful", 2000);
				/*Home rl=new Home();
					RootPanel.get().clear();
					RootPanel.get().add(rl);*/
					History.newItem("gg");
					Singleton.getInstance().function();
					new MaterialToast().toast("Login Again", 5000);
					email.setText("");
					pass.setText("");
					name.setText("");
					add.setText("");
					mob.setText("");
					aadhar.setText("");
				}
				else {
					new MaterialToast().toast(result, 1000);
				}
			}
		});
				
			}
		});
    	 
     }
	
}
