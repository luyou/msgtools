package com.shuizd.yaco.parser;

import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.shuizd.yaco.element.FieldObj;
import com.shuizd.yaco.element.Fset;
import com.shuizd.yaco.element.Loop;
import com.shuizd.yaco.element.Rset;
import com.shuizd.yaco.enums.ElementTag;
import com.shuizd.yaco.utils.MsgException;
import com.shuizd.yaco.utils.StringUtils;

public class MsgLoopParser {

	/**
	 * 解析生成Loop集合
	 * @param loopsNode
	 * @return
	 * @throws MsgException
	 */
	public static Loop generates(Element el) throws MsgException {
		Loop loop = getAttr(el);
		NodeList nodes = el.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				if (ElementTag.isField(element)) {
					List<FieldObj> fieldObjs = loop.getFields();
					fieldObjs.add(MsgFieldParser.generates(element));
					loop.setFields(fieldObjs);
				} else if (ElementTag.isFset(element)) {
					List<Fset> fsets = loop.getFsets();
					fsets.add(MsgFsetParser.generates(element));
					loop.setFsets(fsets);
				} else if (ElementTag.isRset(element)) {
					List<Rset> rsets = loop.getRsets();
					rsets.add(MsgRsetParser.generates(element));
					loop.setRsets(rsets);
				} else if (ElementTag.isLoop(element)) {
					List<Loop> loops = loop.getLoops();
					loops.add(MsgLoopParser.generates(element));
					loop.setLoops(loops);
				}
			}
		}
		return loop;
	}
	
	/**
	 * 解析获取Loop属性
	 * @param loopsElement
	 * @return
	 * @throws MsgException
	 */
	private static Loop getAttr(Element el) throws MsgException {
		Loop loop = new Loop();
		String id = el.getAttribute("id");
		if (StringUtils.isNotEmpty(id)) {
			loop.setId(id);
		} else {
			throw new MsgException("this Loop's attribute [id] is required");
		}
		String caption = el.getAttribute("caption");
		if (StringUtils.isNotEmpty(caption)) {
			loop.setCaption(caption);
		}
		return loop;
	}
}
