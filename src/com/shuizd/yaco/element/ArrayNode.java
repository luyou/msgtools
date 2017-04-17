package com.shuizd.yaco.element;

import java.util.ArrayList;
import java.util.List;

public class ArrayNode extends Node {

	private List<String> values  = new ArrayList<String>();;

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

}
