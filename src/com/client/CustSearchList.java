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
import com.shared.Details;
import com.shared.List;


import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCollection;
import gwt.material.design.client.ui.MaterialCollectionItem;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialLink;

public class CustSearchList extends Composite  {

	
	private static CustSearchListUiBinder uiBinder = GWT.create(CustSearchListUiBinder.class);

	interface CustSearchListUiBinder extends UiBinder<Widget, CustSearchList> {
	}
    String c_id="";
    String ser="";
   
	public CustSearchList(String id, String ser) {
		initWidget(uiBinder.createAndBindUi(this));
		this.c_id=id;
	    this.ser=ser;
	}
	
	
	public CustSearchList() {
		// TODO Auto-generated constructor stub
		initWidget(uiBinder.createAndBindUi(this));
	}



	
	@UiField 
	MaterialCollection mc;
	
	@UiField 
    MaterialContainer cc;
	
	private final GreetingServiceAsync a2 = GWT.create(GreetingService.class);
	

	
	/*@UiHandler("show")
	void onClick(ClickEvent e)
	{
		a2.lists(ser, new AsyncCallback<List>() {
			
			@Override
			public void onSuccess(List result) {
				// TODO Auto-generated method stub
				int n=result.getN();
				String a[]=new String[n];
				a=result.getL(); 
				mc.clear();
				for(int i=0;i<n;i++)
				{
				    String b=a[i];
					a2.name(a[i], new AsyncCallback<String>() {
						
						@Override
						public void onSuccess(String result) {
							// TODO Auto-generated method stub
							String s=result;
							String id=b; 
							MaterialCollectionItem mci=new MaterialCollectionItem();
							MaterialLink m1=new MaterialLink(id+" "+s);
							m1.setTextColor(Color.BLACK);
							mci.add(m1);
							mc.add(mci);
							mci.addClickHandler(new ClickHandler() {
								
								@Override
								public void onClick(ClickEvent event) {
									// TODO Auto-generated method stub
									String s_id=m1.getText();
									String n[]=new String[2];
									n=s_id.split("\\s");
									Details d=new Details();
									String b=n[0];
									a2.sdet(d, n[0], new AsyncCallback<Details>() {
				
										@Override
										public void onSuccess(Details result) {
											// TODO Auto-generated method stub
											Singleton.getInstance().getSkillmenDetails().name.setText(result.getName());
											Singleton.getInstance().getSkillmenDetails().add.setText(result.getAddress());
											Singleton.getInstance().getSkillmenDetails().mob.setText(result.getMobile());
											Singleton.getInstance().getSkillmenDetails().email.setText(result.getEmail());
											
											a2.charges(d, b , new AsyncCallback<Details>() {
												
												@Override
												public void onSuccess(Details result) {
													// TODO Auto-generated method stub
													Singleton.getInstance().getSkillmenDetails().mc.setText(result.getMc());
													Singleton.getInstance().getSkillmenDetails().uc.setText(result.getUc());
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
									Singleton.getInstance().cid=c_id;
									Singleton.getInstance().sid=n[0];
									History.newItem("oo");
									Singleton.getInstance().function();
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
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert(caught.getMessage());
			}
		});
	}*/
	 
	/*SkillmenDetails sd= new SkillmenDetails(c_id,n[0]);
	cc.clear();
	RootPanel.get().clear();
	RootPanel.get().add(sd);*/

}
