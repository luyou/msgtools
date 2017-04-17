package com.shuizd.yaco.parser;

import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.shuizd.yaco.element.FieldObj;
import com.shuizd.yaco.element.Fset;
import com.shuizd.yaco.element.Loop;
import com.shuizd.yaco.element.Other;
import com.shuizd.yaco.element.Rset;
import com.shuizd.yaco.enums.ElementTag;
import com.shuizd.yaco.utils.MsgException;

public class MsgOtherParser {
	
	public static Other generates(Element el) throws MsgException {
		Other other = new Other();
		NodeList nodes = el.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				if (ElementTag.isField(element)) {
					List<FieldObj> fieldObjs = other.getFields();
					fieldObjs.add(MsgFieldParser.generates(element));
					other.setFields(fieldObjs);
				} else if (ElementTag.isFset(element)) {
					List<Fset> fsets = other.getFsets();
					fsets.add(MsgFsetParser.generates(element));
					other.setFsets(fsets);
				} else if (ElementTag.isRset(element)) {
					List<Rset> rsets = other.getRsets();
					rsets.add(MsgRsetParser.generates(element));
					other.setRsets(rsets);
				} else if (ElementTag.isLoop(element)) {
					List<Loop> loops = other.getLoops();
					loops.add(MsgLoopParser.generates(element));
					other.setLoops(loops);
				}
			}
		}
		return other;
	}

}
