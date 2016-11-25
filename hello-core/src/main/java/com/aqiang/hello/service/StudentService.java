package com.aqiang.hello.service;

import java.util.List;

import com.aqiang.hello.entities.Student;

public interface StudentService {
	public void saveStudent(Student student);

	public void deleteStudent(Student student);

	public Student updateStudent(Student student);

	public List<Student> getStudents();

	public List<Student> getStudentsByName(String name);

	public List<Student> getStudentsByNameOrAge(String name, int age);

	public List<Student> getStudentsByNameAndAge(String name, int age);

	public List<Student> getStudentsByNameAndAgeAndGender(String name, int age, String gender);
}
