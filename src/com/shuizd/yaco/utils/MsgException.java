package com.shuizd.yaco.utils;

/**
 * @ClassName: MsgException
 * @Description: 封装的Exception工具类
 * @author yaco www.shuizd.com
 * @date 2017年2月10日 下午3:19:53
 *
 */
public class MsgException extends Exception {

	private static final long serialVersionUID = -4095275974552064550L;

	protected String code = "";

	protected String msg = "";

	protected String actionWord = null;

	protected String action = null;

	public MsgException(String msg) {
		if (msg != null && msg.contains("||")) {
			String[] split = msg.split("\\|\\|");
			this.code = split[0];
			this.msg = split[1];
		} else {
			this.msg = msg;
		}
	}

	public MsgException(Exception e) {
		if (e instanceof MsgException) {
			this.code = ((MsgException) e).getCode();
			this.msg = ((MsgException) e).getMessage();
		} else {
			this.code = "9999";
			this.msg = "SYSTEM ERROR";
		}
	}

	public MsgException(String code, String msg) {
		this.code = code.trim();
		this.msg = msg;
	}
	
	public MsgException(Desc desc) {
		this.code = desc.getCode();
		this.msg = desc.getDesc();
	}

	public MsgException(String msg, String actionWord, String action) {
		this.code = code.trim();
		this.msg = msg;
		this.actionWord = actionWord;
		this.action = action;
	}

	public MsgException(String code, String msg, String actionWord, String action) {
		this.code = code.trim();
		this.msg = msg;
		this.actionWord = actionWord;
		this.action = action;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return this.msg;
	}

	public String getActionWord() {
		return actionWord;
	}

	public String getAction() {
		return action;
	}
}
