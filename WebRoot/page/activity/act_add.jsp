<%@page import="java.sql.ResultSet"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/base/base.jsp"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>发布活动</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=path%>/ArtServlet?action=add">  
         <div class="form-group">
	        <div class="label">
	          <label>活动Id</label>
	        </div>
	        <div class="field">
	          <input type="text" class="input w50"  value="" name="actID" data-validate="required:数据必填项" />
	          <div class="tips"></div>
	        </div>
       </div>
      
       <div class="form-group">
	        <div class="label">
	          <label>活动标题：</label>
	        </div>
	        <div class="field">
	          <input type="text" class="input w50"  value="" name="actName" data-validate="required:数据必填项" />
	          <div class="tips"></div>
	        </div>
       </div>
      
      <div class="form-group">
	        <div class="label">
	          <label>内容：</label>
	        </div>
	        <div class="field">
	          <input type="text" class="input w50"  value="" name="content" />
	          <div class="tips"></div>
	        </div>
       </div>
     
      
       <div class="form-group">
	        <div class="label">
	          <label>要求人数：</label>
	        </div>
	        <div class="field">
	          <input type="text" class="input w50"  value="" name="peopleNum" />
	          <div class="tips"></div>
	        </div>
       </div>
       
       <%
       DbUtil dbutil = new DbUtil();
       String sql = "select vouserID from vouser where 1=1";
       ResultSet rs = dbutil.executeQuery(sql, null);
      
        %>
      
       <div class="form-group">
	        <div class="label">
	          <label>负责人：</label>
	        </div>
	        <div class="field">
	        <select  name="vouserID" class="input w50">
	        <% while(rs.next()){ %>
	          <!-- <input type="text" class="input w50"  value="" name="vouserID" /> -->
	          <option value="<%=rs.getString("vouserID")%>"><%=rs.getString("vouserID")%></option> 
	          <%} %>
	          </select>
	          <div class="tips"></div>
	        </div>
      </div>
      
      
       <div class="form-group">
	        <div class="label">
	          <label>活动开始时间：</label>
	        </div>
	        <div class="field">	       
              <input class="Wdate" autocomplete="off" name="actBegin" type="text" style="width: 280px;height:45px; color: #0000AA;" onClick="WdatePicker()">
            </div>
      </div>
      
      <div class="form-group">
	        <div class="label">
	          <label>活动结束时间：</label>
	        </div>
	        <div class="field">	       
              <input class="Wdate" autocomplete="off" name="actEnd" type="text" style="width: 280px;height:45px; color: #0000AA;" onClick="WdatePicker()">
            </div>
      </div>
      
      
      <div class="form-group">
	        <div class="label">
	          <label>报名时间：</label>
	        </div>
	        <div class="field">	       
              <input class="Wdate" autocomplete="off" name="joinBegin" type="text" style="width: 280px;height:45px; color: #0000AA;" onClick="WdatePicker()">
            </div>
      </div>
      
      
      
      <div class="form-group">
	        <div class="label">
	          <label>报名截止时间：</label>
	        </div>
	        <div class="field">	       
              <input class="Wdate" autocomplete="off" name="joinEnd" type="text" style="width: 280px;height:45px; color: #0000AA;" onClick="WdatePicker()">
            </div>
      </div>
      <%
				Object obj = request.getAttribute("flag");
				
				if (obj!= null){	
				 %>
				 <div style="txxt-align:center">
				 <span>error:键位冲突</span>
				 </div>
				 <%} %>
       <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field" >
          <button class="button bg-main icon-check-square-o" type="submit"> 添加-</button>
        </div>
      </div>
  
          </div>
          </form>
      </div>
    
  </div>
  
</div>


</body>
</html>
