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
<form method="post" action="<%=path%>/FormServlet?action=list_vouser" id="listform">
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
			<th>志愿者ID</th>
			<th>签到状态</th>
			<th>分数</th>
			<th>负责人ID</th>
			<th>操作</th>
       </tr>

			<%   
			List<Form> formList = (List)request.getAttribute("formList");
			for(Form form : formList){
			String actID = form.getActID();
			String voID = form.getVoID();
			String status = form.getStatus();
			String vouserID = form.getVouserID();
			int score = form.getScore();
		    if(status.equals("0")){
		    status = "未签到";
		    }else if(status.equals("1")){
		    status = "已签到";
		    }
				%>
			<tr>
				<td><%=actID%></td>				
				<td><%=voID%></td>								
				<td><%=status%></td>
				<td><%=score%></tsd>	
				<td><%=vouserID%></td>		
				<td>	
				<div class="button-group"> <a class="button border-main" href="<%=path%>/FormServlet?actID=<%=actID%>&action=qiandao&voID=<%=voID%>"><span class="icon-edit"></span>签到</a> 
				<a class="button border-red" href="<%=path%>/FormServlet?actID=<%=actID%>&action=get&voID=<%=voID%>" ><span class="icon-trash-o"></span> 打分</a> </div>
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
