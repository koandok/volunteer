package com.gxuwz.volunteer.bean.manager;

import com.gxuwz.volunteer.bean.entity.Activity;
import com.gxuwz.volunteer.database.DbUtil;

public class FormManager {
	private DbUtil dbUtil =new DbUtil();
	public int bao(Activity activity,String ID)throws Exception{
		   try{
			    String sql="insert into form(actID,voID)";
			    sql+="values(?,?)";		   
			    
			    int index=1;
			    Object params[] = new Object [2];
				params[0] = activity.getActID();
				params[1] = ID;
			    int count = dbUtil.executeUpate(sql, params);
			    return count;
		   }catch(Exception e){
			   e.printStackTrace();
			   throw new Exception("add activity failed!"+e.getMessage(),e);
		   }
			
		}
}
