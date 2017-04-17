package com.shuizd.yaco.core;

import com.shuizd.yaco.element.Xml;
import com.shuizd.yaco.parser.MsgCoreParser;
import com.shuizd.yaco.utils.LogWriter;
import com.shuizd.yaco.utils.StringUtils;

public class MsgTools {

	private String configName;

	private static Xml xml = null;

	private static class MsgToolsHolder {
		private static final MsgTools INSTANCE = new MsgTools();
	}

	private MsgTools() {
	}

	public static final MsgTools getInstance() {
		return MsgToolsHolder.INSTANCE;
	}

	private void init() {
		long startTime = System.currentTimeMillis();
		try {
			if (StringUtils.isEmpty(configName)) {
				this.configName = "msg_validation";
			}
			LogWriter.info(" --> MsgTools init...");
			LogWriter.info(" --> MsgTools init... ### configName : " + configName);
//			String fileUrl = MsgTools.class.getResource("/").getPath();
//			LogWriter.info(" --> MsgTools init... ### this class Path : " + fileUrl);
//			String path = fileUrl.substring(0, fileUrl.indexOf("WEB-INF")) + File.separator + "WEB-INF" + File.separator
//					+ "class" + File.separator + configName + conf_suffix;
			xml = MsgCoreParser.getConfig(configName);
			LogWriter.info(" --> MsgTools init finished, 耗时：" + (System.currentTimeMillis() - startTime) + "ms");
		} catch (Exception e) {
			LogWriter.error(" --> MsgTools init ### Exception : " + e.getMessage());
			LogWriter.error(" --> MsgTools init ### Exception, 耗时:" + (System.currentTimeMillis() - startTime) + "ms");
			e.printStackTrace();
		}
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public static void main(String[] args) {
		MsgTools tools = MsgTools.getInstance();
		tools.init();
		Xml xml = tools.xml;
		System.out.println(xml.getMsg().getId());
		tools = MsgTools.getInstance();
		Xml xml2 = tools.xml;
		System.out.println(xml2.getMsg().getId());
	}
}
