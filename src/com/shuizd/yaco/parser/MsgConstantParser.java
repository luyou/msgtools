package com.shuizd.yaco.parser;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.alibaba.fastjson.JSON;
import com.shuizd.yaco.element.ArrayNode;
import com.shuizd.yaco.element.Constant;
import com.shuizd.yaco.enums.ElementTag;
import com.shuizd.yaco.utils.MsgUtil;
import com.shuizd.yaco.utils.LogWriter;
import com.shuizd.yaco.utils.MsgException;

public class MsgConstantParser {

	public static Constant generates(Element el) throws MsgException {
		Constant constant = new Constant();
		try{
			NodeList arraysNode = el.getElementsByTagName("array");
			NodeList nodes = el.getChildNodes();
			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					if (ElementTag.isField(element)) {
						List<ArrayNode> arrays = constant.getArrayNodes();
						arrays.add(MsgArrayParser.generates(element));
						constant.setArrayNodes(arrays);
					}
				}
			}
			List<ArrayNode> arrays = new ArrayList<ArrayNode>();
			for (int i = 0; i < arraysNode.getLength(); i++) {
				Node arrayNode = arraysNode.item(i);
				ArrayNode array = new ArrayNode();
				if(arrayNode.getNodeType() == Node.ELEMENT_NODE){
					Element arrayElement = (Element) arrayNode;
					array.setId(arrayElement.getAttribute("id"));
					array.setCaption(arrayElement.getAttribute("caption"));
					NodeList valuesNode = arrayElement.getElementsByTagName("value");
					if (MsgUtil.isNotEmptyNode(valuesNode)) {
						List<String> values = new ArrayList<String>();
						for (int h = 0; h < valuesNode.getLength(); h++) {
							Element valElement = (Element) valuesNode.item(h);
							values.add(valElement.getTextContent());
						}
						array.setValues(values);
					}
					arrays.add(array);
				}
			}
			constant.setArrayNodes(arrays);
		}catch(Exception e){
			LogWriter.error("MsgConstantParser parse failure : " + e.getMessage());
			e.printStackTrace();
			throw new MsgException(" MsgConstantParser parse failure");
		}
		LogWriter.info(" --> MsgTools init... ### MsgParse -> parse, Constant: " + JSON.toJSONString(constant));
		return constant;
		
	}
}
