package com.league.project.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.base.platform.framework.web.action.BaseContorller;
import com.league.myrecord.model.MyRecordBo;
import com.league.project.model.ProjectBo;
import com.league.project.service.ProjectService;

@Controller
public class ProjectContorller extends BaseContorller{
	private static final Logger logger = Logger.getLogger(ProjectContorller.class);
	@Resource(name = "projectService")
	private ProjectService projectService;
	private ProjectBo projectBo;//分页
	
	@RequestMapping(value = { "/project/guideList" }, method = {RequestMethod.POST,RequestMethod.GET })
	//如果有项目的情况下，进入的项目列表页面
	public String guideList(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception{
		MyRecordBo user = (MyRecordBo) session.getAttribute("user");//获取session
		List projectList = new ArrayList();
		// 管理员显示所有项目、其他人员仅显示其所在的项目
//		if("admin".equals(user.getUserType())){
//			projectList = projectService.findProjectList();
//		}else{
//			List<ProjectUserBo> recordList = projectService.findBy("userId", user.getId());
//			for (ProjectUserBo bo : recordList) {
//				projectList.add(projectService.findEntityBeanById(bo.getProjectId()));
//			}
//		}
		projectList = projectService.findBy("isPublic","1");//第一个是字段名，第二个是值
		// 项目不为空或不是管理员时显示项目列表
		if((projectList!=null &&projectList.size()>0) || (!"admin".equals(user.getUserType()))){//说明有项目
			request.getSession().setAttribute("projectList", projectList);
			return "igo/project/projectList";
		}else{
			return "igo/project/guideList";//指引页
		}		
	}
	@RequestMapping(value = { "/project/gotoProjectGuide" }, method = {RequestMethod.POST,RequestMethod.GET })
	//进入项目指引页面
	public String gotoProjectGuide(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String projectId=request.getParameter("projectId");
		ProjectBo projectBo = projectService.findEntityBeanById(Long.valueOf(projectId));
		request.getSession().setAttribute("projectBoView", projectBo);
//		LeagueUser user = (LeagueUser) ActionContext.getContext().getSession().get("leagueUser");//当前用户
//		user.setProjectId(projectId);
//		String projectIdentifier = new String(request.getParameter("projectIdentifier").getBytes("ISO8859_1"), "UTF-8");
//		user.setProjectIdentifier(projectIdentifier);
		return "igo/project/gotoProjectGuide";
	}

}
