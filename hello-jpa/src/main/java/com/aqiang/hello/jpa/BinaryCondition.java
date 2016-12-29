package com.aqiang.hello.jpa;

import java.util.Map;

public abstract class BinaryCondition implements Condition {
	protected String fieldName;
	protected Object value;

	public BinaryCondition(String fieldName, Object value) {
		this.fieldName = fieldName;
		this.value = value;
	}

	@Override
	public String generate(Map<String, Object> args) {
		args.put(fieldName, value);
		return String.format("%s %s :%s", fieldName, getOperator(), fieldName);
	}

	protected abstract String getOperator();
}
