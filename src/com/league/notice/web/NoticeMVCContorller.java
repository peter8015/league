package com.league.notice.web;

/**
 * <p/>
 * NoticeContorller  which provides basic CRUD operations
 * 
 * @author Pan,Shaohua
 * @date 2013.10.11
 */

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.platform.framework.utils.FlexiGridJsonUtils;
import com.base.platform.framework.utils.StringToList;
import com.base.platform.framework.web.action.BaseContorller;
import com.league.notice.model.SsBankMsg;
import com.league.notice.model.SsBankMsgValidator;
import com.league.notice.service.ISsBankMsgService;

@Controller
public class NoticeMVCContorller extends BaseContorller {

	private static final Logger logger = Logger
			.getLogger(NoticeMVCContorller.class);

	@Resource(name = "ssBankMsgService")
	private ISsBankMsgService ssBankMsgService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new SsBankMsgValidator());
	}

	@RequestMapping(value = { "/mybatis/notice/NoticeContorller/selectinput" }, method = {
			RequestMethod.GET, RequestMethod.POST })
	public String selectInput(HttpServletRequest request, String ids)
			throws Exception {
		SsBankMsg SsBankMsg = ssBankMsgService.findEntityBeanById(Long
				.parseLong(ids));
		request.setAttribute("govDjgzBos", SsBankMsg);
		return "/pages/league/wzgl/mybatisdemo/view.jsp";
	}

	@RequestMapping(value = { "/mybatis/notice/NoticeContorller/addinputsyn" }, method = {
			RequestMethod.GET, RequestMethod.POST })
	public String addInputsyn() throws Exception {
		return "/pages/league/wzgl/mybatisdemo/add.jsp";
	}

	@RequestMapping(value = { "/mybatis/notice/NoticeContorller/savesyn" }, method = {
			RequestMethod.GET, RequestMethod.POST })
	public String savesyn(@Validated SsBankMsg ssBankMsgTempvo,
			BindingResult result, HttpServletRequest request) throws Exception {
		ssBankMsgTempvo.setDjgzTime(new Date());
		if (result.hasErrors()) {
			String str = "";
			for (ObjectError oe : result.getAllErrors()) {
				str = oe.getCode() + ":" + oe.getDefaultMessage() + ";";
			}
			request.setAttribute("message", str + "<br>保存失败，请查检表单数据是否合法！");
			return "/commons/error.jsp";
		} else {
			ssBankMsgService.doSave(ssBankMsgTempvo);
			return "/commons/success.jsp";
		}
	}

	@RequestMapping(value = { "/mybatis/notice/NoticeContorller/updateinput" }, method = {
			RequestMethod.GET, RequestMethod.POST })
	public String updateInput(HttpServletRequest request, String ids)
			throws Exception {
		SsBankMsg SsBankMsg = ssBankMsgService.findEntityBeanById(Long
				.parseLong(ids));
		request.setAttribute("govDjgzBos", SsBankMsg);
		return "/pages/league/wzgl/mybatisdemo/update.jsp";
	}

	@RequestMapping(value = { "/mybatis/notice/NoticeContorller/updatesyn" }, method = {
			RequestMethod.GET, RequestMethod.POST })
	public String updatesyn(SsBankMsg ssBankMsgTempvo) throws Exception {
		ssBankMsgTempvo.setDjgzTime(new Date());
		ssBankMsgService.doUpdate(ssBankMsgTempvo);
		return "/commons/success.jsp";
	}

	@RequestMapping(value = { "/mybatis/notice/NoticeContorller/delete" }, method = {
			RequestMethod.GET, RequestMethod.POST })
	public String delete(String checkbox) throws Exception {
		List<Long> ids = StringToList.string2List(checkbox);
		try {
			ssBankMsgService.doDelete(ids);
		} catch (Exception e) {
			logger.error("删除报文失败", e);
		}
		return "/commons/success.jsp";
	}

	@RequestMapping(value = { "/mybatis/notice/NoticeContorller/delete/{id}" }, method = { RequestMethod.GET })
	@ResponseBody
	public String restdelete(@PathVariable String id,
			HttpServletResponse response) throws Exception {
		if (id.indexOf(',') > 0) {
			String[] checkBoxes = StringUtils.split(id, ",");
			for (int i = 0; i < checkBoxes.length; i++) {
				try {
					SsBankMsg ssBankMsgTempvo = ssBankMsgService
							.findEntityBeanById(Long.parseLong(checkBoxes[i]));
					ssBankMsgService.doDelete(ssBankMsgTempvo);

				} catch (Exception e) {

					logger.error("删除报文失败", e);
					FlexiGridJsonUtils.render(response, "{false}");
				}
			}
		} else {
			try {
				SsBankMsg ssBankMsgTempvo = ssBankMsgService
						.findEntityBeanById(Long.parseLong(id));
				ssBankMsgService.doDelete(ssBankMsgTempvo);

			} catch (Exception e) {
				logger.error("删除报文失败", e);
				FlexiGridJsonUtils.render(response, "{false}");
			}
		}
		FlexiGridJsonUtils.render(response, "{true}");
		return null;
	}

	@RequestMapping(value = { "/mybatis/notice/NoticeContorller/listsyn" }, method = {
			RequestMethod.GET, RequestMethod.POST })
	public String listsyn(HttpServletRequest request) throws Exception {
		try {
			System.out.println("test333333333333333333");
			SsBankMsg ssBankMsgTempvo = new SsBankMsg();

			List<SsBankMsg> listSsBankMsgTemp = ssBankMsgService.pageQuery(1,
					5, ssBankMsgTempvo);
			int totalCount = ssBankMsgService.queryRecordCount(ssBankMsgTempvo);
			long pageNum = countTotalPage(10, totalCount);
			request.setAttribute("page", 1);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("listSsBankMsgTemp", listSsBankMsgTemp);
			request.setAttribute("totalCount", totalCount);
			return "/pages/league/wzgl/mybatisdemo/list.jsp";

		} catch (Exception e) {
			logger.error("查询数据失败", e);
		}
		return null;

	}

	@RequestMapping(value = { "/mybatis/notice/NoticeContorller/FlaxiGridDataSyn" }, method = {
			RequestMethod.GET, RequestMethod.POST })
	public String FlaxiGridDataSyn(SsBankMsg ssBankMsgTempvo, String query,
			String sortname, String sortorder, int page, int rp,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("test333333333333333333");

			List<SsBankMsg> listSsBankMsgTemp;
			int totalCount = 0;
			if (query != null && !"".equals(query)) {

				listSsBankMsgTemp = ssBankMsgService.pageOrQuery(page, 5,
						ssBankMsgTempvo);
				totalCount = ssBankMsgService
						.queryOrRecordCount(ssBankMsgTempvo);
			} else {
				listSsBankMsgTemp = ssBankMsgService.pageQuery(page, 5,
						ssBankMsgTempvo);
				totalCount = ssBankMsgService.queryRecordCount(ssBankMsgTempvo);
			}
			long pageNum = countTotalPage(5, totalCount);

			request.setAttribute("page", page);
			request.setAttribute("ssBankMsgTempvo", ssBankMsgTempvo);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("listSsBankMsgTemp", listSsBankMsgTemp);
			request.setAttribute("totalCount", totalCount);
			return "/pages/league/wzgl/mybatisdemo/list.jsp";

		} catch (Exception e) {
			logger.error("查询数据失败", e);
		}

		return null;
	}

	

}
