<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/base/base.jsp"%>
<%@ page import = "com.gxuwz.volunteer.bean.manager.*" %>
<%@ page import = "com.gxuwz.volunteer.bean.entity.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>用户信息列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<form method="post" action="<%-- <%=path%>/BuildServlet?action=seach --%>" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 用户列表</strong> </div>
   <%--  <form method="post" action="<%=path%>/BuildServlet?action=seach" > --%>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">

        <li>搜索：</li>
          
          <li> <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />       
         <input type="submit" value="搜索"name="搜索" class="button border-main icon-search"  ></li>
<%--        <li>
          <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="<%=path%>/BuildServlet?action=seach" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li> --%>
      </ul>
    </div>
    <!-- </form>  -->
    <table class="table table-hover text-center">
      <tr>  				
			<th>活动编号</th>
			<th>活动名称</th>
			<th>内容</th>
			<th>人数</th>
			<th>负责人ID</th>
			<th>活动开始时间</th>
			<th>活动截止时间</th>
			<th>报名时间</th>
			<th>报名截止时间</th>
			<th>操作</th>
       </tr>

			<%   
			List<Activity> actList = (List)request.getAttribute("actList");
			for(Activity act : actList){
			String actID = act.getActID();
			String actName = act.getActName();
			String content = act.getContent();
			int peopleNum = act.getPeopleNum();
			String vouserID = act.getVouserID();
			Date actBegin = act.getActBegin();
			Date actEnd = act.getActEnd();
			Date joinBegin = act.getJoinBegin();
			Date joinEnd = act.getJoinEnd();		    
				%>
			<tr>
				<td><%=actID%></td>				
				<td><%=actName%></td>								
				<td><%=content%></td>
				<td><%=peopleNum%></td>
				<td><%=vouserID%></td>							
				<td><%=actBegin%></td>
				<td><%=actEnd%></td>
				<td><%=joinBegin%></td>
				<td><%=joinEnd%></td>
				
				<td>	
				<div class="button-group"> <a class="button border-main" href="<%=path%>/ArtServlet?actID=<%=actID%>&action=get"><span class="icon-edit"></span> 查看</a> <a class="button border-red" href="<%=path%>/ArtServlet?action=bao&actID=<%=actID%>" ><span class="icon-trash-o"></span> 报名</a> </div>
				</td>
			</tr>
			<%
				}
			%>
    </table>
  </div>
  <div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div>
</form>
</body>
</html>
