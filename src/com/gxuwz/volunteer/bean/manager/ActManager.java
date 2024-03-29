package com.gxuwz.volunteer.bean.manager;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.gxuwz.volunteer.bean.entity.*;
import com.gxuwz.volunteer.database.DbUtil;

public class ActManager {
	private DbUtil dbUtil =new DbUtil();
	
	
	 public List<Activity> findAll(String keywords)throws Exception{
	
	        List<Activity> actlist =new ArrayList<Activity>();				
	        String sql = "select * from activity where 1=1";
			if(keywords!=null&&!keywords.equals("")){
				sql = "select * from activity where actID like '%"+keywords+"%' ";
			}
			    ResultSet rs = dbUtil.executeQuery(sql, null);        
	            while(rs.next()){   	
	            	Activity act = new Activity();
	            	act.setActID(rs.getString("actID"));
					act.setActName(rs.getString("actName"));
					act.setContent(rs.getString("content"));
					act.setPeopleNum(rs.getInt("peopleNum"));
					act.setVouserID(rs.getString("vouserID"));
					act.setActBegin(rs.getDate("actBegin"));
					act.setActEnd(rs.getDate("actEnd"));
					act.setJoinBegin(rs.getDate("joinBegin"));
					act.setJoinEnd(rs.getDate("joinEnd"));
					actlist.add(act);    
	            }
	        
	        return actlist;
	    }
	 
		public int add(Activity activity)throws Exception{
		   try{
			    String sql="insert into activity(actID,actName,content,peopleNum,vouserID,actBegin,actEnd,joinBegin,joinEnd)";
			    sql+="values(?,?,?,?,?,?,?,?,?)";		   
			    
			    int index=1;
			    Object params[] = new Object [9];
				params[0] = activity.getActID();
				params[1] = activity.getActName();
				params[2] = activity.getContent();
				params[3] = activity.getPeopleNum();
				params[4] = activity.getVouserID();
				params[5] = activity.getActBegin();
				params[6] = activity.getActEnd();
				params[7] = activity.getJoinBegin();
				params[8] = activity.getJoinEnd();
			    int count = dbUtil.executeUpate(sql, params);
			    return count;
		   }catch(Exception e){
			   e.printStackTrace();
			   throw new Exception("add activity failed!"+e.getMessage(),e);
		   }
			
		}
		
		public int edit(Activity activity)throws Exception{
			   try{
				    String sql="update activity set actName=?,content=?,peopleNum=?,vouserID=?,actBegin=?,actEnd=?,joinBegin=?,joinEnd=? where actID=?";
	   
				    
				    int index=1;
				    Object params[] = new Object [9];

					params[0] = activity.getActName();
					params[1] = activity.getContent();
					params[2] = activity.getPeopleNum();
					params[3] = activity.getVouserID();
					params[4] = activity.getActBegin();
					params[5] = activity.getActEnd();
					params[6] = activity.getJoinBegin();
				    params[7] = activity.getJoinEnd();
					params[8] = activity.getActID();
				    int count = dbUtil.executeUpate(sql, params);
				    return count;
			   }catch(Exception e){
				   e.printStackTrace();
				   throw new Exception("add activity failed!"+e.getMessage(),e);
			   }
				
			}
		
		public int del(Activity act)throws Exception{
			   try{
				    String sql="delect * from activity where actID = '"+act.getActID()+"'";	   
				    int count = dbUtil.executeUpate(sql, null);
				    return count;
			   }catch(Exception e){
				   e.printStackTrace();
				   throw new Exception("add activity failed!"+e.getMessage(),e);
			   }
				
			}
		
	public Activity findbyID(String ID) throws Exception {

		try {

			String sql = "select * from activity where actID = '" + ID + "'";
			Activity act = new Activity();
			ResultSet rs = dbUtil.executeQuery(sql, null);

			while (rs.next()) {
				act.setActID(rs.getString("actID"));
				act.setActName(rs.getString("actName"));
				act.setContent(rs.getString("content"));
				act.setPeopleNum(rs.getInt("peopleNum"));
				act.setVouserID(rs.getString("vouserID"));
				act.setActBegin(rs.getDate("actBegin"));
				act.setActEnd(rs.getDate("actEnd"));
				act.setJoinBegin(rs.getDate("joinBegin"));
				act.setJoinEnd(rs.getDate("joinEnd"));
			}

			return act;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

	}
}
