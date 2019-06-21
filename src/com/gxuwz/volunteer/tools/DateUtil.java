package com.gxuwz.volunteer.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
	public String DateNow(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	public String DatetoS(Date date){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	public Date StringtoD(String string) throws ParseException{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return sdf.parse(string);
	}
	
	
	public  boolean isInTime(Date submissionDate, Date startTime, Date endTime) {

		if (submissionDate.getTime() == startTime.getTime()

		|| submissionDate.getTime() == endTime.getTime()) {

		return true;

		}

		Calendar date = Calendar.getInstance();

		date.setTime(submissionDate);

		Calendar begin = Calendar.getInstance();

		begin.setTime(startTime);

		Calendar end = Calendar.getInstance();

		end.setTime(endTime);

		if (date.after(begin) && date.before(end)) {

		return true;

		} else {

		return false;

		}

		}

}
