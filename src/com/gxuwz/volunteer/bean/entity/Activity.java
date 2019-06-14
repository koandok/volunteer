package com.gxuwz.volunteer.bean.entity;

import java.util.*;

public class Activity {
	private String actID;
	private String actName;
	private String content;
	private String vouserID;
	private int peopleNum;
	private Date actBegin; 
	private Date actEnd;
	private Date joinBegin;
	private Date joinEnd;
	public Activity(){
		
	}
	public String getActID() {
		return actID;
	}
	public void setActID(String actID) {
		this.actID = actID;
	}
	public String getActName() {
		return actName;
	}
	public void setActName(String actName) {
		this.actName = actName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getVouserID() {
		return vouserID;
	}
	public void setVouserID(String vouserID) {
		this.vouserID = vouserID;
	}
	public int getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}
	public Date getActBegin() {
		return actBegin;
	}
	public void setActBegin(Date actBegin) {
		this.actBegin = actBegin;
	}
	public Date getActEnd() {
		return actEnd;
	}
	public void setActEnd(Date actEnd) {
		this.actEnd = actEnd;
	}
	public Date getJoinBegin() {
		return joinBegin;
	}
	public void setJoinBegin(Date joinBegin) {
		this.joinBegin = joinBegin;
	}
	public Date getJoinEnd() {
		return joinEnd;
	}
	public void setJoinEnd(Date joinEnd) {
		this.joinEnd = joinEnd;
	}
	
}
