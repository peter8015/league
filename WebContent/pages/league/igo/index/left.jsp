<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/commons/commonTag.jsp"%>
<%@ include file="/commons/commonMeta.jsp"%>
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
</script>
<div class="left fl tlr_border5">
    	<div class="p_ownerInfo">
        	<a href="#" class="p_ownerInfo_img">
        	<c:choose>
		    <c:when test="${sessionScope.leagueUser.photoPath!=null}">
		      <img src="${ctx}/upload/myrecord/${#session.leagueUser.photoPath}"  onerror="javascript:this.src='${ctx}/pages/leaguecss/images/100.jpg'" border="0" width="100" height="100" title="照片"/>
		    </c:when>
		   <c:otherwise>  
		       <img src="${ctx}/pages/leaguecss/images/100.jpg" border="0" width="100" height="100"/>
		   </c:otherwise>
		  </c:choose>
        	</a>
            <div class="p_ownerInfo_tool">
            	<p><a class="messages_voice fr" href="#"><em class="num_btn2"><b>30</b></em></a><span class="p_name">${sessionScope.leagueUser.realName}<em class="p_owner_level"><span class="num n8"></span><span class="num n9"></span></em></span></p>
                <p><a href="${ctx}/myrecord/MyRecordContorller/list.do">[详细]</a><a href="${ctx}/myrecord/MyRecordContorller/addinput.do">[编辑]</a></p>
            </div>
        </div>
<!--    	<div class="subnav_fisrt clearfix">-->
<!--        	<ul>-->
<!--            	<li><a href="#" class="on"><span class="fr"><em class="num_btn2 fl"><b>22222</b></em></span><i class="hydt"></i>好友动态</a></li>-->
<!--                <li><a href="#"><i class="ywxg"></i>与我相关</a></li>-->
<!--                <li><a href="#"><i class="tbgz"></i>特别关注</a></li>-->
<!--                <li><a href="#"><i class="gxxc"></i>共享相册</a></li>-->
<!--            </ul>-->
<!--        </div>-->
        <div class="subnav_fisrt clearfix">
        	<ul>
<!--            	<li><a href="#"><i class=" xmdt"></i>项目动态</a></li>-->
<!--                 <li><a href="#"><span class="fr"><em class="num_btn2 fl"><b>2</b></em></span><i class=" xtgl"></i>系统管理</a></li>-->
<!--                <li><a href="#"><i class="jcb"></i>基础表</a></li>-->
<!--                <li><a href="#"><i class=" xmgl"></i>项目管理</a></li>-->
<!--                <li><a href="${ctx}/task/TaskCardContorller/searchlistNew.do" onclick="itemlist();"><i class=" igo"></i>I Go<em class="subnav_second_btn"></em></a>-->
<!--                	<div class="none" id="subnav_second_list">-->
<!--                    <a class="subnav_second on" href="#">我的工作台</a>-->
<!--                    <a class="subnav_second" href="#">我的工作台</a>-->
<!--                    <a class="subnav_second" href="#">我的工作台</a>-->
<!--                    <a class="subnav_second" href="#">我的工作台</a>-->
<!--                    </div>-->
<!--                </li>-->
                   <li>
<!--                <a href="${ctx}/igo/IGoContorller/list.do" title="I Go"><i class="igo"></i>I Go</a>
<!--                   <a href="${ctx}/igo/IGoContorller/myWorkList.do" title="I Go"><i class=" igo"></i>I Go</a>-->

                </li>
<!--                <li><a href="${ctx}/task/TaskCardContorller/searchISpyIndex.do"><i class="rygl"></i>I Spy</a></li>-->
<!--                <li><a href="${ctx}/task/TaskCardContorller/addinputIndex.do"><i class="rygl"></i>新增任务</a></li>-->
<!--                <li><a href="#"><i class="rygl"></i>人员管理</a></li>-->
            </ul>
        </div>
        <div class="subnav_sec clearfix">
        	<ul>
        	<li><a href="${ctx}/pages/league/igo/search/search_index.jsp" title="I Go"><img src="${ctx}/pages/leaguecss/images/go-icon.gif" /></a></li>
<!--            	<li><a href="${ctx}/process/ProjectContorller/newProjectList.do" title="I Go"><img src="${ctx}/pages/leaguecss/images/go-icon.gif" /></a></li>-->
            	<li><a href="#" title="I Go"><img src="${ctx}/pages/leaguecss/images/gray_icon.png" /></a>
            	</li>
            	<li><a href="#" title="I Go"><img src="${ctx}/pages/leaguecss/images/gray_icon.png" /></a>
            	</li>
            	<li><a href="#" title="I Go"><img src="${ctx}/pages/leaguecss/images/gray_icon.png" /></a>
            	</li>
            	<li><a href="#" title="I Go"><img src="${ctx}/pages/leaguecss/images/gray_icon.png" /></a>
            	</li>
            	<li><a href="#" title="I Go"><h1><strong>&nbsp;...</strong></h1></a>
            	</li>
            </ul>
        </div>
        <div class="clr30"></div>
    </div>