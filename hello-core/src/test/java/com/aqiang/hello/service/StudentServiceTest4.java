package com.aqiang.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.aqiang.hello.CoreTest;
import com.aqiang.hello.entities.Student;

public class StudentServiceTest4 extends CoreTest {

	@Autowired
	private StudentService studentService;

	@Test
	public void testGetStudentsGTAndGTEQ() {
		studentService.saveStudent(createStudent("kyo", 25, "male"));
		studentService.saveStudent(createStudent("kyo", 24, null));
		studentService.saveStudent(createStudent("kyo", 25, "female"));
		studentService.saveStudent(createStudent("aqiang", 25, null));
		studentService.saveStudent(createStudent("moon", 24, null));
		assert studentService.getStudentsGenderIsNull().size() == 3;
		assert studentService.getStudentsGenderIsNotNull().size() == 2;
		assert studentService.getStudentsByGender("male").size() == 1;
		assert studentService.getStudentsByGender("female").size() == 1;
	}

	private Student createStudent(String name, int age, String gender) {
		Student student = new Student();
		student.setGender(gender);
		student.setName(name);
		student.setAge(age);
		return student;
	}

}
