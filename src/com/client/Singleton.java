package com.client;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class Singleton {
    String id;
    String ser;
    String cid;
    String sid; 
    FileUpload up;
	static Singleton sn=null;
	Customer c=null;
	CustomerDetails cd=null;
	CustomerPortal cp=null;
	CustSearchList csl=null;
	CustServiceHistory csh=null;
	CustServiceStatus css=null;
	Home h=null;
	LabourPortal lp=null;
	Login l=null;
	Plan p=null;
	Registration r=null;
	Request rt=null;
	Response rp=null;
	Skillmen s=null;
	SkillmenDetails sd=null;
	private Singleton()
	{
	}
	static Singleton getInstance()
	{
		if(sn==null)
		{
			sn=new Singleton();
		}
		return sn;
	}
	public void function()
	{
		 if(History.getToken().contentEquals("aa"))
			{
				RootPanel.get().clear();
				RootPanel.get().add(getCustomer());
			}
			else if(History.getToken().contentEquals("bb"))
			{
				RootPanel.get().clear();
				RootPanel.get().add(getCustomerDetails());
			}
			else if(History.getToken().contentEquals("cc"))
			{
				RootPanel.get().clear();
				RootPanel.get().add(getCustomerPortal());
			}
			else if(History.getToken().contentEquals("dd"))
			{
				RootPanel.get().clear();
				RootPanel.get().add(getCustSearchList());
			}
			else if(History.getToken().contentEquals("ee"))
			{
				RootPanel.get().clear();
				RootPanel.get().add(getCustServiceHistory());
			}
			else if(History.getToken().contentEquals("ff"))
			{
				RootPanel.get().clear();
				RootPanel.get().add(getCustServiceStatus());
			}
			else if(History.getToken().contentEquals("gg"))
			{
				RootPanel.get().clear();
				RootPanel.get().add(getHome().header);
				RootPanel.get().add(getHome());
			}
			else if(History.getToken().contentEquals("hh"))
			{
				RootPanel.get().clear();
				RootPanel.get().add(getLabourPortal());
			}
			else if(History.getToken().contentEquals("ii"))
			{
				RootPanel.get().clear();
				RootPanel.get().add(getHome().header);
				RootPanel.get().add(getLogin());
			}
			else if(History.getToken().contentEquals("jj"))
			{
				RootPanel.get().clear();
				RootPanel.get().add(getPlan());
			}
			else if(History.getToken().contentEquals("kk"))
			{
				RootPanel.get().clear();
				RootPanel.get().add(getHome().header);
				RootPanel.get().add(getRegistration());
			}
			else if(History.getToken().contentEquals("ll"))
			{
				RootPanel.get().clear();
				RootPanel.get().add(getRequest());
			}
			else if(History.getToken().contentEquals("mm"))
			{
				RootPanel.get().clear();
				RootPanel.get().add(getResponse());
			}
			else if(History.getToken().contentEquals("nn"))
			{
				RootPanel.get().clear();
				RootPanel.get().add(getSkillmen());
			}
			else if(History.getToken().contentEquals("oo"))
			{
				RootPanel.get().clear();
				RootPanel.get().add(getSkillmenDetails());
			}
	}
	SkillmenDetails getSkillmenDetails() {
		// TODO Auto-generated method stub
		if(sd==null)
		{
			sd=new SkillmenDetails(cid,sid);
		}
		return sd;
	}
	Skillmen getSkillmen() {
		// TODO Auto-generated method stub
		if(s==null)
		{
			s=new Skillmen();
		}
		return s;
	}
	Response getResponse() {
		// TODO Auto-generated method stub
		if(rp==null)
		{
			rp=new Response(id);
		}
		return rp;
	}
	Request getRequest() {
		// TODO Auto-generated method stub
		if(rt==null)
		{
			rt=new Request(id);
		}
		return rt;
	}
	Registration getRegistration() {
		// TODO Auto-generated method stub
		if(r==null)
		{
			r=new Registration();
		}
		return r;
	}
	Plan getPlan() {
		// TODO Auto-generated method stub
		if(p==null)
		{
			p=new Plan(id);
		}
		return p;
	}
	Login getLogin() {
		// TODO Auto-generated method stub
		if(l==null)
		{
			l=new Login();
		}
		return l;
	}
	LabourPortal getLabourPortal() {
		// TODO Auto-generated method stub
		if(lp==null)
		{
			lp=new LabourPortal(id);
		}
		return lp;
	}
	Home getHome() {
		// TODO Auto-generated method stub
		if(h==null)
		{
			h=new Home();
		}
		return h;
	}
	CustServiceStatus getCustServiceStatus() {
		// TODO Auto-generated method stub
		if(css==null)
		{
			css=new CustServiceStatus(id);
		}
		return css;
		
	}
	CustServiceHistory getCustServiceHistory() {
		// TODO Auto-generated method stub
		if(csh==null)
		{
			csh=new CustServiceHistory(id);
		}
		
		return csh;
	}
	CustSearchList getCustSearchList() {
		// TODO Auto-generated method stub
		if(csl==null)
		{
			csl=new CustSearchList(id,ser);
		}
		return csl;
	}
	CustomerPortal getCustomerPortal() {
		// TODO Auto-generated method stub
		if(cp==null)
		{
			cp=new CustomerPortal(id);
		}
		return cp;
	}
	CustomerDetails getCustomerDetails() {
		// TODO Auto-generated method stub
		if(cd==null)
		{
			cd=new CustomerDetails(cid,sid);
		}	
		return cd;
	}
	Customer getCustomer() {
		// TODO Auto-generated method stub
		if(c==null)
		{
			c=new Customer();
		}
		return c;
	}
	
	
	
}
