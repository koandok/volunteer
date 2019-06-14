package com.gxuwz.volunteer.bean.manager;
import com.gxuwz.volunteer.bean.entity.*;
import com.gxuwz.volunteer.database.DbUtil;

import java.util.*;
import java.sql.*;
public class UserManager {
	private DbUtil dbUtil =new DbUtil();
	
	
	public int edit(User user)throws Exception{
		try {
			String sql = "update sys_user set fullname = ?,password=?,telephone=? WHERE userid=?";
			Object params[] = new Object [4];
			params[0] = user.getFullname();
			params[1] = user.getPassword();
			params[2] = user.getTelephone();
			params[3] = user.getUserid();
		    int count = dbUtil.executeUpate(sql, params);
		    return count;
		       }catch(Exception e){
		       e.printStackTrace();
		       throw e;
		       }
	}
	
	public User findAllbyID(String ID)throws Exception{
		try {
			String sql = "select * sys_user from  WHERE userid='"+ID+"'";
			
		    ResultSet rs = dbUtil.executeQuery(sql, null);
		    User user =new User();
		    while(rs.next()){
		    	user.setFullname(rs.getString("fullname"));
		    	user.setPassword(rs.getString("password"));
		    	user.setTelephone(rs.getString("telephone"));
		    	user.setUserid(rs.getString("userid"));
		    }
		    return user;
		       }catch(Exception e){
		       e.printStackTrace();
		       throw e;
		       }
	}
}
