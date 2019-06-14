package com.gxuwz.volunteer.bean.manager;

import java.sql.*;
import java.util.*;

import com.gxuwz.volunteer.bean.entity.Building;
import com.gxuwz.volunteer.bean.entity.Ruser;
import com.gxuwz.volunteer.database.DbUtil;

public class BuildManager {

	private DbUtil dbUtil =new DbUtil();
	
	public List<Building> findAll() throws Exception{
		List<Building> buildList = new ArrayList<Building>();
		String sql = "select * from sys_building where 1=1";
		ResultSet rs = dbUtil.executeQuery(sql, null);
		while(rs.next()){
			Building build = new Building();
			build.setBuildID(rs.getString("buildID"));
			build.setBuildName(rs.getString("buildName"));
			buildList.add(build);
		}
		return buildList;
	}
	
	public List<Building> Seach(String keywords) throws Exception{
		List<Building> buildList = new ArrayList<Building>();
		String sql = "select * from sys_building where 1=1";
			  if(keywords!=null){
			   sql="select * from sys_building where buildID like '%"+keywords+"%'  ";
		      }
		ResultSet rs = dbUtil.executeQuery(sql, null);
		while(rs.next()){
			Building build = new Building();
			build.setBuildID(rs.getString("buildID"));
			build.setBuildName(rs.getString("buildName"));
			buildList.add(build);
		}
		return buildList;
	}
	
	public Building findAllbyID(String ID)throws Exception{
		try {
			String sql = "select *  from sys_building WHERE buildID='"+ID+"'";
			
		    ResultSet rs = dbUtil.executeQuery(sql, null);
		    Building build =new Building();
		    while(rs.next()){
		    	build.setBuildID(rs.getString("buildID"));
		    	build.setBuildName(rs.getString("buildName"));
		    }
		    return build;
		       }catch(SQLException e){
		       e.printStackTrace();
		       throw e;
		       }
	}
	
	public int edit(Building build)throws Exception{
		try {
			String sql = "update sys_building set buildName=? WHERE buildID=?";
			Object params[] = new Object [2];
			params[0] = build.getBuildName();
			params[1] = build.getBuildID();
		    int count = dbUtil.executeUpate(sql, params);
		    return count;
		       }catch(Exception e){
		       e.printStackTrace();
		       throw e;
		       }
	}
	
	public int del(Building build)throws Exception{
		try {
			String sql = "delete from sys_building where buildID=?";
			Object params[] = new Object [1];
			params[0] = build.getBuildID();

		    int count = dbUtil.executeUpate(sql, params);
		    return count;
		       }catch(Exception e){
		       e.printStackTrace();
		       throw e;
		       }
	}
	
	public int add(Building build)throws Exception{
		try {
			String sql = "insert into sys_building(buildID,buildName)values(?,?)";
			Object params[] = new Object [2];
			params[0] = build.getBuildID();
			params[1] = build.getBuildName();
		    int count = dbUtil.executeUpate(sql, params);
		    return count;
		       }catch(Exception e){
		       e.printStackTrace();
		       throw e;
		       }
	}
}
