<%@ page language="java" pageEncoding="GB2312" contentType="text/html; charset=gb2312"%>
<jsp:directive.page import="com.sanqing.bean.ummasterBean"/>
<jsp:directive.page import="com.sanqing.bean.employeeBean"/>
<jsp:directive.page import="com.sanqing.bean.WareHousebean"/>
<jsp:directive.page import="com.sanqing.bean.vendbean"/>
<jsp:directive.page import="com.sanqing.bean.itemBean"/>
<jsp:directive.page import="com.sanqing.bean.departmentBean"/>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<html>
<head>
<title>JSP for ItemeditorForm form</title>
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
function AddTOIntable_onclick(){
       $("#oper").val("add_to_intable");
       submitFormTOIntableCar();
}
function submitFormTOIntableCar(){
      var MyWait = new wait(150,30,'请稍候,正在等待数据','../../IMAGES/processing.gif');
		MyWait.show();
    $("#outtable").ajaxSubmit(
		function(data)	
		{
		$(data).appendTo("#Data");
		$("#outtable").clearForm();
         MyWait.hidden();
	    });
}
function itemid_select(){
	   var   ModelID= $("#itemId").val();
		$.post($("#outtable").attr("action"),               
            {
                oper: "select",         
                itemId: ModelID,
            },           
            function(MyData) {
                BuildModel_select(MyData);        
            }
        );
	}
	
	function BuildModel_select(MyData)
	{
		try {
			var json = eval('(' + MyData + ')');
			$("#itemDesc").val(json.data[0].itemDesc);
			$("#prodCode").val(json.data[0].prodCode);
			$("#salePic").val(json.data[0].salePic);
			$("#wareId").val(json.data[0].wareId);
			$("#locaId").val(json.data[0].locaId);
			$("#vendId").val(json.data[0].vendId);
		}
		catch(e){			
		}
	}	
function clearIntable_onclick(){

$("#outtable").clearForm();
}
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
		$("#outtable").ajaxSubmit(
		function(data)
		{
			MyWait.hidden();
			$("#Dataforwhole").empty();
			$("#Data").empty();
			//alert(data);
			
			try{
				$(data).appendTo("#Dataforwhole");
				$("#outtable").clearForm();
			}catch(e){}
		});
	}
	//点击每一列的时候出发的事件
	 function clickTR(Row)
	{
		var ModelID = Row.cells[0].innerHTML;
		var ModelID2=Row.cells[1].innerHTML;
		ResetFocus("#Dataforwhole",Row);
		GetSingle(ModelID,ModelID2);
	} 
	
 	function lookup_onclick(){
		$("#oper").val("lookup");
		submitFormlookup();
	}
	 function submitFormlookup() {
	 
		var MyWait = new wait(150,30,'请稍候,正在等待数据','../../IMAGES/processing.gif');
		MyWait.show();
		$("#outtable").ajaxSubmit(
		function(data)
		{
			if (data=="flase") {	
			alert("出库单号不存在");
			MyWait.hidden();
			}
			else{
			MyWait.hidden();
			BuildModel(data);	
			}
		});
	 }
	function GetSingle(ModelID,ModelID2)
	{
		var MyWait = new wait(150,30,'请稍候,正在等待数据','../../IMAGES/processing.gif');
		MyWait.show();
		$.post($("#outtable").attr("action"),               
            {
                oper: "model",         
                warehouseWarrant: ModelID,
                 itemId:  ModelID2
             
            },
            function(MyData) {
                BuildModel(MyData);
                MyWait.hidden();
            }
        );
	}
	//这是显示在各个框里面的值
	function BuildModel(MyData)
	{
		try {
			var json = eval('(' + MyData + ')');
			$("#itemId").val(json.data[0].itemId);
			$("#itemDesc").val(json.data[0].itemDesc);
			/* $("#prodCode").val(json.data[0].prodCode); */
			$("#salePic").val(json.data[0].salePic);
			$("#poEmpId").val(json.data[0].poEmpId);
			$("#wareId").val(json.data[0].wareId);
			$("#locaId").val(json.data[0].locaId);
			$("#vendId").val(json.data[0].vendId);
			$("#warehouseWarrantOut").val(json.data[0].warehouseWarrantOut);
			$("#number").val(json.data[0].number);
			$("#outdate").val(json.data[0].outdate);
			$("#department").val(json.data[0].department);
		}
		catch(e){
			
		}
	}
	$(
		function(){
			submitForm();
		}
	) 
	
</script>
</head>
<body>
<html:form action="/outtable" styleId="outtable">
  <div class="command">
   <input type="button" name="btn_lookup" id="btn_lookup" value="清空" onClick="clearIntable_onclick();">
  <input type="button" name="btn_lookup" id="btn_lookup" value="添加" onClick="AddTOIntable_onclick();">
  <input type="button" name="btn_lookup" id="btn_lookup" value="查询" onClick="lookup_onclick();">
    <input type="button" name="btn_add" id="btn_add" value="出库" onClick="btn_add_onclick();">
    <input type="button" name="btn_edit" id="btn_edit" value="修改" onClick="btn_edit_onclick();">
    <input type="button" name="btn_delete" id="btn_delete" value="删除" onClick="btn_delete_onclick();">
  </div>
  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table1">
  <tr>
  </tr>
    <tr>
      <td width="13%">&nbsp;领料单号：</td>
      <td width="20%">&nbsp;
        
        <html:text property="warehouseWarrantOut" styleId="warehouseWarrantOut"/></td>
      <td width="13%">&nbsp;物料ID:</td>
      <td width="20%">&nbsp;
         <jsp:useBean id="itemBean" scope="page" class="com.sanqing.bean.itemBean"></jsp:useBean>
          <html:select property="itemId" styleId="itemId"   onchange="itemid_select();" >
        	<html:option value=""></html:option>
        	<html:optionsCollection name="itemBean" property="beanCollection"/>
        </html:select></td>
      <td width="14%">&nbsp;物料名称:</td>
      <td width="20%">&nbsp;
	  	<html:text property="itemDesc" styleId="itemDesc"/>
        
        <input type="hidden" value="getList" name="oper" id="oper">
		
		</td>
    </tr>
    <tr>
      <td>&nbsp;受益部门：</td>
      <td>&nbsp;  
          <jsp:useBean id="departmentBean" scope="page" class="com.sanqing.bean.departmentBean"></jsp:useBean>
        <html:select property="department" styleId="department">
        	<html:option value=""></html:option>
        	<html:optionsCollection name="departmentBean" property="beanCollection"/>
        </html:select></td>
      <td>供应商：</td>
      <td>&nbsp;
        <jsp:useBean id="vendbean" scope="page" class="com.sanqing.bean.vendbean"></jsp:useBean>
        <html:select property="vendId" styleId="vendId">
        	<html:option value=""></html:option>
        	<html:optionsCollection name="vendbean" property="beanCollection"/>
        </html:select>
        </td>
   
      <td>数量：&nbsp;
        
        </td>
        <td><html:text property="number" styleId="number"/></td>
    </tr>
    <tr>
      <td>&nbsp;仓库：</td>
      <td>&nbsp;
      <jsp:useBean id="testbean" scope="page" class="com.sanqing.bean.WareHousebean"></jsp:useBean><html:select property="wareId" styleId="wareId">
        	<html:option value=""></html:option>
        	<html:optionsCollection name="testbean" property="beanCollection"/>
        </html:select><br>
        
        </td>
      <td>&nbsp;仓位:</td>
      <td>&nbsp;
        <jsp:useBean id="localtionbean" scope="page" class="com.sanqing.bean.localtionbean"></jsp:useBean><html:select property="locaId" styleId="locaId">
        	<html:option value=""></html:option>
        	<html:optionsCollection name="localtionbean" property="beanCollection"/>
        </html:select></td><td>单价:</td>
      <td>&nbsp;
        <html:text property="salePic" styleId="salePic"/>
        </td>
    </tr>
    <tr>
      <td>&nbsp;经办人:</td>
      <td>&nbsp;
 
        <jsp:useBean id="employeeBean" scope="page" class="com.sanqing.bean.employeeBean"></jsp:useBean><html:select property="poEmpId" styleId="poEmpId">
        	<html:option value=""></html:option>
        	<html:optionsCollection name="employeeBean" property="beanCollection"/>
        </html:select>
        </td>
      <td>出库时间：</td>
      <td>&nbsp;
      	 <html:text property="outdate" styleId="outdate" onclick="new Calendar().show(this);"/></td>
      <td>
      	&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr></tr>
  </table>
  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2">
    <tr class="fixedHeaderTr" id="Header">
      <th width="15%">出库单号</th>
      <th width="10%">料号</th>
      <th width="20%">物料名称</th>
      <th width="11%">数量</th>
    </tr>
    <tbody id="Data">出库单物料：
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        
        
        
      </tr>
    </tbody>
  </table>
   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2">
    <tr class="fixedHeaderTr" id="Header">
      <th width="15%">出库单号</th>
      <th width="10%">料号</th>
      <th width="20%">物料名称</th>
      <th width="12%">仓库</th>
      <th width="12%">仓位</th>
      <th width="11%">数量</th>
       <th width="20%">出库时间</th>
    </tr>
    <tbody id="Dataforwhole">出库单：
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
