package com.league.myrecord.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.base.platform.framework.utils.SpringSecurityUtils;
import com.base.platform.framework.web.action.BaseContorller;
import com.league.myrecord.model.MyRecordBo;
import com.league.myrecord.service.MyRecordServiceFacade;
import com.league.sys.LeagueUser;

@Controller
@RequestMapping(value = "/user")
public class MyRecordContorller extends BaseContorller{
	
	private static final long serialVersionUID = 6807712849840659045L;
	private static final Logger logger = Logger.getLogger(MyRecordContorller.class);

	@Autowired
	private MyRecordServiceFacade myRecordServiceFacade;
	
	private String page;//分页
	private int rp;//
	private long pageNum;
	private long totalCount;
	private String sortname;// 排序
	private String sortorder;
	private Long ids;
	private String  checkbox;
	private MyRecordBo  myRecordBo;//成员
	
	
	@RequestMapping(value = { "/login" }, method = {RequestMethod.POST,RequestMethod.GET })
	public String login(HttpServletRequest request) {
		try {
			List recordList = myRecordServiceFacade.findBy("loginName",
					SpringSecurityUtils.getCurrentUserName());
			MyRecordBo userBo = null;
			if (recordList != null && recordList.size() > 0) {
				userBo = (MyRecordBo) recordList.get(0);
			}
			if (userBo == null) {
				return "igo/index/login";
			}

			// 首次登陆，往session中放用户信息
			Object user = request.getSession().getAttribute("user");
			if (user == null
					|| user != null
					&& !userBo.getLoginName().equals(
							((MyRecordBo) user).getLoginName())) {
				logger.info(userBo.getTrueName() + " :开始登录啦......");
				request.getSession().setAttribute("user", userBo);

				LeagueUser leagueUser = new LeagueUser();
				leagueUser.setLoginName(userBo.getLoginName());
				List<MyRecordBo> userInfoList = myRecordServiceFacade.findBy(
						"loginName", userBo.getLoginName());// 根据操作人去个人档中查询trueName
				if (userInfoList != null && userInfoList.size() > 0) {
					MyRecordBo myRecordBo = (MyRecordBo) userInfoList.get(0);
					leagueUser.setRealName(myRecordBo.getTrueName());

					String photoPath = myRecordBo.getPhotoPath();
					if (photoPath != null && !photoPath.trim().equals("")) {
						leagueUser.setPhotoPath(photoPath);
					} else {
						leagueUser.setPhotoPath(null);
					}

					leagueUser.setProjectId(myRecordBo.getProjectId());
					leagueUser.setReleaseId(myRecordBo.getReleaseId());
					leagueUser.setIteratorId(myRecordBo.getIteratorId());

				}
				request.getSession()
						.setAttribute("leagueUser", leagueUser);
			}


		} catch (Exception e) {
			logger.error("登录失败", e);
			return "igo/index/login";
		}
		return "igo/index/index";
	}
	
	/**
	 * 用户开始登出系统
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/logout" }, method = {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		try {
			String userName = "";
			if (request.getSession().getAttribute("user") != null) {
				userName = ((MyRecordBo) request.getSession()
						.getAttribute("user")).getTrueName();

				logger.info(userName + " :开始注销啦......");
			}

			// 更新数据库--
			LeagueUser leagueUser = (LeagueUser) request.getSession()
					.getAttribute("leagueUser");
			String leagueLoginName = leagueUser.getLoginName();
			if (leagueLoginName != null && !leagueLoginName.trim().equals("")) {
				List<MyRecordBo> userInfoList = myRecordServiceFacade.findBy(
						"loginName", leagueLoginName);// 根据操作人去个人档中查询trueName
				if (userInfoList != null && userInfoList.size() > 0) {
					MyRecordBo myRecordBo = (MyRecordBo) userInfoList.get(0);
					myRecordBo.setProjectId(leagueUser.getProjectId());
					myRecordBo.setReleaseId(leagueUser.getReleaseId());
					myRecordBo.setIteratorId(leagueUser.getIteratorId());
					myRecordServiceFacade.doSave(myRecordBo);
				}
			}

			// 清空用户session
			request.getSession().removeAttribute("user");
			request.getSession().removeAttribute("leagueUser");

			// 开始重定位登出
			response.sendRedirect(
					request.getContextPath()
							+ "/j_spring_security_logout");
		} catch (Exception e) {
			logger.error("登出失败", e);
		}
		return "igo/index/login";
	}
	
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public int getRp() {
		return rp;
	}
	public void setRp(int rp) {
		this.rp = rp;
	}
	public String getSortname() {
		return sortname;
	}
	public void setSortname(String sortname) {
		this.sortname = sortname;
	}
	public String getSortorder() {
		return sortorder;
	}
	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}
	public Long getIds() {
		return ids;
	}
	public void setIds(Long ids) {
		this.ids = ids;
	}
	public String getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
	public MyRecordBo getMyRecordBo() {
		return myRecordBo;
	}
	public void setMyRecordBo(MyRecordBo myRecordBo) {
		this.myRecordBo = myRecordBo;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getPageNum() {
		return pageNum;
	}

	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}

}
