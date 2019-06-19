package com.gxuwz.volunteer.bean.manager;

import java.sql.*;

import com.gxuwz.volunteer.database.DbUtil;

public class LoginManager {
	private DbUtil dbUtil =new DbUtil();

	public boolean userlogin(String name, String password) throws Exception {
			boolean a = false;
			String sql = "select * from user where userID = '"+name+"'and password = '"+password+"'";
			ResultSet rs = dbUtil.executeQuery(sql, null);
			if(rs.next()){
				a = true;
			}
			return a;
	}

	public boolean vologin(String name, String password) throws Exception {
		boolean a = false;
		String sql = "select * from volunteer where voID = '"+name+"'and password = '"+password+"'";
		ResultSet rs = dbUtil.executeQuery(sql, null);
		if(rs.next()){
			a = true;
		}
		return a;
	}

	public boolean vouserlogin(String name, String password) throws Exception {
		boolean a = false;
		String sql = "select * from vouser where vouserID = '"+name+"'and password = '"+password+"'";
		ResultSet rs = dbUtil.executeQuery(sql, null);
		if(rs.next()){
			a = true;
		}
		return a;
	}
}
