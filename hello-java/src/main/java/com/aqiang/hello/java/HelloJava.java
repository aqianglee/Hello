package com.aqiang.hello.java;

import com.aqiang.hello.entities.Student;

public class HelloJava {
	public static void main(String[] args) {
		Student student = new Student();
		student.setName("kyolee");
		student.setAge(25);
		student.setGender("male");
		System.out.println(student);
	}
}
