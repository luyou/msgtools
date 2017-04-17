package com.shuizd.yaco.utils;

public class Rsp {
	private String rspCode = "";
	private String rspDesc = "";

	public Rsp() {
		this.rspCode = "0000";
		this.rspDesc = "success";
	}

	public Rsp(String rspCode, String rspDesc) {
		this.rspCode = rspCode;
		this.rspDesc = rspDesc;
	}
	
	public void overload(String rspCode, String rspDesc) {
		this.rspCode = rspCode;
		this.rspDesc = rspDesc;
	}

	public String getRspCode() {
		return rspCode;
	}

	public void setRspCode(String rspCode) {
		this.rspCode = rspCode;
	}

	public String getRspDesc() {
		return rspDesc;
	}

	public void setRspDesc(String rspDesc) {
		this.rspDesc = rspDesc;
	}
}
