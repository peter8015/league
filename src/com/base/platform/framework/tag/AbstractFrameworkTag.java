package com.base.platform.framework.tag;

import java.util.Map;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * <p>Title: AbstractFrameworkTag.java</p>
 * <p>Description: </p>
 */
public abstract class AbstractFrameworkTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3065949996867049355L;
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
		WebApplicationContext wac = WebApplicationContextUtils
				.getWebApplicationContext(this.pageContext.getServletContext());
		if(wac==null){
			throw new IllegalStateException("can't receive WebApplicationContext.");
		}
		
		this.initWebApplicationContext(wac);
	}
	 
	protected abstract void initWebApplicationContext(WebApplicationContext webApplicationContext); 
	
	protected Object getBean(WebApplicationContext webApplicationContext,Class type){
		Map map = webApplicationContext.getBeansOfType(type);
		
		Object target = ((Map.Entry)map.entrySet().iterator().next()).getValue();
		if(target==null){
			throw new IllegalStateException("can't find Bean which type is["+type+"]");
		}
		return target;
	}

}