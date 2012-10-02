package com.qubo.xml;

import java.util.Map.Entry;

public class Xml extends AbstractParentOf<ChildOf<Xml>, Xml> {
	private static final String XML_INDENT = "\t";

	public Xml(String name) {
		super(name);
	}

	@Override
	protected ChildOf<Xml> newChild(String name) {
		return new ChildOf<Xml>(this, name);
	}

	public void build() {
		StringBuilder builder = new StringBuilder();
		build(builder, this, 0);
		System.out.println(builder);
	}

	private <T> void build(StringBuilder builder, ParentOf<T> parent, int indent) {
		for (int i = 0; i < indent; i++) {
			builder.append(XML_INDENT);
		}
		builder.append("<").append(parent.name());
		for (Entry<String, String> entry : parent.as()) {
			builder.append(" ")
					.append("\"")
					.append(entry.getKey())
					.append("\"=\"")
					.append(entry.getValue())
					.append("\"");
		}
		builder.append(">\n");
		for (T child : parent._s()) {
			if (child instanceof ParentOf<?>) {
				build(builder, (ParentOf<?>) child, indent + 1);
			}
		}
		for (int i = 0; i < indent; i++) {
			builder.append(XML_INDENT);
		}
		builder.append("</").append(parent.name()).append(">\n");
	}
}
