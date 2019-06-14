package com.gxuwz.volunteer.bean.entity;

public class Vouser {
	private String vouserID;
	private String vouserName;
	private String password;
	private String depID;
	public Vouser(){
		
	}
	public String getVouserID() {
		return vouserID;
	}
	public void setVouserID(String vouserID) {
		this.vouserID = vouserID;
	}
	public String getVouserName() {
		return vouserName;
	}
	public void setVouserName(String vouserName) {
		this.vouserName = vouserName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepID() {
		return depID;
	}
	public void setDepID(String depID) {
		this.depID = depID;
	}
	
}
