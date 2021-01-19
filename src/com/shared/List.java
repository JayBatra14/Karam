package com.shared;

import java.io.Serializable;

public class List implements Serializable {
	int n;
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public String[] getL() {
		return L;
	}
	public void setL(String[] l) {
		this.L = l;
	}
	String L[]=new String[n];
	String date[]=new String[n];
	String time[]=new String[n];
	String status[]=new String[n];
	public String[] getDate() {
		return date;
	}
	public void setDate(String[] date) {
		this.date = date;
	}
	public String[] getTime() {
		return time;
	}
	public void setTime(String[] time) {
		this.time = time;
	}
	public String[] getStatus() {
		return status;
	}
	public void setStatus(String[] status) {
		this.status = status;
	}

}
