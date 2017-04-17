package com.shuizd.yaco.enums;

/**
* @ClassName: MsgCategory
* @Description: 检验消息格式的针对对象
* @author yaco www.shuizd.com
* @date 2017年3月10日 上午10:38:45
*
 */
public enum MsgCategory {
	
	ALL(0,"all"),
	XML(1,"xml"),
	JSON(2,"json");
	
	private int no;
	private String category;
	
	private MsgCategory(int no, String category) {
		this.no = no;
		this.category = category;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
