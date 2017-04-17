package com.shuizd.yaco.utils;

import java.lang.reflect.Method;
import java.util.List;

import org.w3c.dom.NodeList;

public class MsgUtil {

	/**
	 * @Title: isOneNode
	 * @Description: 是否为单个节点
	 */
	public static boolean isOnlyNode(NodeList ufxNode) {
		return ufxNode != null && ufxNode.getLength() == 1;
	}
	
	/**
	 * @Title: isNotEmptyNode
	 * @Description: 是否有下级节点
	 */
	public static boolean isNotEmptyNode(NodeList node) {
		return node != null && node.getLength() > 0;
	}
	
	/**
	 * @Title: isNotEmpty
	 * @Description: 是否为空集合
	 */
	public static boolean isNotEmpty(List list) {
		return list != null && list.size() > 0;
	}
	
	public static Object getClazzProperty(String clazzPropertyName, Class clazz, Object obj) throws MsgException{
		try{
			Method method = clazz.getMethod("get" + clazzPropertyName.substring(0, 1).toUpperCase()
					+ clazzPropertyName.substring(1));
			return method.invoke(obj);
		}catch(Exception e){
			throw new MsgException("Exception reflection clazz : " + clazz.getName());
		}
	}
}
