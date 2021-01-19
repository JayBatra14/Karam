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
import com.shared.registration;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class Customer extends Composite {

	private static CustomerUiBinder uiBinder = GWT.create(CustomerUiBinder.class);

	interface CustomerUiBinder extends UiBinder<Widget, Customer> {
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
	     public Customer() {
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
			registration cr=new registration();
			cr.setUsername(email.getText());
			cr.setPassword(pass.getText());
			cr.setName(name.getText());
			cr.setAddress(add.getText());
			cr.setMob(mob.getText());
			cr.setAadhar(aadhar.getText());
			cr.setGender(gen.getValue());
			cr.setCity(city.getValue());
			cr.setDistrict(dis.getValue());
			cr.setState(state.getValue());
			a2.registrationc(cr,new AsyncCallback<String>() {

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
						new MaterialToast().toast("registration unsuccessful", 1000);
					}
				}
			});
					
				}
			});
	    	 
	     }
		

}
