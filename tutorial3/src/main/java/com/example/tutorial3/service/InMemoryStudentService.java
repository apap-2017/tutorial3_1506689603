package com.example.tutorial3.service;

import java.util.ArrayList;
import java.util.List;

import com.example.tutorial3.model.StudentModel;

/**
 * 
 * Student service class
 * @author Haryo Parigroho
 *
 */
public class InMemoryStudentService implements StudentService {
	private static List<StudentModel> studentList = new ArrayList<StudentModel>();

	/**
	 * Select student from List
	 * @param npm student npm
	 * @return StudentModel
	 */
	@Override
	public StudentModel selectStudent(String npm) {
		// TODO Auto-generated method stub
		for(StudentModel student : studentList) {
			if(student.getNpm().equals(npm)) {
				return student;
			}
		}
		return null;
	}	

	/**
	 * Select all student from list
	 * @return List of Student
	 */
	@Override
	public List<StudentModel> selectAllStudent() {
		return studentList; 
	}

	/**
	 * Add student to the list
	 * @param StudentModel student
	 * @return void
	 */
	@Override
	public void addStudent(StudentModel student) {
		// TODO Auto-generated method stub
		studentList.add(student);
	}
	
	/**
	 * Delete student
	 * @param npm student npm
	 * @return StudentModel
	 */
	@Override
	public StudentModel deleteStudent(String npm) {
		StudentModel student = selectStudent(npm);
		studentList.remove(student);
		return student;
	}
}
