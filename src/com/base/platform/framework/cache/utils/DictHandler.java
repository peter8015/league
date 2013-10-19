package com.base.platform.framework.cache.utils;

import java.util.ArrayList;
import java.util.List;

public class DictHandler {
    
    public static List<String> commonTableList() {
        List<String> list = new ArrayList<String>();
        list.add("T_DM_ZZMM"); // 政治面貌
        list.add("T_DM_ZHICHENG"); // 职称_技术职称
        list.add("T_DM_ZHUANYE"); // 专业
        list.add("T_DM_DWXZ"); // 单位性质
        list.add("T_DM_XZQH"); // 行政区划
        list.add("T_DM_XB"); // 性别
        list.add("T_DM_WHCD"); // 学历_文化程度
        list.add("T_DM_RYZT");
        return list;
    }
    

    public static String getCommonSql(String tableName) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select dm , mc from ");
        sql.append(tableName);
        sql.append(" order by mc asc ");
        return sql.toString();
    }
    
    public static String getZHCNSql() {
        StringBuffer sql = new StringBuffer();
        sql.append(" select code , text from ");
        sql.append(" T_DM_RYMZ               ");
        sql.append(" order by code  asc      ");
        return sql.toString();
    }
    
    public static String getENUSSql() {
        StringBuffer sql = new StringBuffer();
        sql.append(" select code , text from ");
        sql.append(" T_DM_RYMZ               ");
        sql.append(" order by code  asc      ");
        return sql.toString();
    }
    
    public static String getZHTWSql() {
        StringBuffer sql = new StringBuffer();
        sql.append(" select code , text from ");
        sql.append(" T_DM_RYMZ               ");
        sql.append(" order by code  asc      ");
        return sql.toString();
    }
    
    public static String getRymzSql() {
        StringBuffer sql = new StringBuffer();
        sql.append(" select code , text from ");
        sql.append(" T_DM_RYMZ               ");
        sql.append(" order by code  asc      ");
        return sql.toString();
    }

}
