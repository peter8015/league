/**
 * Copyright (c) 2005-2009 springside.org.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * $Id: JCaptchaFilter.java 453 2009-09-12 17:57:34Z calvinxiu $
 */
package com.base.platform.framework.security;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.octo.captcha.service.CaptchaService;
import com.octo.captcha.service.CaptchaServiceException;

/**
 * 集成JCaptcha验证码的Filter.
 * 
 * 可通过配置与SpringSecurity相同的登录表单处理URL与身份验证失败URL,实现与SpringSecurity的集成.
 * 另本filter主要演示与SpringSecurity的集成方式，用户可参考其他验证码方案的集成.
 * 
 * 在web.xml中配置的参数包括：
 * 1.failureUrl -- 身份验证失败后跳转的URL, 需与SpringSecurity中的配置保持一致, 无默认值必须配置.
 * 2.filterProcessesUrl -- 登录表单处理URL, 需与SpringSecurity中的配置一致, 默认为"/j_spring_security_check".
 * 3.captchaServiceId -- captchaService在Spring ApplicationContext中的bean id,默认为"captchaService".
 * 4.captchaParamter -- 登录表单中验证码Input框的名称, 默认为"j_captcha".
 * 5.autoPassValue -- 用于自动化功能测试的自动通过值, 默认该值不存在.
 * 
 * 
 * 具体应用参考showcase示例的web.xml与login.jsp.
 */
public class JCaptchaFilter implements Filter {

	//web.xml中的参数名定义
	public static final String CAPTCHA_PARAMTER_NAME_PARAM = "captchaParamterName";
	public static final String CAPTCHA_SERVICE_ID_PARAM = "captchaServiceId";
	public static final String FILTER_PROCESSES_URL_PARAM = "filterProcessesUrl";
	public static final String FAILURE_URL_PARAM = "failureUrl";
	public static final String AUTO_PASS_VALUE_PARAM = "autoPassValue";

	//默认值定义
	public static final String DEFAULT_FILTER_PROCESSES_URL = "/j_spring_security_check";
	public static final String DEFAULT_CAPTCHA_SERVICE_ID = "captchaService";
	public static final String DEFAULT_CAPTCHA_PARAMTER_NAME = "j_captcha";

	public static final String INVALID_AUTO_PASS_VALUE = "invalid";

	private static Logger logger = LoggerFactory.getLogger(JCaptchaFilter.class);

	private String failureUrl;
	private String filterProcessesUrl = DEFAULT_FILTER_PROCESSES_URL;
	private String captchaServiceId = DEFAULT_CAPTCHA_SERVICE_ID;
	private String captchaParamterName = DEFAULT_CAPTCHA_PARAMTER_NAME;
	private String autoPassValue = INVALID_AUTO_PASS_VALUE;

	private CaptchaService captchaService;

	/**
	 * Filter回调初始化函数.
	 */
	public void init(final FilterConfig fConfig) throws ServletException {
		initParameters(fConfig);
		initCaptchaService(fConfig);
	}

	/**
	 * 初始化web.xml中定义的filter init-param.
	 */
	protected void initParameters(final FilterConfig fConfig) {
		if (StringUtils.isBlank(fConfig.getInitParameter(FAILURE_URL_PARAM)))
			throw new IllegalArgumentException("CaptchaFilter缺少failureUrl参数");

		failureUrl = fConfig.getInitParameter(FAILURE_URL_PARAM);

		if (StringUtils.isNotBlank(fConfig.getInitParameter(FILTER_PROCESSES_URL_PARAM))) {
			filterProcessesUrl = fConfig.getInitParameter(FILTER_PROCESSES_URL_PARAM);
		}

		if (StringUtils.isNotBlank(fConfig.getInitParameter(CAPTCHA_SERVICE_ID_PARAM))) {
			captchaServiceId = fConfig.getInitParameter(CAPTCHA_SERVICE_ID_PARAM);
		}

		if (StringUtils.isNotBlank(fConfig.getInitParameter(CAPTCHA_PARAMTER_NAME_PARAM))) {
			captchaParamterName = fConfig.getInitParameter(CAPTCHA_PARAMTER_NAME_PARAM);
		}

		if (StringUtils.isNotBlank(fConfig.getInitParameter(AUTO_PASS_VALUE_PARAM))) {
			autoPassValue = fConfig.getInitParameter(AUTO_PASS_VALUE_PARAM);
		}
	}

	/**
	 * 从ApplicatonContext获取CaptchaService实例.
	 */
	protected void initCaptchaService(final FilterConfig fConfig) {
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(fConfig.getServletContext());
		captchaService = (CaptchaService) context.getBean(captchaServiceId);
	}

	/**
	 * Filter回调退出函数.
	 */
	public void destroy() {
	}

	/**
	 * Filter回调请求处理函数.
	 */
//	public void doFilter(final ServletRequest theRequest, final ServletResponse theResponse, final FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest request = (HttpServletRequest) theRequest;
//		HttpServletResponse response = (HttpServletResponse) theResponse;
//		String servletPath = request.getServletPath();
//
//		//符合filterProcessesUrl为验证处理请求,其余为生成验证图片请求.
//		if (StringUtils.startsWith(servletPath, filterProcessesUrl)) {
//			boolean validated = validateCaptchaChallenge(request);
//			if (validated) {
//				chain.doFilter(request, response);
//			} else {
//				redirectFailureUrl(request, response);
//			}
//		} else {
//			genernateCaptchaImage(request, response);
//		}
//	}
	
	public void doFilter(final ServletRequest theRequest,
			final ServletResponse theResponse, final FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) theRequest;
		HttpServletResponse response = (HttpServletResponse) theResponse;
		chain.doFilter(request, response);
	}
	
	

	/**
	 * 生成验证码图片.
	 */
	protected void genernateCaptchaImage(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		ServletOutputStream out = response.getOutputStream();
		try {
			String captchaId = request.getSession(true).getId();
			BufferedImage challenge = (BufferedImage) captchaService.getChallengeForID(captchaId, request.getLocale());
			ImageIO.write(challenge, "jpg", out);
			out.flush();
		} catch (CaptchaServiceException e) {
			logger.error(e.getMessage(), e);
		} finally {
			out.close();
		}
	}

	/**
	 * 验证验证码.
	 */
	protected boolean validateCaptchaChallenge(final HttpServletRequest request) {
		try {
			String captchaID = request.getSession().getId();
			String challengeResponse = request.getParameter(captchaParamterName);

			//自动通过值存在时且不等于invalid时,检验输入值是否等于自动通过值
			if (!INVALID_AUTO_PASS_VALUE.equals(autoPassValue) && autoPassValue.equals(challengeResponse))
				return true;
			return captchaService.validateResponseForID(captchaID, challengeResponse);
		} catch (CaptchaServiceException e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}

	/**
	 * 跳转到失败页面.
	 * 
	 * 可在子类进行扩展, 比如在session中放入SpringSecurity的Exception.
	 */
	protected void redirectFailureUrl(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		response.sendRedirect(request.getContextPath() + failureUrl);
	}
}
