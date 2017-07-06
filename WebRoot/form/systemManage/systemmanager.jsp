<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'systemmanager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <a href="form/systemManage/ummaster.jsp"><img alt="" src="">计量单位管理</a>
     <!-- <a href="form/systemManage/currencyEditor.jsp"><img alt="" src="">货币管理</a> -->
     <a href="form/systemManage/classCodeEditor.jsp"><img alt="" src="">分类管理</a>
     <!-- <a href="form/systemManage/shipvinEditor.jsp"><img alt="" src="">运输途径管理</a> -->
     <!-- <a href="form/systemManage/roleEditor.jsp"><img alt="" src="">角色信息管理</a> -->
    <!--  <a href="form/systemManage/actionEditor.jsp"><img alt="" src="">权限信息管理</a> -->
   <!--   <a href="form/systemManage/roleAction.jsp"><img alt="" src="">角色权限管理</a> -->
      <a href="form/systemManage/DepartmentEditor.jsp"><img alt="" src="">部门信息维护</a>
  </body>
</html>
