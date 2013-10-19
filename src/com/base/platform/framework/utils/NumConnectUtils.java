package com.base.platform.framework.utils;

import java.text.DecimalFormat;

public class NumConnectUtils {
	public static String getFormatNumber(Double d){

		DecimalFormat dataForm = new DecimalFormat("#,##0.00");
		return  dataForm.format(d);  
	}
	
}
