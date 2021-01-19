package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.BorderStyle;
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
import com.shared.List;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.Position;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCollection;
import gwt.material.design.client.ui.MaterialCollectionItem;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;

public class CustServiceHistory extends Composite{

	private static CustServiceHistoryUiBinder uiBinder = GWT.create(CustServiceHistoryUiBinder.class);

	interface CustServiceHistoryUiBinder extends UiBinder<Widget, CustServiceHistory> {
	}
String cid="";
	public CustServiceHistory() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	

	/*@UiField
	Button button;

	public CustServiceHistory(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
		
		      <m:MaterialCollectionItem ui:field="mci" type="AVATAR" dismissible="true">
        <ma:webp.MaterialWebpImage url="skillman.png" fallbackExtension="jpg" type="CIRCLE"/>
        <m:MaterialLabel text="Skillmen 1" fontSize="1.4em"/>
        <m:MaterialLabel text="Brunch this weekend?" fontSize="1.2em"/>
        <m:MaterialLabel text="I'll be in your neighborhood doing errands"/>
      </m:MaterialCollectionItem>  
	}*/

    public CustServiceHistory(String id) {
		// TODO Auto-generated constructor stub
    	initWidget(uiBinder.createAndBindUi(this));
    	this.cid=id;
	}

    @UiField 
    MaterialContainer cc;
    
	@UiField
	MaterialCollection mc; 
	
	
    
   // private final GreetingServiceAsync a2 = GWT.create(GreetingService.class);
    
    /*@UiHandler("show")
    void onClick(ClickEvent e)
    {
    	a2.appcan(cid, new AsyncCallback<List>() {
			
			@Override
			public void onSuccess(List result) {
				// TODO Auto-generated method stub
				int n=result.getN();
				String l[]=new String[n];
				String d[]=new String[n];
				String t[]=new String[n];
				String s[]=new String[n];
				l=result.getL();
				d=result.getDate(); 
				t=result.getTime();
				s=result.getStatus(); 
				mc.clear();
				for(int i=0;i<n;i++)
				{
					String b=l[i];
					String st=s[i];
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
					
                    a2.name(l[0], new AsyncCallback<String>() {
						
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
							String s=st;
							
							MaterialCollectionItem mci=new MaterialCollectionItem();
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
							MaterialLabel m4=new MaterialLabel("Status: "+s); 
							m4.setTextColor(Color.BLACK);
							m4.setFontSize("1.4em");
							MaterialButton b1=new MaterialButton();
							b1.setText("Save to history"); 
							b1.setTextColor(Color.BLACK); 
							b1.setBackgroundColor(Color.YELLOW);  
							b1.addClickHandler(new ClickHandler() {
								
								@Override
								public void onClick(ClickEvent event) {
									// TODO Auto-generated method stub 
									String date=d1+" "+d2+" "+d3+" "+d4;
									String time=t1+" "+t2;
									a2.ac(cid,id, date, time, s, new AsyncCallback<String>() {
										
										@Override
										public void onSuccess(String result) {
											// TODO Auto-generated method stub
											
										}
										
										@Override
										public void onFailure(Throwable caught) {
											// TODO Auto-generated method stub
											Window.alert(caught.getMessage());
										}
									});
									a2.del(cid, id, new AsyncCallback<String>() {
										
										@Override
										public void onSuccess(String result) {
											// TODO Auto-generated method stub
											Window.alert(result); 
											History.replaceItem("historyToken");
											History.newItem("ee");
											Singleton.getInstance().function();
										}
										
										@Override
										public void onFailure(Throwable caught) {
											// TODO Auto-generated method stub
											Window.alert(caught.getMessage());
										}
									});
								}
							});
							mci.add(m1);
							mci.add(m4);
							mci.add(m2);
							mci.add(m3); 
							mci.add(b1);
							mc.add(mci);
							
						}
						
						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							Window.alert(caught.getMessage());
						}
					});
					
				} //hello
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert(caught.getMessage());
			}
		});
    }*/
	

 

}
