package com.swkj.zebra.util;

import com.amaz.core.common.StringUtils;

/**
 * @author: xiewanpin
 * @since:  Dec 14, 2016 10:20:09 AM
 * The class CharacterFilter
 * Description:特殊符号处理字符串过滤
 */
public class CharacterFilter {

	public static String filterEmoji(String source) {
		if (StringUtils.isNotBlank(source)) {
			return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "");
		} else {
			return source;
		}
	}
}
