package com.gxuwz.volunteer.bean.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.volunteer.bean.entity.*;
import com.gxuwz.volunteer.database.DbUtil;

public class DormManager {
private DbUtil dbUtil =new DbUtil();
	
	public List<Dorm> findAll(String buildID) throws Exception{
		List<Dorm> dormList = new ArrayList<Dorm>();
		String sql = "select * from sys_dorm where buildID='"+buildID+"'";
		ResultSet rs = dbUtil.executeQuery(sql, null);
		while(rs.next()){
			Dorm dorm = new Dorm();
		dorm.setBedID(rs.getString("bedID"));
		dorm.setBuildID(rs.getString("buildID"));
		dorm.setDormID(rs.getString("dormID"));
		dorm.setStuID(rs.getString("stuID"));
		dormList.add(dorm);
		}
		return dormList;
	}
	

	public List<Dorm> Seach(String keywords,String buildID) throws Exception{
		List<Dorm> dormList = new ArrayList<Dorm>();
		String sql = "select * from sys_dorm where buildID='"+buildID+"'";
			  if(keywords!=null){
			   sql="select * from sys_dorm where dormID like '%"+keywords+"%' and buildID='"+buildID+"' ";
		      }
		ResultSet rs = dbUtil.executeQuery(sql, null);
		while(rs.next()){
			Dorm dorm = new Dorm();
			dorm.setBedID(rs.getString("bedID"));
			dorm.setBuildID(rs.getString("buildID"));
			dorm.setDormID(rs.getString("dormID"));
			dorm.setStuID(rs.getString("stuID"));
			dormList.add(dorm);
		}
		return dormList;
	}
	
	public Dorm findAllbyID(String ID,String stuID)throws Exception{
		try {
			String sql = "select *  from sys_dorm WHERE dormID='"+ID+"' and stuID = '"+stuID+"'";
			
		    ResultSet rs = dbUtil.executeQuery(sql, null);
		    Dorm dorm = new Dorm();
		    while(rs.next()){
		    	dorm.setBedID(rs.getString("bedID"));
				dorm.setBuildID(rs.getString("buildID"));
				dorm.setDormID(rs.getString("dormID"));
				dorm.setStuID(rs.getString("stuID"));
		    }
		    return dorm;
		       }catch(SQLException e){
		       e.printStackTrace();
		       throw e;
		       }
	}
	
	public boolean findBedID(String bedID,String dormID)throws Exception{
		try {
			boolean b=true;
			String sql = "select *  from sys_dorm WHERE bedID = '"+bedID+"' and dormID='"+dormID+"'";
		    ResultSet rs = dbUtil.executeQuery(sql, null);
		    Dorm dorm = new Dorm();
		    if(rs.next()){
		    	b = false;
		    }
		    return b;
		       }catch(SQLException e){
		       e.printStackTrace();
		       return false;
		       }
	}
	public List<Dorm> findBedID(String bedID,String dormID,String buildID)throws Exception{
		ResultSet rs = null;

			List<Dorm> dormList = new ArrayList<Dorm>();
			String sql = "select * from sys_dorm  where Not dormID='" + dormID + "' AND bedID = '" + bedID
					+ "' and buildID ='" + buildID + "'";
			rs = dbUtil.executeQuery(sql, null);
			while(rs.next()){
				Dorm dorm = new Dorm();
				dorm.setBedID(rs.getString("bedID"));
				dormList.add(dorm);
			}
			return dormList;
	}
	public int edit(Dorm dorm)throws Exception{
		try {
			String sql = "update sys_dorm set bedID=? WHERE dormID=? and stuID=?";
			
			Object params[] = new Object [3];
			params[0] = dorm.getBedID();
			params[1] = dorm.getDormID();
			params[2] = dorm.getStuID();
		    int count = dbUtil.executeUpate(sql, params);
		    return count;
		       }catch(Exception e){
		       e.printStackTrace();
		       return 0;
		       }
	}
	
	public int del(Dorm dorm)throws Exception{
		try {
			String sql = "delete from sys_dorm where  dormID=? and stuID=?";
			Object params[] = new Object [2];
			params[0] = dorm.getDormID();
			params[1] = dorm.getStuID();

		    int count = dbUtil.executeUpate(sql, params);
		    return count;
		       }catch(Exception e){
		       e.printStackTrace();
		       return 0;
		       }
	}
	
	public int add(Dorm dorm)throws Exception{
		try {
			String sql = "insert into sys_dorm(dormID,buildID,stuID,bedID)values(?,?,?,?)";
			Object params[] = new Object [4];
			params[0] = dorm.getDormID();
			params[1] = dorm.getBuildID();
			params[2] =dorm.getStuID();
			params[3] = dorm.getBedID();
		    int count = dbUtil.executeUpate(sql, params);
		    return count;
		       }catch(Exception e){
		       e.printStackTrace();
		       return 0;
		       }
	}
}
