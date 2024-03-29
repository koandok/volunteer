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
import javax.servlet.http.HttpSession;

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
		//选择结构
		if("list_vouser".equals(action)){
			try {
				list_vouser(request, response);//青协端活动表列表
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			
		}else if("qiandao".equals(action)){
			try {
				qiandao(request, response);//签到
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("pingfen".equals(action)){
			try {
				pingfen(request, response);//评分
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
		}else if("list_vo".equals(action)){
			try {
				list_vo(request, response);
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
		FormManager formmanager = new FormManager();

		if(formmanager.qiandao(actID,voID)>0){
		list_vouser(request, response);
		}else{
			request.setAttribute("flag", "error");
			list_vouser(request, response);
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
		list_vouser(request, response);
		}else{
			request.setAttribute("flag", "error");
			list_vouser(request, response);
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
			proccess(request, response, "/page/form/form_pingfen.jsp");
		
		}catch(Exception e){
			e.printStackTrace();
			}
		}
	public void list_vouser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String keywords = request.getParameter("keywords");
		HttpSession session = request.getSession();
		String vouserID = (String)session.getAttribute("userid");
		List<Form> formList = new ArrayList<Form>();			
		FormManager formmanager = new FormManager();
		formList = formmanager.findAllvu(vouserID,keywords);
		request.setAttribute("formList", formList);
		proccess(request, response, "/page/form/form_list_vouser.jsp");
		
	}
	public void list_vo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String keywords = request.getParameter("keywords");
		HttpSession session = request.getSession();
		String voID = (String)session.getAttribute("userid");
		List<Form> formList = new ArrayList<Form>();			
		FormManager formmanager = new FormManager();
		formList = formmanager.findAllvo(voID,keywords);
		request.setAttribute("formList", formList);
		proccess(request, response, "/page/form/form_list_vo.jsp");
		
	}
}
