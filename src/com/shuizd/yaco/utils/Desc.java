package com.shuizd.yaco.utils;

public enum Desc {

	SUCCESS("0000","success"),
	ERROR("9999","unknown Exception"),
	ERR_PARSE_JSON("1001","Json parse failure"),
	ERR_NULL_VALUE("1002","value is null"),
	ERR_NOT_EXIST_FILE("1003","File does not exist"),
	ERR_XML_VERIFY("1004","XML verify error"),
	ERR_XML_CONVERT("1005","XML convert failure"),
	ERR_XML_PARSE("1006","XML parse failure"),
	ERR_HTTP_GET("1007","http get failure"),
	ERR_WX_ACCESS_TOKEN("2001","weixin access token is null")
	
	;
	
	private String code;
	private String desc;
	
	private Desc(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
