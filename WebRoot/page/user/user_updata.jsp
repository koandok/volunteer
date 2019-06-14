<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
    <%@ include file="/base/base.jsp"%>
<%@ page import="com.gxuwz.volunteer.bean.entity.*" %>
<%@ page import="com.gxuwz.volunteer.bean.manager.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>个人设置</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<%
	//设置编码方式

User user = (User)request.getAttribute("user");
%>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>个人设置</strong></div>
  <div class="body-content" >
    <form action="<%=path %>/UserServlet?action=edit" method="post" class="form-x" >  
    
      <div class="form-group">
        <div class="label">
          <label>工号：</label>
        </div>
        <div class="field" align="center">
          <input readOnly="true" type="text" class="input w50" value="<%=user.getUserid()%>" name="userid" data-validate="required:请输入工号" maxlength="30"/>
          <div class="tips"></div>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>姓名：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="<%=user.getFullname()%>" name="fullname" data-validate="required:请输入姓名" maxlength="50"/>
          <div class="tips"></div>
        </div>
      </div>
      
            <div class="form-group">
        <div class="label">
          <label>密码：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="<%=user.getPassword()%>" name="pwd" data-validate="required:请输入密码" maxlength="50"/>
          <div class="tips"></div>
        </div>
      </div>
      
            <div class="form-group">
        <div class="label">
          <label>电话：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="<%=user.getTelephone()%>" name="telephone" data-validate="required:请输入电话" maxlength="11"/>
          <div class="tips"></div>
        </div>
      </div>
      
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