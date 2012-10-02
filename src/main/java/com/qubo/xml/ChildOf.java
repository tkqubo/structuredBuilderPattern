package com.qubo.xml;

public class ChildOf<T> extends AbstractParentOf<ChildOf<ChildOf<T>>, ChildOf<T>> {
	private final T _;

	public ChildOf(T parent, String name) {
		super(name);
		this._ = parent;
	}

	public T _() {
		return _;
	}

	@Override
	protected ChildOf<ChildOf<T>> newChild(String name) {
		return new ChildOf<ChildOf<T>>(this, name);
	}
}