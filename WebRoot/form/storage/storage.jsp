<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'storage.jsp' starting page</title>
    
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
   <!--  <a href="form/vender/venderTypeEditor.jsp"><img alt="" src="">盘赢入库</a> -->
   <!--  <a href="form/vender/venderEditor.jsp"><img alt="" src="">盘亏出库</a> -->
    <a href="form/storage/intable.jsp"><img alt="" src="">普通入库</a>
    <a href="form/storage/outtable.jsp"><img alt="" src="">普通出库</a>
   <!--  <a href="form/vender/venderEditor.jsp"><img alt="" src="">仓库补货</a> -->
  <!--   <a href="form/vender/venderEditor.jsp"><img alt="" src="">成本计算</a> -->
    <a href="form/storage/itemeditor.jsp"><img alt="" src="">物料信息维护</a>
    <a href="form/storage/warehouse.jsp"><img alt="" src="">仓库信息维护</a>
    <a href="form/storage/locationeditor.jsp"><img alt="" src="">仓位信息维护</a>
    <a href="form/report/report.jsp"><img alt="" src="">供应商类型维护</a>
    
  </body>
</html>
