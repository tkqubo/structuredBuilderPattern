package com.qubo.structuredBuilder;

public class Root implements ParentOf<ChildOf<Root>> {
	public ChildOf<Root> child() {
		return new ChildOf<Root>(this);
	}
}
