/**
 * Copyright (c) 2005-2009 springside.org.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * $Id: SpringSecurityUtils.java 515 2009-10-01 16:19:34Z calvinxiu $
 */
package com.base.platform.framework.utils;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.Authentication;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.User;

/**
 * SpringSecurity的工具类.
 */
public class SpringSecurityUtils {
    
    /**
     * 取得当前用户, 返回值为SpringSecurity的User类及其子类, 如果当前用户未登录则返回null.
     */
    @SuppressWarnings("unchecked")
    public static <T extends User> T getCurrentUser() {
        ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAuthorities()[0].getAuthority();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal == null) { return null; }
        return (T) principal;
    }
    

    /**
     * 取得当前用户的登录名, 如果当前用户未登录则返回空字符串.
     */
    public static String getCurrentUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) { return ""; }
        return auth.getName();
    }
    

    /**
     * 根据权限前缀判断用户是否有此权限
     * 
     * @param prefixs
     * @return
     */
    public static boolean hasAuthority(String prefixsJoin) {
        String[] prefixs = StringUtils.split(prefixsJoin , ",");
        if (ArrayUtils.isEmpty(prefixs)) { return false; }
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user == null) { return false; }
        for (GrantedAuthority auth : user.getAuthorities()) {
            for (String prefix : prefixs) {
                if (StringUtils.startsWithIgnoreCase(auth.getAuthority() , prefix)) { return true; }
            }
        }
        return false;
    }
    

    public static boolean hasAuthority(String authority, String matchMode) {
        String[] prefixs = StringUtils.split(authority , ",");
        if (ArrayUtils.isEmpty(prefixs)) { return false; }
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user == null) { return false; }
        for (GrantedAuthority auth : user.getAuthorities()) {
            for (String prefix : prefixs) {
                if (StringUtils.equalsIgnoreCase(matchMode , "START")) {
                    if (StringUtils.startsWith(auth.getAuthority() , prefix)) { return true; }
                }
                else if (StringUtils.equalsIgnoreCase(matchMode , "END")) {
                    if (StringUtils.endsWith(auth.getAuthority() , prefix)) { return true; }
                }
                else if (StringUtils.equalsIgnoreCase(matchMode , "EXACT")) {
                    if (StringUtils.equals(auth.getAuthority() , prefix)) { return true; }
                }
                else {
                    throw new IllegalArgumentException("matchMode must in \"START\",\"END\",\"EXACT\"");
                }
            }
        }
        return false;
        
    }
}
