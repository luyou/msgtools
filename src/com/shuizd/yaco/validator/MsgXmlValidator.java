package com.shuizd.yaco.validator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shuizd.yaco.element.FieldObj;
import com.shuizd.yaco.element.Msg;
import com.shuizd.yaco.element.Xml;
import com.shuizd.yaco.utils.Desc;
import com.shuizd.yaco.utils.MsgUtil;
import com.shuizd.yaco.utils.LogWriter;
import com.shuizd.yaco.utils.MsgException;
import com.shuizd.yaco.utils.Rsp;

public class MsgXmlValidator<T> {

	public static <T> Rsp validates(T t) {
		Rsp rsp = new Rsp();
		try {
			if (t != null) {
				// TODO 获取校验配置文件对象
				Xml config = new Xml();
				// 业务校验
				Msg msg = config.getMsg();
				validation(t, msg);
			} else {
				throw new MsgException(Desc.ERR_NULL_VALUE.getCode(),
						Desc.ERR_NULL_VALUE.getDesc() + ",XML validation object is null");
			}
		} catch (Exception e) {
			if (e instanceof MsgException) {
				MsgException es = (MsgException) e;
				LogWriter.error("MsgXmlValidator Exception : " + es.getMessage());
				rsp.overload(es.getCode(), es.getMessage());
			} else {
				LogWriter.error("MsgXmlValidator Exception : " + e.getMessage());
				rsp.overload("2001", "XML validation unknown Exception");
			}
			e.printStackTrace();
		}
		return rsp;
	}

	private static <T> void validation(T t, Msg msg)
			throws MsgException {
		try {
			if (msg != null) {
				boolean isExist = false;
				String configPropertyName = msg.getId();
				Class<?> clazz = t.getClass();
				Field[] clazzFields = clazz.getDeclaredFields();
				Object clazzObj = null;
				for (Field clazzField : clazzFields) {
					String clazzPropertyName = clazzField.getName();
					if (configPropertyName.equals(clazzPropertyName)) {
						isExist = true;
						clazzObj = MsgUtil.getClazzProperty(clazzPropertyName, clazz, t);
						List<FieldObj> fieldObjs = msg.getFields();
						if(MsgUtil.isNotEmpty(fieldObjs)){
							validateFields(clazzObj, fieldObjs);
						}
					}
				}
				if (!isExist) {
					throw new MsgException(Desc.ERR_NULL_VALUE.getCode(),
							Desc.ERR_NULL_VALUE.getDesc() + ",Msg validation object is null");
				}
			}else{
				throw new MsgException(Desc.ERR_NULL_VALUE.getCode(),
						Desc.ERR_NULL_VALUE.getDesc() + ",Msg validation object is null");
			}
		} catch (Exception e) {
			LogWriter.error("MsgXmlValidator Exception : " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void validateFields(Object clazzObj, List<FieldObj> fieldObjs) throws MsgException {
		Map<String, Field> map = new HashMap<String, Field>();
		Class<?> clazz = clazzObj.getClass();
		Field[] clazzFields = clazz.getDeclaredFields();
		for(Field clazzField : clazzFields){
			String clazzPropertyName = clazzField.getName();
			map.put(clazzPropertyName, clazzField);
		}
		for (FieldObj fieldObj : fieldObjs) {
			String configPropertyName = fieldObj.getId();
			if(map.get(configPropertyName) != null){
				try{
					Object fs = MsgUtil.getClazzProperty(configPropertyName, clazz, clazzObj);
				}catch(Exception e){
					//TODO精确异常
					throw new MsgException(Desc.ERR_NULL_VALUE.getCode(),
							Desc.ERR_NULL_VALUE.getDesc() + ",Field[" +configPropertyName+ "] is required");
				}
			}else{
				if(fieldObj.getRequired()){
					throw new MsgException(Desc.ERR_NULL_VALUE.getCode(),
							Desc.ERR_NULL_VALUE.getDesc() + ",Field[" +configPropertyName+ "] is required");
				}
			}
		}
	}

	private static void validate(Object obj) throws Exception {
		Class<?> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			String propertyName = field.getName();// 获取属性名
			LogWriter.info("clazz : " + clazz + "; propertyName ==> " + propertyName);
			String propertyType = field.getGenericType().toString();// 获取属性的类型
			LogWriter.info("clazz : " + clazz + "; propertyType ==> " + propertyType);
			Method method = clazz
					.getMethod("get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1));
			Object nextObj = method.invoke(obj);// 调用getter方法获取属性值
			validate(nextObj);
		}
	}
}
