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
<%
Form form = (Form)request.getAttribute("form");

 %>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加用户</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=path%>/FormServlet?action=pingfen">
      
      <div class="form-group">
        <div class="label">
          <label>活动号：</label>
        </div>
        <div class="field" align="center">
          <input  type="text" class="input w50" value="<%=form.getActID()%>" name="actID" readonly="ture" />
          <div class="tips"></div>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>志愿者ID：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="<%=form.getVoID()%>" name="voID" data-validate="required:请输入班号" readonly="ture"/>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>签到状态：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="<%=form.getStatus()%>" name="status" data-validate="required:请输入班号" readonly="ture"/>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>分数：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="<%=form.getScore()%>" name="score" data-validate="required:请输入班号" />
          <div class="tips"></div>
        </div>
      </div>
      
	<div class="form-group">
        <div class="label">
          <label>负责人ID：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="<%=form.getVouserID()%>" name="vouserID" data-validate="required:请输入班号"readonly="ture" />
          <div class="tips"></div>
        </div>
      </div>
      <%
				Object obj = request.getAttribute("flag");
				
				if (obj!= null){	
				 %>
				 <div style="txxt-align:center">
				 <span>error:操作失败</span>
				 </div>
				 <%}%> 
       <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field" >
          <button class="button bg-main icon-check-square-o" type="submit"> 修改</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body>
</html>
