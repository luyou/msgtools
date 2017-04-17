package com.shuizd.yaco.parser;

import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.shuizd.yaco.element.FieldObj;
import com.shuizd.yaco.element.Fset;
import com.shuizd.yaco.element.Loop;
import com.shuizd.yaco.element.Route;
import com.shuizd.yaco.element.Rset;
import com.shuizd.yaco.enums.ElementTag;
import com.shuizd.yaco.utils.MsgException;
import com.shuizd.yaco.utils.StringUtils;

public class MsgRouteParser {

	public static Route generates(Element el) throws MsgException {
		Route route = getAttr(el);
		NodeList nodes = el.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				if (ElementTag.isField(element)) {
					List<FieldObj> fieldObjs = route.getFields();
					fieldObjs.add(MsgFieldParser.generates(element));
					route.setFields(fieldObjs);
				} else if (ElementTag.isFset(element)) {
					List<Fset> fsets = route.getFsets();
					fsets.add(MsgFsetParser.generates(element));
					route.setFsets(fsets);
				} else if (ElementTag.isRset(element)) {
					List<Rset> rsets = route.getRsets();
					rsets.add(MsgRsetParser.generates(element));
					route.setRsets(rsets);
				} else if (ElementTag.isLoop(element)) {
					List<Loop> loops = route.getLoops();
					loops.add(MsgLoopParser.generates(element));
					route.setLoops(loops);
				}
			}
		}
		return route;
	}
	
	private static Route getAttr(Element routeElement) throws MsgException {
		Route route = new Route();
		String caption = routeElement.getAttribute("caption");
		if (StringUtils.isNotEmpty(caption)) {
			route.setCaption(caption);
		}
		String value = routeElement.getAttribute("value");
		if (StringUtils.isNotEmpty(value)) {
			route.setValue(value);
		}else{
			throw new MsgException("this Route's attribute [value] is required");
		}
		return route;
	}

}
