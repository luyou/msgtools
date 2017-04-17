package com.shuizd.yaco.utils;

import org.apache.log4j.Logger;

public class LogWriter {
	
	private static Logger logger = null;

	private static class SingletonHolder {
		private static final LogWriter INSTANCE = new LogWriter();
	}

	private LogWriter() {
	}

	public static final LogWriter getInstance() {
		return SingletonHolder.INSTANCE;
	}
	
	static{
		init(Logger.getLogger("msgtools"));
	}
	
	public static void init(Logger logger) {
		setLogger(logger);
		if (logger != null) {
			logger.setAdditivity(false);
		}
	}
	
	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		LogWriter.logger = logger;
		logger.setAdditivity(false);
	}
	
	/**
	 * 记录调试信息
	 * 
	 * @param aMsg
	 *            调试信息
	 */
	public static void debug(String aMsg) {
		logger.debug(aMsg);
	}

	/**
	 * 记录调试信息
	 * 
	 * @param aObject
	 *            调试对象
	 * @param aMsg
	 *            调试信息
	 */
	public static void debug(Object aObject, String aMsg) {
		logger.debug("[" + aObject.getClass().getName() + "]:" + aMsg);
	}

	/**
	 * 记录调试信息
	 * 
	 * @param aObject
	 *            调试对象
	 * @param aMsg
	 *            调试信息
	 */
	public static void debug(Object aObject, Throwable aThrowable) {
		logger.debug(aObject, aThrowable);
	}

	/**
	 * 记录基本信息
	 * 
	 * @param aMsg
	 *            基本信息
	 */
	public static void info(String aMsg) {
		logger.info(aMsg);
	}

	/**
	 * 记录基本信息
	 * 
	 * @param aObject
	 *            调试对象
	 * @param aMsg
	 *            基本信息
	 */
	public static void info(Object aObject, String aMsg) {
		logger.info("[" + aObject.getClass().getName() + "]:" + aMsg);
	}

	/**
	 * 记录警告信息
	 * 
	 * @param aMsg
	 *            警告信息
	 */
	public static void warn(String aMsg) {
		logger.warn(aMsg);
	}

	/**
	 * 记录警告信息
	 * 
	 * @param aObject
	 *            调试对象
	 * @param msg
	 *            警告信息
	 */
	public static void warn(Object aObject, String aMsg) {
		logger.warn("[" + aObject.getClass().getName() + "]:" + aMsg);
	}

	/**
	 * 记录错误信息
	 * 
	 * @param aMsg
	 *            错误信息
	 */
	public static void error(String aMsg) {
		logger.error(aMsg);
	}

	/**
	 * 记录错误信息
	 * 
	 * @param aObject
	 *            调试对象
	 * @param aMsg
	 *            错误信息
	 */
	public static void error(Object aObject, String aMsg) {

		logger.error("[" + aObject.getClass().getName() + "]:" + aMsg);
	}

	/**
	 * 记录调试信息
	 * 
	 * @param aObject
	 *            调试对象
	 * @param aMsg
	 *            调试信息
	 */
	public static void error(Object aObject, Throwable aThrowable) {
		logger.error(aObject, aThrowable);
	}

	/**
	 * 记录失败信息
	 * 
	 * @param aMsg
	 *            失败信息
	 */
	public static void fatal(String aMsg) {
		logger.fatal(aMsg);
	}

	/**
	 * 记录失败信息
	 * 
	 * @param aObject
	 *            调试对象
	 * @param aMsg
	 *            失败信息
	 */
	public static void fatal(Object aObject, String aMsg) {
		logger.fatal("[" + aObject.getClass().getName() + "]:" + aMsg);
	}
	
}
