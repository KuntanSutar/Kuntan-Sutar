package com.techlab.college.test;

import java.io.*;
import java.util.List;

import com.techlab.college.College;
import com.techlab.person.Professor;
import com.techlab.person.Student;

public class ReportBuilder {
	
	public static void printReport(College college) throws Exception {
		FileWriter fw = new FileWriter("D:\\KUNTAN\\SwabhavRepository\\OOP"+" "+"Workspace\\college-app\\data\\CollegeReport.html");
		fw.write("<h1>College Name : "+college.getName()+"</h1>");
		fw.write("<p> It has "+college.getStudentCount()+" students</p>");
		fw.write("<h2>Their details are as follows : </h2>");
		List<Student> studentList = college.getStudentList();
		for(Student student:studentList) {
			fw.write("<p>ID : "+student.getId()+"\t Name : "+student.getName()+"\t Address : "+student.getAddress() + "\t DOB : " + student.getDOB()+"</p>");
		}
		fw.write("<p> It has "+college.getProfessorCount()+" professors</p>");
		List<Professor> professorList = college.getProfessorList();
		fw.write("<h2>Their details are as follows : </h2>");
		for(Professor professor:professorList) {
			professor.calcSalary();
			fw.write("<p>ID : "+professor.getId()+"\t Name : "+professor.getName()+"\t Address : "+professor.getAddress() + "\t DOB : " + professor.getDOB()+ "\t Salary : " + professor.getSalary()+"</p>");
		}
		fw.close();
	}
}
