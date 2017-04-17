package com.shuizd.yaco.parser;

import org.w3c.dom.Element;

import com.shuizd.yaco.element.FieldObj;
import com.shuizd.yaco.utils.MsgException;
import com.shuizd.yaco.utils.StringUtils;

public class MsgFieldParser {

	public static FieldObj generates(Element el) throws MsgException {
		return getAttr(el);
	}

	private static FieldObj getAttr(Element fieldElement) throws MsgException {
		FieldObj fieldObj = new FieldObj();
		String id = fieldElement.getAttribute("id");
		if (StringUtils.isNotEmpty(id)) {
			fieldObj.setId(id);
		} else {
			throw new MsgException("this FieldObj's attribute [id]  is required");
		}
		String caption = fieldElement.getAttribute("caption");
		if (StringUtils.isNotEmpty(caption)) {
			fieldObj.setCaption(caption);
		}
		String value = fieldElement.getAttribute("value");
		if (StringUtils.isNotEmpty(value)) {
			fieldObj.setValue(value);
		}
		String type = fieldElement.getAttribute("type");
		if (StringUtils.isNotEmpty(type)) {
			fieldObj.setType(type);
		} else {
			throw new MsgException("this FieldObj's attribute [type] is required");
		}
		String prefix = fieldElement.getAttribute("prefix");
		if (StringUtils.isNotEmpty(prefix)) {
			fieldObj.setPrefix(prefix);
		}
		String suffix = fieldElement.getAttribute("suffix");
		if (StringUtils.isNotEmpty(suffix)) {
			fieldObj.setSuffix(suffix);
		}
		String len = fieldElement.getAttribute("len");
		if (StringUtils.isNotEmpty(len)) {
			fieldObj.setLen(Integer.parseInt(len));
		}
		String maxlen = fieldElement.getAttribute("maxlen");
		if (StringUtils.isNotEmpty(maxlen)) {
			fieldObj.setMaxlen(Integer.parseInt(maxlen));
		}
		String content = fieldElement.getAttribute("content");
		if (StringUtils.isNotEmpty(content)) {
			fieldObj.setContent(content);
		}
		String array = fieldElement.getAttribute("array");
		if (StringUtils.isNotEmpty(array)) {
			fieldObj.setArray(array);
		}
		String required = fieldElement.getAttribute("required");
		if (StringUtils.isNotEmpty(required) && "true".equals(required)) {
			fieldObj.setRequired(true);
		} else {
			fieldObj.setRequired(false);
		}
		return fieldObj;
	}
}
