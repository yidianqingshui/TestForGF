<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>My JSP 'maintest.jsp' starting page</title> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/test/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/test/css/main.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/test/css/jquery.dialog.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/test/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/test/js/global.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/test/js/core.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/test/js/jquery.dialog.js"></script>
<script type="text/javascript">
$("#bd").height($(window).height()-$("#hd").outerHeight()-26);

$(window).resize(function(e) {
    $("#bd").height($(window).height()-$("#hd").outerHeight()-26);

});

$('.exitDialog').Dialog({
	title:'提示信息',
	autoOpen: false,
	width:400,
	height:200
});

$('.exit').click(function(){
	$('.exitDialog').Dialog('open');
});

$('.exitDialog input[type=button]').click(function(e) {
    $('.exitDialog').Dialog('close');
	
	if($(this).hasClass('ok')){
		window.location.href = "login.html"	;
	}
});

(function(){
	var totalWidth = 0, current = 1;
	
	$.each($('.nav').find('li'), function(){
		totalWidth += $(this).outerWidth();
	});
	
	$('.nav').width(totalWidth);
	
	function currentLeft(){
		return -(current - 1) * 93;	
	}
	
	$('.nav-btn a').click(function(e) {
		var tempWidth = totalWidth - ( Math.abs($('.nav').css('left').split('p')[0]) + $('.nav-wrap').width() );
        if($(this).hasClass('nav-prev-btn')){
			if( parseInt($('.nav').css('left').split('p')[0])  < 0){
				current--;
				Math.abs($('.nav').css('left').split('p')[0]) > 93 ? $('.nav').animate({'left': currentLeft()}, 200) : $('.nav').animate({'left': 0}, 200);
			}
		}else{

			if(tempWidth  > 0)	{
				
			   	current++;
				tempWidth > 93 ? $('.nav').animate({'left': currentLeft()}, 200) : $('.nav').animate({'left': $('.nav').css('left').split('p')[0]-tempWidth}, 200);
			}
		}
    });
	
	
	
	$.each($('.skin-opt li'),function(index, element){
		if((index + 1) % 3 == 0){
			$(this).addClass('third');	
		}
		$(this).css('background',$(this).attr('attr-color'));
	});
	
	$('.setting-skin').click(function(e) {
        $('.skin-opt').show();
    });
	
	$('.skin-opt').click(function(e) {
        if($(e.target).is('li')){
			alert($(e.target).attr('attr-color'));	
		}
    });
	
	$('.hd-top .user-info .more-info').click(function(e) {
       $(this).toggleClass('active'); 
	   $('.user-opt').toggle();
    });
	
	$('.logo-icon').click(function(e) {
         $(this).toggleClass('active'); 
	     $('.system-switch').toggle();
    });
	
	hideElement($('.user-opt'), $('.more-info'), function(current, target){

		$('.more-info').removeClass('active'); 
	});
	
	hideElement($('.skin-opt'), $('.switch-bar'));
	
	hideElement($('.system-switch'), $('.logo-icon'), function(current, target){

		$('.logo-icon').removeClass('active'); 
	});
	
	
	
})();

	

</script>
  </head>
  
  <body>
    <div id="container">
	<div id="hd">
    	<div class="hd-top">
            <h1 class="logo"><a href="javascript:;" class="logo-icon"></a></h1>
            <div class="user-info">
                <a href="javascript:;" class="user-avatar"><span><i class="info-num">2</i></span></a>
                <span class="user-name">admin</span>
                <a href="javascript:;" class="more-info"></a>
            </div>
            <div class="setting ue-clear">
            	<div class="setting-skin">
                	<div class="switch-bar">
                    	<i class="skin-icon"></i>
                        <span class="text">皮肤</span>
                        <i class="arrow-icon"></i>
                    </div>
                </div>
                <ul class="setting-main ue-clear">
                	<li><a href="javascript:;">桌面</a></li>
                    <li><a href="javascript:;">设置</a></li>
                    <li><a href="javascript:;">帮助</a></li>
                    <li><a href="javascript:;" class="close-btn exit"></a></li>
                </ul>
            </div>
        </div>
        <div class="hd-bottom">
        	<i class="home"><a href="javascript:;"></a></i>
        	<div class="nav-wrap">
                <ul class="nav ue-clear">
                    <li><a href="${pageContext.request.contextPath}/form/systemManage/ummaster.jsp">计量单位管理</a></li>
                    <li><a href="javascript:;">分类管理</a></li>
                    <li><a href="javascript:;">部门信息维护</a></li>
                    <li><a href="javascript:;">入库管理</a></li>
                    <li><a href="javascript:;">出库管理</a></li>
                    <li><a href="javascript:;">物料信息维护</a></li>
                    <li><a href="javascript:;">仓库信息维护</a></li>
                    <li><a href="javascript:;">仓位信息维护</a></li>
                    <li><a href="javascript:;">报表</a></li>
                     <li><a href="javascript:;">供应商信息维护</a></li>
                    <li><a href="javascript:;">供应商类型维护</a></li>
                </ul>
            </div>
            <div class="nav-btn">
            	<a href="javascript:;" class="nav-prev-btn"></a>
                <a href="javascript:;" class="nav-next-btn"></a>
            </div>
        </div>
    </div>
    <div id="bd">
        <iframe width="100%" height="100%" id="mainIframe" src="${pageContext.request.contextPath}/test/navtest.jsp" frameborder="0"></iframe>
    </div>
    
    <div id="ft" class="ue-clear">
    	<div class="ft1 ue-clear">
        	<i class="ft-icon1"></i>
            <span>仓库管理系统</span>
            <em>Digital Pertal</em>
        </div>
        <div class="ft2 ue-clear">
        	<span>Call Center</span>
            <em>V2.0 2014</em>
            <i class="ft-icon2"></i>
        </div>
    </div>
</div>


            <p class="tips">如果是请点击“确定”，否则点“取消”</p>
            
            <div class="buttons">
                <input type="button" class="button long2 ok" value="确定">
                <input type="button" class="button long2 normal" value="取消">
            </div>
        
        
    


<div class="opt-panel user-opt" style="top:52px;left:330px;">
	<ul>
    	<li><a class="text">用户资料</a></li>
        <li><a class="text">短消息<span class="num">(2)</span></a></li>
        <li><a class="text">资料信息</a></li>
        <li><a class="text">注销</a></li>
        <li><a class="text">自定义</a></li>
    </ul>
    <div class="opt-panel-tl"></div>
    <div class="opt-panel-tc"></div>
    <div class="opt-panel-tr"></div>
    <div class="opt-panel-ml"></div>
    <div class="opt-panel-mr"></div>
    <div class="opt-panel-bl"></div>
    <div class="opt-panel-bc"></div>
    <div class="opt-panel-br"></div>
    <div class="opt-panel-arrow"></div>
</div>

<div class="opt-panel skin-opt" style="top:36px;right:157px;">
	<ul class="ue-clear">
    	<li attr-color="#0f8dc7"></li>
        <li attr-color="#1ea4a9"></li>
        <li attr-color="#eb7f00"></li>
        <li attr-color="#ed0f04"></li>
        <li attr-color="#f24b39"></li>
        <li attr-color="#ed0f04"></li>
        <li attr-color="#eb7f00"></li>
        <li attr-color="#ed0f04"></li>
        <li attr-color="#1ea4a9"></li>
    </ul>
    <div class="opt-panel-ml"></div>
    <div class="opt-panel-mr"></div>
    <div class="opt-panel-bl"></div>
    <div class="opt-panel-bc"></div>
    <div class="opt-panel-br"></div>
</div>


  </body>
</html>
