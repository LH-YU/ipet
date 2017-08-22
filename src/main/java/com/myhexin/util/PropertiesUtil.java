package com.myhexin.util;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 读取配置文件工具类
 * 
 * @author zhc time:2012-3-12
 */
public final class PropertiesUtil {
	private static Log log = LogFactory.getLog(PropertiesUtil.class);
	private static Map<Object, Properties> propMap = new HashMap<Object, Properties>();

	/**
	 * 得到指定名称的属性文件
	 * 
	 * @param propName
	 *            ****.properties文件名
	 * @return
	 */
	public static Properties getProperties(String propName) {
		if (propName == null)
			return null;
		if (propMap.containsKey(propName))
			return (Properties) propMap.get(propName);
		Properties props = new Properties();
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			props.load(new InputStreamReader(loader.getResourceAsStream(propName),"UTF-8"));
			propMap.put(propName, props);
		} catch (Exception e) {
			log.error("getProperties(String) Exception.", e);
		}
		return props;
	}

	/**
	 * 获取指定 Properties文件里的内容
	 * 
	 * @param propName
	 *            ****.properties文件名
	 * @param key
	 *            properties文件里面的key
	 * @return
	 */
	public static String getEntryValue(String propName, String key) {
		Properties prop = getProperties(propName);
		if (prop != null)
			return prop.getProperty(key);
		else
			return null;
	}

	/**
	 * 返回内容为 int类型
	 * 
	 * @param propName
	 *            ****.properties文件名
	 * @param key
	 *            properties文件里面的key
	 * @return
	 */
	public static int getIntEntryValue(String propName, String key) {
		String value = getEntryValue(propName, key);
		int intValue = 0;
		if (value != null)
			try {
				intValue = Integer.parseInt(value.trim());
			} catch (NumberFormatException ex) {
				log.error(
						"getIntEntryValue(String propName,String key) NumberFormatException.",
						ex);
			}
		return intValue;
	}

	/**
	 * 返回内容为 long类型
	 * 
	 * @param propName
	 *            ****.properties文件名
	 * @param key
	 *            properties文件里面的key
	 * @return
	 */
	public static long getLongEntryValue(String propName, String key) {
		String value = getEntryValue(propName, key);
		long longValue = 0L;
		if (value != null)
			try {
				longValue = Long.parseLong(value.trim());
			} catch (NumberFormatException ex) {
				log.error(
						"getLongEntryValue(String propName,String key) NumberFormatException.",
						ex);
			}
		return longValue;
	}

	/**
	 * 获取指定 Properties文件里的内容
	 * 
	 * @param propName
	 *            ****.properties文件名
	 * @param key
	 *            properties文件里面的key
	 * @param defaultValue
	 *            默认值 | 当key不存在时将返回此参数
	 * @return
	 */
	public static String getEntryValue(String propName, String key,
			String defaultValue) {
		Properties prop = getProperties(propName);
		if (prop != null)
			return prop.getProperty(key, defaultValue);
		else
			return null;
	}
}