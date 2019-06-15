package com.gxuwz.volunteer.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.volunteer.bean.entity.*;

import com.gxuwz.volunteer.bean.manager.*;

public class FormServlet extends HttpServlet {

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
		if("list_vouser".equals(action)){
			try {
				list_vouser(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			
		}else if("qiandao".equals(action)){
			try {
				qiandao(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("pingfen".equals(action)){
			try {
				pingfen(request, response);
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
	public void qiandao(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{

			String actID = request.getParameter("actID");
			String voID = request.getParameter("voID");
			Form form = new Form();
		FormManager formmanager = new FormManager();

		if(formmanager.qiandao(actID,voID)>0){
		//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");
		list_vouser(request, response);
		}else{
		//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");	
			proccess(request, response, "/page/department/dep_update.jsp");
		}
		}catch(Exception e){
			e.printStackTrace();
			}
		}
	
	public void pingfen(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			Form form = new Form();
			form.setActID(request.getParameter("actID"));
			form.setVoID(request.getParameter("voID")); 
			form.setScore(Integer.parseInt(request.getParameter("score")));
			
			
		FormManager formmanager = new FormManager();

		if(formmanager.pingfen(form)>0){
		//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");
		list_vouser(request, response);
		}else{
		//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");	
			proccess(request, response, "/page/department/dep_update.jsp");
		}
		}catch(Exception e){
			e.printStackTrace();
			}
		}
	public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			Form form = new Form();
			String actID = request.getParameter("actID");
			String voID = request.getParameter("voID");
				
			FormManager formmanager = new FormManager();
	
			form = formmanager.findAllbyID(actID, voID);
			request.setAttribute("form", form);
			proccess(request, response, "/page/department/dep_update.jsp");
		
		}catch(Exception e){
			e.printStackTrace();
			}
		}
	public void list_vouser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Form> formList = new ArrayList<Form>();			
		FormManager formmanager = new FormManager();
		formList = formmanager.findAll();
		request.setAttribute("formList", formList);
		proccess(request, response, "/page/form/form_list_vouser.jsp");
		
	}
}
