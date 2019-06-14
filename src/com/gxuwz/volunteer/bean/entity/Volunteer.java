package com.gxuwz.volunteer.bean.entity;

import java.util.Date;

public class Volunteer {
	private String voID;
	private String classID;
	private String voName;
	private String telephone;
	private String password;
	private String depID;
	private String email;
	private Date joinTime;
	public Volunteer(){
		
	}
	public String getVoID() {
		return voID;
	}
	public void setVoID(String voID) {
		this.voID = voID;
	}
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public String getVoName() {
		return voName;
	}
	public void setVoName(String voName) {
		this.voName = voName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	
}
