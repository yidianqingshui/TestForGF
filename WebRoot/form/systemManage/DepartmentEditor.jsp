<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="GB2312"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<html>
<head>
<title>JSP for VenderTypeEditorForm form</title>
<meta http-equiv="content-type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="../../STYLE/AJAXSTYLE.css" type="text/css" />
<link rel="stylesheet" href="../../STYLE/Styles.css" type="text/css" />
<script type="text/javascript" src="../../JS/jquery.js"></script>
<script type="text/javascript" src="../../JS/iutil.js"></script>
<script type="text/javascript" src="../../JS/idrag.js"></script>
<script type="text/javascript" src="../../JS/jquery.form.js"></script>
<script type="text/javascript" src="../../JS/waiting.js"></script>
<script type="text/javascript" src="../../JS/FelyTools.js"></script>
<script type="text/javascript">
	function btn_add_onclick(){
		$("#oper").val("add");
		submitForm();
	}
	function btn_edit_onclick(){
		$("#oper").val("edit");
		submitForm();
	}
	function btn_delete_onclick(){
		$("#oper").val("delete");
		submitForm();
	}
	function submitForm(){
		var MyWait = new wait(150,30,'请稍候,正在等待数据','../../IMAGES/processing.gif');
		MyWait.show();
		$("#department").ajaxSubmit(
		function(data)
		{
			MyWait.hidden();
			$("#Data").empty();
			$(data).appendTo("#Data");
			$("#department").clearForm();
			//document.getElementById("Data").innerHTML=data;
		});
	}
	function clickTR(Row)
	{
		$("#departmengtId").val(Row.cells[0].innerHTML);
		$("#departmentName").val(Row.cells[1].innerHTML);
		ResetFocus("#Data",Row);
	}
	//页面加载时执行
	$(
		function(){
			submitForm();
		}
	)
</script>
</head>
<body>
<html:form action="/department" styleId="department"> 
<div class="command">
  <input type="button" name="btn_add" id="btn_add" value="添加" onclick="btn_add_onclick();">
  <input type="button" name="btn_edit" id="btn_edit" value="修改" onclick="btn_edit_onclick();">
  <input type="button" name="btn_delete" id="btn_delete" value="删除" onclick="btn_delete_onclick();">
</div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td width="13%">部门编号:</td>
    <td width="20%">&nbsp;
      <html:text property="departmengtId" styleId="departmengtId"/>
    <td width="13%">&nbsp;部门名称:</td>
    <td width="20%">&nbsp;
      <html:text property="departmentName" styleId="departmentName"/><html:errors property="vendtype_desc"/></td>
    <td width="14%">&nbsp;</td>
    <td width="20%">&nbsp;<input type="hidden" value="getList" name="oper" id="oper"></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2">
  <tr class="fixedHeaderTr" id="Header">
    <th width="40%">供应商类型ID</th>
    <th>供应商名称</th>
  </tr>
  <tbody id="Data">
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  </tbody>
</table>

</html:form>
</body>
</html>
