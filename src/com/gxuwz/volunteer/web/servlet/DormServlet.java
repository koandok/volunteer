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

public class DormServlet extends HttpServlet {
private void proccess(HttpServletRequest request,HttpServletResponse response,String path)throws ServletException,IOException{
		
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�������ֲ�ͬ���������Ͳ���: list:��ʾ��ʾ�б�add��ʾ��ӣ�input��ʾ¼�룬edit��ʾ�޸ģ�get��ʾ��ȡ�����û���Ϣ
		String action=request.getParameter("action");
		//ѡ��ṹ
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
		}

	}
	
	public void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			String dormID = request.getParameter("dormID");
			String buildID = request.getParameter("buildID");
			String stuID = request.getParameter("stuID");
			String bedID = request.getParameter("bedID");
			
			//ʵ����user
			Dorm dorm = new Dorm();
			//�Ѳ�����Ӧ����ʵ����user������
			dorm.setBedID(bedID);
			dorm.setBuildID(buildID);
			dorm.setDormID(dormID);
			dorm.setStuID(stuID);
			DormManager dormmanager = new DormManager();
			
		if(dormmanager.findBedID(bedID, dormID)){
		if(dormmanager.edit(dorm)>0){
		//�޸�����	
		list(request, response);
		
		}else{
			//�޸ĳ���
			request.setAttribute("flag", "error");
			get(request, response);
		}
		}else{
			request.setAttribute("flag", "error");
			get(request, response);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
	public void del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
	
			String dormID = request.getParameter("dormID");
			String stuID = request.getParameter("stuID");
			
			// ʵ����user
			Dorm dorm = new Dorm();
			// �Ѳ�����Ӧ����ʵ����user������
			dorm.setDormID(dormID);
			dorm.setStuID(stuID);
			DormManager dormmanager = new DormManager();
		
		if(dormmanager.del(dorm)>0){
		
		list(request, response);
		}else{
		
			proccess(request, response, "/page/user/user_update.jsp");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		
		public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String dormID = request.getParameter("dormID");
			String stuID = request.getParameter("stuID");
			Dorm dorm = new Dorm();
			DormManager dormmanager = new DormManager();
			dorm = dormmanager.findAllbyID(dormID,stuID);
			request.setAttribute("dorm", dorm);
			proccess(request, response, "/page/dorm/dorm_update.jsp");
			
	}

		public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
			try{
			
			String dormID = request.getParameter("dormID");
			String buildID = request.getParameter("buildID");
			String stuID = request.getParameter("stuID");
			String bedID = request.getParameter("bedID");
			
			//ʵ����user
			Dorm dorm = new Dorm();
			//�Ѳ�����Ӧ����ʵ����user������
			dorm.setBedID(bedID);
			dorm.setBuildID(buildID);
			dorm.setDormID(dormID);
			dorm.setStuID(stuID);
			DormManager dormmanager = new DormManager();
			
			if(dormmanager.findBedID(bedID, dormID)){
			if(dormmanager.add(dorm)>0){
			//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");
			list(request, response);
			}else{
			    request.setAttribute("flag", "error");	
				proccess(request, response, "/page/build/build_add.jsp");
			}
			}else{
				request.setAttribute("flag", "error");
				proccess(request, response, "/page/build/build_add.jsp");
			}
			}catch(Exception e){
				e.printStackTrace();
				}
			}
		public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
			List<Dorm> dormList = new ArrayList<Dorm>();			
			DormManager dormmanager = new DormManager();
			RuserManager rusermanager = new RuserManager();
			Ruser ruser = new Ruser();
			//��ȡsession�е�ruserid
			HttpSession session=request.getSession();
			String ruserid = (String)session.getAttribute("userid");
			//ͨ��ruserid�õ��������Ա����Ϣ
			ruser = rusermanager.findAllbyID(ruserid);
			//���������Ա�����¥�Ÿ�ֵ��buildID
		    String buildID = ruser.getBuildID();
			//ͨ��¥�Ų��Ҷ�Ӧ�����Ტ�ŵ�List��
			dormList = dormmanager.findAll(buildID);
			request.setAttribute("dormList", dormList);
			proccess(request, response, "/page/dorm/dorm_list.jsp");
			
	}
		
		public void seach(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String keywords= request.getParameter("keywords");
			List<Dorm> dormList = new ArrayList<Dorm>();		
			DormManager dormmanager = new DormManager();
			RuserManager rusermanager = new RuserManager();
			Ruser ruser = new Ruser();
			//��ȡsession�е�ruserid
			HttpSession session=request.getSession();
			String ruserid = (String)session.getAttribute("userid");
			//ͨ��ruserid�õ��������Ա����Ϣ
			ruser = rusermanager.findAllbyID(ruserid);
			//���������Ա�����¥�Ÿ�ֵ��buildID
		    String buildID = ruser.getBuildID();
		    dormList =dormmanager.Seach(keywords,ruserid);
			request.setAttribute("dormList", dormList);
			proccess(request, response, "/page/dorm/dorm_list.jsp");
			
			
	}

}
