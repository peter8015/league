<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/commons/commonTag.jsp"%>
<%@ include file="/commons/commonMeta.jsp"%>
<%@ include file="/commons/commonJS.jsp"%>


<!doctype html>
<head>
<base href="${ctx}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guider</title>

<link rel="Shortcut Icon" href="${ctx}/pages/leaguecss/images/igo.ico">
<link rel="stylesheet" type="text/css" href="${ctx}/css/other/global.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/other/miaov_style.css" />

<link rel="stylesheet" type="text/css">
.navbar-inverse {
  background-color: #FF6600;
  border-color: #FF6600;
}
</link>
<script type="text/javascript" src="${ctx}/other/js/miaov.js"></script>
<script type="text/javascript">
	$(function() {
	});

	function person_D() {
		var pn = document.getElementById("person_name");
		var pdc = document.getElementById("person_Dc");
		var pi = document.getElementById("person_icon");
		if (pi.className == "icon-down") {
			pi.className = "icon-up";
			pdc.className = "person_detail";
		} else {
			pi.className = "icon-down";
			pdc.className = "person_detail none";
		}
	}
</script>
</head>
<body>

	<div class="container">
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div>
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</a> 
				<a class="brand" href="index.html">
					<img src="${ctx}/images/league/igo/league_icon.png" />
				</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li class="divider-vertical"></li>
						<li class="">
							<a href="#"> 
								<span> 
									<img src="${ctx}/images/league/igo/home_icon.png" />
								</span>我的主页
							</a>
						</li>
						<li><div class="input-append btn-group">
								<input type="text" class="span2" placeholder="请输入文字..." /> 
									<a class="btn dropdown-toggle" data-toggle="dropdown"
									href="search01.html#">搜项目<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="search01.html#">搜团队</a></li>
									<li><a href="search01.html#">搜人员</a></li>
									<li><a href="search01.html#">搜任务</a></li>
								</ul>
							</div></li>

						<li><button type="submit" class="btn marg_t05 marg_l03">搜索</button></li>
					</ul>

					<ul class="nav" style="float: right;">
						<li class="tools"><a href="#"><img
								src="${ctx}/images/league/igo/defect.jpg" /><span class="num">5</span></a></li>
						<li class="tools"><a href="#"><img
								src="${ctx}/images/league/igo/task.jpg" /><span class="num">33</span></a></li>
						<li class="active posi_r"><a href="#" id="person_name"
							onclick="person_D()"><img
								src="${ctx}/images/league/igo/people_icon.png" /> 何欣<span
								class="icon-down" id="person_icon"></span></a>
							<div class="person_detail none" id="person_Dc">
								<p>
									<a href="#">个人资料</a>
								</p>
								<p>
									<a href="#">密码修改</a>
								</p>
							</div></li>
						<li><a href="#"><span><img
									src="${ctx}/images/league/igo/exit.jpg" /></span></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
     
	<div style="margin-top: 50px;"></div>
	<div class="logo_menu">
		<div class="container">
			<a href="#" class="logo"><img src="${ctx}/images/league/igo/logo.png" /></a>
			<a href="#" class="ad"><img src="${ctx}/images/league/igo/ad.jpg" /></a>
		</div>
		<div class="clr10"></div>
<!-- 		<div class="menu"> -->
<!-- 			<div class="container"> -->
<!-- 				<a href="#">鹰眼</a> <a href="#">故事树</a> <a href="#">版本树</a> <a -->
<!-- 					href="#">冲刺计划</a> <a href="#">冲刺墙</a> <a href="#">任务墙</a> <a -->
<!-- 					href="#">缺陷墙</a> <a href="#">故事集</a> <a href="#">故事集</a> -->
<!-- 			</div> -->
<!-- 		</div> -->
		
	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav">
				<li class="active"><a href="#"><b>鹰眼</b></a></li>
				<li><a href="#"><b>故事树</b></a></li>
				<li><a href="#">版本树</a></li>
				<li><a href="#">冲刺计划</a></li>
				<li><a href="#">冲刺墙</a></li>
				<li><a href="#">任务墙</a></li>
				<li><a href="#">缺陷墙</a></li>
				<li><a href="#">故事集</a></li>
			</ul>
		</div>
	</div>	

	<div class="row">
		<div class="navbar">
			<div id="myCarousel" class="carousel">
				<!-- Carousel items -->
				<div class="carousel-inner">
					<div class="active item">
						<img alt="" src="${ctx}/images/league/igo/img02.jpg" >
					</div>
					<div class="item">
						<img alt="" src="${ctx}/images/league/igo/img03.jpg">
					</div>
					<div class="item">
						<img alt="" src="${ctx}/images/league/igo/img04.jpg">
					</div>
					<!--  
					<div class="item">
						<div class="row">
							<div class="span4">
							sfsfsdfds
							</div>
							<div class="span4">
							12133
							</div>
							<div class="span4">
								qqqq
							</div>
							
						</div>
					</div>
					-->
				</div>
				
				<!-- Carousel nav -->
				<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a> 
				<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
			</div>
		</div>
	</div>
	
	<div>
		<div class="">
	        <p class="pull-right"><a href="${ctx}/guider.do">回到顶端</a></p>
			<table class="table">
				<tr>
					<td>
					             我们倾注世间之爱于设计与创作 <a href="#">IGO</a> by <a href="#">LEAGUE GROUP</a> <br>
	            	            开源依照 <a href="http://www.apache.org/licenses/LICENSE-2.0" target="_blank">Apache License v2.0</a> 发布。<br> 
   		    			Icons取自 <a href="http://glyphicons.com">Glyphicons Free</a>，授权依照 <a href="http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>。
						
					</td>
				</tr>			
			</table>
	    </div>
    </div>

	</div>


</body>
</html>