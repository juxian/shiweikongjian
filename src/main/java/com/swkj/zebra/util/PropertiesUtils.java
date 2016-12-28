/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.swkj.zebra.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Properties;

/**
 * Properties文件帮助类
 *
 */
public class PropertiesUtils {

	private static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);

	public static Properties get(Map<String,String> map){
		Properties properties = new Properties();
		for (String key: map.keySet()) {
			properties.setProperty(key,map.get(key));
		}
		return  properties;
	}
}
