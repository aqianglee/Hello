package com.aqiang.hello.jpa;

public class Conditions {

	public static Condition eq(String fieldName, Object value) {
		return new BasicCondition(fieldName, value) {

			@Override
			protected String getOperator() {
				return "=";
			}

		};
	}

	public static Condition gt(String fieldName, Object value) {
		return new BasicCondition(fieldName, value) {

			@Override
			protected String getOperator() {
				return ">";
			}

		};
	}

	public static Condition lt(String fieldName, Object value) {
		return new BasicCondition(fieldName, value) {

			@Override
			protected String getOperator() {
				return "<";
			}

		};
	}

	public static ComplexCondition and() {
		return new ComplexCondition() {

			@Override
			protected String getLinkMethod() {
				return "and";
			}
		};
	}

	public static ComplexCondition or() {
		return new ComplexCondition() {

			@Override
			protected String getLinkMethod() {
				return "or";
			}
		};
	}

}
