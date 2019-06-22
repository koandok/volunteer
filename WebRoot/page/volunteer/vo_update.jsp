<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/base/base.jsp"%>
<%@ page import = "com.gxuwz.volunteer.bean.manager.*" %>
<%@ page import = "com.gxuwz.volunteer.bean.entity.*" %>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" import="com.gxuwz.volunteer.database.*"%>
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
Volunteer vo = (Volunteer)request.getAttribute("vo");

 %>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加用户</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=path%>/VoServlet?action=edit">  
         <div class="form-group">
	        <div class="label">
	          <label>志愿者ID</label>
	        </div>
	        <div class="field">
	          <input type="text" class="input w50"  value="<%=vo.getVoID() %>" name="voID" data-validate="required:数据必填项" readonly="readonly"/>
	          <div class="tips"></div>
	        </div>
       </div>
      
       <div class="form-group">
	        <div class="label">
	          <label>班级ID：</label>
	        </div>
	        <div class="field">
	          <input type="text" class="input w50"  value="<%=vo.getClassID() %>" name="classID" data-validate="required:数据必填项" />
	          <div class="tips"></div>
	        </div>
       </div>
      
      <div class="form-group">
	        <div class="label">
	          <label>志愿者姓名：</label>
	        </div>
	        <div class="field">
	            <input type="text" class="input w50"  value="<%=vo.getVoName()%>" name="voName" data-validate="required:数据必填项" />
	          <div class="tips"></div>
	        </div>
       </div>
     
      
       <div class="form-group">
	        <div class="label">
	          <label>电话：</label>
	        </div>
	        <div class="field">
	            <input type="text" class="input w50"  value="<%=vo.getTelephone() %>" name="telephone" data-validate="required:数据必填项" />
	          <div class="tips"></div>
	        </div>
       </div>
       
        
        <%
       DbUtil dbutil = new DbUtil();
       String sql = "select depID from department where depID != '"+vo.getDepID()+"'";
       ResultSet rs = dbutil.executeQuery(sql, null);
      
        %>
      
       <div class="form-group">
	        <div class="label">
	          <label>二级学院：</label>
	        </div>
	        <div class="field">
	         <%--  <input type="text" class="input w50"  value="<%=vo.getDepID() %>" name=depID /> --%>   
	         <select  name="depID" class="input w50">
	          <option value="<%=vo.getDepID()%>"><%=vo.getDepID()%></option> 
	       	 <% while(rs.next()){ %>
	          <option value="<%=rs.getString("depID")%>"><%=rs.getString("depID")%></option> 
	          <%} %>
	          </select>
	          <div class="tips"></div>
	        </div>
      </div>
      
      
       <div class="form-group">
	        <div class="label">
	          <label>邮箱：</label>
	        </div>
	        <div class="field">	       
                <input type="text" class="input w50"  value="<%=vo.getEmail() %>" name="email" data-validate="required:数据必填项" />
            </div>
      </div>
      
    
      <div class="form-group">
	        <div class="label">
	          <label>加入时间：</label>
	        </div>
	        <div class="field">	       
                <input type="text" class="input w50"  value="<%=vo.getJoinTime() %>" name="joinTime" data-validate="required:数据必填项" readonly="readonly"/>
            </div>
      </div>
      
             <div class="form-group">
	        <div class="label">
	          <label>密码：</label>
	        </div>
	        <div class="field">	       
                <input type="text" class="input w50"  value="<%=vo.getPassword() %>" name="password" data-validate="required:数据必填项" />
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
