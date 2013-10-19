package com.base.platform.framework.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springside.modules.orm.Page;

/**
 * 
 * @Description flexigrid json字符串转换工具类
 *
 */
public class FlexiGridJsonUtils{
	
	public final static String PAGE_INDEX_KEY = "page";
	public final static String ROW_COUNT_KEY = "total";
	public final static String ROW_ID_KEY = "id";
	public final static String ROW_DATA_KEY = "cell";
	public final static String ROW_DATA_LIST_KEY = "rows";

	/**
	 * @Description 将page对象转换成flexigrid使用的固定格式的json字符串 
	 * @param page 分页数据对象
	 * @param fields 字段名数组
	 * @param idFields id字段名
	 * @return 转换后的json字符串
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
//	@SuppressWarnings("unchecked")
	public static String convert(Page<?> page,String[] fields,String idField) throws Exception{
		Map<String, Object> flexigridMap = new HashMap<String, Object>();
		flexigridMap.put(PAGE_INDEX_KEY, page.getPageNo());
		flexigridMap.put(ROW_COUNT_KEY,page.getTotalCount() + "");
		
		List<?> dataList = page.getResult();
		
		List<Map<String, Object>> rowList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < dataList.size(); i++) {
			Map<String, Object> cellMap = new HashMap<String, Object>();
			Object tempData = dataList.get(i);
			cellMap.put(ROW_ID_KEY, BeanUtils.getProperty(tempData, idField));
			
			Object[] tempCell = new Object[fields.length];
			for(int j=0;j<fields.length;j++){
				if(StringUtils.contains(fields[j], ".")){
					if(BeanUtils.getProperty(tempData, StringUtils.substringBefore(fields[j], ".")) != null){
						tempCell[j]=BeanUtils.getProperty(tempData, fields[j]);
					}else{
						tempCell[j]="";
					}
				}else{
					tempCell[j]=BeanUtils.getProperty(tempData, fields[j]);
				}
			}
			cellMap.put(ROW_DATA_KEY,tempCell);
			rowList.add(cellMap);
		}
		flexigridMap.put(ROW_DATA_LIST_KEY, rowList);
		
		JSONObject jsonObject = JSONObject.fromObject(flexigridMap);
		return jsonObject.toString();
	}
	
	/**
	 * @Description 将json字符串写入到response中
	 * @param response HttpServletResponse
	 * @param jsonString json字符串
	 * @throws Exception 
	 */
	public static void render(HttpServletResponse response,String jsonString) throws Exception {		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.getWriter().write(jsonString);
		response.getWriter().flush();
		response.getWriter().close();
	}
}