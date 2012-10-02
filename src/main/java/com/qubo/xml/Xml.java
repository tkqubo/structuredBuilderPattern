package com.qubo.xml;

import java.util.Map.Entry;

public class Xml extends AbstractParentOf<ChildOf<Xml>, Xml> {
	public Xml(String name) {
		super(name);
	}

	@Override
	protected ChildOf<Xml> newChild(String name) {
		return new ChildOf<Xml>(this, name);
	}

	public void build() {
		StringBuilder builder = new StringBuilder();
		build(builder, this);
		System.out.println(builder);
	}

	private <T> void build(StringBuilder builder, ParentOf<T> parent) {
		builder.append("<").append(parent.name());
		for (Entry<String, String> entry : parent.as()) {
			builder.append(" ")
					.append("\"")
					.append(entry.getKey())
					.append("\"=\"")
					.append(entry.getValue())
					.append("\"");
		}
		builder.append(">");
		for (T child : parent._s()) {
			if (child instanceof ParentOf<?>) {
				build(builder, (ParentOf<?>) child);
			}
		}
		builder.append("</").append(parent.name()).append(">");

	}
}
