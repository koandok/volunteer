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

import com.gxuwz.volunteer.bean.entity.Building;
import com.gxuwz.volunteer.bean.entity.Department;
import com.gxuwz.volunteer.bean.manager.BuildManager;
import com.gxuwz.volunteer.bean.manager.DepManager;

public class DepServlet extends HttpServlet {
private void proccess(HttpServletRequest request,HttpServletResponse response,String path)throws ServletException,IOException{
		
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//定义区分不同处理动作类型参数: list:表示显示列表，add表示添加，input表示录入，edit表示修改，get表示读取单个用户信息
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
		}


}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {

			String depID = request.getParameter("depID");
			String depName = request.getParameter("depName");

			// 实例化user
			Department dep = new Department();
			// 把参数对应放入实体类user属性中
			dep.setDepID(depID);
			dep.setDepName(depName);

			DepManager depmanager = new DepManager();

			if (depmanager.edit(dep) > 0) {
				// response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");
				list(request, response);
			} else {
				// response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");
				proccess(request, response, "/page/department/dep_update.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {

			String depID = request.getParameter("depID");

			Department dep = new Department();
			// 把参数对应放入实体类user属性中
			dep.setDepID(depID);

			DepManager depmanager = new DepManager();

			if (depmanager.del(dep) > 0) {
				// response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");
				list(request, response);
			} else {
				// response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");
				proccess(request, response, "/page/user/user_updata.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String depID = request.getParameter("depID");

		Department dep = new Department();
		// 把参数对应放入实体类user属性中
		dep.setDepID(depID);

		DepManager depmanager = new DepManager();
		dep = depmanager.findAllbyID(depID);
		request.setAttribute("dep", dep);
		proccess(request, response, "/page/department/dep_update.jsp");

	}

	public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {

			String depID = request.getParameter("depID");
			String depName = request.getParameter("depName");

			// 实例化user
			Department dep = new Department();
			// 把参数对应放入实体类user属性中
			dep.setDepID(depID);
			dep.setDepName(depName);

			DepManager depmanager = new DepManager();

			if (depmanager.add(dep) > 0) {
				// response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");
				list(request, response);
			} else {
				// response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");
				proccess(request, response, "/page/build/build_add.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Department> depList = new ArrayList<Department>();
		DepManager depmanager = new DepManager();
		depList = depmanager.findAll();
		request.setAttribute("depList", depList);
		proccess(request, response, "/page/department/dep_list.jsp");

	}

	public void seach(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String keywords = request.getParameter("keywords");
		List<Department> depList = new ArrayList<Department>();
		DepManager depmanager = new DepManager();
		depList = depmanager.Seach(keywords);
		request.setAttribute("depList", depList);
		proccess(request, response, "/page/department/dep_list.jsp");

	}

	}

