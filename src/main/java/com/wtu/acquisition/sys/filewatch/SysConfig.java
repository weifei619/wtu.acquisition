package com.wtu.acquisition.sys.filewatch;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.core.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;

public class SysConfig {
	private static Log log = LogFactory.getLog(SysConfig.class);
	private static Map<String, String> indexconfig;
	private static Map<String, String> sysconfig;
	static {
		reloadAllConfig();
//		addConfigChangeWatcher();
	}

	private static void reloadAllConfig() {
		SysConfig.indexconfig = loadproperties("index.properties");
		SysConfig.sysconfig = loadproperties("config.properties");
	}

//	private static void addConfigChangeWatcher() {
//           String baseFold =SysConfig.class.getClassLoader().getResource("").getFile();
//           FileWatcher
//	}

	// 获取索引配置
	public static String getIndexConfig(String key) {
		return SysConfig.indexconfig.get(key);

	}

	// 获取索引配置
	public static String getIndexConfig(String key, String property) {
		return SysConfig.indexconfig.get(key + "." + property);

	}

	private static Map<String, String> loadproperties(String filename) {
		Map<String, String> map = new HashMap<String, String>();
		Properties ps = new Properties();
		InputStream is = SysConfig.class.getClassLoader().getResourceAsStream(filename);
		try {
			ps.load(is);
			for (Entry  enty : ps.entrySet()) {
				String key = enty.getKey().toString();
				String value=enty.getValue().toString();
				value=new String(value.getBytes("utf-8"));
				map.put(key, value);
			}
		} catch (IOException e) {
			e.printStackTrace();
			log.error("读取流失败....", e);
		}
		finally {
			IOUtils.closeQuietly(is);
		}
		return map;
	}
}
