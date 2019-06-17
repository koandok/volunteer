package com.gxuwz.volunteer.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gxuwz.volunteer.bean.manager.LoginManager;

public class LoginServlet extends HttpServlet {

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
		//Ñ¡Ôñ½á¹¹
		if("login".equals(action)){
			try {
				login(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("loginout".equals(action)){
			try {
				loginout(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}

	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String user = request.getParameter("user");
		HttpSession session=request.getSession();
		session.setAttribute("userid", name);
		LoginManager loginmanager = new  LoginManager();
		try{
		if(user.equals("A")){
			if(loginmanager.stulogin(name, password)){
				proccess(request, response, "/index_stu.jsp");
			}else{
				proccess(request, response, "/login.jsp");
			}
			}else if(user.equals("B")){
			if(loginmanager.vouserlogin(name, password)){
				proccess(request, response, "/index_vouser.jsp");
			}else{
				proccess(request, response, "/login.jsp");
			}
			}else if(user.equals("C")){
				if(loginmanager.userlogin(name, password)){
					proccess(request, response, "/index_user.jsp");
				}else{
					proccess(request, response, "/login.jsp");
				}
			}else{
				proccess(request, response, "/login.jsp");
			}
		}catch(Exception e){
		e.printStackTrace();
	}
		
	}
	public void loginout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
