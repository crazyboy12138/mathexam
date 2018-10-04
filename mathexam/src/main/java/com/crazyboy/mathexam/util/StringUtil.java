package com.crazyboy.mathexam.util;
/**
 * TODO <BR>
 * 
 * @author 15软件工程2班第六小组
 * @since lin.tingmin@2018年10月4日
 */
public class StringUtil {
	public static boolean isStringValid(String str) {
		return !(str == null || "".equals(str.trim()));
	}
}
