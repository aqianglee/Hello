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

	public List<Student> getStudentsAgeGT(int age);

	public List<Student> getStudentsAgeGTEQ(int age);

	public List<Student> getStudentsAgeLT(int age);

	public List<Student> getStudentsAgeLTEQ(int age);

	public List<Student> getStudentsByAge(int age);

	public List<Student> getStudentsGenderIsNull();

	public List<Student> getStudentsGenderIsNotNull();

	public List<Student> getStudentsByGender(String gender);

	public List<Student> getstudentsOrderByName();

	public List<Student> getstudentsOrderByNameDesc();

	public List<Student> getstudentsOrderByNameAndAgeDesc();

	public List<Student> getstudentsNameLike(String name);

	public List<Student> getStudentsByNameAndAgeOrGenderIsNull(String string, int age);

	public List<Student> getStudentsByNameOrAgeAndGenderIsNull(String string, int age);
}
