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

public class MsgFsetParser {

	/**
	 * 解析生成Fset集合
	 * 
	 * @param fsetsNode
	 * @return
	 * @throws MsgException
	 */
	public static Fset generates(Element el) throws MsgException {
		Fset fset = getAttr(el);
		NodeList nodes = el.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				if (ElementTag.isField(element)) {
					List<FieldObj> fieldObjs = fset.getFields();
					fieldObjs.add(MsgFieldParser.generates(element));
					fset.setFields(fieldObjs);
				} else if (ElementTag.isFset(element)) {
					List<Fset> fsets = fset.getFsets();
					fsets.add(MsgFsetParser.generates(element));
					fset.setFsets(fsets);
				} else if (ElementTag.isRset(element)) {
					List<Rset> rsets = fset.getRsets();
					rsets.add(MsgRsetParser.generates(element));
					fset.setRsets(rsets);
				} else if (ElementTag.isLoop(element)) {
					List<Loop> loops = fset.getLoops();
					loops.add(MsgLoopParser.generates(element));
					fset.setLoops(loops);
				}
			}
		}
		return fset;
	}

	/**
	 * 解析获取Fset属性
	 * 
	 * @param fsetsElement
	 * @return
	 * @throws MsgException
	 */
	private static Fset getAttr(Element el) throws MsgException {
		Fset fset = new Fset();
		String id = el.getAttribute("id");
		if (StringUtils.isNotEmpty(id)) {
			fset.setId(id);
		} else {
			throw new MsgException("this Fset's attribute [id] is required");
		}
		String caption = el.getAttribute("caption");
		if (StringUtils.isNotEmpty(caption)) {
			fset.setCaption(caption);
		}
		return fset;
	}

}
