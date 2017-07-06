<%@ page language="java" pageEncoding="GB2312" contentType="text/html; charset=gb2312"%>
<jsp:directive.page import="com.sanqing.bean.ummasterBean"/>
<jsp:directive.page import="com.sanqing.bean.employeeBean"/>
<jsp:directive.page import="com.sanqing.bean.WareHousebean"/>
<jsp:directive.page import="com.sanqing.bean.vendbean"/>
<jsp:directive.page import="com.sanqing.bean.itemBean"/>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%response.setHeader("Pragma","No-cache"); response.setHeader("Cache-Control","no-cache"); response.setDateHeader("Expires", 0); response.flushBuffer();%>
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
/* 物料删除 */
 function clickTRclear(Row)
	{
		var ModelID = Row.cells[0].innerHTML;
		var ModelID2=Row.cells[1].innerHTML;
		ResetFocus("#Data",Row);
		submitForm_clear(ModelID,ModelID2);
	} 

/*传要删除行的值  */
function clearitem(row){
     var $td = $(row).parents('tr').children('td');
     var itid =$td.eq(1).text();
		$.post($("#intable").attr("action"),               
            {
                oper: "clearitem",         
                itemId: itid,
            },
           
            function(MyData) {
             $("#Data").empty();		
             $(MyData).appendTo("#Data");
             
            }
        );
	}


/* 清空表单 */
function clearIntable_onclick(){

$("#intable").clearForm();

}
/* 向入库单添加物料 */
function AddTOIntable_onclick(){
       $("#oper").val("add_to_intable");
       submitFormTOIntableCar();
}
function submitFormTOIntableCar(){
      var MyWait = new wait(150,30,'请稍候,正在等待数据','../../IMAGES/processing.gif');
		MyWait.show();
    $("#intable").ajaxSubmit(
		function(data)	
		{
		$(data).appendTo("#Data");
		$("#intable").clearForm();
         MyWait.hidden();
	    });
}

/*对入库单进行增删查改  */
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
		$("#intable").clearForm();
	}
	
	function itemid_select(){
	 var   ModelID= $("#itemId").val();
		$.post($("#intable").attr("action"),               
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
		function submitForm(){
		var MyWait = new wait(150,30,'请稍候,正在等待数据','../../IMAGES/processing.gif');
		MyWait.show();
		$("#intable").ajaxSubmit(
		function(data)
		{
			MyWait.hidden();
			$("#Dataforwhole").empty();	
			$("#Data").empty();		
			try{
				$(data).appendTo("#Dataforwhole");
				$("#intable").clearForm();
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
		$("#intable").ajaxSubmit(
		function(data)
		{
			if (data=="flase") {	
			alert("入库单号不存在");
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
		$.post($("#intable").attr("action"),               
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
			$("#prodCode").val(json.data[0].prodCode);
			$("#salePic").val(json.data[0].salePic);
			$("#poEmpId").val(json.data[0].poEmpId);
			$("#wareId").val(json.data[0].wareId);
			$("#locaId").val(json.data[0].locaId);
			$("#vendId").val(json.data[0].vendId);
			$("#warehouseWarrant").val(json.data[0].warehouseWarrant);
			$("#number").val(json.data[0].number);
			$("#indate").val(json.data[0].indate);
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
<html:form action="/intable" styleId="intable">
  <div class="command">
   <input type="button" name="btn_lookup" id="btn_lookup" value="清空" onClick="clearIntable_onclick();">
  <input type="button" name="btn_lookup" id="btn_lookup" value="添加" onClick="AddTOIntable_onclick();">
  <input type="button" name="btn_lookup" id="btn_lookup" value="查询" onClick="lookup_onclick();">
    <input type="button" name="btn_add" id="btn_add" value="入库" onClick="btn_add_onclick();">
    <input type="button" name="btn_edit" id="btn_edit" value="修改" onClick="btn_edit_onclick();">
    <input type="button" name="btn_delete" id="btn_delete" value="删除" onClick="btn_delete_onclick();">
  </div>
  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table1">
  <tr>
  </tr>
    <tr>
      <td width="13%">&nbsp;入库单号：</td>
      <td width="20%">&nbsp;
        
        <html:text property="warehouseWarrant" styleId="warehouseWarrant"/></td>
      <td width="13%">&nbsp;物料ID:</td>
      <td width="20%">&nbsp;
         <jsp:useBean id="itemBean" scope="page" class="com.sanqing.bean.itemBean"></jsp:useBean>
          <html:select property="itemId" styleId="itemId"   onchange="itemid_select();">
        	<html:option value=""></html:option>
        	<html:optionsCollection name="itemBean" property="beanCollection"/>
        </html:select></td>
      <td width="14%">&nbsp;物料名称:</td>
      <td width="20%">&nbsp;
	  	<html:text property="itemDesc" styleId="itemDesc"/>
        <label></label>
        <input type="hidden" value="getList" name="oper" id="oper">
		
		</td>
    </tr>
    <tr>
      <td>&nbsp;类别:</td>
      <td>&nbsp;
      	<jsp:useBean id="prodcodebean" scope="page" class="com.sanqing.bean.classCodeBean"></jsp:useBean>
        <html:select property="prodCode" styleId="prodCode">
        	<html:option value=""></html:option>
        	<html:optionsCollection name="prodcodebean" property="beanCollection"/>
        </html:select>
        </td>
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
      <td>&nbsp;采购员:</td>
      <td>&nbsp;
 
        <jsp:useBean id="employeeBean" scope="page" class="com.sanqing.bean.employeeBean"></jsp:useBean><html:select property="poEmpId" styleId="poEmpId">
        	<html:option value=""></html:option>
        	<html:optionsCollection name="employeeBean" property="beanCollection"/>
        </html:select>
        </td>
      <td>入库时间：</td>
      <td>&nbsp;
      	 <html:text property="indate" styleId="indate" onclick="new Calendar().show(this);"/></td>
      <td>
      	&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr></tr>
  </table>
  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2">
    <tr class="fixedHeaderTr" id="Header">
      <th width="10%">入库单号</th>
      <th width="10%">料号</th>
      <th width="10%">物料名称</th>
      <th width="11%">数量</th>
    </tr>
    <tbody id="Data">入库单物料：
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td >&nbsp;</td>
        <td>&nbsp;</td>
        
        
        
         
         </tr>
         <tr>
    </tbody>
  </table>
   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2">
    <tr class="fixedHeaderTr" id="Header2">
      <th width="10%">入库单号</th>
      <th width="10%">料号</th>
      <th width="10%">物料名称</th>
      <th width="15%">类型</th>
      <th width="12%">仓库</th>
      <th width="12%">仓位</th>
      <th width="11%">数量</th>
      <th width="20%">入库时间</th>
    </tr>
    <tbody id="Dataforwhole">入库单：
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td >&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
         <td>&nbsp;</td>
         </tr>
         <tr>
    </tbody>
  </table>
</html:form>
</body>
</html>
