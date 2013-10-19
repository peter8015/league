/**
 * Create time 2008-6-3 上午09:46:23
 */
package com.base.platform.framework.tag;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.jsp.JspException;

import org.springframework.web.context.WebApplicationContext;

import com.base.platform.framework.dictionary.Dictionary;
import com.base.platform.framework.dictionary.DictionaryProvider;

/**
 * <p>Title: DictMapTag</p>
 * <p>Description: </p>
 */
public class DictMapTag extends AbstractFrameworkTag {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3570599089659104537L;

	private String var;
	
	private String dict;
	
	private DictionaryProvider dictionaryProvider;


	@Override
	public int doStartTag() throws JspException {

		Map<String, String> map = new HashMap<String, String>();
		Dictionary dictObject =  this.dictionaryProvider.getDictionary(this.dict);
		if (dictObject != null){
			map =  dictObject.getItems();
		}
		
		String dictName = "";
		if(this.var==null){
			dictName = "dict_"+this.dict;
		}
		else{
			dictName = this.var;
		}
		this.pageContext.setAttribute(dictName, map);
		
		return this.SKIP_BODY;
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
	 * @param var The var to set.
	 */
	public void setVar(String var) {
		this.var = var;
	}

}
