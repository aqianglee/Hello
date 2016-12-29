package com.aqiang.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.aqiang.hello.CoreTest;
import com.aqiang.hello.entities.Student;

public class StudentServiceTest5 extends CoreTest {

	@Autowired
	private StudentService studentService;

	@Test
	public void testGetStudentsOrderByName() {
		studentService.saveStudent(createStudent("kyo", 25, "male"));
		studentService.saveStudent(createStudent("aqiang", 25, null));
		studentService.saveStudent(createStudent("kyo", 25, "female"));
		studentService.saveStudent(createStudent("moon", 24, null));
		studentService.saveStudent(createStudent("kyo", 24, null));
		List<Student> students = studentService.getstudentsOrderByName();
		assert students.get(0).getName().equals("aqiang");
		assert students.get(1).getName().equals("kyo");
		assert students.get(2).getName().equals("kyo");
		assert students.get(3).getName().equals("kyo");
		assert students.get(4).getName().equals("moon");
	}

	@Test
	public void testGetStudentsOrderByNameDesc() {
		studentService.saveStudent(createStudent("kyo", 25, "male"));
		studentService.saveStudent(createStudent("aqiang", 25, null));
		studentService.saveStudent(createStudent("kyo", 25, "female"));
		studentService.saveStudent(createStudent("moon", 24, null));
		studentService.saveStudent(createStudent("kyo", 24, null));
		List<Student> students = studentService.getstudentsOrderByNameDesc();
		assert students.get(0).getName().equals("moon");
		assert students.get(1).getName().equals("kyo");
		assert students.get(2).getName().equals("kyo");
		assert students.get(3).getName().equals("kyo");
		assert students.get(4).getName().equals("aqiang");
	}

	@Test
	public void testGetStudentsOrderByNameAndAgeDesc() {
		studentService.saveStudent(createStudent("kyo", 25, "male"));
		studentService.saveStudent(createStudent("aqiang", 25, null));
		studentService.saveStudent(createStudent("kyo", 23, "female"));
		studentService.saveStudent(createStudent("moon", 24, null));
		studentService.saveStudent(createStudent("kyo", 24, null));
		List<Student> students = studentService.getstudentsOrderByNameAndAgeDesc();
		assert students.get(0).getName().equals("aqiang");
		assert students.get(1).getName().equals("kyo");
		assert students.get(2).getName().equals("kyo");
		assert students.get(3).getName().equals("kyo");
		assert students.get(4).getName().equals("moon");

		assert students.get(0).getAge() == 25;
		assert students.get(1).getAge() == 25;
		assert students.get(2).getAge() == 24;
		assert students.get(3).getAge() == 23;
		assert students.get(4).getAge() == 24;
	}

	private Student createStudent(String name, int age, String gender) {
		Student student = new Student();
		student.setGender(gender);
		student.setName(name);
		student.setAge(age);
		return student;
	}

}
