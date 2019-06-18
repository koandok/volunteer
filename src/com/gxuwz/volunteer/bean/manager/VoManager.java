package com.gxuwz.volunteer.bean.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.volunteer.bean.entity.*;
import com.gxuwz.volunteer.database.DbUtil;

public class VoManager {
	private DbUtil dbUtil =new DbUtil();
	
	
	public List<Volunteer> findAll(String keywords) throws Exception{
		List<Volunteer> voList = new ArrayList<Volunteer>();
		String sql = "select * from volunteer where 1=1";
			  if(keywords!=null){
			   sql="select * from volunteer where voID like '%"+keywords+"%'  ";
		      }
		ResultSet rs = dbUtil.executeQuery(sql, null);
		while(rs.next()){
			Volunteer vo = new Volunteer();
			vo.setClassID(rs.getString("classID"));
			vo.setDepID(rs.getString("depID"));	
			vo.setEmail(rs.getString("email"));
			vo.setJoinTime(rs.getDate("joinTime"));
			vo.setPassword(rs.getString("password"));
			vo.setTelephone(rs.getString("telephone"));
			vo.setVoID(rs.getString("voID"));
			vo.setVoName(rs.getString("voName"));	
			voList.add(vo);
		}
		return voList;
	}
	
	public Volunteer findAllbyID(String ID)throws Exception{
		try {
			String sql = "select *  from volunteer WHERE voID='"+ID+"'";
			
		    ResultSet rs = dbUtil.executeQuery(sql, null);
		    Volunteer vo = new Volunteer();
		    while(rs.next()){
				vo.setClassID(rs.getString("classID"));
				vo.setDepID(rs.getString("depID"));	
				vo.setEmail(rs.getString("email"));
				vo.setJoinTime(rs.getDate("joinTime"));
				vo.setPassword(rs.getString("password"));
				vo.setTelephone(rs.getString("telephone"));
				vo.setVoID(rs.getString("voID"));
				vo.setVoName(rs.getString("voName"));	
		    }
		    return vo;
		       }catch(SQLException e){
		       e.printStackTrace();
		       throw e;
		       }
	}
	
	public int edit(Volunteer vo)throws Exception{
		try {
			String sql = "update volunteer set voName=?,classID=?, telephone=?,password=?,depID=?,email=? WHERE voID=?";
			Object params[] = new Object [7];
			params[0] = vo.getVoName();
			params[1] = vo.getClassID();
			params[2] = vo.getTelephone();
			params[3] = vo.getPassword();
			params[4] = vo.getDepID();
			params[5] = vo.getEmail();
			params[6] = vo.getVoID();
		    int count = dbUtil.executeUpate(sql, params);
		    return count;
		       }catch(Exception e){
		       e.printStackTrace();
		       throw e;
		       }
	}
	
	public int del(Volunteer vo)throws Exception{
		try {
			String sql = "delete from volunteer where voID=?";
			Object params[] = new Object [1];
			params[0] = vo.getVoID();

		    int count = dbUtil.executeUpate(sql, params);
		    return count;
		       }catch(Exception e){
		       e.printStackTrace();
		       throw e;
		       }
	}
	
	public int add(Volunteer vo)throws Exception{
		try {
			String sql = "insert into volunteer(voName,classID,telephone,password,depID,email,voID,joinTime)values(?,?,?,?,?,?,?,?)";
			Object params[] = new Object [8];
			params[0] = vo.getVoName();
			params[1] = vo.getClassID();
			params[2] = vo.getTelephone();
			params[3] = vo.getPassword();
			params[4] = vo.getDepID();
			params[5] = vo.getEmail();
			params[6] = vo.getVoID();
			params[7] = vo.getJoinTime();
		    int count = dbUtil.executeUpate(sql, params);
		    return count;
		       }catch(Exception e){
		       e.printStackTrace();
		       throw e;
		       }
	}
}