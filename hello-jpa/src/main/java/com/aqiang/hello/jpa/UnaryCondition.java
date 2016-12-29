package com.aqiang.hello.jpa;

import java.util.Map;

public abstract class UnaryCondition implements Condition {
	protected String fieldName;

	public UnaryCondition(String fieldName) {
		this.fieldName = fieldName;
	}

	@Override
	public String generate(Map<String, Object> args) {
		return String.format("%s %s", fieldName, getOperator());
	}

	protected abstract String getOperator();
}
