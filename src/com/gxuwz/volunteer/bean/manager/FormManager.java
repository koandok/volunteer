package com.gxuwz.volunteer.bean.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.volunteer.bean.entity.*;
import com.gxuwz.volunteer.bean.entity.*;
import com.gxuwz.volunteer.database.DbUtil;

public class FormManager {
	private DbUtil dbUtil =new DbUtil();
	public int bao(Activity activity,String ID)throws Exception{
		   try{
			    String sql="insert into form(actID,voID,vouserID)";
			    sql+="values(?,?,?)";		   
			    
			    int index=1;
			    Object params[] = new Object [3];
				params[0] = activity.getActID();
				params[1] = ID;
				params[2] = activity.getVouserID();
			    int count = dbUtil.executeUpate(sql, params);
			    return count;
		   }catch(Exception e){
			   e.printStackTrace();
			   throw new Exception("add activity failed!"+e.getMessage(),e);
		   }
			
		}
	
	public int qiandao(String actID ,String voID)throws Exception{
		   try{
			    String sql="update form set status=1 WHERE actID='"+actID+"' and voID = '"+voID+"'";
			    int count = dbUtil.executeUpate(sql, null);
			    return count;
		   }catch(Exception e){
			   e.printStackTrace();
			   throw new Exception("add activity failed!"+e.getMessage(),e);
		   }
			
		}
	
	public List<Form> findAllvu(String id,String keywords) throws Exception{
		List<Form> formList = new ArrayList<Form>();
		String sql = "";
		if(keywords == null||keywords.equals("")){
			sql = "select * from form where vouserID = '"+id+"'";
		}
		else{
			sql = "select * from form where vouserID = '"+id+"' and actID like '%"+keywords+"%'";
		}
		ResultSet rs = dbUtil.executeQuery(sql, null);
		while(rs.next()){
			Form form = new Form();
			form.setActID(rs.getString("actID"));
			form.setScore(rs.getInt("score"));
			form.setStatus(rs.getString("status"));
			form.setVoID(rs.getString("voID"));
			form.setVouserID(rs.getString("vouserID"));
			formList.add(form);
		}
		return formList;
	}
	public List<Form> findAllvo(String id,String keywords) throws Exception{
		System.out.println(keywords);
		List<Form> formList = new ArrayList<Form>();
		String sql = "select * from form where voID = '"+id+"'";
		if(keywords != null){
			sql = "select * from form where voID = '"+id+"' and actID like '%"+keywords+"%'";
		}
		ResultSet rs = dbUtil.executeQuery(sql, null);
		while(rs.next()){
			Form form = new Form();
			form.setActID(rs.getString("actID"));
			form.setScore(rs.getInt("score"));
			form.setStatus(rs.getString("status"));
			form.setVoID(rs.getString("voID"));
			form.setVouserID(rs.getString("vouserID"));
			formList.add(form);
		}
		return formList;
	}
	
	public int pingfen(Form form)throws Exception{
		   try{
			    String sql="update form set score=? WHERE actID='"+form.getActID()+"' and voID = '"+form.getVoID()+"'";		   	    
			    Object params[] = new Object [1];
				params[0] = form.getScore();
			    int count = dbUtil.executeUpate(sql, params);
			    return count;
		   }catch(Exception e){
			   e.printStackTrace();
			   throw new Exception("add activity failed!"+e.getMessage(),e);
		   }
			
		}
	
	public Form findAllbyID(String actID,String voID)throws Exception{
		try {
			String sql = "select *  from form WHERE actID='"+actID+"' and voID='"+voID+"' ";
			
		    ResultSet rs = dbUtil.executeQuery(sql, null);
		    Form form = new Form();
		    while(rs.next()){
		    	form.setActID(rs.getString("actID"));
		    	form.setStatus(rs.getString("status"));
		    	form.setVoID(rs.getString("voID"));
		    	form.setScore(rs.getInt("score"));
		    	form.setVouserID(rs.getString("vouserID"));
		    }
		    return form;
		       }catch(SQLException e){
		       e.printStackTrace();
		       throw e;
		       }
	}
	
	public int people (int peopleNum,String actID)throws Exception{
			String sql="select  COUNT(*)num from form  where actID = '"+actID+"'";
			ResultSet rs = dbUtil.executeQuery(sql, null);
			
			rs.next();
			int num = rs.getInt("num");
			System.out.println("已有人数"+num);
		   return num;
	}
}
