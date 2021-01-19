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
import com.shared.addplan;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class Plan extends Composite{

	private static PlanUiBinder uiBinder = GWT.create(PlanUiBinder.class);

	interface PlanUiBinder extends UiBinder<Widget, Plan> {
	}
	@UiField
	MaterialTextBox mc;
	@UiField
	MaterialTextBox uc;
	@UiField
	MaterialListBox s;
	@UiField
	MaterialButton sub;
	GreetingServiceAsync a2 = GWT.create(GreetingService.class);
	public Plan(String id) {
		initWidget(uiBinder.createAndBindUi(this));
		this.id=id;
		setup();
	}

    public Plan() {
		// TODO Auto-generated constructor stub
    	initWidget(uiBinder.createAndBindUi(this));
	}

	String id;
	private void setup() {
		
		sub.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				addplan ap = new addplan();
				ap.setMc(mc.getText());
				ap.setUc(uc.getText());
				ap.setS(s.getValue());
				ap.setId(id);

				a2.add(ap,new AsyncCallback<String>() {
					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						if(result.equals("success")) {
							new MaterialToast().toast("Plan Added Successful;", 2000);
						/*LabourPortal ph=new LabourPortal(id);
							RootPanel.get().clear();
							RootPanel.get().add(ph);*/
							Singleton.getInstance().id=id;
							History.newItem("hh");
							Singleton.getInstance().function();
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
