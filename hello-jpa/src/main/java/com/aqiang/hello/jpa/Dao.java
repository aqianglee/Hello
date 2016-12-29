package com.aqiang.hello.jpa;

import java.util.List;

public interface Dao {
	public <T extends Persistable> void save(T t);

	public <T extends Persistable> T marge(T t);

	public <T extends Persistable> void delete(T t);

	public <T extends Persistable> T find(Class<T> clazz, Object id);

	public <T extends Persistable> List<T> list(Class<T> clazz);

	public <T extends Persistable> List<T> list(Class<T> clazz, List<Condition> coditions);

	public <T extends Persistable> List<T> list(Class<T> clazz, List<Condition> coditions, List<Order> orders);

	public <T extends Persistable> List<T> list(Class<T> clazz, int first, int size);

	public <T extends Persistable> List<T> list(Class<T> clazz, List<Condition> coditions, int first, int size);

	public <T extends Persistable> List<T> list(Class<T> clazz, List<Condition> coditions, List<Order> orders,
			int first, int size);

	public Query query();

}
