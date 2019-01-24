package com.techlab.college.test;

import java.util.*;

import com.techlab.person.Student;
import com.techlab.college.BranchOptions;
import com.techlab.college.College;
import com.techlab.person.Professor;

public class TestCollege {

	public static void main(String[] args) throws Exception {

		College college1 = new College("Atharva");
		Student student1 = new Student(1, "Goregaon", "13/4/1997", "Kuntan", college1, BranchOptions.SCIENCE);
		Student student2 = new Student(2, "Kandivali", "29/5/1997", "Prasad", college1, BranchOptions.SCIENCE);
		college1.addStudent(student1);
		college1.addStudent(student2);

		Professor professor1 = new Professor(1, "Goregaon", "17/4/1950", college1, "Kalekar");
		Professor professor2 = new Professor(2, "Goregaon", "13/11/1950", college1, "Dubey");
		college1.addProfessor(professor1);
		college1.addProfessor(professor2);
		printDetails(college1);
		ReportBuilder.printReport(college1);
	}

	private static void printDetails(College college1) {
		System.out.println(
				"College Name : " + college1.getName() + "\nIt has " + college1.getStudentCount() + " students");
		System.out.println("Their details are as follows : ");
		List<Student> studentList = college1.getStudentList();
		printStudentDetails(studentList);
		System.out.println("It has " + college1.getProfessorCount() + " professors");
		System.out.println("Theirs details are as follows : ");
		List<Professor> professorList = college1.getProfessorList();
		printProfessorDetails(professorList);
	}

	private static void printProfessorDetails(List<Professor> professorList) {
		for (Professor professor : professorList) {
			professor.calcSalary();
			System.out.println("ID : " + professor.getId() + "\t Name : " + professor.getName() + "\t Address : "
					+ professor.getAddress() + "\t DOB : " + professor.getDOB()+"\t Salary : " + professor.getSalary());
		}
	}

	private static void printStudentDetails(List<Student> studentList) {
		for (Student student : studentList) {
			System.out.println("ID : " + student.getId() + "\t Name : " + student.getName() + "\t Address : "
					+ student.getAddress() + "\t DOB : " + student.getDOB());
		}
	}

}
