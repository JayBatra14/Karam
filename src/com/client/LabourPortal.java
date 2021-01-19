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
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCollectionItem;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialLabel;

public class LabourPortal extends Composite{

	private static LabourPortalUiBinder uiBinder = GWT.create(LabourPortalUiBinder.class);

	interface LabourPortalUiBinder extends UiBinder<Widget, LabourPortal> {
	}

	public LabourPortal(String id) {
		initWidget(uiBinder.createAndBindUi(this));
		this.sid=id;
	}

	public LabourPortal() {
		// TODO Auto-generated constructor stub
		initWidget(uiBinder.createAndBindUi(this));
	}

	String sid;

    @UiField
    MaterialColumn b,b1,b2,b3;
    
    private final GreetingServiceAsync a2 = GWT.create(GreetingService.class);
    
    @UiHandler("b")
    void onClick(ClickEvent e)
    {
    	
    	a2.clists(sid, new AsyncCallback<List>() {
    		
    		@Override
    		public void onSuccess(List result) {
    			// TODO Auto-generated method stub
    			int n=result.getN();
    			String a[]=new String[n]; 
    			String d[]=new String[n];
    			String t[]=new String[n];
    			a=result.getL(); 
    			d=result.getDate();
    			t=result.getTime();
    			Singleton.getInstance().getRequest().mc.clear();
    			for(int i=0;i<n;i++)
    			{
    				String b=a[i]; 
    				String date[]=new String[6];
    				date=d[i].split("\\s");
    				String time[]=new String[6];
    				time=t[i].split("\\s"); 
    				String day=date[0];
    				String month=date[1];
    				String da=date[2];
    				String year=date[5]; 
    				String ti=time[3];
    				String is=time[4];
    				a2.cname(a[i], new AsyncCallback<String>() {
    					
    					@Override
    					public void onSuccess(String result) {
    						// TODO Auto-generated method stub
    						String id=b;
    						String d1=day;
    						String d2=month;
    						String d3=da;
    						String d4=year;
    						String t1=ti;
    						String t2=is;
    						MaterialCollectionItem mci=new MaterialCollectionItem();
    						mci.setWaves(WavesType.GREEN);
    						MaterialLabel m1=new MaterialLabel(id+" "+result); 
    						m1.setTextColor(Color.BLACK); 
    						m1.setFontSize("1.4em");
    						MaterialLabel m2=new MaterialLabel("Date: "+d1+" "+d2+" "+d3+" "+d4); 
    						m2.setTextColor(Color.BLACK);
    						m2.setFontSize("1.4em");
    						m2.setTextAlign(TextAlign.RIGHT);
    						MaterialLabel m3=new MaterialLabel("Time: "+t1+" "+t2); 
    						m3.setTextColor(Color.BLACK);
    						m3.setFontSize("1.4em");
    						m3.setTextAlign(TextAlign.RIGHT);
    						mci.add(m1);
    						mci.add(m2);
    						mci.add(m3);
    						Singleton.getInstance().getRequest().mc.add(mci);
    						mci.addClickHandler(new ClickHandler() {
    							
    							@Override
    							public void onClick(ClickEvent event) {
    								// TODO Auto-generated method stub
    								String c_id=m1.getText();
    								String na[]=new String[2];
    								na=c_id.split("\\s");
    								
    								Details d=new Details();
    								a2.cdet(d, na[0], new AsyncCallback<Details>() {
    									
    									@Override
    									public void onSuccess(Details result) {
    										// TODO Auto-generated method stub
    										Singleton.getInstance().getCustomerDetails().name.setText(result.getName());
    										Singleton.getInstance().getCustomerDetails().add.setText(result.getAddress());
    										Singleton.getInstance().getCustomerDetails().mob.setText(result.getMobile());
    										Singleton.getInstance().getCustomerDetails().email.setText(result.getEmail());
    									}
    									
    									@Override
    									public void onFailure(Throwable caught) {
    										// TODO Auto-generated method stub
    										Window.alert(caught.getMessage());
    									}
    								});
    								Singleton.getInstance().cid=na[0];
    								Singleton.getInstance().sid=sid;
    								History.newItem("bb");
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
    	Singleton.getInstance().id=sid;
		History.newItem("ll");
		Singleton.getInstance().function();
    }
    
    @UiHandler("b1")
    void onClick1(ClickEvent e)
    {
    	
    	Singleton.getInstance().id=sid;
		History.newItem("mm");
		Singleton.getInstance().function();
    }
    
    @UiHandler("b2")
    void onClick2(ClickEvent e)
    {
    
    	Singleton.getInstance().id=sid;
		History.newItem("jj");
		Singleton.getInstance().function();
    }
    
    @UiHandler("b3")
    void onClick3(ClickEvent e)
    {
    	
    	History.replaceItem("historyToken");
		History.newItem("gg");
		Singleton.getInstance().function();
    }
    

}