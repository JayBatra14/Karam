package com.client;

import java.util.Date;

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

import gwt.material.design.addins.client.timepicker.MaterialTimePicker;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialDatePicker;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class SkillmenDetails extends Composite{

	private static SkillmenDetailsUiBinder uiBinder = GWT.create(SkillmenDetailsUiBinder.class);

	interface SkillmenDetailsUiBinder extends UiBinder<Widget, SkillmenDetails> {
	}

	public SkillmenDetails() {
		initWidget(uiBinder.createAndBindUi(this));
	}

String c_id="";
String s_id="";
	public SkillmenDetails(String c_id,String s_id) {
		initWidget(uiBinder.createAndBindUi(this));
		this.c_id=c_id;	
		this.s_id=s_id;
	} 
	
	@UiField
	MaterialButton book;

	@UiField
	MaterialTextBox name,add, email,mob,mc,uc;
	
	@UiField
	MaterialContainer x;
	
	@UiField 
	MaterialDatePicker dp;
	
	@UiField 
	MaterialTimePicker tp;

private final GreetingServiceAsync a2 = GWT.create(GreetingService.class);


@UiHandler("book")
void onClick(ClickEvent e)
{
	Details d= new Details();
	d.setCid(c_id);
	d.setSid(s_id);
	d.setDate(dp.getDate()); 
	d.setTime(tp.getValue());
   a2.book(d, new AsyncCallback<String>() {
	
	@Override
	public void onSuccess(String result) {
		// TODO Auto-generated method stub
		Window.alert(result);
		History.newItem("cc");
		Singleton.getInstance().function();
	}
	
	@Override
	public void onFailure(Throwable caught) {
		// TODO Auto-generated method stub
		
	}
});
}

/*@UiHandler("show")
void onClick1(ClickEvent e)
{
	Details d=new Details();
	a2.sdet(d, s_id, new AsyncCallback<Details>() {
		
		@Override
		public void onSuccess(Details result) {
			// TODO Auto-generated method stub
			String s1=result.getName();
			String s2=result.getAddress();
			String s3=result.getMobile();
			String s4=result.getEmail();
			
			
			name.setText(s1);
			add.setText(s2);
			mob.setText(s3);
			email.setText(s4);
			
			a2.charges(d, s_id, new AsyncCallback<Details>() {
				
				@Override
				public void onSuccess(Details result) {
					// TODO Auto-generated method stub
					
					mc.setText(result.getMc());
					uc.setText(result.getUc());
				}
				
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					Window.alert(caught.getMessage());
				}
			});
			
			
			
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
