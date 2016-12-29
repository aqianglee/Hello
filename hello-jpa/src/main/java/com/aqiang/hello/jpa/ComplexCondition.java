package com.aqiang.hello.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public abstract class ComplexCondition implements Condition {
	private List<Condition> conditions = new ArrayList<>();

	public void add(Condition condition) {
		this.conditions.add(condition);
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	@Override
	public String generate(Map<String, Object> args) {
		if (conditions.isEmpty()) {
			return null;
		}
		List<String> buffer = new ArrayList<>();
		for (Condition condition : conditions) {
			buffer.add(condition.generate(args));
		}
		if (buffer.size() == 1) {
			return buffer.get(0);
		}
		return String.format("( %s )", StringUtils.join(buffer, String.format(" ) %s ( ", getLinkMethod())));
	}

	protected abstract String getLinkMethod();
}
