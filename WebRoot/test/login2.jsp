<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"  prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"  prefix="html"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>仓库管理系统登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/test/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/test/css/login.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/iutil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/idrag.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/waiting.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/FelyTools.js"></script>
<script type="text/javascript">
 function checkuser() {		
		if (validInput()){		
		submitForm();
		}
		return;	
}
	  
function submitForm(){
	
		$("#login").ajaxSubmit(
		function(data) {
			if (data == "true") {
				location.href = "${pageContext.request.contextPath}/Frame.html";
			} else if(data == "true2"){
                location.href = "Frame for employee.html";
			}
			else {
				alert("登陆失败");
			}
			
			MyWait.hidden();
			$("#login").clearForm();
		
			});
	}
	
	
	//验证用户输入
	function validInput() {
		if ($("#username").val()== "") {
			alert("用户名不能为空");				
			return false;
		}	
		
		if ($("#password").val()== "") {
			alert("密码不能为空");
			return false;
		}
		return true;
	}
</script>
  </head>
  
  <body>
   <html:form action="/login" styleId="login"  method="get"  >
 <div id="container">
    <div id="bd">
    	<div id="main">
        	<div class="login-box">
                <div id="logo" style="color:#080808; font-size:30px"><label ><br><br><br>    仓库管理系统    </label></div>
                <h1></h1>
                <div class="input username" id="username">
                    <label for="userName">用户名</label>
                    <span></span>
                    <input type="text" id="username" name="username"/>
                </div>
                <div class="input psw" id="psw">
                    <label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
                    <span></span>
                    <input type="password" id="password"  name="password"/>
                </div>
                
                <div class="styleArea">
                    
                </div>
                <div id="btn" class="loginButton">
                    <input type="button" class="button" value="登录"  onclick="checkuser();"/>
                </div>
            </div>
        </div>
        
    </div>
   
</div>
</html:form>
  </body>
</html>
