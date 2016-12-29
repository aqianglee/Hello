package com.aqiang.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.aqiang.hello.CoreTest;
import com.aqiang.hello.entities.Student;

public class StudentServiceTest3 extends CoreTest {

	@Autowired
	private StudentService studentService;

	@Test
	public void testGetStudentsGTAndGTEQ() {
		studentService.saveStudent(createStudent("kyo", 25, "male"));
		studentService.saveStudent(createStudent("kyo", 24, "male"));
		studentService.saveStudent(createStudent("kyo", 25, "female"));
		studentService.saveStudent(createStudent("aqiang", 25, "male"));
		studentService.saveStudent(createStudent("moon", 24, "male"));
		assert studentService.getStudentsAgeGT(24).size() == 3;
		assert studentService.getStudentsAgeGTEQ(24).size() == 5;
		assert studentService.getStudentsAgeLT(25).size() == 2;
		assert studentService.getStudentsAgeLTEQ(25).size() == 5;
		assert studentService.getStudentsByAge(25).size() == 3;
		assert studentService.getStudentsByAge(24).size() == 2;
	}

	private Student createStudent(String name, int age, String gender) {
		Student student = new Student();
		student.setGender(gender);
		student.setName(name);
		student.setAge(age);
		return student;
	}

}
