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
import com.gxuwz.volunteer.tools.*;
import com.gxuwz.volunteer.bean.manager.DepManager;
import com.gxuwz.volunteer.bean.manager.VoManager;

public class VoServlet extends HttpServlet {
	DateUtil dateutil = new DateUtil();
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
		try {
			Volunteer vo = new Volunteer();
			vo.setClassID(request.getParameter("classID"));
			vo.setDepID(request.getParameter("depID"));
			vo.setEmail(request.getParameter("email"));
			vo.setPassword(request.getParameter("password"));
			vo.setTelephone(request.getParameter("telephone"));
			vo.setVoID(request.getParameter("voID"));
			vo.setVoName(request.getParameter("voName"));

			VoManager vomanager = new VoManager();

			if (vomanager.edit(vo) > 0) {
				list(request, response);
			} else {
				request.setAttribute("flag", "error");
				proccess(request, response, "/page/volunteer/vo_update.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {

			String voID = request.getParameter("voID");

			Volunteer vo = new Volunteer();
			// 把参数对应放入实体类user属性中
			vo.setVoID(voID);

			VoManager vomanager = new VoManager();

			if (vomanager.del(vo) > 0) {
				list(request, response);
			} else {
				proccess(request, response, "/error.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Volunteer vo = new Volunteer();

		String voID = request.getParameter("voID");

		VoManager vomanager = new VoManager();
		vo = vomanager.findAllbyID(voID);
		request.setAttribute("vo", vo);
		proccess(request, response, "/page/volunteer/vo_update.jsp");

	}

	public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Volunteer vo = new Volunteer();
			vo.setClassID(request.getParameter("classID"));
			vo.setDepID(request.getParameter("depID"));
			vo.setEmail(request.getParameter("email"));
			vo.setJoinTime(dateutil.StringtoD(request.getParameter("joinTime")));
			vo.setPassword(request.getParameter("password"));
			vo.setTelephone(request.getParameter("telephone"));
			vo.setVoID(request.getParameter("voID"));
			vo.setVoName(request.getParameter("voName"));
			
			VoManager vomanager = new VoManager();

			if (vomanager.add(vo) > 0) {
				list(request, response);
			} else {
				request.setAttribute("flag", "error");
				proccess(request, response, "/page/volunteer/vo_add.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String keywords = request.getParameter("keywords");
		List<Volunteer> voList = new ArrayList<Volunteer>();
		VoManager vomanager = new VoManager();
		voList = vomanager.findAll(keywords);
		request.setAttribute("voList", voList);
		proccess(request, response, "/page/volunteer/vo_list.jsp");

	}


}
