package com.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.validation.constraints.Null;

import com.client.GreetingService;
import com.shared.Details;
import com.shared.FieldVerifier;
import com.shared.List;

import com.shared.addplan;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.shared.logindetails;
import com.shared.registration;

import gwt.material.design.client.ui.MaterialToast;

@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
    GreetingService {
	private static String u=null;
	private static String p=null;
	private static String name=null;
	private static String add=null;
	private static String mob=null;
	private static String aadhar=null;
	private static String gen=null;
	private static String city=null;
	private static String state=null;
	private static String dis=null;
	private static String mc=null;
	private static String uc=null;
	private static String s=null;
	private static String id=null;
	
	
Connection con = null;
Statement st = null;

  public void init() {
	  
    try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
    try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/karam","root","");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    try {
		st=con.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }

@Override
public  String login(logindetails c)throws IllegalArgumentException {
	// TODO Auto-generated method stub
	init();
	ResultSet rs=null;
	String ss ="NO";
     u = c.getUsername();
	 p = c.getPassword();
	 id = c.getId();	
	try {
		rs=st.executeQuery("select * from customer where mob_no='"+u+"' and password='"+p+"'");
		if(rs.next())
			ss="success";
		if(ss=="success") {
			rs=st.executeQuery("select c_id from customer where mob_no='"+u+"' and password='"+p+"'  ");
			if(rs.next())
				{c.setId(rs.getString(1));
			    ss=c.getId();}
		}
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return ss;
}

@Override
public  String logind(logindetails s)throws IllegalArgumentException {
	// TODO Auto-generated method stub
	init();
	ResultSet rs=null;
	String ss ="NO";
     u = s.getUsername();
	 p = s.getPassword();
	 id = s.getId();	
	try {
		rs=st.executeQuery("select * from  skillmen where mob_no='"+u+"' and password='"+p+"'");
		if(rs.next())
			ss="success";
		if(ss=="success") {
			rs=st.executeQuery("select s_id from skillmen where mob_no='"+u+"' and password='"+p+"'  ");
			if(rs.next())
				{s.setId(rs.getString(1));
			    ss=s.getId();}
		}
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return ss;
}

@Override
public String registrations(registration ss) throws IllegalArgumentException {
	// TODO Auto-generated method stub
	init();
	ResultSet rs=null;
	String r ="NO";
	name=ss.getName();
	add=ss.getAddress();
	mob=ss.getMob();
	aadhar=ss.getAadhar();
	gen=ss.getGender();
	city=ss.getCity();
	dis=ss.getDistrict();
	state=ss.getState();
	u=ss.getUsername();
	p=ss.getPassword();
	String sql="INSERT INTO skillmen(name,address,mob_no,aadhar,gender,city,district,state,email,password)VALUES('"+name+"','"+add+"','"+mob+"','"+aadhar+"','"+gen+"','"+city+"','"+dis+"','"+state+"','"+u+"','"+p+"')";
	try {
		st.executeUpdate(sql);
		return "success";
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
        }
	return r;
}
@Override
public String registrationc(registration cr) throws IllegalArgumentException {
	// TODO Auto-generated method stub
	init();

	String r ="NO";
	name=cr.getName();
	add=cr.getAddress();
	mob=cr.getMob();
	aadhar=cr.getAadhar();
	gen=cr.getGender();
	city=cr.getCity();
	dis=cr.getDistrict();
	state=cr.getState();
	u=cr.getUsername();
	p=cr.getPassword();
	String sql="INSERT INTO customer(name,address,mob_no,aadhar,gender,city,district,state,email,password)VALUES('"+name+"','"+add+"','"+mob+"','"+aadhar+"','"+gen+"','"+city+"','"+dis+"','"+state+"','"+u+"','"+p+"')";
	try {
		st.executeUpdate(sql);
		r = "success";
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
        }
	return r;
}

@Override
public String add(addplan ap) throws IllegalArgumentException {
	// TODO Auto-generated method stub
	init();
	String q="NO";
	mc=ap.getMc();
	uc=ap.getUc();
	s=ap.getS();
	id=ap.getId();
	String sql="INSERT INTO plan(s_id,minimum_charges,urgent_charges,service)VALUES('"+id+"','"+mc+"','"+uc+"','"+s+"')";

	try {
		st.executeUpdate(sql);
		q="success";
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return q;
}

@Override
public List lists(String Ser) throws IllegalArgumentException {
	// TODO Auto-generated method stub
	init();
	ResultSet rs=null;
	
	int n;
	List l= new List();
	int i=0;
	try {
		rs=st.executeQuery("select s_id from plan where service= '"+Ser+"'");
		rs.last();
		n=rs.getRow();
		rs.beforeFirst();
		String a[]= new String[n];
		while(rs.next())
		{
			a[i]=rs.getString(1);
			i++;
		}

		l.setN(n);
		l.setL(a);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return l;
}

@Override
public Details sdet(Details d, String s_id) throws IllegalArgumentException {
	// TODO Auto-generated method stub
	init();
	ResultSet rs=null;
	try {
		rs=st.executeQuery("select name,address,mob_no,email from skillmen where s_id='"+s_id+"'");
		if(rs.next())
		{
			d.setName(rs.getString(1));
			d.setAddress(rs.getString(2));
			d.setMobile(rs.getString(3));
			d.setEmail(rs.getString(4));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return d;
}

@Override
public String name(String id) throws IllegalArgumentException {
	// TODO Auto-generated method stub
	init();
	ResultSet rs=null;
	String S="";
	try {
		rs=st.executeQuery("select name from skillmen where s_id='"+id+"'");
		if(rs.next())
		{
			S=rs.getString(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return S;
}

@Override
public Details charges(Details d, String s_id) throws IllegalArgumentException {
	// TODO Auto-generated method stub
	init();
	ResultSet rs= null;
	try {
		rs=st.executeQuery("select minimum_charges,urgent_charges from plan where s_id='"+s_id+"'");
		if(rs.next())
		{
			d.setMc(rs.getString(1));
			d.setUc(rs.getString(2));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return d;
}


@Override
public List clists(String sid) throws IllegalArgumentException {
	// TODO Auto-generated method stub
	init();
	ResultSet rs=null;
	int n;
	List l=new List();
	int i=0;
	try {
		rs=st.executeQuery("select c_id,date,time from book where s_id= '"+sid+"'");
		rs.last();
		n=rs.getRow();
		rs.beforeFirst();
		String a[]=new String[n]; 
		String d[]=new String[n];
		String t[]=new String[n];
		while(rs.next())
		{
			a[i]=rs.getString(1);
			d[i]=rs.getString(2);
			t[i]=rs.getString(3);
			i++;
		}
		l.setL(a); 
		l.setDate(d);
		l.setTime(t);
		l.setN(n);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return l;
}

@Override
public String cname(String cid) throws IllegalArgumentException {
	// TODO Auto-generated method stub
	init();
	ResultSet rs=null;
	String S="";
	try {
		rs=st.executeQuery("select name from customer where c_id='"+cid+"'");
		if(rs.next())
		{
			S=rs.getString(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return S;
}

@Override
public Details cdet(Details d, String c_id) throws IllegalArgumentException {
	// TODO Auto-generated method stub
	init();
	ResultSet rs=null;
	try {
		rs=st.executeQuery("select name,address,mob_no,email from customer where c_id='"+c_id+"'");
		if(rs.next())
		{
			d.setName(rs.getString(1));
			d.setAddress(rs.getString(2));
			d.setMobile(rs.getString(3));
			d.setEmail(rs.getString(4));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return d;
}


@Override
public String image(String s) throws IllegalArgumentException {
	// TODO Auto-generated method stub
	init();
	String q="";
	try {
		st.executeUpdate("INSERT INTO image(id,i)values('2','"+s+"')");
		q="Success";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return q;
}

@Override
public String show(String s) throws IllegalArgumentException {
	// TODO Auto-generated method stub
	init();
	ResultSet rs=null;
	String q="";
    try {
		rs=st.executeQuery("select i from image where id='2'");
		if(rs.next())
		{
			q=rs.getString(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return q;
}

@Override
public String book(Details d) throws IllegalArgumentException {
	// TODO Auto-generated method stub
	init();
	String q="";
	try {
		st.executeUpdate("INSERT INTO book(c_id,s_id,date,time)values('"+d.getCid()+"','"+d.getSid()+"','"+d.getDate()+"','"+d.getTime()+"')");
		q="Booking Successfull";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return q;
}

@Override
public String status(String cid, String sid, String q) throws IllegalArgumentException {
	// TODO Auto-generated method stub
	init();
	String s="";
	if(q.equals("Approved")) 
	{
		try {
			st.executeUpdate("update book set status='"+q+"' where c_id='"+cid+"'and s_id='"+sid+"'");
			s="Approved";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	else
	{
		try {
			st.executeUpdate("update book set status='"+q+"' where c_id='"+cid+"'and s_id='"+sid+"'");
			s="Cancelled";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return s;
}

@Override
public List appcan(String c_id) throws IllegalArgumentException {
	// TODO Auto-generated method stub
	init();
	int n;
	ResultSet rs=null;
	List l= new List();
	int i=0;
	try {
		rs=st.executeQuery("select s_id,date,time,status from book where c_id='"+c_id+"'");
		rs.last();
		n=rs.getRow();
		rs.beforeFirst();
		String a[]=new String[n]; 
		String d[]=new String[n];
		String t[]=new String[n];
		String s[]=new String[n];
		while(rs.next())
		{
			a[i]=rs.getString(1);
			d[i]=rs.getString(2);
			t[i]=rs.getString(3);
			s[i]=rs.getString(4);
			i++;
		}
		l.setL(a);
		l.setDate(d);
		l.setTime(t);
		l.setStatus(s);
		l.setN(n);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return l;
}

@Override
public String del(String cid, String sid) throws IllegalArgumentException {
	// TODO Auto-generated method stub 
	init();
	String s="";
	try {
		st.executeUpdate("delete from book where c_id='"+cid+"'and s_id='"+sid+"'"); 
		s="Saved to history";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return s;
}

@Override
public String ac(String cid, String sid, String date, String time, String status) throws IllegalArgumentException {
	// TODO Auto-generated method stub 
	init();
	try {
		st.executeUpdate("INSERT INTO appcan(c_id,s_id,date,time,status)values('"+cid+"','"+sid+"','"+date+"','"+time+"','"+status+"')");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

@Override
public List cac(String cid, String q) throws IllegalArgumentException {
	// TODO Auto-generated method stub 
	init();
	int n;
	ResultSet rs=null;
	List l= new List();
	int i=0;
	if(q.equals("Approved"))
	{
		try {
			rs=st.executeQuery("select s_id,date,time from appcan where c_id='"+cid+"' and status='"+q+"'");
			rs.last();
			n=rs.getRow();
			rs.beforeFirst();
			String a[]=new String[n]; 
			String d[]=new String[n];
			String t[]=new String[n];
			while(rs.next())
			{
				a[i]=rs.getString(1);
				d[i]=rs.getString(2);
				t[i]=rs.getString(3);
				i++;
			}
			l.setL(a);
			l.setDate(d);
			l.setTime(t);
			l.setN(n);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	else
	{
		try {
			rs=st.executeQuery("select s_id,date,time from appcan where c_id='"+cid+"' and status='"+q+"'");
			rs.last();
			n=rs.getRow();
			rs.beforeFirst();
			String a[]=new String[n]; 
			String d[]=new String[n];
			String t[]=new String[n];
			while(rs.next())
			{
				a[i]=rs.getString(1);
				d[i]=rs.getString(2);
				t[i]=rs.getString(3);
				i++;
			}
			l.setL(a);
			l.setDate(d);
			l.setTime(t);
			l.setN(n);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return l;
}

@Override
public List sac(String sid, String q) throws IllegalArgumentException {
	// TODO Auto-generated method stub 
	init();
	int n;
	ResultSet rs=null;
	List l= new List();
	int i=0;
	if(q.equals("Approved"))
	{
		try {
			rs=st.executeQuery("select c_id,date,time from appcan where s_id='"+sid+"' and status='"+q+"'");
			rs.last();
			n=rs.getRow();
			rs.beforeFirst();
			String a[]=new String[n]; 
			String d[]=new String[n];
			String t[]=new String[n];
			while(rs.next())
			{
				a[i]=rs.getString(1);
				d[i]=rs.getString(2);
				t[i]=rs.getString(3);
				i++;
			}
			l.setL(a);
			l.setDate(d);
			l.setTime(t);
			l.setN(n);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	else
	{
		try {
			rs=st.executeQuery("select c_id,date,time from appcan where s_id='"+sid+"' and status='"+q+"'");
			rs.last();
			n=rs.getRow();
			rs.beforeFirst();
			String a[]=new String[n]; 
			String d[]=new String[n];
			String t[]=new String[n];
			while(rs.next())
			{
				a[i]=rs.getString(1);
				d[i]=rs.getString(2);
				t[i]=rs.getString(3);
				i++;
			}
			l.setL(a);
			l.setDate(d);
			l.setTime(t);
			l.setN(n);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return l;
}




}
