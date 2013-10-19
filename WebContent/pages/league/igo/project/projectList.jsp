<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/commons/commonTag.jsp"%>
<%@ include file="/commons/commonMeta.jsp"%>
<%@ include file="/commons/commonCiteList1.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${ctx}/pages/leaguecss/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/pages/leaguecss/bootstrap/css/bootstrap-responsive.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${ctx}/pages/leaguecss/bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/pages/leaguecss/css/igo_global.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/pages/leaguecss/css/miaov_style.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/pages/leaguecss/css/bootcss_re.css" />
<link rel="shortcut icon" type="image/x-icon" href="${ctx}/pages/leaguecss/images/igo.ico" />
<script type="text/javascript" src="${ctx}/pages/leaguecss/js/person_D.js"></script>
<title>项目列表</title>
</head>
<body>
<%@ include file="/commons/commonHead.jsp"%>

<div style="margin-top:50px;"></div>
<div class="container">
	<div class="logo_menu">
    	<a href="#" class="logo"><img src="${ctx}/pages/leaguecss/images/igo/logo.png" /></a>
        <a href="#" class="ad"><img src="${ctx}/pages/leaguecss/images/igo/ad.jpg" /></a>
	</div>
    <div class="clr10"></div>
    <div class="pro_list_box">
    	<div class="clr10"></div>
        	<div class="pro_list_l span8">
            	<ul>
            	
            	<c:forEach items="${projectList}" var="ex">
                	<li class="on">
                    	<div class="pro_img"><a href="${ctx}/project/gotoProjectGuide?projectId=${ex.id}&projectIdentifier=${ex.identifier}"><img src="${ctx}/pages/leaguecss/images/igo/pro_img01.jpg" /></a></div>
                        <div class="item_info">
                        	<div class="item_tit"><h2>${ex.name}</h2><span class="star"><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /></span></div>
                            <div class="item_icon"><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/defect.jpg" /></a><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/defect.jpg" /></a></div>
                        </div>
                        <div class="admin_btn">
<!--                        <a href="#"><span class="create_pro"></span>创建项目模板</a><a href="#" class="gray_S_btn"><span class="del_pro"></span>删除项目</a>-->
                        </div>
                        <div class="level">98分<span class="level_tips_up02"></span></div>
                        <div class="clr10"></div>
                    </li>

                    </c:forEach>
<!--                    <li>-->
<!--                    	<div class="pro_img"><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/pro_img01.jpg" /></a></div>-->
<!--                        <div class="item_info">-->
<!--                        	<div class="item_tit"><h2>项目名称</h2><span class="star"><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /></span></div>-->
<!--                            <div class="item_icon"><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/defect.jpg" /></a><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/defect.jpg" /></a></div>-->
<!--                        </div>-->
<!--                        <div class="admin_btn"><a href="#"><span class="create_pro"></span>创建项目模板</a><a href="#" class="gray_S_btn"><span class="del_pro"></span>删除项目</a></div>-->
<!--                        <div class="level">98分<span class="level_tips_up"></span></div>-->
<!--                        <div class="clr10"></div>-->
<!--                    </li>-->
<!--                    <li>-->
<!--                    	<div class="pro_img"><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/pro_img01.jpg" /></a></div>-->
<!--                        <div class="item_info">-->
<!--                        	<div class="item_tit"><h2>项目名称</h2><span class="star"><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /></span></div>-->
<!--                            <div class="item_icon"><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/defect.jpg" /></a><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/defect.jpg" /></a></div>-->
<!--                        </div>-->
<!--                        <div class="admin_btn"><a href="#"><span class="create_pro"></span>创建项目模板</a><a href="#" class="gray_S_btn"><span class="del_pro"></span>删除项目</a></div>-->
<!--                        <div class="level">98分<span class="level_tips_up"></span></div>-->
<!--                        <div class="clr10"></div>-->
<!--                    </li>-->
<!--                    <li>-->
<!--                    	<div class="pro_img"><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/pro_img01.jpg" /></a></div>-->
<!--                        <div class="item_info">-->
<!--                        	<div class="item_tit"><h2>项目名称</h2><span class="star"><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /></span></div>-->
<!--                            <div class="item_icon"><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/defect.jpg" /></a><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/defect.jpg" /></a></div>-->
<!--                        </div>-->
<!--                        <div class="admin_btn"><a href="#"><span class="create_pro"></span>创建项目模板</a><a href="#" class="gray_S_btn"><span class="del_pro"></span>删除项目</a></div>-->
<!--                        <div class="level">98分<span class="level_tips_up"></span></div>-->
<!--                        <div class="clr10"></div>-->
<!--                    </li>-->
<!--                    <li>-->
<!--                    	<div class="pro_img"><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/pro_img01.jpg" /></a></div>-->
<!--                        <div class="item_info">-->
<!--                        	<div class="item_tit"><h2>项目名称</h2><span class="star"><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /><img src="${ctx}/pages/leaguecss/images/igo/star01.png" /></span></div>-->
<!--                            <div class="item_icon"><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/defect.jpg" /></a><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/defect.jpg" /></a></div>-->
<!--                        </div>-->
<!--                        <div class="admin_btn"><a href="#"><span class="create_pro"></span>创建项目模板</a><a href="#" class="gray_S_btn"><span class="del_pro"></span>删除项目</a></div>-->
<!--                        <div class="level">98分<span class="level_tips_up"></span></div>-->
<!--                        <div class="clr10"></div>-->
<!--                    </li>-->
                </ul>
                <div class="page marg_l30">
                
                	<a href="#" class="btn marg_l03">上一页</a><a href="#" class="btn marg_l03">1</a><a href="#" class="btn btn-warning marg_l03">2</a><a href="#" class="btn marg_l03">3</a><a href="#" class="btn marg_l03">4</a><a href="#" class="btn marg_l03">下一页</a>
                </div>
            </div>
        <div class="paihang">
            <div class="item_phb">
            	<div class="item_phb_tm">
                	<div class="rank"><span><img src="${ctx}/pages/leaguecss/images/igo/rank1.png" /></span></div>
                    <div class="honour">
                    	<span><img src="${ctx}/pages/leaguecss/images/igo/person_ph_li.png" /></span>
                        <span><img src="${ctx}/pages/leaguecss/images/igo/person_ph_li.png" /></span>
                        <span><img src="${ctx}/pages/leaguecss/images/igo/person_ph_li.png" /></span>
                    </div>
                    <div class="item_name">LEAGUE项目组</div>
                    <div class="item_des">
                    	<div class="txt">league项目简介、项目简介项目简介、项目简介项目简介、项目简介</div>
                        <span class="level">98分</span>
                    </div>
                    <div class="item_member">
                    	团队成员：<a href="#"><img src="${ctx}/pages/leaguecss/images/igo/pro_img01.jpg" /></a><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/pro_img01.jpg" /></a><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/pro_img01.jpg" /></a><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/pro_img01.jpg" /></a><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/pro_img01.jpg" /></a><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/pro_img01.jpg" /></a><a href="#"><img src="${ctx}/pages/leaguecss/images/igo/pro_img01.jpg" /></a>
                    </div>
                </div>
                <div class="page_num">
                	<a href="#" class="play"></a><a href="#" class="num">1</a><a href="#" class="num">2</a><a href="#" class="num">3</a>
                </div>
            </div>
            <div class="clr10"></div>
            <div class="person_phb">
            	<div class="person_phb_tit"><span class="jiangb"></span>个人活跃度</div>
                <div class="person_phb_cont">
                	<ul>
                    	<li>
                        	<span class="P_phb_C_li_icon">1</span><span class="P_phb_C_li_img"><img src="${ctx}/pages/leaguecss/images/igo/pro_img01.jpg" /></span><a href="#" class="name">姓名</a><a href="#" class="add_friend"></a>
                        </li>
                        <li>
                        	<span class="P_phb_C_li_icon">2</span><span class="P_phb_C_li_img"><img src="${ctx}/pages/leaguecss/images/igo/pro_img01.jpg" /></span><a href="#" class="name">姓名</a><a href="#" class="add_friend"></a>
                        </li>
                        <li>
                        	<span class="P_phb_C_li_icon">3</span><span class="P_phb_C_li_img"><img src="${ctx}/pages/leaguecss/images/igo/pro_img01.jpg" /></span><a href="#" class="name">姓名</a><a href="#" class="add_friend"></a>
                        </li>
                        <li>
                        	<span class="P_phb_C_li_icon">4</span><span class="P_phb_C_li_img"><img src="${ctx}/pages/leaguecss/images/igo/pro_img01.jpg" /></span><a href="#" class="name">姓名</a><a href="#" class="add_friend"></a>
                        </li>
                        <li>
                        	<span class="P_phb_C_li_icon">5</span><span class="P_phb_C_li_img"><img src="${ctx}/pages/leaguecss/images/igo/pro_img01.jpg" /></span><a href="#" class="name">姓名名</a><span class="img_icon"><img src="${ctx}/pages/leaguecss/images/igo/defect.jpg" /></span><a href="#" class="add_friend"></a>
                        </li>
                    </ul>
                </div>
            </div>
		</div>
            <div class="clr10"></div>
    </div>
</div>
<div style="height:120px;"></div>
</body>
</html>