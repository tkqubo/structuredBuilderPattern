package com.qubo.structuredBuilder;

public class ChildOf<T> implements ParentOf<ChildOf<ChildOf<T>>> {
	private T parent;

	public T parent() {
		return parent;
	}

	public ChildOf(T parent) {
		this.parent = parent;
	}

	public ChildOf<ChildOf<T>> child() {
		return new ChildOf<ChildOf<T>>(this);
	}

}
