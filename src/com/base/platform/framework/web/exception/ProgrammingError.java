package com.base.platform.framework.web.exception;

import org.apache.log4j.Logger;
/**
 * <p/> Persistence framework which provides basic CRUD operations
 * 
 * @author Pan,Shaohua 
 * @date 2013.10.11
 */
public class ProgrammingError extends Error
{
  private static final long serialVersionUID = 1L;
  private static final Logger logger = Logger.getLogger(ProgrammingError.class);

  public ProgrammingError(String message) {
    super(message);
    logger.error(message, this);
  }

  public ProgrammingError(Throwable cause) {
    super(cause);
    logger.error(getMessage(), this);
  }

  public ProgrammingError(String message, Throwable cause) {
    super(message, cause);
    logger.error(message, this);
  }
}