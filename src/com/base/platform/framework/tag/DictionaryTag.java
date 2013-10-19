package com.base.platform.framework.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;

import org.springframework.web.context.WebApplicationContext;

import com.base.platform.framework.dictionary.Dictionary;
import com.base.platform.framework.dictionary.DictionaryProvider;

/**
 * <p>Title: DictionaryTag</p>
 * <p>Description: </p>
 */
public class DictionaryTag extends AbstractFrameworkTag{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 341085390031339790L;

	private String dict;
	
	private Object code;
	
	private DictionaryProvider dictionaryProvider;


	@Override
	public int doStartTag() throws JspException {
		
		//获得页面输出用的Writer
		JspWriter jw = this.pageContext.getOut();
		
		String target = "";
		if(code!=null && !(code instanceof String))
			code =  String.valueOf(code);
		Dictionary dictObject = this.dictionaryProvider.getDictionary(dict);
		if(dictObject==null){
			target = "not match";
		}else {
			target =dictObject.getItems().get(code);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("dict[" + dict + "]code[" + code
					+ "]target[" + target + "]");
		}
		
		//输出信息
		try {
			jw.print(target);
			
		} catch (IOException e) {
			logger.error(e);
			throw new IllegalArgumentException(e);
		}
		
		return Tag.SKIP_BODY;
	}


	@Override
	protected void initWebApplicationContext(
			WebApplicationContext webApplicationContext) {
		this.dictionaryProvider = (DictionaryProvider) super.getBean(
				webApplicationContext, DictionaryProvider.class);

	}

	/**
	 * @param dict The dict to set.
	 */
	public void setDict(String dict) {
		this.dict = dict;
	}

	/**
	 * @param code The code to set.
	 */
	public void setCode(Object code) {
		this.code = code;
	}

}
