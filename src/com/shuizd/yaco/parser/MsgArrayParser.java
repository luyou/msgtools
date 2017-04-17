package com.shuizd.yaco.parser;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.shuizd.yaco.element.ArrayNode;
import com.shuizd.yaco.enums.ElementTag;
import com.shuizd.yaco.utils.MsgUtil;
import com.shuizd.yaco.utils.MsgException;
import com.shuizd.yaco.utils.StringUtils;

public class MsgArrayParser{

	public static ArrayNode generates(Element el) throws MsgException {
		ArrayNode array = getAttr(el);
		NodeList nodes = el.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				if (ElementTag.isValue(element)) {
					NodeList valuesNode = element.getElementsByTagName("value");
					if (MsgUtil.isNotEmptyNode(valuesNode)) {
						List<String> values = new ArrayList<String>();
						for (int h = 0; h < valuesNode.getLength(); h++) {
							Element valElement = (Element) valuesNode.item(h);
							values.add(valElement.getTextContent());
						}
						array.setValues(values);
					}
				}
			}
		}
		return array;
	}
	
	private static ArrayNode getAttr(Element el) throws MsgException {
		ArrayNode array = new ArrayNode();
		String id = el.getAttribute("id");
		if (StringUtils.isNotEmpty(id)) {
			array.setId(id);
		} else {
			throw new MsgException("this ArrayNode's attribute [id] is required");
		}
		String caption = el.getAttribute("caption");
		if (StringUtils.isNotEmpty(caption)) {
			array.setCaption(caption);
		}
		return array;
	}
}
