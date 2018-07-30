package com.revature.util;

import java.sql.Date;

public class ConversionUtil {
	public static Object[] toObjArray(Object ...objects) {
		return objects;
	}
	
	public static String[] toStrArray(String ...strings) {
		return strings;
	}
	
	public static Integer toInt(Object o) {
		return Integer.valueOf(o.toString());
	}
	
	public static Date toDt(Object o) {
		return Date.valueOf(o.toString().substring(0,10));
	}
}
