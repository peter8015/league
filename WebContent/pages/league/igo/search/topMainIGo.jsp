<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/commons/commonTag.jsp"%>
<%@ include file="/commons/commonMeta.jsp"%>
<!--<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-1.9.1.js"></script>-->
<script type="text/javascript">  
function selectFirstTitle(firstTitleId) {
	var firstTitles=document.getElementsByName("firstTitle");
	for (var i=0; i<firstTitles.length; i++ ) {
		firstTitles[i].className="";
	}
	document.getElementById(firstTitleId).className="on";
}
</script>

<div class="topbar clearfix ">
	<div class="w1200">
		<div class="tablist_link fl">
        	<span class="icon sy fl"></span><a href="${ctx}/sym/user/login.do" class="tablist_link_i fl">我的主页</a>
            <div class="tablist_search"><input type="text" class="input_search" value="搜 文档/图片" title="搜 影视/音乐/应用" onfocus="this.value=''" onblur="this.value='搜 任务/文档/图片'" /><input value="&nbsp;" title="点击开始搜索" type="button" class="bt_search" /></div>
        </div>
        <div class="project_name">项目名称：<select id="wholeProject">
                  <option value="">--请选择--</option>
	  	          <s:iterator value="#session.projectList" >
	  	 	      <option value="<s:property value='value'/>"><s:property value="name"/></option>
	  	          </s:iterator>
                
        </select>
        
        <script type="text/javascript">
  	           //$("#wholeProject").val("<s:property value='#session.leagueUser.projectId'/>");
        </script>
        </div>
        
        <div class="tool_set fr">
<!--            <div class="space_set fr"><a href="#" class="icon space" title="空间设置"></a></div>-->
<!--            <div class="subnav_set fr">-->
<!--            	<a href="#" class="subnav_tx fl">娱乐<em class="num_btn"><b>3</b></em></a>-->
<!--                <a href="#" class="subnav_tx fl">I Go<em class="num_btn"><b>30</b></em></a>-->
<!--            </div>-->
        	<div class="person_set fr">
            	<span class="icon person fl"></span>
                <a href="#" class="name"><s:property value="#session.leagueUser.realName"/> </a>
                <div class="email_phone none">
               			<ul>
                        	<li><a href="#"><span>Email:</span>*******@bankht.com.cn</a></li>
                            <li><a href="#"><span>Tel:</span>13088886666</a></li>
                        </ul>
                </div>
                <a href="${ctx}/sym/user/logout.do"  class="exit"  >[退出]</a>
            </div>
        </div>
    </div> 
</div>

<div class="nav  w1200">
<!--	<a href="${ctx}/process/ProjectContorller/newProjectList.do" id="home" title="Home" name="firstTitle">&nbsp;</a>-->
<!--<a href="${ctx}/guide/GuideContorller/guideList.do" id="home" title="Home" name="firstTitle">&nbsp;</a>-->
<a href="${ctx}/pages/league/igo/guide/search_index.jsp" id="home" title="Home" name="firstTitle">&nbsp;</a>
	
	<ul class="nav_menu">
    	<li>
    	<a href="#" title="BIRDS-EYE VIEW" id="bird" name="firstTitle">BIRDS-EYE</a>
    	</li>
    	
    	<li><a href="${ctx}/process/ProjectContorller/viewProject.do?projectId=<s:property value='#session.leagueUser.projectId'/>&projectIdentifier=<s:property value='#session.leagueUser.projectIdentifier'/>" title="PROJECT" id="project" name="firstTitle">PROJECT</a></li>

<!--        <li><a href="${ctx}/igo/IGoContorller/projectList.do" title="PROJECT" id="project" name="firstTitle">PROJECT</a></li>-->
        <li><a href="${ctx}/treeTable/StoryTreeContorller/storyTreeList.do" title="STORY" id="story" name="firstTitle">STORY</a></li>
        <li><a href="${ctx}/igo/IGoContorller/timeAxisList.do" id="clock" title="TIME AXIS" name="firstTitle">TIME AXIS</a></li>
        <li><a href="#" title="BUG" id="bug" name="firstTitle">BUG</a></li>
        <li><a href="#" title="LOG" id="log" name="firstTitle">LOG</a></li>
        <li><a href="#" title="MURMURS" id="murmurs" name="firstTitle" >MURMURS</a></li>
    </ul>	
	
<!--    <a class="on" title="TIME AXIS" name="firstTitle">TIME AXIS</a>-->
<!--    <a href="${ctx}/igo/IGoContorller/projectList.do" title="PROJECT" id="project" name="firstTitle">PROJECT</a>-->
<!--    <a href="#" title="BIRDS-EYE VIEW" id="bird" name="firstTitle">BIRDS-EYE VIEW</a>-->
<!--    <a href="${ctx}/igo/IGoContorller/addStory.do" title="STORY">STORY</a>-->
<!--    <a href="${ctx}/igo/IGoContorller/myStoryList.do" title="STORY" id="story" name="firstTitle">STORY</a>-->
<!--    <a href="#" title="BUG" id="bug" name="firstTitle">BUG</a>-->
<!--    <a href="#" title="LOG" id="log" name="firstTitle">LOG</a>-->
<!--    <a href="#" title="MURMURS" id="murmurs" name="firstTitle">MURMURS</a>-->
</div>
