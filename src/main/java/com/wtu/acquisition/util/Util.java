package com.wtu.acquisition.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;

public class Util {
	private static ApplicationContext applicationContext;

	public static void setApplicationContext(ApplicationContext applicationContext) {
		Util.applicationContext = applicationContext;
	}

	// 得到bean
	public static Object getBeanByName(String name) {
		return applicationContext.getBean(name);
	}

	/**
	 * 返回int
	 * 
	 * @param str
	 * @param defaultVal
	 * @return
	 */
	public static int parseInt(String str, int... defaultVal) {
		if (defaultVal.length > 0) {
			return defaultVal[0];
		}
		return Integer.parseInt(StringUtils.trim(str));
	}

	/**
	 * 返回日期
	 * 
	 * @param strdate
	 * @param pattern
	 * @return
	 */
	public static Date parserDate(String strdate, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = sdf.parse(strdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 去掉html标签
	 * 
	 * @param content
	 * @return
	 */
	public static String cutHtmlTag(String content) {
		if (StringUtils.isBlank(content)) {
			return "";
		}
		String findStr = content.replaceAll("(\\s+)", " ").replaceAll("<[^<>]*>", " ").replaceAll("(&nbsp;)+", " ");
		return findStr;
	}
	/**
	 * 去掉url后面参数
	 *
	 * @param url
	 * @return
	 */
	public static String cutUrl(String url) {
		if(StringUtils.isBlank(url)) {
			return "";
		}
		if(url.indexOf("?")>0) {
			url=url.substring(0, url.indexOf("?"));
		}
		return url;
	}
}
