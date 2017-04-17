package com.shuizd.yaco.enums;

import org.w3c.dom.Element;

import com.shuizd.yaco.utils.MsgException;

public enum ElementTag {
	
	MSG("msg"),
	CONSTANT("constant"),
	ARRAY("array"),
	VALUE("value"),
	FIELD("field"),
	FSET("fset"),
	LOOP("loop"),
	RSET("rset"),
	ROUTE("route"),
	OTHER("other");
	

	private ElementTag(String tagName) {
		this.tagName = tagName;
	}

	private String tagName;

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	public static boolean isConstant(Element el) throws MsgException{
		if(CONSTANT.getTagName().equals(el.getTagName())){
			return true;
		}
		return false;
	}
	
	public static boolean isArray(Element el) throws MsgException{
		if(ARRAY.getTagName().equals(el.getTagName())){
			return true;
		}
		return false;
	}
	
	public static boolean isValue(Element el) throws MsgException{
		if(VALUE.getTagName().equals(el.getTagName())){
			return true;
		}
		return false;
	}
	
	public static boolean isMsg(Element el) throws MsgException{
		if(MSG.getTagName().equals(el.getTagName())){
			return true;
		}
		return false;
	}
	
	public static boolean isField(Element el) throws MsgException{
		if(FIELD.getTagName().equals(el.getTagName())){
			return true;
		}
		return false;
	}
	
	public static boolean isFset(Element el) throws MsgException{
		if(FSET.getTagName().equals(el.getTagName())){
			return true;
		}
		return false;
	}
	
	public static boolean isRset(Element el) throws MsgException{
		if(RSET.getTagName().equals(el.getTagName())){
			return true;
		}
		return false;
	}
	
	public static boolean isLoop(Element el) throws MsgException{
		if(LOOP.getTagName().equals(el.getTagName())){
			return true;
		}
		return false;
	}
	
	public static boolean isRoute(Element el) throws MsgException{
		if(ROUTE.getTagName().equals(el.getTagName())){
			return true;
		}
		return false;
	}
	
	public static boolean isOther(Element el) throws MsgException{
		if(OTHER.getTagName().equals(el.getTagName())){
			return true;
		}
		return false;
	}
	
	
}
