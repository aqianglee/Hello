package com.aqiang.hello.jpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

@Repository
public class JPADaoImpl implements Dao {

	@PersistenceContext
	EntityManager em;

	@Override
	public <T extends Persistable> void save(T t) {
		em.persist(t);
	}

	@Override
	public <T extends Persistable> T marge(T t) {
		return em.merge(t);
	}

	@Override
	public <T extends Persistable> void delete(T t) {
		em.remove(t);
	}

	@Override
	public <T extends Persistable> T find(Class<T> clazz, Object id) {
		return em.find(clazz, id);
	}

	@Override
	public <T extends Persistable> List<T> list(Class<T> clazz) {
		return list(clazz, null);
	}

	@Override
	public <T extends Persistable> List<T> list(Class<T> clazz, List<Condition> coditions) {
		return list(clazz, coditions, null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Persistable> List<T> list(Class<T> clazz, List<Condition> conditions, List<Order> orders) {
		Query query = createQuery(clazz, conditions, orders);
		return query.getResultList();
	}

	private <T extends Persistable> Query createQuery(Class<T> clazz, List<Condition> conditions, List<Order> orders) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(String.format("select e from %s e", clazz.getSimpleName()));
		Query query = handleConditions(conditions, buffer, orders);
		return query;
	}

	private Query handleConditions(List<Condition> conditions, StringBuffer buffer, List<Order> orders) {
		Map<String, Object> args = new HashMap<>();
		if (conditions != null && !conditions.isEmpty()) {
			buffer.append(" where ");
			ComplexCondition and = Conditions.and();
			and.setConditions(conditions);
			buffer.append(and.generate(args));
		}
		if (orders != null && !orders.isEmpty()) {
			buffer.append(" order by ");
			List<String> subBuffer = new ArrayList<>();
			for (Order order : orders) {
				subBuffer.add(order.generate());
			}
			buffer.append(StringUtils.join(subBuffer, ','));
		}
		System.out.println(buffer.toString());
		Query query = em.createQuery(buffer.toString());
		for (String fieldName : args.keySet()) {
			query.setParameter(fieldName, args.get(fieldName));
		}
		return query;
	}

	@Override
	public <T extends Persistable> List<T> list(Class<T> clazz, int first, int size) {
		return list(clazz, null, 0, size);
	}

	@Override
	public <T extends Persistable> List<T> list(Class<T> clazz, List<Condition> coditions, int first, int size) {
		return list(clazz, coditions, null, 0, size);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Persistable> List<T> list(Class<T> clazz, List<Condition> coditions, List<Order> orders,
			int first, int size) {
		Query query = createQuery(clazz, coditions, orders);
		query.setFirstResult(first);
		query.setMaxResults(size);
		return query.getResultList();
	}

	@Override
	public com.aqiang.hello.jpa.Query query() {
		return new com.aqiang.hello.jpa.Query(em);
	}

}
