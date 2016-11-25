package com.aqiang.hello.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < conditions.size(); i++) {
			Condition condition = conditions.get(i);
			buffer.append(condition.generate(args));
			if (i < conditions.size() - 1) {
				buffer.append(String.format(" %s ", getLinkMethod()));
			}
		}
		return buffer.toString();
	}

	protected abstract String getLinkMethod();
}
