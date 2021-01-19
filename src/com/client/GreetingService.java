package com.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.shared.Details;
import com.shared.List;

import com.shared.addplan;
import com.shared.logindetails;
import com.shared.registration;


@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {

	String login(logindetails c) throws IllegalArgumentException;
	String logind(logindetails s) throws IllegalArgumentException;
	String registrations(registration ss) throws IllegalArgumentException;
	String registrationc(registration cr) throws IllegalArgumentException;
	String add(addplan ap) throws IllegalArgumentException;
	List lists(String Ser) throws IllegalArgumentException;
	Details sdet(Details d,String s_id) throws IllegalArgumentException;
	String name(String id) throws IllegalArgumentException;
	Details charges(Details d,String s_id) throws IllegalArgumentException;
	List clists(String sid) throws IllegalArgumentException;
	String cname(String cid) throws IllegalArgumentException;
	Details cdet(Details d,String c_id) throws IllegalArgumentException;
	String image(String s) throws IllegalArgumentException;
	String show(String s) throws IllegalArgumentException;
	String book(Details d) throws IllegalArgumentException;
	String status(String cid,String sid,String q) throws IllegalArgumentException;
	List appcan(String c_id) throws IllegalArgumentException; 
	String del(String cid,String sid) throws IllegalArgumentException;
	String ac(String cid,String sid,String date,String time,String status) throws IllegalArgumentException;
	List cac(String cid,String q) throws IllegalArgumentException;
    List sac(String sid,String q) throws IllegalArgumentException;
}
