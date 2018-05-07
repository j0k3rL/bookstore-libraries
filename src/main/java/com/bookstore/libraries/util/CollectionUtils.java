package com.bookstore.libraries.util;

import java.util.Collection;

public class CollectionUtils {

	private CollectionUtils() {}

	public static boolean isEmpty(Collection<?> list) {
		return list == null || list.isEmpty();
	}

	public static boolean isNotEmpty(Collection<?> list) {
		return !CollectionUtils.isEmpty(list);
	}
}