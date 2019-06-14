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
<form method="post" action="<%=path %>/DormServlet?action=seach" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 用户列表</strong> </div>
   <%--  <form method="post" action="<%=path%>/BuildServlet?action=seach" > --%>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">

        <li> <a class="button border-main icon-plus-square-o" href="page/dorm/dorm_add.jsp"> 添加用户</a> </li>
            
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
       <th>序号</th>
				<th>宿舍号</th>
				<th>楼号</th>
				<th>学生号</th>
				<th>床号</th>
				<th>操作</th>
      </tr>
    
				
				
			<%--读取所有用户信息记录 --%>
			<%  //设置编码方式
		       List<Dorm> dormList = new ArrayList<Dorm>();
			   dormList = (List)request.getAttribute("dormList");
			   int index = 1;
			   for(Dorm dorm : dormList){
			   	 String dormID = dorm.getDormID();
			   	 String buildID = dorm.getBuildID();
			   	 String stuID = dorm.getStuID();
			   	 String bedID = dorm.getBedID();
			   
			%>

			<tr>
				<td><%=index++%></td>
				<td><%=dormID%></td>
				<td><%=buildID%></td>
				<td><%=stuID%></td>
				<td><%=bedID%></td>
				<td>
				<div class="button-group"> <a class="button border-main" href="<%=path%>/DormServlet?dormID=<%=dormID%>&action=get&stuID=<%=stuID %>"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="<%=path%>/DormServlet?dormID=<%=dormID%>&action=del&stuID=<%=stuID %>" ><span class="icon-trash-o"></span> 删除</a> </div>
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
