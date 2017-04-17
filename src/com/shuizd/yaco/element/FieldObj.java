package com.shuizd.yaco.element;

import com.shuizd.yaco.utils.Desc;
import com.shuizd.yaco.utils.MsgException;
import com.shuizd.yaco.utils.StringUtils;

public class FieldObj extends Node {

	private String type;
	private Integer len;
	private Integer maxlen;
	private String content;
	private String prefix;
	private String suffix;
	private String array;
	private Boolean required;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getLen() {
		return len;
	}
	public void setLen(Integer len) {
		this.len = len;
	}
	public Integer getMaxlen() {
		return maxlen;
	}
	public void setMaxlen(Integer maxlen) {
		this.maxlen = maxlen;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getArray() {
		return array;
	}
	public void setArray(String array) {
		this.array = array;
	}
	public Boolean getRequired() {
		return required;
	}
	public void setRequired(Boolean required) {
		this.required = required;
	}
	
	@Override
	public void verify() throws MsgException {
		super.verify();
		if(StringUtils.isEmpty(getId())){
			throw new MsgException(Desc.ERR_XML_VERIFY.getCode(),
					Desc.ERR_XML_VERIFY.getDesc() + " : FieldObj's attribute [id] is required ");
		}
	}
	
}
