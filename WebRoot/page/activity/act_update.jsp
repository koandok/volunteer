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
<script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
<%
Activity act = (Activity)request.getAttribute("act");

 %>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加用户</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=path%>/ArtServlet?action=edit">  
         <div class="form-group">
	        <div class="label">
	          <label>活动Id</label>
	        </div>
	        <div class="field">
	          <input type="text" class="input w50"  value="<%=act.getActID() %>" name="actID" readonly="readonly" />
	          <div class="tips"></div>
	        </div>
       </div>
      
       <div class="form-group">
	        <div class="label">
	          <label>活动标题：</label>
	        </div>
	        <div class="field">
	          <input type="text" class="input w50"  value="<%=act.getActName() %>" name="actName" data-validate="required:数据必填项" />
	          <div class="tips"></div>
	        </div>
       </div>
      
      <div class="form-group">
	        <div class="label">
	          <label>内容：</label>
	        </div>
	        <div class="field">
	          <input type="text" class="input w50" style="width: 280px;height:120px;" value="<%=act.getContent() %>" name="content" />
	          <div class="tips"></div>
	        </div>
       </div>
     
      
       <div class="form-group">
	        <div class="label">
	          <label>要求人数：</label>
	        </div>
	        <div class="field">
	          <input type="text" class="input w50"  value="<%=act.getPeopleNum() %>" name="peopleNum" />
	          <div class="tips"></div>
	        </div>
       </div>
       
       
      
       <div class="form-group">
	        <div class="label">
	          <label>发起人：</label>
	        </div>
	        <div class="field">
	          <input type="text" class="input w50"  value="<%=act.getVouserID() %>" name="vouserID" />
	          <div class="tips"></div>
	        </div>
      </div>
      
      
       <div class="form-group">
	        <div class="label">
	          <label>活动开始时间：</label>
	        </div>
	        <div class="field">	       
              <input class="Wdate" autocomplete="off" name="actBegin" value="<%=act.getActBegin() %>" type="text" style="width: 280px;height:45px; color: #0000AA;" onClick="WdatePicker()">
            </div>
      </div>
      
      <div class="form-group">
	        <div class="label">
	          <label>活动结束时间：</label>
	        </div>
	        <div class="field">	       
              <input class="Wdate" autocomplete="off" name="actEnd" type="text" value="<%=act.getActEnd() %>" style="width: 280px;height:45px; color: #0000AA;" onClick="WdatePicker()">
            </div>
      </div>
      
      
      <div class="form-group">
	        <div class="label">
	          <label>报名时间：</label>
	        </div>
	        <div class="field">	       
              <input class="Wdate" autocomplete="off" name="joinBegin" type="text" value="<%=act.getJoinBegin() %>" style="width: 280px;height:45px; color: #0000AA;" onClick="WdatePicker()">
            </div>
      </div>
      
      
      
      <div class="form-group">
	        <div class="label">
	          <label>报名截止时间：</label>
	        </div>
	        <div class="field">	       
              <input class="Wdate" autocomplete="off" name="joinEnd" type="text" value="<%=act.getJoinEnd() %>" style="width: 280px;height:45px; color: #0000AA;" onClick="WdatePicker()">
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
