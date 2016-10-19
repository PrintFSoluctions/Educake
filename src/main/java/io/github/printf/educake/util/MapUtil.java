package io.github.printf.educake.util;

import java.util.*;

public class MapUtil {
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
		Map<K, V> result = new LinkedHashMap<>();

		Collections.sort(list, (key1, key2) -> (key1.getValue()).compareTo(key2.getValue()));
		for (Map.Entry<K, V> entry : list) result.put(entry.getKey(), entry.getValue());

		return result;
	}
}