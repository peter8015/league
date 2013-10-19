package com.base.platform.framework.web.utils;

import com.base.platform.framework.web.exception.ProgrammingError;
/**
 * <p/> Persistence framework which provides basic CRUD operations
 * 
 * @author Pan,Shaohua 
 * @date 2013.10.11
 */
public class Assert
{
  public static void assertNotNull(Object maybeNull, String message)
  {
    if (maybeNull == null)
      throw new ProgrammingError(message);
  }
  
  
}