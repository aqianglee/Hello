package com.aqiang.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.aqiang.hello.CoreTest;
import com.aqiang.hello.entities.Student;

public class StudentServiceTest6 extends CoreTest {

	@Autowired
	private StudentService studentService;

	@Test
	public void testGetStudentsOrderByName() {
		studentService.saveStudent(createStudent("kyo", 25, "male"));
		studentService.saveStudent(createStudent("aqiang", 25, null));
		studentService.saveStudent(createStudent("yole", 27, "female"));
		studentService.saveStudent(createStudent("monday", 24, null));
		studentService.saveStudent(createStudent("kyo", 24, null));
		List<Student> students = studentService.getstudentsNameLike("%o%");
		assert students.size() == 4;
	}

	private Student createStudent(String name, int age, String gender) {
		Student student = new Student();
		student.setGender(gender);
		student.setName(name);
		student.setAge(age);
		return student;
	}

}
