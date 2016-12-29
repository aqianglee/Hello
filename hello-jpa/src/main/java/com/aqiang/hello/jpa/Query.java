package com.aqiang.hello.jpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;

public class Query {
	private ComplexCondition condition;
	private List<Order> orders;

	private Boolean distinct;

	private Map<String, Object> args;

	private EntityManager em;

	private Class<? extends Persistable> clazz;

	private int first;
	private int size;
	private StringBuffer jpql;

	public Query(EntityManager em) {
		this.em = em;
		this.condition = Conditions.and();
		this.orders = new ArrayList<>();
		this.args = new HashMap<>();
		this.first = 0;
		this.size = Integer.MAX_VALUE;
	}

	public Query setClazz(Class<? extends Persistable> clazz) {
		this.clazz = clazz;
		return this;
	}

	public Query page(int page) {
		this.first = page;
		return this;
	}

	public Query pageSize(int pageSize) {
		this.size = pageSize;
		return this;
	}

	public Query distinct(Boolean distinct) {
		this.distinct = distinct;
		return this;
	}

	public Query where(Condition condition) {
		this.condition.add(condition);
		return this;
	}

	public Query order(Order order) {
		this.orders.add(order);
		return this;
	}

	private void handleOrders() {
		if (orders.isEmpty()) {
			return;
		}
		List<String> buf = new ArrayList<>();
		for (Order order : orders) {
			buf.add(order.generate());
		}
		jpql.append("order by ");
		jpql.append(StringUtils.join(buf, ','));
	}

	@SuppressWarnings("unchecked")
	public List<? extends Persistable> query() {
		javax.persistence.Query createQuery = em.createQuery(createJPQL());
		for (String name : args.keySet()) {
			createQuery.setParameter(name, args.get(name));
		}
		createQuery.setFirstResult(first);
		createQuery.setMaxResults(size);
		return createQuery.getResultList();
	}

	private String createJPQL() {
		jpql = new StringBuffer();
		jpql.append(String.format("select e from %s e ", clazz.getSimpleName()));
		handleConditions();
		handleOrders();
		System.out.println(jpql.toString());
		return jpql.toString();
	}

	private void handleConditions() {
		String generate = this.condition.generate(args);
		if (generate == null) {
			return;
		}
		jpql.append("where ");
		jpql.append(generate);
	}
}
