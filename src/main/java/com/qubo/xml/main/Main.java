package com.qubo.xml.main;

import com.qubo.xml.Xml;

public class Main {
	public static void main(String[] args) {
		new Xml("html")
				._("body")
					.a("bgcolor", "red")
					.a("id", "body")
					._("div")
						.a("id", "main")
							._("h1")
							._()
							._("p")
								.a("class", "description")
							._()
						._()
					._()
				.build();

	}
}
