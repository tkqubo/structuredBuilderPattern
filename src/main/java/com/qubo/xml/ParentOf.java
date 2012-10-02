package com.qubo.xml;

import java.util.Map;

public interface ParentOf<T> {
	T _(String name);

	ParentOf<T> a(String name, String value);

	String a(String name);

	String name();

	Iterable<T> _s();

	Iterable<Map.Entry<String, String>> as();
}
