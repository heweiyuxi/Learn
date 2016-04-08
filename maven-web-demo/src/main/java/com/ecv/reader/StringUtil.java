package com.ecv.reader;

public class StringUtil {
	public static boolean isEmpty(String inStr) {
        return (inStr == null || inStr.trim().length() < 1);
    }

}
