package com.gxuwz.volunteer.bean.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.volunteer.bean.entity.*;
import com.gxuwz.volunteer.database.DbUtil;

public class DepManager {
private DbUtil dbUtil =new DbUtil();
	
	public List<Department> findAll() throws Exception{
		List<Department> depList = new ArrayList<Department>();
		String sql = "select * from department where 1=1";
		ResultSet rs = dbUtil.executeQuery(sql, null);
		while(rs.next()){
			Department dep = new Department();
			dep.setDepID(rs.getString("depID"));
			dep.setDepName(rs.getString("depName"));
			depList.add(dep);
		}
		return depList;
	}
/*	public List<Department> findAll(String keywords) throws Exception{
		List<Department> depList = new ArrayList<Department>();
		String sql = "select * from department where 1=1";
		if(keywords!=null){
			sql = "select * from department where depID like '%"+keywords+"%'  ";
		}
		ResultSet rs = dbUtil.executeQuery(sql, null);
		while(rs.next()){
			Department dep = new Department();
			dep.setDepID(rs.getString("depID"));
			dep.setDepName(rs.getString("depName"));
			depList.add(dep);
		}
		return depList;
	}*/
	
	public List<Department> Seach(String keywords) throws Exception{
		List<Department> depList = new ArrayList<Department>();
		String sql = "select * from department where 1=1";
			  if(keywords!=null){
			   sql="select * from department where depID like '%"+keywords+"%'  ";
		      }
		ResultSet rs = dbUtil.executeQuery(sql, null);
		while(rs.next()){
			Department dep = new Department();
			dep.setDepID(rs.getString("depID"));
			dep.setDepName(rs.getString("depName"));
			depList.add(dep);
		}
		return depList;
	}
	
	public Department findAllbyID(String ID)throws Exception{
		try {
			String sql = "select *  from department WHERE depID='"+ID+"'";
			
		    ResultSet rs = dbUtil.executeQuery(sql, null);
		    Department dep = new Department();
		    while(rs.next()){
		    	dep.setDepID(rs.getString("depID"));
				dep.setDepName(rs.getString("depName"));
		    }
		    return dep;
		       }catch(SQLException e){
		       e.printStackTrace();
		       throw e;
		       }
	}
	
	public int edit(Department dep)throws Exception{
		try {
			String sql = "update department set depName=? WHERE depID=?";
			Object params[] = new Object [2];
			params[0] = dep.getDepName();
			params[1] = dep.getDepID();
		    int count = dbUtil.executeUpate(sql, params);
		    return count;
		       }catch(Exception e){
		       e.printStackTrace();
		       throw e;
		       }
	}
	
	public int del(Department dep)throws Exception{
		try {
			String sql = "delete from department where depID=?";
			Object params[] = new Object [1];
			params[0] = dep.getDepID();

		    int count = dbUtil.executeUpate(sql, params);
		    return count;
		       }catch(Exception e){
		       e.printStackTrace();
		       throw e;
		       }
	}
	
	public int add(Department dep)throws Exception{
		try {
			String sql = "insert into department(depID,depName)values(?,?)";
			Object params[] = new Object [2];
			params[0] = dep.getDepID();
			params[1] = dep.getDepName();
		    int count = dbUtil.executeUpate(sql, params);
		    return count;
		       }catch(Exception e){
		       e.printStackTrace();
		       throw e;
		       }
	}
}
