<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/commons/commonTag.jsp"%>
<%@ include file="/commons/commonMeta.jsp"%>
<div class="topbar clearfix">
	<div class="w1200">
		<div class="tablist_link fl">
        	<span class="icon sy fl"></span><a href="${ctx}/sym/user/login.do" class="tablist_link_i fl">我的主页</a>
            <div class="tablist_search"><input type="text" class="input_search" value="搜 文档/图片" title="搜 影视/音乐/应用" onfocus="this.value=''" onblur="this.value='搜 任务/文档/图片'" /><input value="&nbsp;" title="点击开始搜索" type="button" class="bt_search" /></div>
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
<!--                <a href="${ctx}/j_spring_security_logout"  class="exit"  >[退出]</a>-->
                <a href="${ctx}/user/logout.do"  class="exit"  >[退出]</a>
            </div>
        </div>
    </div>
</div>
<div class="header">
	<div class="head w1200">
    	<a href="#" class="logo"><img src="${ctx}/pages/leaguecss/images/logo.png" /></a>
        <div class="fr">
        </div>
    </div>
    <div class="nav w1200">
        <a href="${ctx}/sym/user/login.do" title="主页">主页</a>
        <a href="${ctx}/myrecord/MyRecordContorller/list.do" title="个人档">个人档</a>
<!--        <a href="${ctx}/igo/IGoContorller/list.do" title="I Go">I Go</a>-->
<!--        <a href="#" title="时光轴">时光轴</a>-->
<!--        <a href="#" title="工作">工作</a>-->
<!--        <a href="#" title="相册">相册</a>-->
<!--        <a href="#" title="好友圈">好友圈</a>-->
<!--        <a href="#" title="更多">更多</a>-->
    </div>
</div>