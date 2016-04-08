package com.gh.config;

public class Config {
	private static final String HOME_DIR_KEY = "HOMEDIR";
	
	public static String getBaseDir(){
		return System.getProperty(HOME_DIR_KEY);
	}
}
