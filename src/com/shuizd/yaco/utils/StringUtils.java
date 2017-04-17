package com.shuizd.yaco.utils;

public class StringUtils {

	/**
	 * 字符串是否不为空
	 * @param str 
	 * @return true:不为空;false:为空
	 */
	public static boolean isNotEmpty(String str) {
		return ((str != null) && (str.trim().length() > 0));
	}

	/**
	 * 字符串是否为空
	 * @param aStr
	 * @return true:为空;false:不为空
	 */
	public static boolean isEmpty(String aStr) {
		return ((aStr == null) || (aStr.trim().length() == 0));
	}
}
