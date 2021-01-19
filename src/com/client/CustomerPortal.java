package com.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shared.Details;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCollectionItem;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialDropDown;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialToast;

public class CustomerPortal extends Composite{

	private static final String MaterialLink = null;
	private static CustomerPortalUiBinder uiBinder = GWT.create(CustomerPortalUiBinder.class);

	interface CustomerPortalUiBinder extends UiBinder<Widget, CustomerPortal> {
	}

	public CustomerPortal(String id) {
		initWidget(uiBinder.createAndBindUi(this));
		this.cid=id;  
		
	}

	
   public CustomerPortal() {
		// TODO Auto-generated constructor stub
	   initWidget(uiBinder.createAndBindUi(this));
	}


String cid; 

	@UiField
    MaterialColumn status,history,logout;
	@UiField
	MaterialListBox search;
	@UiField
	MaterialButton b; 
	
	
	private final GreetingServiceAsync a2 = GWT.create(GreetingService.class);

    
	
	@UiHandler("b")
		   void onClick3(ClickEvent e) {
		        String ser=search.getSelectedValue();
		        /*CustSearchList csl = new CustSearchList(id,ser);
				RootPanel.get().clear();
				RootPanel.get().add(csl);*/
				a2.lists(ser, new AsyncCallback<com.shared.List>() {
					
					@Override
					public void onSuccess(com.shared.List result) {
						// TODO Auto-generated method stub
						int n=result.getN();
						String a[]=new String[n];
						a=result.getL(); 
						Singleton.getInstance().getCustSearchList().mc.clear();
						for(int i=0;i<n;i++)
						{
						    String b=a[i];
							a2.name(a[i], new AsyncCallback<String>() {
								
								@Override
								public void onSuccess(String result) {
									// TODO Auto-generated method stub
									String id=b; 
									MaterialCollectionItem mci=new MaterialCollectionItem(); 
									MaterialCollectionItem mcii=new MaterialCollectionItem();
									//mci.setBackgroundColor(Color.GREEN_DARKEN_1); 
									mci.setWaves(WavesType.GREEN); 
									mci.setPaddingTop(20.0);
									mci.setPaddingBottom(20.0);
									mcii.setBackgroundColor(Color.GREEN_ACCENT_3);
									MaterialLabel m1=new MaterialLabel(id+" "+result); 
									m1.setTextColor(Color.BLACK); 
									m1.setFontSize("1.4em");
									mci.add(m1);
									Singleton.getInstance().getCustSearchList().mc.add(mci); 
									Singleton.getInstance().getCustSearchList().mc.add(mcii);
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
											Singleton.getInstance().cid=cid;
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
		        Singleton.getInstance().id=cid;
		        Singleton.getInstance().ser=ser;
				History.newItem("dd");
				Singleton.getInstance().function();
		   }
	
    @UiHandler("status")
    void onClick(ClickEvent e) {
    	
    	/*CustServiceStatus css = new CustServiceStatus(id);
		RootPanel.get().clear();
		RootPanel.get().add(css);*/
		Singleton.getInstance().id=cid;
		History.newItem("ff");
		Singleton.getInstance().function();
	}
    
    @UiHandler("history")
    void onClick1(ClickEvent e)
    {   
    	/*CustServiceHistory csh = new CustServiceHistory();
    	RootPanel.get().clear();
    	RootPanel.get().add(csh);*/
    	a2.appcan(cid, new AsyncCallback<com.shared.List>() {
			
			@Override
			public void onSuccess(com.shared.List result) {
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
				Singleton.getInstance().getCustServiceHistory().mc.clear();
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
							MaterialLabel m4=new MaterialLabel("Status: "+s); 
							m4.setTextColor(Color.BLACK);
							m4.setFontSize("1.4em");
							MaterialButton b1=new MaterialButton();
							b1.setText("Save to history"); 
							b1.setTextColor(Color.WHITE); 
							b1.setBackgroundColor(Color.GREEN_DARKEN_1);  
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
											History.newItem("cc");
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
							Singleton.getInstance().getCustServiceHistory().mc.add(mci);
							
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
    	Singleton.getInstance().id=cid;
    	History.newItem("ee");
		Singleton.getInstance().function();
    }
    
    @UiHandler("logout")
    void onClick2(ClickEvent e)
    {   /*Home h = new Home();
    	RootPanel.get().clear();
    	RootPanel.get().add(h);*/ 
    	
    	History.replaceItem("historyToken");
    	History.newItem("ii");
		Singleton.getInstance().function();
    	}


 
    

	

}
