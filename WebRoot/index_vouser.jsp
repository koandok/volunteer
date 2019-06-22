<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/base/base.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>志愿者管理系统</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="shortcut icon" href="images/logo.jpg">
    <script src="js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/logo.jpg" class="radius-circle rotate-hover" height="50" alt="" />志愿者管理系统</h1>
  </div><%String admin = (String)session.getAttribute("userid"); 
 %>
  <div class="head-l" ><a href="" target="_blank" style="color:#FFF" ><span class="icon-user"></span>  欢迎 <%=admin%></a>&nbsp;&nbsp;<a class="button button-little bg-green" href="index_vouser.jsp" target="_blank" ><span class="icon-home"></span> 首页</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="login.jsp"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  
  
   

 
<li> <h2><a href="<%=path %>/FormServlet?action=list_vouser" target="right"><span class="icon-user"></span>报名表管理</a></h2></li>
    

  
 
  
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="index_vouser.jsp"  class="icon-home"> 首页</a></li>
  <li><a href="index_vouser.jsp" id="a_leader_txt">欢迎界面</a></li>
  <li><b>当前语言：</b><span style="color:red;">中文</php></span>
 </li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="welcome.jsp" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
</div>
</body>

</html>
