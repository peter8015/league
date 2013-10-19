package com.base.platform.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author pan,shaohua
 * @date 2011.10.08
 */
public class CreateCode {
	
	/**
	 * @Description:生成年度大修计划编码
	 */
	public static String createFixPlanCode(){		
		String fixplanCode="DXJH"+currentDate();
		return fixplanCode;
	}
	
	/**
	 * @Description:生成年度专业检计划编码
	 */
	public static String createExaPlanCode(){	
		String fixplanCode="ZYJJH"+currentDate();
		return fixplanCode;
	}
	
	/**
	 * @Description:生成维修计划编码
	 */
	public static String createRepairPlanCode(){		
		String fixplanCode="WXJH"+currentDate();
		return fixplanCode;
	}
	
	/**
	 * @Description:生成缺陷编码
	 */
	public static String createQXCode(){		
		String qxCode="QX"+currentDate();
		return qxCode;
	}
	
	/**
	 * @Description:生成故障编码
	 */
	public static String createGZCode(){		
		String gzCode="GZ"+currentDate();		
		return gzCode;
	}
	
	/**
	 * @Description:生成设备小修编码
	 */
	public static String createEquipRepairCode(){		
		String repCode="SBXX"+currentDate();		
		return repCode;
	}
	
	public static String currentDate(){
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
		String currentDate=sdf.format(d);		
		return currentDate;
	}
}
