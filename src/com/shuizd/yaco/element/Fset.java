package com.shuizd.yaco.element;

import com.shuizd.yaco.utils.Desc;
import com.shuizd.yaco.utils.MsgException;
import com.shuizd.yaco.utils.StringUtils;

public class Fset extends BaseArchitectureNode {
	
	@Override
	public void verify() throws MsgException {
		super.verify();
		if(StringUtils.isEmpty(getId())){
			throw new MsgException(Desc.ERR_XML_VERIFY.getCode(),
					Desc.ERR_XML_VERIFY.getDesc() + " : Fset's attribute [id] is required ");
		}
	}

}
