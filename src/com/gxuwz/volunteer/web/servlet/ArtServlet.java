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
import javax.servlet.http.HttpSession;

import com.gxuwz.volunteer.bean.entity.*;
import com.gxuwz.volunteer.bean.manager.*;
import com.gxuwz.volunteer.tools.DateUtil;

public class ArtServlet extends HttpServlet {
	DateUtil dateutil = new DateUtil();

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
				//选择结构
				if("list_user".equals(action)){
					try {
						list_user(request, response);
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
				}else if("bao".equals(action)){
					try {
						bao(request, response);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if("getvo".equals(action)){
					try {
						getvo(request, response);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

	}
	public void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			String actID = request.getParameter("actID");
			String actName = request.getParameter("actName");
			String content = request.getParameter("content");
			String peopleNum = request.getParameter("peopleNum");
			String vouserID = request.getParameter("vouserID");
			String actBegin = request.getParameter("actBegin");
			String actEnd = request.getParameter("actEnd");
			String joinBegin = request.getParameter("joinBegin");
			String joinEnd = request.getParameter("joinEnd");
			Activity activity = new Activity();
			activity.setActID(actID);
			activity.setActName(actName);
			activity.setContent(content);
			activity.setPeopleNum(Integer.parseInt(peopleNum));
			activity.setVouserID(vouserID);
			activity.setActBegin(dateutil.StringtoD(actBegin));
			activity.setActEnd(dateutil.StringtoD(actEnd));
			activity.setJoinBegin(dateutil.StringtoD(joinBegin));
			activity.setJoinEnd(dateutil.StringtoD(joinEnd));		
			 ActManager actmanager = new ActManager();
			

		if(actmanager.edit(activity)>0){
			list_user(request, response);
		}else{
			request.setAttribute("flag", "error");
			proccess(request, response, "/page/activity/act_update.jsp");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		public void del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{

			String actID = request.getParameter("actID");
			
			Activity act = new Activity();
			//把参数对应放入实体类user属性中
			act.setActID(actID);
			

			ActManager actmanager = new ActManager();

		if(actmanager.del(act)>0){
		list_user(request, response);
		}else{
			request.setAttribute("flag", "error");
			proccess(request, response, "/page/activity/act_list_user.jsp");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		}

		public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String actID = request.getParameter("actID");
			Activity act = new Activity();
			ActManager actmanager = new ActManager();
			act = actmanager.findbyID(actID);
			request.setAttribute("act", act);
			proccess(request, response, "/page/activity/act_update.jsp");
			
		}
		
		public void getvo(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String actID = request.getParameter("actID");
			Activity act = new Activity();
			ActManager actmanager = new ActManager();
			act = actmanager.findbyID(actID);
			request.setAttribute("act", act);
			proccess(request, response, "/page/activity/act_update_vo.jsp");
			
		}
		public void bao(HttpServletRequest request, HttpServletResponse response) throws Exception {
			FormServlet fs = new FormServlet();
			String actID = request.getParameter("actID");
			
			Date date = new Date();
			HttpSession session = request.getSession();
			String voID = (String)session.getAttribute("userid");
			System.out.println("?????"+voID);
			Activity act = new Activity();
			//把参数对应放入实体类user属性中
			ActManager actmanager = new ActManager();
			FormManager formmanager = new FormManager();
			act = actmanager.findbyID(actID);
			Date joinBegin = act.getJoinBegin();
			Date joinEnd =act.getJoinEnd() ;
			int num = formmanager.people(act.getPeopleNum(), act.getActID());
			if(dateutil.isInTime(date, joinBegin, joinEnd)&&act.getPeopleNum()>num){
			int c = formmanager.bao(act,voID);
			fs.list_vo(request, response);
			}else{
				request.setAttribute("flag", "error");
				list_vo(request, response);
			}
			
		}


		private void add(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {		
			try{
			String actID = request.getParameter("actID");
			String actName = request.getParameter("actName");
			String content = request.getParameter("content");
			String peopleNum = request.getParameter("peopleNum");
			String vouserID = request.getParameter("vouserID");
			String actBegin = request.getParameter("actBegin");
			String actEnd = request.getParameter("actEnd");
			String joinBegin = request.getParameter("joinBegin");
			String joinEnd = request.getParameter("joinEnd");
			Activity activity = new Activity();
			activity.setActID(actID);
			activity.setActName(actName);
			activity.setContent(content);
			activity.setPeopleNum(Integer.parseInt(peopleNum));
			activity.setVouserID(vouserID);
			activity.setActBegin(dateutil.StringtoD(actBegin));
			activity.setActEnd(dateutil.StringtoD(actEnd));
			activity.setJoinBegin(dateutil.StringtoD(joinBegin));
			activity.setJoinEnd(dateutil.StringtoD(joinEnd));
			
			 ActManager actmanager = new ActManager();
			
				if(actmanager.add(activity)>0){
					list_user(request, response);
					}else{
						request.setAttribute("flag", "error");
						proccess(request, response, "/page/activity/act_add.jsp");
					}
					}catch(Exception e){
				e.printStackTrace();
					}
			  }

		public void list_user(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String keywords= request.getParameter("keywords");
			List<Activity> actList = new ArrayList<Activity>();			
			ActManager actmanager = new ActManager();
			actList = actmanager.findAll(keywords);
			request.setAttribute("actList", actList);
			proccess(request, response, "/page/activity/act_list_user.jsp");
			
		}
		public void list_vo(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String keywords= request.getParameter("keywords");
			List<Activity> actList = new ArrayList<Activity>();			
			ActManager actmanager = new ActManager();
			actList = actmanager.findAll(keywords);
			request.setAttribute("actList", actList);
			proccess(request, response, "/page/activity/act_list_vo.jsp");
			
		}
		/*public void seach(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String keywords= request.getParameter("keywords");
			List<Department> depList = new ArrayList<Department>();			
			DepManager depmanager = new DepManager();
			depList = depmanager.Seach(keywords);
			request.setAttribute("depList", depList);
			proccess(request, response, "/page/department/dep_list.jsp");
			
			
		}*/
}
