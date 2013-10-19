package com.league.search.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.platform.framework.web.action.BaseContorller;
import com.league.project.model.ProjectBo;
import com.league.project.service.ProjectService;
import com.league.search.model.KeywordBo;
import com.league.search.model.SearchContentBo;
import com.league.search.service.KeywordServiceFacade;
import com.league.search.service.SearchServiceFacade;

@Controller
@RequestMapping(value = "/search")
public class SearchContorller extends BaseContorller {

	private static final long serialVersionUID = 6807712849840659045L;
	private static final Logger logger = Logger.getLogger(SearchContorller.class);
	
	@Resource(name = "projectService")
	private ProjectService projectService;

	@Autowired
	private SearchServiceFacade searchService;

	@Autowired
	private KeywordServiceFacade keywordService;

	/**
	 * 当前第几页
	 */
	private String page;

	/**
	 * 总页数
	 */
	private long pageNum;

	/**
	 * 总条数
	 */
	private long totalCount;

	/**
	 * 功能：查询输入时联想到的关键字
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = { "/getKeywords" }, method = {RequestMethod.POST,RequestMethod.GET })
	@ResponseBody
	public List<String> getKeywords() throws Exception {
		// List<SearchContentBo> searchContentList =
		// searchServiceFacade.findAll();
		List<KeywordBo> keywordList = keywordService.findAll();
		List<String> namelist = new ArrayList<String>();
		for (KeywordBo bo : keywordList) {
			namelist.add(bo.getName());
		}
		return namelist;
//		JSONUtil.writeResponse(namelist, ServletActionContext.getResponse()
//				.getWriter());
	}

	/**
	 * 功能：获取搜索结果
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = { "/getSearchContent/{queryParam}" }, method = {RequestMethod.GET })
	public String getSearchContent(@PathVariable String queryParam, Model model) throws Exception {
		try {
			if(page == null){
				page = "1";
			}
			
			SearchContentBo bo = new SearchContentBo();
			bo.setProjectName(queryParam);
			bo.setCardName(queryParam);
			bo.setCardType(queryParam);
			List<SearchContentBo> resultList = searchService
					.pageOrQuery(Integer.parseInt(page),5,bo);
			
//			List<String> namelist = new ArrayList<String>();
//			for (SearchContentBo bo : searchContentList) {
//				namelist.add(bo.getName());
//			}
//			JSONUtil.writeResponse(searchContentList, ServletActionContext.getResponse()
//					.getWriter());
			model.addAttribute("resultList", resultList);
			return "igo/search/searchResult";
		} catch (Exception e) {
			logger.error("获取搜索结果失败", e);
		}
		return null;
	}
	
	/**
	 * 功能：获取项目列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = { "/getProjectList" }, method = {RequestMethod.POST,RequestMethod.GET })
	public String getProjectList(Model model) throws Exception {
		try {
			if(page == null){
				page = "1";
			}
			
			List<ProjectBo> projectList = projectService.findAll();
			model.addAttribute("projectList", projectList);
			
			return "igo/search/searchResult";
		} catch (Exception e) {
			logger.error("获取搜索结果失败", e);
		}
		return null;
	}
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public long getPageNum() {
		return pageNum;
	}

	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

}
