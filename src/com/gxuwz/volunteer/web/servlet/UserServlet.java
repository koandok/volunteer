package com.gxuwz.volunteer.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.volunteer.bean.entity.*;
import com.gxuwz.volunteer.bean.manager.UserManager;

public class UserServlet extends HttpServlet {

	private void proccess(HttpServletRequest request,HttpServletResponse response,String path)throws ServletException,IOException{
		
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//定义区分不同处理动作类型参数: list:表示显示列表，add表示添加，input表示录入，edit表示修改，get表示读取单个用户信息
		String action=request.getParameter("action");
		//选择结构
		if("list".equals(action)){
			
		}else if("add".equals(action)){
			
		}else if("input".equals(action)){
			
		}else if("edit".equals(action)){
			try {
				System.out.println(action);
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
		}

	}
	
	public void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
		//1获得参数
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String telephone = request.getParameter("telephone");
		String fullname = request.getParameter("fullname");
		//实例化user
		User user = new User();
		//把参数对应放入实体类user属性中
		user.setFullname(fullname);
		user.setPassword(pwd);;
		user.setTelephone(telephone);
		user.setUserid(userid);
		
		UserManager usermanager = new UserManager();
		
		if(usermanager.edit(user)>0){
		//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");
		proccess(request, response, "/login.jsp");
		}else{
		//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");	
			proccess(request, response, "/page/user/user_updata.jsp");
		}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
		//1获得参数
		String userid = request.getParameter("userid");
		//实例化user
		User user = new User();
		//把参数对应放入实体类user属性中
		user.setUserid(userid);
		
		UserManager usermanager = new UserManager();
		user = usermanager.findAllbyID(userid);
		request.setAttribute("user", user);
		proccess(request, response, "/page/user/user_update.jsp");
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	
}
