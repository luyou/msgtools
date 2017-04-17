package com.shuizd.yaco.parser;

import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.shuizd.yaco.element.BaseArchitectureNode;
import com.shuizd.yaco.element.FieldObj;
import com.shuizd.yaco.element.Fset;
import com.shuizd.yaco.element.Loop;
import com.shuizd.yaco.element.Rset;
import com.shuizd.yaco.enums.ElementTag;
import com.shuizd.yaco.utils.MsgException;

public class BaseParser<T extends BaseArchitectureNode> {

	public static <T extends BaseArchitectureNode> T generates(Element el) throws MsgException {
		T t = (T) new BaseArchitectureNode();
		NodeList nodes = el.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				if (ElementTag.isField(element)) {
					List<FieldObj> fieldObjs = t.getFields();
					fieldObjs.add(MsgFieldParser.generates(element));
					t.setFields(fieldObjs);
				} else if (ElementTag.isFset(element)) {
					List<Fset> fsets = t.getFsets();
					fsets.add(MsgFsetParser.generates(element));
					t.setFsets(fsets);
				} else if (ElementTag.isRset(element)) {
					List<Rset> rsets = t.getRsets();
					rsets.add(MsgRsetParser.generates(element));
					t.setRsets(rsets);
				} else if (ElementTag.isLoop(element)) {
					List<Loop> loops = t.getLoops();
					loops.add(MsgLoopParser.generates(element));
					t.setLoops(loops);
				}
			}
		}
		return t;
	}

}
