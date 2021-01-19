package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shared.List;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialCollection;
import gwt.material.design.client.ui.MaterialCollectionItem;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;

public class CustServiceStatus extends Composite{

	private static CustServiceStatusUiBinder uiBinder = GWT.create(CustServiceStatusUiBinder.class);

	interface CustServiceStatusUiBinder extends UiBinder<Widget, CustServiceStatus> {
	}
String cid="";
	public CustServiceStatus() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	

	public CustServiceStatus(String cid) {
		initWidget(uiBinder.createAndBindUi(this));
		this.cid=cid;
	}
@UiField 
MaterialCollection mc,mc1;

@UiField
MaterialLink app,can;

private final GreetingServiceAsync a2 = GWT.create(GreetingService.class);

@UiHandler("app")
void onClick(ClickEvent e)
{
	String q="Approved"; 
	a2.cac(cid,q, new AsyncCallback<List>() {
		
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
			mc.clear(); 
			for(int i=0;i<n;i++)
			{
				String b=a[i]; 
				String date=d[i];
				String time=t[i];
			    a2.name(a[i], new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						String id=b;
						MaterialCollectionItem mci=new MaterialCollectionItem();  
						MaterialCollectionItem mcii=new MaterialCollectionItem(); 
						mcii.setBackgroundColor(Color.GREEN_ACCENT_3);
						mci.setBackgroundColor(Color.WHITE); 
						//mci.setWaves(WavesType.GREEN); 
						MaterialLabel m1=new MaterialLabel(id+" "+result); 
						m1.setTextColor(Color.BLACK); 
						m1.setFontSize("1.4em");
						MaterialLabel m2=new MaterialLabel("Date: "+date); 
						m2.setTextColor(Color.BLACK);
						m2.setFontSize("1.4em");
						m2.setTextAlign(TextAlign.RIGHT);
						MaterialLabel m3=new MaterialLabel("Time: "+time); 
						m3.setTextColor(Color.BLACK);
						m3.setFontSize("1.4em");
						m3.setTextAlign(TextAlign.RIGHT);
						mci.add(m1);
						mci.add(m2);
						mci.add(m3); 
						mc.add(mci); 
						mc.add(mcii); 
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
}

@UiHandler("can")
void onClick1(ClickEvent e)
{
	String q="Cancelled";
	a2.cac(cid,q, new AsyncCallback<List>() {
		
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
			mc1.clear(); 
			for(int i=0;i<n;i++)
			{
				String b=a[i]; 
				String date=d[i];
				String time=t[i];
			    a2.name(a[i], new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						String id=b;
						MaterialCollectionItem mci=new MaterialCollectionItem();
						mci.setWaves(WavesType.GREEN);
						MaterialLabel m1=new MaterialLabel(id+" "+result); 
						m1.setTextColor(Color.BLACK); 
						m1.setFontSize("1.4em");
						MaterialLabel m2=new MaterialLabel("Date: "+date); 
						m2.setTextColor(Color.BLACK);
						m2.setFontSize("1.4em");
						m2.setTextAlign(TextAlign.RIGHT);
						MaterialLabel m3=new MaterialLabel("Time: "+time); 
						m3.setTextColor(Color.BLACK);
						m3.setFontSize("1.4em");
						m3.setTextAlign(TextAlign.RIGHT);
						mci.add(m1);
						mci.add(m2);
						mci.add(m3); 
						mc1.add(mci);
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
}

}
