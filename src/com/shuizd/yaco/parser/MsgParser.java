package com.shuizd.yaco.parser;

import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.shuizd.yaco.element.FieldObj;
import com.shuizd.yaco.element.Fset;
import com.shuizd.yaco.element.Loop;
import com.shuizd.yaco.element.Msg;
import com.shuizd.yaco.element.Rset;
import com.shuizd.yaco.enums.ElementTag;
import com.shuizd.yaco.utils.MsgException;
import com.shuizd.yaco.utils.StringUtils;

public class MsgParser {

	public static Msg generates(Element el) throws MsgException {
		Msg msg = getAttr(el);
		NodeList nodes = el.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				if (ElementTag.isField(element)) {
					List<FieldObj> fieldObjs = msg.getFields();
					fieldObjs.add(MsgFieldParser.generates(element));
					msg.setFields(fieldObjs);
				} else if (ElementTag.isFset(element)) {
					List<Fset> fsets = msg.getFsets();
					fsets.add(MsgFsetParser.generates(element));
					msg.setFsets(fsets);
				} else if (ElementTag.isRset(element)) {
					List<Rset> rsets = msg.getRsets();
					rsets.add(MsgRsetParser.generates(element));
					msg.setRsets(rsets);
				} else if (ElementTag.isLoop(element)) {
					List<Loop> loops = msg.getLoops();
					loops.add(MsgLoopParser.generates(element));
					msg.setLoops(loops);
				}
			}
		}
		return msg;
	}
	
	private static Msg getAttr(Element el) throws MsgException {
		Msg msg = new Msg();
		String id = el.getAttribute("id");
		if (StringUtils.isNotEmpty(id)) {
			msg.setId(id);
		} else {
			throw new MsgException("this Msg's attribute [id] is required");
		}
		String caption = el.getAttribute("caption");
		if (StringUtils.isNotEmpty(caption)) {
			msg.setCaption(caption);
		}
		return msg;
	}

}
