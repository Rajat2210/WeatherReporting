package com.weather.utils;

import java.io.*;
import java.util.*;

public class PropertyReader {
	public static String path = getPath();
	
	public String readApplicationFile(String key) {
		String value = "";
		try {
			Properties prop = new Properties();
			File f = new File(path + File.separator + "properties" + File.separator
					+ "application.properties");
			if (f.exists()) {
				prop.load(new FileInputStream(f));
				value = prop.getProperty(key);
		  }
		} catch (Exception e) {
			System.out.println("Failed to read from application.properties file.");
		}
		return value;
	}

	public static String getPath() {
		String path = " ";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
		return path;
	}
}
