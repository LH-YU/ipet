package com.myhexin.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 自定义异常
 * 
 * @author zhc time:2012-3-8
 */
public class SysRunException extends RuntimeException {

	private static final long serialVersionUID = 66115371494354642L;

	private static Log logger = LogFactory.getLog(SysRunException.class);

	/**
	 * 自定义异常：一般用此异常传递一些信息
	 * <p>
	 * 日志：logger.debug(message);
	 */
	public SysRunException(String message) {
		super(message);
		logger.warn(message);
	}

	/**
	 * 自定义异常：一般用此异常传递一些信息
	 * <p>
	 * 日志：logger.debug(message);
	 * 
	 * @param isToError
	 *            为true时将日志加入到error级别中
	 */
	public SysRunException(String message, boolean isToError) {
		super(message);

		if (isToError) {
			logger.error(message);
		} else {
			logger.debug(message);
		}
	}

	/**
	 * 自定义异常：传递异常信息及异常对象
	 * <p>
	 * 日志：logger.error(message, cause);
	 */
	public SysRunException(String message, Throwable cause) {
		super(message, cause);
		logger.error(message, cause);
	}
}