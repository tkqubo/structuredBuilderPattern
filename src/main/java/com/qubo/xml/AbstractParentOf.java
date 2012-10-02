package com.qubo.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

abstract class AbstractParentOf<T, TSelf extends ParentOf<T>> implements ParentOf<T> {
	private final String name;
	private final List<T> list = new ArrayList<T>();
	private final Map<String, String> attrs = new TreeMap<String, String>();

	public AbstractParentOf(String name) {
		this.name = name;
	}

	@SuppressWarnings("unchecked")
	public TSelf a(String name, String value) {
		attrs.put(name, value);
		return (TSelf) this;
	}

	public String a(String name) {
		return attrs.get(name);
	}

	public String name() {
		return name;
	}

	public T _(String name) {
		T t = newChild(name);
		list.add(t);
		return t;
	}

	protected abstract T newChild(String name);

	public Iterable<Entry<String, String>> as() {
		return attrs.entrySet();
	}

	public Iterable<T> _s() {
		return list;
	}
}