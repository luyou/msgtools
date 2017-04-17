package com.shuizd.yaco.element;

import java.util.ArrayList;
import java.util.List;

public class Constant extends Node{
	
	private List<ArrayNode> arrayNodes = new ArrayList<ArrayNode>();

	public List<ArrayNode> getArrayNodes() {
		return arrayNodes;
	}

	public void setArrayNodes(List<ArrayNode> arrayNodes) {
		this.arrayNodes = arrayNodes;
	}

}
