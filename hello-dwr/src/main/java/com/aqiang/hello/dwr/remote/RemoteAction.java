package com.aqiang.hello.dwr.remote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.aqiang.hello.entities.Student;

public class RemoteAction {
	public String getStudentName() {
		return "Kyolee";
	}

	public void sayHi() {
		System.out.println("HI");
	}

	public void greeting(String name) {
		System.out.println("Hello " + name);
	}

	public Student getStudent() {
		Student student = new Student();
		student.setName("kyo lee");
		student.setAge(25);
		student.setGender("man");
		System.out.println("success");
		return student;
	}

	public void setStudent(Student student) {
		System.out.println(student);
	}

	public List<Student> getStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(createStudent("kyo", 25, "male"));
		students.add(createStudent("yabou", 23, "male"));
		students.add(createStudent("moon", 24, "female"));
		return students;
	}

	private Student createStudent(String name, Integer age, String gender) {
		Student student = new Student();
		student.setName(name);
		student.setAge(age);
		student.setGender(gender);
		return student;
	}

	public void toOtherPage() throws ServletException, IOException {
		WebContext webContext = WebContextFactory.get();
		HttpServletRequest httpServletRequest = webContext.getHttpServletRequest();
		HttpServletResponse httpServletResponse = webContext.getHttpServletResponse();
		httpServletRequest.getRequestDispatcher("WEB-INF/other.jsp").forward(httpServletRequest, httpServletResponse);
	}

	public void sendDoubleParam(String param, int param2) {
		System.out.println(param + " " + param2);
	}

}
