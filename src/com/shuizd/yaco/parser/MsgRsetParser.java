package com.shuizd.yaco.parser;

import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.shuizd.yaco.element.Route;
import com.shuizd.yaco.element.Rset;
import com.shuizd.yaco.enums.ElementTag;
import com.shuizd.yaco.utils.MsgException;
import com.shuizd.yaco.utils.StringUtils;

public class MsgRsetParser {

	/**
	 * 解析生成Rset集合
	 * 
	 * @param rsetsNode
	 * @return
	 * @throws MsgException
	 */
	public static Rset generates(Element el) throws MsgException {
		Rset rset = getAttr(el);
		NodeList nodes = el.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				if (ElementTag.isRoute(element)) {
					List<Route> routes = rset.getRoutes();
					routes.add(MsgRouteParser.generates(element));
					rset.setRoutes(routes);
				} else {
					rset.setOther(MsgOtherParser.generates(element));
				}
			}
		}
		return rset;
	}

	/**
	 * 解析获取Rset属性
	 * 
	 * @param rsetElement
	 * @return
	 * @throws MsgException
	 */
	private static Rset getAttr(Element rsetElement) throws MsgException {
		Rset rset = new Rset();
		String id = rsetElement.getAttribute("id");
		if (StringUtils.isNotEmpty(id)) {
			rset.setId(id);
		}
		String ref = rsetElement.getAttribute("ref");
		if (StringUtils.isNotEmpty(ref)) {
			rset.setRef(ref);
		} else {
			throw new MsgException("this Rset's attribute [ref] is required");
		}
		String caption = rsetElement.getAttribute("caption");
		if (StringUtils.isNotEmpty(caption)) {
			rset.setCaption(caption);
		}
		return rset;
	}

}
