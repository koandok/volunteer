package com.gxuwz.volunteer.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.volunteer.bean.entity.*;
import com.gxuwz.volunteer.bean.manager.*;
import com.gxuwz.volunteer.tools.DateUtil;

public class LaterServlet extends HttpServlet {
private void proccess(HttpServletRequest request,HttpServletResponse response,String path)throws ServletException,IOException{
		
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action");
		System.out.println("11111111111"+action);
		//选择结构
		if("list".equals(action)){
			try {
				list(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("add".equals(action)){
			try {
				add(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("seach".equals(action)){
			try {
				seach(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("edit".equals(action)){
			try {
				edit(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("get".equals(action)){
			try {
				get(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("del".equals(action)){
			try {
				del(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("adds".equals(action)){
			try {
				gets(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
	
			String buildID = request.getParameter("buildID");
			String buildName = request.getParameter("buildName");
			
			//实例化user
			Building build = new Building();
		//把参数对应放入实体类user属性中
	build.setBuildID(buildID);
	build.setBuildName(buildName);
		
	BuildManager buildmanager = new BuildManager();
		
		if(buildmanager.edit(build)>0){
		//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");
		list(request, response);
		}else{
		//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");	
			proccess(request, response, "/page/user/user_updata.jsp");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
	public void del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
	
			String buildID = request.getParameter("buildID");
			
			//实例化user
			Building build = new Building();
		//把参数对应放入实体类user属性中
	build.setBuildID(buildID);
	
		
	BuildManager buildmanager = new BuildManager();
		
		if(buildmanager.del(build)>0){
		//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");
		list(request, response);
		}else{
		//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");	
			proccess(request, response, "/page/user/user_update.jsp");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		
		public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String buildID = request.getParameter("buildID");;
			//实例化user
			
			Building build = new Building();		
			BuildManager buildmanager = new BuildManager();
			build = buildmanager.findAllbyID(buildID);
			request.setAttribute("build", build);
			proccess(request, response, "/page/building/building_update.jsp");
			
	}
		public void gets(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String stuID = request.getParameter("stuID");;
			//实例化user
			
			Student  stu   = new Student();		
			LaterManager latermanager = new LaterManager();
			stu = buildmanager.findAllbyID(buildID);
			request.setAttribute("build", build);
			proccess(request, response, "/page/building/building_update.jsp");
			
	}

		public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
			try{
			DateUtil dateutil = new DateUtil(); 
			String laterID = request.getParameter("laterID");
			String dormID = request.getParameter("dormID");
			String stuID = request.getParameter("stuID");
			String stuName = request.getParameter("stuName");
			String laterTime = request.getParameter("laterTime");
			String reason = request.getParameter("reason");
			String classID = request.getParameter("classID");
			//实例化user
			Later later = new Later();
			//把参数对应放入实体类user属性中
			later.setClassID(classID);
			later.setDormID(dormID);
			later.setLaterID(laterID);
			later.setLaterTime(dateutil.StringtoD(laterTime));
			later.setReason(reason);
			later.setStuID(stuID);
			later.setStuName(stuName);
			LaterManager latermanager = new LaterManager();
			
			if(latermanager.add(later)>0){
			//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");
			list(request, response);
			}else{
			//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");	
				list(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
				}
			}
		public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			List<Later> laterList = new ArrayList<Later>();			
			LaterManager latermanager = new LaterManager();
			laterList = latermanager.findAll();
			request.setAttribute("laterList", laterList);
			proccess(request, response, "/page/later/later_list.jsp");
			
	}
		
		public void seach(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String keywords= request.getParameter("keywords");
			List<Later> laterList = new ArrayList<Later>();			
			LaterManager latermanager = new LaterManager();
			laterList = latermanager.Seach(keywords);
			request.setAttribute("laterList", laterList);
			proccess(request, response, "/page/later/later_list.jsp");
			
			
	}
}
