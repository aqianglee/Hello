package com.aqiang.hello.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqiang.hello.entities.Student;
import com.aqiang.hello.jpa.ComplexCondition;
import com.aqiang.hello.jpa.Conditions;
import com.aqiang.hello.jpa.Dao;

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
		return dao.list(Student.class);
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
		return dao.list(Student.class, Arrays.asList(Conditions.eq("name", name)));
	}

	@Override
	public List<Student> getStudentsByNameOrAge(String name, int age) {
		ComplexCondition or = Conditions.or();
		or.add(Conditions.eq("name", name));
		or.add(Conditions.eq("age", age));
		return dao.list(Student.class, Arrays.asList(or));
	}

	@Override
	public List<Student> getStudentsByNameAndAge(String name, int age) {
		return dao.list(Student.class, Arrays.asList(Conditions.eq("name", name), Conditions.eq("age", age)));
	}

	@Override
	public List<Student> getStudentsByNameAndAgeAndGender(String name, int age, String gender) {
		return dao.list(Student.class,
				Arrays.asList(Conditions.eq("name", name), Conditions.eq("age", age), Conditions.eq("gender", gender)));
	}

}
