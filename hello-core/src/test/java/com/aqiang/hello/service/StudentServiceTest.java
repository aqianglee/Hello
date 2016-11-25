package com.aqiang.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.aqiang.hello.CoreTest;
import com.aqiang.hello.entities.Student;

public class StudentServiceTest extends CoreTest {

	@Autowired
	private StudentService studentService;

	@Test
	public void testSaveStudent() {
		studentService.saveStudent(createStudent("kyo", 25, "male"));
		List<Student> students = studentService.getStudents();
		assert students.size() == 1;
		Student student = students.get(0);
		assert student.getName().equals("kyo");
		assert student.getAge().equals(25);
		assert student.getGender().equals("male");
	}

	@Test
	public void testMergeStudent() {
		studentService.saveStudent(createStudent("kyo", 25, "male"));
		List<Student> students = studentService.getStudents();
		assert students.size() == 1;
		Student student = students.get(0);
		assert student.getName().equals("kyo");
		assert student.getAge().equals(25);
		assert student.getGender().equals("male");
		student.setAge(23);
		studentService.updateStudent(student);
		List<Student> students2 = studentService.getStudents();
		assert students2.size() == 1;
		Student student2 = students2.get(0);
		assert student2.getName().equals("kyo");
		assert student2.getAge().equals(23);
		assert student2.getGender().equals("male");
	}

	@Test
	public void testDeleteStudent() {
		studentService.saveStudent(createStudent("kyo", 25, "male"));
		List<Student> students = studentService.getStudents();
		assert students.size() == 1;
		assert students.get(0).getName().equals("kyo");
		studentService.deleteStudent(students.get(0));
		assert studentService.getStudents().isEmpty();
	}

	private Student createStudent(String name, int age, String gender) {
		Student student = new Student();
		student.setGender(gender);
		student.setName(name);
		student.setAge(age);
		return student;
	}

}
