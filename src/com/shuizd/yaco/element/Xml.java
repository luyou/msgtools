package com.shuizd.yaco.element;

import com.shuizd.yaco.utils.Desc;
import com.shuizd.yaco.utils.MsgException;

public class Xml extends Node {
	
	private Msg msg;
	
	private Constant constant;

	public Msg getMsg() {
		return msg;
	}

	public void setMsg(Msg msg) {
		this.msg = msg;
	}

	public Constant getConstant() {
		return constant;
	}

	public void setConstant(Constant constant) {
		this.constant = constant;
	}

	@Override
	public void verify() throws MsgException {
		super.verify();
		if(msg == null){
			throw new MsgException(Desc.ERR_XML_VERIFY.getCode(),
					Desc.ERR_XML_VERIFY.getDesc() + " : msg is required");
		}
	}
	
	
	
}
