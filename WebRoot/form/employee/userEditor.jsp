<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="GB2312"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<html>
<head>
<title>JSP for UserEditorForm form</title>
<meta http-equiv="content-type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="../../STYLE/AJAXSTYLE.css" type="text/css" />
<link rel="stylesheet" href="../../STYLE/Styles.css" type="text/css" />
<script type="text/javascript" src="../../JS/jquery.js"></script>
<script type="text/javascript" src="../../JS/iutil.js"></script>
<script type="text/javascript" src="../../JS/idrag.js"></script>
<script type="text/javascript" src="../../JS/jquery.form.js"></script>
<script type="text/javascript" src="../../JS/waiting.js"></script>
<script type="text/javascript" src="../../JS/FelyTools.js"></script>
<script type="text/javascript" src="../../JS/WebCalendar.js" charset="utf-8"></script>
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
	function btn_passwordset_onclick(){
		$("#oper").val("passwordSet");
		submitForm();
	}
	function btn_roleset_onclick(){
		$("#oper").val("roleSet");
		submitForm();
	}
	function submitForm(){
		var MyWait = new wait(150,30,'���Ժ�,���ڵȴ�����','../../IMAGES/processing.gif');
		MyWait.show();
		$("#userEditor").ajaxSubmit(
		function(data){
			MyWait.hidden();
			$("#Data").empty();
			try{
				$(data).appendTo("#Data");
				$("#userEditor").clearForm();
			}catch(e){}
		});
	}
	function clickTR(Row)
	{
		var ModelID = Row.cells[0].innerHTML;
		ResetFocus("#Data",Row);
		GetSingle(ModelID);
	}
	
	function GetSingle(ModelID)
	{
		var MyWait = new wait(150,30,'���Ժ�,���ڵȴ�����','../../IMAGES/processing.gif');
		MyWait.show();
		$.post($("#userEditor").attr("action"),               
            {
                oper: "model",         
                employID: ModelID
            },
            function(MyData) {
                BuildModel(MyData);
                MyWait.hidden();
            }
        );
	}
	
	function BuildModel(MyData)
	{
		try {
			var json = eval('(' + MyData + ')');
			$("#emp_id").val(json.data[0].emp_id);
			$("#emp_desc").val(json.data[0].emp_desc);
			$("#folk").val(json.data[0].folk);
			$("#birth").val(json.data[0].birth);
			$("#marri").val(json.data[0].marri);
			$("#family").val(json.data[0].family);
			$("#collage").val(json.data[0].collage);
			$("#speci").val(json.data[0].speci);
			$("#wage").val(json.data[0].wage);
			$("#role").val(json.data[0].role);
		}
		catch(e){
			
		}
	}
	
	//ҳ�����ʱִ��
	$(
		function(){
			submitForm();
		}
	)
</script>
</head>
<body>
<html:form action="/userEditor" styleId="userEditor">
  <div class="command">
 <!--    <select onchange="javascript:location.href=this.value;">
    <option value="../../form/systemManage/systemmanager.jsp" selected="selected" >ϵͳ����</option>
    <option value="../../form/storage/storage.jsp">�ֿ����</option>
    <option value="../../form/vender/vendermanager.jsp">��Ӧ�̹���</option>
    </select> -->
    <input type="button" name="btn_add" id="btn_add" value="���" onClick="btn_add_onclick();">
    <input type="button" name="btn_edit" id="btn_edit" value="�޸�" onClick="btn_edit_onclick();">
    <input type="button" name="btn_delete" id="btn_delete" value="ɾ��" onClick="btn_delete_onclick();">
  </div>
  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table1">
    <tr>
      <td width="13%">&nbsp;�û���:</td>
      <td width="20%">&nbsp;
        <html:text property="emp_id" styleId="emp_id"/>
        <html:errors property="emp_id"/></td>
      <td width="13%">&nbsp;����:</td>
      <td width="20%">&nbsp;
        <html:text property="emp_desc" styleId="emp_desc"/>
        <html:errors property="emp_desc"/></td>
      <td width="14%">&nbsp;����:</td>
      <td width="20%">&nbsp;
        <html:text property="folk" styleId="folk"/>
        <html:errors property="folk"/>
        <input type="hidden" value="getList" name="oper" id="oper"></td>
    </tr>
    <tr>
      <td>&nbsp;��������:</td>
      <td>&nbsp;
        <html:text property="birth" styleId="birth" onclick="new Calendar().show(this);"/>
        <html:errors property="birth"/></td>
      <td>&nbsp;����״��:</td>
      <td>&nbsp;
        <html:text property="marri" styleId="marri"/>
        <html:errors property="marri"/></td>
      <td>&nbsp;��ͥ��Ա:</td>
      <td>&nbsp;
        <html:text property="family" styleId="family"/>
        <html:errors property="family"/></td>
    </tr>
    <tr>
      <td>&nbsp;��ҵԺУ:</td>
      <td>&nbsp;
        <html:text property="collage" styleId="collage"/>
        <html:errors property="collage"/></td>
      <td>&nbsp;רҵ:</td>
      <td>&nbsp;
        <html:text property="speci" styleId="speci"/>
        <html:errors property="speci"/></td>
      <td>&nbsp;Ŀǰнˮ:</td>
      <td>&nbsp;
        <html:text property="wage" styleId="wage"></html:text>
        <html:errors property="wage"/></td>
    </tr>
    <tr>
      <td>&nbsp;��ǰ��ɫ:</td>
  <td><html:select property="role" styleId="role">
        	<html:option value="0">Ա��</html:option>
        	<html:option value="1">����</html:option>
        </html:select></td> 
      <td>���룺</td>
      <td><html:text property="password" styleId="password"/></td>
      <td colspan="2" style="text-align:right">  
        
        </td>
    </tr>
  </table>
  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2">
    <tr class="fixedHeaderTr" id="Header">
      <th width="10%">�û���</th>
      <th width="15%">����</th>
      <th width="5%">����</th>
      <th width="20%">��ҵԺУ</th>
      <th width="15%">רҵ</th>
      <th width="20%">��ɫ</th>
      <th width="15%">нˮ</th>
    </tr>
    <tbody id="Data">
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </tbody>
  </table>

</html:form>
</body>
</html>
