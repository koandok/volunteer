package com.gxuwz.volunteer.bean.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.gxuwz.volunteer.bean.entity.Student;
import com.gxuwz.volunteer.database.DbUtil;

public class StudentManager {
	private DbUtil dbUtil =new DbUtil();
	public Student findAllbyID(String ID) throws Exception{
		try {
		Student stu = new Student();
		
			String sql = "select *  from sys_dorm WHERE stuID = '"+ID+"'";
			
		    ResultSet rs = dbUtil.executeQuery(sql, null);
	
		    while(rs.next()){
		    	stu.setBedID(rs.getString("bedID"));
		    	stu.setClassID(rs.getString("classID"));
		    	stu.setDormID(rs.getString("dormID"));
		    	stu.setGarde(rs.getString("grade"));
		    	stu.setPassword(rs.getString("password"));
		    	stu.setStuID(rs.getString("stuID"));
		    	stu.setStuName(rs.getString("stuName"));
		    }
		    return stu;
		       }catch(SQLException e){
		       e.printStackTrace();
		       throw e;
		       }
	}
}
