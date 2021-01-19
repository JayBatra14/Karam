package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
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
import com.shared.Details;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

public class CustomerDetails extends Composite{

	private static CustomerDetailsUiBinder uiBinder = GWT.create(CustomerDetailsUiBinder.class);

	interface CustomerDetailsUiBinder extends UiBinder<Widget, CustomerDetails> {
	}

	public CustomerDetails() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	
String cid="";
String sid="";
	public CustomerDetails(String cid,String sid) {
		initWidget(uiBinder.createAndBindUi(this));
		this.cid=cid;
		this.sid=sid;
	}

@UiField 
MaterialButton can,app;

@UiField 
MaterialTextBox name,add,mob,email;

private final GreetingServiceAsync a2 = GWT.create(GreetingService.class);

@UiHandler("app")
void onClick(ClickEvent e)
{
	String q="Approved";
	a2.status(cid, sid, q, new AsyncCallback<String>() {
		
		@Override
		public void onSuccess(String result) {
			// TODO Auto-generated method stub
			Window.alert(result);
			History.newItem("hh");
			Singleton.getInstance().function();
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert(caught.getMessage());
		}
	});

}

@UiHandler("can")
void onClick1(ClickEvent e)
{
	String q="Cancelled";
	a2.status(cid, sid, q, new AsyncCallback<String>() {
		
		@Override
		public void onSuccess(String result) {
			// TODO Auto-generated method stub
			Window.alert(result);
			History.newItem("hh");
			Singleton.getInstance().function();
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert(caught.getMessage());
		}
	});
}

/*@UiHandler("show")
void onClick(ClickEvent e)
{
	Details d=new Details();
	a2.cdet(d, cid, new AsyncCallback<Details>() {
		
		@Override
		public void onSuccess(Details result) {
			// TODO Auto-generated method stub
			name.setText(result.getName());
			add.setText(result.getAddress());
			mob.setText(result.getMobile());
			email.setText(result.getEmail());
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert(caught.getMessage());
		}
	});
}
<m:MaterialRow paddingLeft="500">
             <m:MaterialButton ui:field="show" text="Show details" backgroundColor="YELLOW" textColor="BLACK" width="35%"/>
             </m:MaterialRow>
*/



}
