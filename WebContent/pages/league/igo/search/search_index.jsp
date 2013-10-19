<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/commons/commonTag.jsp"%>
<%@ include file="/commons/commonMeta.jsp"%>
<%@ include file="/commons/commonJS.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%-- <link rel="Shortcut Icon" href="<%=request.getContextPath()%>/pages/leaguecss/images/igo.ico"> --%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/jqueryui/css/css/tck.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pages/leaguecss/css/igo_global.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pages/leaguecss/css/miaov_style.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/pages/leaguecss/js/miaov.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/pages/leaguecss/js/person_D.js"></script>
<title>搜索主页</title>
<script>

 	var availableTags = new Array();
	$(function() {
		showDiv();
		getKeywords();
		$( "#searchText" ).autocomplete({
			source: availableTags
		});
		
		// 隐藏页首搜索框
		$("#dropdownli").hide();
		$("#dropdownli").next().hide();
		
		//添加回车事件
		$(document).keydown(function(event) {
			switch (event.keyCode) {
			case 13:
				enterResponse();
				break;
			}
		});
		
	});
	
	// 显示回车进入项目列表提示
	function showDiv(){
		$('#popDiv').css('display','block');
		$('#popIframe').css('display','block');
		$('#bg').css('display','block');
	}
	
	function closeDiv(){
		$('#popDiv').css('display','none');
		$('#bg').css('display','none');
		$('#popIframe').css('display','none');
	}
	
	var tip = '" * "搜所有项目 "#+关键字"搜任务 "$+关键字"搜项目';
	var enterResponse = function(){
		var searchText = $("#searchText").val();
		if(searchText!=""&&searchText!=null&&searchText!=tip){
			doSearch();
		}else{
			window.location.href='<%=request.getContextPath() %>/project/guideList';
		}
	}
	
	function getKeywords() {
		$.getJSON("<%=request.getContextPath()%>/search/getKeywords",
				function(data){
					var str = new String(data);
					var keywords = str.split(",");
					for(var i in keywords){
						availableTags.push(keywords[i]);
					}
			});
	   }
	
	function doSearch(){
		var searchText = $("#searchText").val();
		if(searchText!=""&&searchText!=null&&searchText!=tip){
			if("*"==searchText){
				window.location.href='<%=request.getContextPath() %>/search/getProjectList';
			}else{
				window.location.href='<%=request.getContextPath() %>/search/getSearchContent/'+searchText;
			}
		}
	}
	
	var onSearchFocus = function(self){
		if(self.value==tip){
			self.value='';
		}
	}
	
	var onSearchBlur = function(self){
		if(self.value==""){
			self.value=tip;
		}
	}
	
	</script>
</head>

<body>
<%@ include file="/commons/commonHead.jsp"%>
<div style="margin-top:130px;"></div>
<div class="container">
	<div class="logo clearfix">
    	<a href="#"><img src="<%=request.getContextPath()%>/pages/leaguecss/images/igologo.png" /></a>
     </div>
    <div class="search_cont">
        <input type="text" class="span5" id="searchText" value='" * "搜所有项目 "#+关键字"搜任务 "$+关键字"搜项目'  onfocus="onSearchFocus(this);" onblur="onSearchBlur(this);"//>
        <button type="submit" onclick="doSearch();" class=" btn btn-warning marg_l03">走你</button>
    </div>
    <div>Guider</div>
    <div class="clr10"></div>
	<div>
<div id="div1">
	<a href="#" class="purple">移动办卡项目</a>
	<a href="#" class="pink">澳门二期</a>e
	<a href="#" class="red">催收</a>
	<a href="#" class="blue02">澳门新线改造</a>
	<a href="#" >精品</a>
	<a href="#" class="blue">妙味课堂</a>
	<a href="#" >SEO</a>
	<a href="#" class="red">特效</a>
	<a href="#" class="orange">JavaScript</a>
	<a href="#" >miaov</a>
	<a href="#" class="red">CSS</a>
	<a href="#" >求职</a>
	<a href="#" class="blue">面试题</a>
	<a href="#"  class="orange">继承</a>
	<a href="#" class="red">妙味课堂</a>
	<a href="#" class="blue">OOP</a>
	<a href="#" >XHTML</a>
</div>
    </div>
</div>

<div id="popDiv" class="mydiv" style="display:;">
	<div class="txt">
    	<p>Hi，伙伴：</p>
        <p class="text_c">敲"回车"键，<br />试试效果吧！</p>
        <p class="text_c"><a href="javascript:closeDiv()" id="close"><img src="<%=request.getContextPath()%>/pages/leaguecss/images/btn_knowl.png" /></a></p>
    </div>
</div>
<div id="bg" class="bg" style="display:;"></div>
<iframe id='popIframe' class='popIframe' frameborder='0' ></iframe>

</body>
</html>
