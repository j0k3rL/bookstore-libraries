package com.bookstore.libraries.util;

import java.net.URL;

public class ResourceUtils {

	private ResourceUtils() {}
	
	@SuppressWarnings("rawtypes")
	public static URL getResource(Class clazz, String resourcePath) {
		return clazz.getClassLoader().getResource(resourcePath);
	}
}