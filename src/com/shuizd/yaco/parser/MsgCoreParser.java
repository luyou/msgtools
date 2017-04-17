package com.shuizd.yaco.parser;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.alibaba.fastjson.JSON;
import com.shuizd.yaco.element.Xml;
import com.shuizd.yaco.enums.ElementTag;
import com.shuizd.yaco.utils.LogWriter;
import com.shuizd.yaco.utils.MsgException;

public class MsgCoreParser {
	
	private static final String conf_suffix = ".xml";
	
	/**
	 * 获取配置文件对象
	 * @param path
	 * @return
	 * @throws MsgException 
	 */
	public static Xml getConfig(String configFileName) throws MsgException {
		Xml xml = new Xml();
		try {
			InputStream configStream = MsgCoreParser.class.getClassLoader().getResourceAsStream(configFileName + conf_suffix); 
//			LogWriter.info(" --> MsgCoreParser getConfig... ### configPath : " + configStream.);
			xml = generates(xml, loadConf(configStream));
			LogWriter.info(" --> MsgCoreParser getConfig... ### Xml : " + JSON.toJSONString(xml));
		} catch (Exception e) {
			LogWriter.error(" --> MsgCoreParser getConfig... ### exception : " + e.getMessage());
			e.printStackTrace();
			throw new MsgException(" MsgCoreParser getConfig failure;");
		}
		return xml;
	}

	/**
	 * 生成配置文件对象
	 * @param xml
	 * @param root
	 * @throws MsgException
	 */
	private static Xml generates(Xml xml, Node root) throws MsgException {
		NodeList childNodes = root.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			 Node child = childNodes.item(i);
			if (child.getNodeType() == Node.ELEMENT_NODE) {
				Element el = (Element) child;
				if (ElementTag.isConstant(el)) {
					xml.setConstant(MsgConstantParser.generates(el));
				} else if (ElementTag.isMsg(el)) {
					xml.setMsg(MsgParser.generates(el));
				}
			}
		}
		return xml;
	}
	
	/**
	 * 载入校验工具配置文件
	 * @param inputStream
	 * @return
	 * @throws MsgException
	 */
	private static Node loadConf(InputStream inputStream) throws MsgException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = (Document) builder.parse(inputStream);
			Node node = document.getElementsByTagName("xml").item(0);
			if (node == null) {
				throw new MsgException(" loadConf msg_validation.xml ==> Failed to parse the Config XML");
			}
			return node;
		} catch (Exception e) {
			LogWriter.error("loadConf [msg_validation.xml] failure : " + e.getMessage());
			e.printStackTrace();
			throw new MsgException(" Failed to parse the Config XML");
		}
	}
	
	public static void main(String[] args) {
		InputStream configStream = MsgCoreParser.class.getClassLoader().getResourceAsStream("msg_validation" + conf_suffix); 
	}

}
