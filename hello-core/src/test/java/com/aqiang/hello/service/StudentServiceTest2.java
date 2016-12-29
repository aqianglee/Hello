package com.aqiang.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.aqiang.hello.CoreTest;
import com.aqiang.hello.entities.Student;

public class StudentServiceTest2 extends CoreTest {

	@Autowired
	private StudentService studentService;

	@Test
	public void testGetStudentsByName() {
		studentService.saveStudent(createStudent("kyo", 25, "male"));
		studentService.saveStudent(createStudent("kyo", 24, "male"));
		studentService.saveStudent(createStudent("aqiang", 25, "male"));
		studentService.saveStudent(createStudent("moon", 24, "male"));
		List<Student> list = studentService.getStudentsByName("kyo");
		assert list.size() == 2;
	}

	@Test
	public void testGetStudentsByNameAndAgeAndGender() {
		studentService.saveStudent(createStudent("kyo", 25, "male"));
		studentService.saveStudent(createStudent("kyo", 24, "male"));
		studentService.saveStudent(createStudent("kyo", 25, "female"));
		studentService.saveStudent(createStudent("aqiang", 25, "male"));
		studentService.saveStudent(createStudent("moon", 24, "male"));
		List<Student> list = studentService.getStudentsByNameAndAgeAndGender("kyo", 25, "male");
		assert list.size() == 1;
	}

	@Test
	public void testGetStudentsByNameAndAge() {
		studentService.saveStudent(createStudent("kyo", 25, "male"));
		studentService.saveStudent(createStudent("kyo", 24, "male"));
		studentService.saveStudent(createStudent("kyo", 25, "female"));
		studentService.saveStudent(createStudent("aqiang", 25, "male"));
		studentService.saveStudent(createStudent("moon", 24, "male"));
		List<Student> list = studentService.getStudentsByNameAndAge("kyo", 25);
		assert list.size() == 2;
	}

	@Test
	public void testGetStudentsByNameOrAge() {
		studentService.saveStudent(createStudent("kyo", 25, "male"));
		studentService.saveStudent(createStudent("kyo", 24, "male"));
		studentService.saveStudent(createStudent("kyo", 25, "female"));
		studentService.saveStudent(createStudent("aqiang", 25, "male"));
		studentService.saveStudent(createStudent("moon", 24, "male"));
		List<Student> list = studentService.getStudentsByNameOrAge("kyo", 25);
		assert list.size() == 4;
	}

	@Test
	public void testGetStudentsByNameAndAgeOrGenderIsNull() {
		studentService.saveStudent(createStudent("kyo", 25, "male"));
		studentService.saveStudent(createStudent("kyo", 24, "male"));
		studentService.saveStudent(createStudent("kyo", 23, "female"));
		studentService.saveStudent(createStudent("aqiang", 25, null));
		studentService.saveStudent(createStudent("moon", 24, null));
		List<Student> list = studentService.getStudentsByNameAndAgeOrGenderIsNull("kyo", 25);
		assert list.size() == 3;
	}

	@Test
	public void testGetStudentsByNameOrAgeAndGenderIsNull() {
		studentService.saveStudent(createStudent("kyo", 25, null));
		studentService.saveStudent(createStudent("kyo", 24, "male"));
		studentService.saveStudent(createStudent("kyo", 23, "female"));
		studentService.saveStudent(createStudent("aqiang", 25, null));
		studentService.saveStudent(createStudent("moon", 24, null));
		List<Student> list = studentService.getStudentsByNameOrAgeAndGenderIsNull("kyo", 25);
		assert list.size() == 2;
	}

	private Student createStudent(String name, int age, String gender) {
		Student student = new Student();
		student.setGender(gender);
		student.setName(name);
		student.setAge(age);
		return student;
	}

}
