package com.cx.utils.Array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class Lists {
	private Lists() {
	}

	public static <T> List<T> list() {
		return new ArrayList<>();
	}

	public static <T> List<T> list(Collection<T> coll) {
		return new ArrayList<>(coll);
	}

	public static <T> List<T> list(int size) {
		if (size < 0) {
			throw new IllegalArgumentException("size " + size + "<  0");
		}
		return new ArrayList<>(size);
	}

	public static <T> List<T> list(T[] arrs) {
		List<T> res = null;
		if (arrs != null) {
			res = new ArrayList<>();
			for (int i = 0; i < arrs.length; i++) {
				res.add(arrs[i]);
			}
		}
		return res;
	}

	public static <T> List<T> filter(List<T> list, Selector<T> selector) {
		if (list == null) {
			throw new IllegalArgumentException("list is null");
		}
		if (selector == null) {
			throw new IllegalArgumentException("selector is null");
		}
		List<T> res = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			T t = list.get(i);
			if (selector.filter(t)) {
				res.add(t);
			}
		}
		return res;
	}

	public static <K, V, T> void toMap(List<T> list, Map<K, V> map, Mapper<K, V, T> mapper) {
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				mapper.map(map, list.get(i));
			}
		}
	}

	public static <K, V, T> Map<K, V> toMap(List<T> list, Mapper<K, V, T> mapper) {
		Map<K, V> map = null;
		if (list != null) {
			map = Maps.toMap();
			toMap(list, map, mapper);
		}
		return map;
	}

	public static interface Selector<T> {
		public boolean filter(T t);
	}

	public static interface Mapper<K, V, T> {
		public void map(Map<K, V> map, T t);
	}
}
