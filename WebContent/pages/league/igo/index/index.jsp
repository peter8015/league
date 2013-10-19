<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/commonTag.jsp"%>
<%@ include file="/commons/commonMeta.jsp"%>
<%@ include file="topIndex.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="${ctx}/pages/leaguecss/css/global.css" />
<link rel="shortcut icon" type="image/x-icon" href="${ctx}/pages/leaguecss/images/favicon.ico" />
<title>首页</title>
<script type="text/javascript" language="javascript" src="${ctx}/js/common/jquery-1.2.6.js"></script>
<script type="text/javascript">
function itemlist(){
	list=document.getElementById('subnav_second_list');
	if(list.className=='none')
	{
		list.className="block";
	}else{
		if(list.className=='block')
		{
			list.className="none";
		}
	}
}
function logout(){
	top.window.location.href="${ctx}/j_spring_security_logout"; 
}  
</script>
</head>
<body>
<div id=wrap>
<div class="clr15"></div>
<div class="container tl_border5">
<%@ include file="../../../league/igo/index/left.jsp"%>
    <div class="main">
    	<div class="friend_nearest_update">
        	<div class="friend_head_icon">
            	<ul>
                	<li><a href="#" class="on"><img src="${ctx}/pages/leaguecss/images/rw.png" /></a></li>
                    <li><a href="#"><img src="${ctx}/pages/leaguecss/images/rw.png" /></a></li>
                    <li><a href="#"><img src="${ctx}/pages/leaguecss/images/rw.png" /></a></li>
                    <li><a href="#"><img src="${ctx}/pages/leaguecss/images/rw.png" /></a></li>
                    <li class="txt"><strong style="font-size:14px;">好友最近更新</strong></li>
                </ul>
            </div>
            <div class="friend_update_list">
            	<ul>
                	<li>
                    	<a href="#" class="img"><img src="${ctx}/pages/leaguecss/images/img.png" /></a>
                    </li>
                    <li>
                    	<a href="#" class="img"><img src="${ctx}/pages/leaguecss/images/img.png" /></a>
                    </li>
                    <li>
                    	<a href="#" class="img"><img src="${ctx}/pages/leaguecss/images/img.png" /></a>
                    </li>
                    <li>
                    	<a href="#" class="img" onmouseover="document.getElementById('author-meta').style.bottom=1+'px';" onmouseout="document.getElementById('author-meta').style.bottom=-22+'px';"><img src="${ctx}/pages/leaguecss/images/img.png" /></a>
                        <a href="#" class="author_meta" style=" bottom:-22px;" id="author-meta">
                            <span class="txt ellipsis break">作者：<span>${sessionScope.leagueUser.realName}</span></span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="clr10"></div>
        <div class="person_publish">
        	<div class="person_head_img">
        	<c:choose>
        		<c:when test="${sessionScope.leagueUser.photoPath!=null}">
        			<img src="${ctx}/upload/myrecord/${sessionScope.leagueUser.photoPath}"  onerror="javascript:this.src='${ctx}/pages/leaguecss/images/100.jpg'" border="0" width="100" height="100" title="照片"/>
        		</c:when>
        		<c:otherwise>
        			 <img src="${ctx}/pages/leaguecss/images/100.jpg" border="0" width="100" height="100"/>
        		</c:otherwise>
        	</c:choose>
        
            </div>
            <div class="person_publish_border">
            <div class="person_publish_box">
            	<p><textarea></textarea></p>
                <p>
                    <div class="fr" style="width:195px;">
                    	<span class="icon eye"></span>
                    	<div class="select fr">所有人可见
                        <div class="select_list none"><!--点击所有人可见后的小三角时，这个层应该是显示，写法<div class="select_list block">-->
                        	<ul>
                            	<li><a href="#"><input type="checkbox" />指定好友可见</a></li>
                                <li><a href="#"><input type="checkbox" />GCS好友圈可见</a></li>
                                <li><a href="#"><input type="checkbox" />GCS好友圈可见</a></li>
                                <li><a href="#"><input type="checkbox" />GCS好友圈可见</a></li>
                                <li><a href="#"><input type="checkbox" />GCS好友圈可见</a></li>
                            </ul>
                        </div>
                        </div>
                        <a href="#" class="btn fr">发表</a>
                    </div>
                    <div class="fl"><a href="#" class="icon smile"></a><a href="#" class="icon at"></a><a href="#" class="icon jing"></a></div>
                    <div class="clr"></div>
                </p>
            </div>
            <div class="person_publish_jt"></div>
            </div>
        </div>
        <div class="clr10"></div>
        <div class="center_tab">
        	<div class="center_tab_T">
                <div class="tool"><a href="#" class="refresh icon"></a><a href="#" class="set icon"></a></div>
            	<ul>
                	<li><a href="#" class="on">全部</a></li>
                    <li><a href="#">相册</a></li>
                    <li><a href="#">日志</a></li>
                    <li><a href="#">提问</a></li>
                </ul>
            </div>
            <!-- div -->
           
            <div class="center_cont">
           
            	<ul class="center_cont_per">
            	 <c:forEach items="indexPingStringVoList" var="vo">
                	<li>
                    	<div class="head_img"><a href="#">
                    	<img src="${ctx}/upload/myrecord/${photoPath}" onerror="javascript:this.src='${ctx}/pages/leaguecss/images/100.jpg'" border="0" width="105" height="128" title="照片"/>
                    	</a></div>
                    	<div class="center_cont_info">
                        	<div class="center_cont_info_frs">
                            	<a href="#" class="name green bold">${realName}</a>
                            	<c:if test="${projectName!=null}">
                                <span class="blue">【<a href="#" class="blue">${projectName}</a>】</span>
                                </c:if>
                                <c:if test="${versionName!=null}">
                                <span class="gray01">【<a href="#" class="gray01">${versionName}</a>】</span>
                                </c:if>
                                <c:if test="${iteratorName!=null}">
                                <span class="red">【<a href="#" class="red">${iteratorName}</a>】</span>
                                </c:if>
                            </div>
                        	<div class="center_cont_info_sec">
                            	<p>${dynamic}</p>
                            </div>
                        	<div class="center_cont_info_thd" style="background:none;">
                            	<p style="background:none;">
                            	<span>${operatorDate}</span>
                                <a href="#" class="green">赞（1）</a>
                                <a href="#" class="green">回复</a>
                                <a href="#" class="green">分类</a>
                                <a href="#" class="green">转发</a>
                                </p>
                            </div>
                        </div>
                       <div class="clr"></div>
                    </li>
                    </c:forEach>
                </ul>
                	
            </div>
            <div style="width:100%;text-align:center;"><input type="button" value="下一页" onclick="javascript:window.location.href='${ctx}/sym/user/login.do?currenPage=${nextPageIndex}';"/></div>
        </div>
    </div>
<!--    <div class="right">-->
<!--    	<img src="${ctx}/pages/leaguecss/images/right.jpg" />-->
<!--    </div>-->
    <div class="clr"></div>
</div>
<div class="footer"></div>
</div>
</body>
</html>