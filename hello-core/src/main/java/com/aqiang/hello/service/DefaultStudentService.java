package com.aqiang.hello.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqiang.hello.entities.Student;
import com.aqiang.hello.jpa.ComplexCondition;
import com.aqiang.hello.jpa.Conditions;
import com.aqiang.hello.jpa.Dao;
import com.aqiang.hello.jpa.Orders;

@SuppressWarnings("unchecked")
@Service
@Transactional
public class DefaultStudentService implements StudentService {

	@Autowired
	private Dao dao;

	@Override
	public void saveStudent(Student student) {
		dao.save(student);
	}

	@Override
	public List<Student> getStudents() {
		return (List<Student>) dao.query().setClazz(Student.class).query();
		// return dao.list(Student.class);
	}

	@Override
	public void deleteStudent(Student student) {
		dao.delete(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return dao.marge(student);
	}

	@Override
	public List<Student> getStudentsByName(String name) {
		// return dao.list(Student.class, Arrays.asList(Conditions.eq("name",
		// name)));
		return (List<Student>) dao.query().setClazz(Student.class).where(Conditions.eq("name", name)).query();
	}

	@Override
	public List<Student> getStudentsByNameOrAge(String name, int age) {
		ComplexCondition or = Conditions.or();
		or.add(Conditions.eq("name", name));
		or.add(Conditions.eq("age", age));
		// return dao.list(Student.class, Arrays.asList(or));
		return (List<Student>) dao.query().setClazz(Student.class).where(or).query();
	}

	@Override
	public List<Student> getStudentsByNameAndAge(String name, int age) {
		// return dao.list(Student.class, Arrays.asList(Conditions.eq("name",
		// name), Conditions.eq("age", age)));
		return (List<Student>) dao.query().setClazz(Student.class).where(Conditions.eq("name", name))
				.where(Conditions.eq("age", age)).query();
	}

	@Override
	public List<Student> getStudentsByNameAndAgeAndGender(String name, int age, String gender) {
		// return dao.list(Student.class,
		// Arrays.asList(Conditions.eq("name", name), Conditions.eq("age", age),
		// Conditions.eq("gender", gender)));
		return (List<Student>) dao.query().setClazz(Student.class).where(Conditions.eq("name", name))
				.where(Conditions.eq("age", age)).where(Conditions.eq("gender", gender)).query();
	}

	@Override
	public List<Student> getStudentsAgeGT(int age) {
		// return dao.list(Student.class, Arrays.asList(Conditions.gt("age",
		// age)));
		return (List<Student>) dao.query().setClazz(Student.class).where(Conditions.gt("age", age)).query();
	}

	@Override
	public List<Student> getStudentsAgeGTEQ(int age) {
		// return dao.list(Student.class, Arrays.asList(Conditions.gteq("age",
		// age)));
		return (List<Student>) dao.query().setClazz(Student.class).where(Conditions.gteq("age", age)).query();
	}

	@Override
	public List<Student> getStudentsAgeLT(int age) {
		// return dao.list(Student.class, Arrays.asList(Conditions.lt("age",
		// age)));
		return (List<Student>) dao.query().setClazz(Student.class).where(Conditions.lt("age", age)).query();
	}

	@Override
	public List<Student> getStudentsAgeLTEQ(int age) {
		// return dao.list(Student.class, Arrays.asList(Conditions.lteq("age",
		// age)));
		return (List<Student>) dao.query().setClazz(Student.class).where(Conditions.lteq("age", age)).query();
	}

	@Override
	public List<Student> getStudentsByAge(int age) {
		// return dao.list(Student.class, Arrays.asList(Conditions.eq("age",
		// age)));
		return (List<Student>) dao.query().setClazz(Student.class).where(Conditions.eq("age", age)).query();
	}

	@Override
	public List<Student> getStudentsGenderIsNull() {
		// return dao.list(Student.class,
		// Arrays.asList(Conditions.isNull("gender")));
		return (List<Student>) dao.query().setClazz(Student.class).where(Conditions.isNull("gender")).query();
	}

	@Override
	public List<Student> getStudentsGenderIsNotNull() {
		// return dao.list(Student.class,
		// Arrays.asList(Conditions.isNotNull("gender")));
		return (List<Student>) dao.query().setClazz(Student.class).where(Conditions.isNotNull("gender")).query();
	}

	@Override
	public List<Student> getStudentsByGender(String gender) {
		// return dao.list(Student.class, Arrays.asList(Conditions.eq("gender",
		// gender)));
		return (List<Student>) dao.query().setClazz(Student.class).where(Conditions.eq("gender", gender)).query();
	}

	@Override
	public List<Student> getstudentsOrderByName() {
		// return dao.list(Student.class, null,
		// Arrays.asList(Orders.asc("name")));
		return (List<Student>) dao.query().setClazz(Student.class).order(Orders.asc("name")).query();
	}

	@Override
	public List<Student> getstudentsOrderByNameDesc() {
		// return dao.list(Student.class, null,
		// Arrays.asList(Orders.desc("name")));
		return (List<Student>) dao.query().setClazz(Student.class).order(Orders.desc("name")).query();
	}

	@Override
	public List<Student> getstudentsOrderByNameAndAgeDesc() {
		// return dao.list(Student.class, null,
		// Arrays.asList(Orders.asc("name"), Orders.desc("age")));
		return (List<Student>) dao.query().setClazz(Student.class).order(Orders.asc("name")).order(Orders.desc("age"))
				.query();
	}

	@Override
	public List<Student> getstudentsNameLike(String name) {
		// return dao.list(Student.class, Arrays.asList(Conditions.like("name",
		// name)));
		return (List<Student>) dao.query().setClazz(Student.class).where(Conditions.like("name", name)).query();
	}

	@Override
	public List<Student> getStudentsByNameAndAgeOrGenderIsNull(String string, int age) {
		ComplexCondition or = Conditions.or();
		ComplexCondition and = Conditions.and();
		and.add(Conditions.eq("name", "kyo"));
		and.add(Conditions.eq("age", age));
		or.add(and);
		or.add(Conditions.isNull("gender"));
		// return dao.list(Student.class, Arrays.asList(or));
		return (List<Student>) dao.query().setClazz(Student.class).where(or).query();
	}

	@Override
	public List<Student> getStudentsByNameOrAgeAndGenderIsNull(String string, int age) {
		ComplexCondition or = Conditions.or();
		ComplexCondition and = Conditions.and();
		and.add(or);
		or.add(Conditions.eq("name", string));
		or.add(Conditions.eq("age", age));
		and.add(Conditions.isNull("gender"));
		// return dao.list(Student.class, Arrays.asList(and));
		return (List<Student>) dao.query().setClazz(Student.class).where(and).query();
	}

}
