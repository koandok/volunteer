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
<form method="post" action=" <%=path%>/VoServlet?action=list " id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 用户列表</strong> </div>
   <%--  <form method="post" action="<%=path%>/BuildServlet?action=seach" > --%>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">

        <li> <a class="button border-main icon-plus-square-o" href="page/volunteer/vo_add.jsp"> 添加用户</a> </li>
            
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
			<th>志愿者ID</th>
			<th>志愿者名称</th>
			<th>班级ID</th>
			<th>电话</th>
			<th>二级学院ID</th>
			<th>邮箱</th>
			<th>密码</th>
			<th>加入时间</th>
			<th>操作</th>
       </tr>

			<%   
			List<Volunteer> voList = (List)request.getAttribute("voList");
			for(Volunteer vo : voList){
			String voID = vo.getVoID();
			String voName = vo.getVoName();
			String classID = vo.getClassID();
			String telephone = vo.getTelephone();
			String depID = vo.getDepID();
			String email = vo.getEmail();
			String password = vo.getPassword();
			Date joinTime = vo.getJoinTime();
					    
				%>
			<tr>
				<td><%=voID%></td>				
				<td><%=voName%></td>								
				<td><%=classID%></td>
				<td><%=telephone%></td>
				<td><%=depID%></td>							
				<td><%=email%></td>
				<td><%=password%></td>
				<td><%=joinTime%></td>
				
				<td>	
				<div class="button-group"> <a class="button border-main" href="<%=path%>/VoServlet?voID=<%=voID%>&action=get"><span class="icon-edit"></span> 修改</a>
				 <a class="button border-red" href="<%=path%>/VoServlet?action=del&voID=<%=voID %>" ><span class="icon-trash-o"></span> 删除</a> </div>
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
