package com.gxuwz.volunteer.database;

import java.sql.*;

public class DbUtil {
	private String jdbc_url;
	private String jdbc_id;
	private String jdbc_pwd;
	private String jdbc_driver;
	public DbUtil(){
		this.jdbc_driver="com.mysql.jdbc.Driver";
		this.jdbc_url="jdbc:mysql://127.0.0.1:3306/volunteerdb";
		this.jdbc_id="root";
		this.jdbc_pwd="123456";
	}
	public Connection getConn()throws Exception{
		try{
		Class.forName(this.jdbc_driver);
		Connection conn=DriverManager.getConnection(jdbc_url, jdbc_id, jdbc_pwd);
		return conn;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	  public int executeUpate(String sql,Object params[]) throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
		    try{
		    conn = getConn();
			pstmt = conn.prepareStatement(sql);
		    int index=1;
		    if(params!= null){
		    for(Object obj:params){
				 //判断参数的数据类型
				 if(obj instanceof Integer){
					 pstmt.setInt(index++, (Integer)obj);
				 }
				 if(obj instanceof Float){
					 pstmt.setFloat(index++, (Float)obj);
				 }
				 if(obj instanceof Double){
					 pstmt.setDouble(index++, (Double)obj);
				 }
				 if(obj instanceof String){
					 pstmt.setString(index++, (String)obj);
				 }
				 if(obj instanceof java.util.Date){
					 java.util.Date  date=(java.util.Date)obj;
					 pstmt.setDate(index++,new java.sql.Date(date.getTime()));
				 }
			  }
		    }
		    int a = pstmt.executeUpdate(); 
		    return a;
		    }catch(SQLException e){
				  e.printStackTrace();
					 return 0; 
			  }	
		    	   
	  }
	 
	  
	  public ResultSet executeQuery(String sql,Object[]params) throws Exception{
		    
		    Connection conn = null;
	    	ResultSet rs = null;	
			PreparedStatement pstmt = null;
		    try{
		    conn = getConn();
			pstmt = conn.prepareStatement(sql);
		    int index=1;
		    if(params!= null){
		    for(Object obj:params){
				 //判断参数的数据类型
				 if(obj instanceof Integer){
					 pstmt.setInt(index++, (Integer)obj);
				 }
				 if(obj instanceof Float){
					 pstmt.setFloat(index++, (Float)obj);
				 }
				 if(obj instanceof Double){
					 pstmt.setDouble(index++, (Double)obj);
				 }
				 if(obj instanceof String){
					 pstmt.setString(index++, (String)obj);
				 }
				 if(obj instanceof java.util.Date){
					 java.util.Date  date=(java.util.Date)obj;
					 pstmt.setDate(index++,new java.sql.Date(date.getTime()));
				 }
			  }
		    }
		    rs = pstmt.executeQuery(); 
		    }catch(SQLException e){
		    	e.printStackTrace();
		    }
		  return rs;
	  }
	  
	  
	  public void close(ResultSet rs,Statement stmt,Connection conn)throws SQLException{
		    try{
		      if(rs!=null){
		     stmt.close();
		  }
		    if(stmt!=null){
		     stmt.close();
		  }
		   if(conn!=null){
		     conn.close();
		  }
		    }catch(SQLException e){
		      throw e;
		    }
		  }
		  
		   public void close(Statement stmt,Connection conn)throws SQLException{
		       close(null, stmt, conn);
		   }
		   
		  public void close(ResultSet rs)throws SQLException{
		       close(rs, null, null);
		   }
		    public void close(Statement stmt)throws SQLException{
		       close(null, stmt, null);
		   }
		   public void close(Connection conn)throws SQLException{
		       close(null, null, conn);
		   }
}
