package com.aqiang.hello.jpa;

public class Conditions {

	public static Condition eq(String fieldName, Object value) {
		return new BinaryCondition(fieldName, value) {

			@Override
			protected String getOperator() {
				return "=";
			}

		};
	}

	public static Condition gt(String fieldName, Object value) {
		return new BinaryCondition(fieldName, value) {

			@Override
			protected String getOperator() {
				return ">";
			}

		};
	}

	public static Condition lt(String fieldName, Object value) {
		return new BinaryCondition(fieldName, value) {

			@Override
			protected String getOperator() {
				return "<";
			}

		};
	}

	public static Condition neq(String fieldName, Object value) {
		return new BinaryCondition(fieldName, value) {

			@Override
			protected String getOperator() {
				return "!=";
			}

		};
	}

	public static Condition gteq(String fieldName, Object value) {
		return new BinaryCondition(fieldName, value) {

			@Override
			protected String getOperator() {
				return ">=";
			}

		};
	}

	public static Condition lteq(String fieldName, Object value) {
		return new BinaryCondition(fieldName, value) {

			@Override
			protected String getOperator() {
				return "<=";
			}

		};
	}

	public static Condition like(String fieldName, Object value) {
		return new BinaryCondition(fieldName, value) {

			@Override
			protected String getOperator() {
				return "like";
			}

		};
	}

	public static Condition isNull(String fieldName) {
		return new UnaryCondition(fieldName) {

			@Override
			protected String getOperator() {
				return "is null";
			}
		};
	}

	public static Condition isNotNull(String fieldName) {
		return new UnaryCondition(fieldName) {

			@Override
			protected String getOperator() {
				return "is not null";
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
