package com.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.shared.Details;
import com.shared.List;

import com.shared.addplan;
import com.shared.logindetails;
import com.shared.registration;

public interface GreetingServiceAsync {

	void login(logindetails c, AsyncCallback<String> asyncCallback)  throws IllegalArgumentException;
	void logind(logindetails s, AsyncCallback<String> asyncCallback)  throws IllegalArgumentException;
	void registrations(registration ss, AsyncCallback<String> asyncCallback) throws IllegalArgumentException; 
	void registrationc(registration cr, AsyncCallback<String> asyncCallback) throws IllegalArgumentException;
	void add(addplan ap, AsyncCallback<String> asyncCallback) throws IllegalArgumentException;
	void lists(String Ser, AsyncCallback<List> asyncCallback) throws IllegalArgumentException;
	void sdet(Details d,String s_id, AsyncCallback<Details> asyncCallback) throws IllegalArgumentException;
	void name(String id, AsyncCallback<String> asyncCallback) throws IllegalArgumentException;
	void charges(Details d,String s_id, AsyncCallback<Details> asyncCallback) throws IllegalArgumentException;
	void clists(String sid, AsyncCallback<List> asyncCallback) throws IllegalArgumentException;
	void cname(String cid, AsyncCallback<String> asyncCallback) throws IllegalArgumentException;
	void cdet(Details d,String c_id, AsyncCallback<Details> asyncCallback) throws IllegalArgumentException;
	void image(String s, AsyncCallback<String> callback) throws IllegalArgumentException;
	void show(String s, AsyncCallback<String> callback) throws IllegalArgumentException;
	void book(Details d, AsyncCallback<String> asyncCallback) throws IllegalArgumentException;
	void status(String cid,String sid,String q, AsyncCallback<String> callback) throws IllegalArgumentException;
	void appcan(String c_id, AsyncCallback<List> asyncCallback) throws IllegalArgumentException;
	void del(String cid,String sid, AsyncCallback<String> callback) throws IllegalArgumentException;
	void ac(String cid,String sid,String date,String time,String status, AsyncCallback<String> callback) throws IllegalArgumentException;
	void cac(String cid,String q, AsyncCallback<List> asyncCallback) throws IllegalArgumentException;
	void sac(String sid,String q, AsyncCallback<List> asyncCallback) throws IllegalArgumentException;
}
