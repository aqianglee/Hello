package com.aqiang.hello.jpa;

public class Orders {
	public static Order asc(String fieldName) {
		return new Order() {

			@Override
			public String generate() {
				return fieldName;
			}
		};
	}

	public static Order desc(String fieldName) {
		return new Order() {

			@Override
			public String generate() {
				return String.format("%s desc", fieldName);
			}
		};
	}
}
