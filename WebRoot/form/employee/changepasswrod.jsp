<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"  prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"  prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'changepasswrod.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/iutil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/idrag.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/waiting.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/FelyTools.js"></script>
<script type="text/javascript">
function changepassword(){
  if (validInput()){		
		submitForm();
		}
   return;	
}			
function submitForm(){
	    var MyWait = new wait(150,30,'请稍候,正在等待数据','${pageContext.request.contextPath}/IMAGES/processing.gif');
		MyWait.show();
		$("#change").ajaxSubmit(
		function(data) {
			if (data == "true") {
			alert("修改密码成功");
			}	
			else if(data == "Password_ed_flase") {
				alert("原密码错误");
			}
			else {
				alert("新密码不一致");
			}
			$("#change").clearForm();
			MyWait.hidden();
		
			});
	}
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
         <html:form action="/change" styleId="change"   >
         <tr>
          <label for="userName">原密码：<input type="password_ed" id="password_ed"  name="password_ed"></label>
                    <span></span>
                    
            </tr><tr>新密码：<input type="password" id="password_new"  name="password_new">       
            </tr>
                      <label for="password">确认密码：</label>
                    <span></span>
                    <input type="password" id="password"  name="password"/>
              <input type="button" class="button" value="修改密码"  onclick="changepassword();"/>
         </html:form>
  </body>
</html>
