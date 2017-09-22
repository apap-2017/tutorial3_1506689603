package com.example.tutorial3.model;

/**
 * 
 * Student model
 * @author Haryo Parigroho
 *
 */
public class StudentModel {
	private String name;
	private String npm;
	private double gpa;
	
	/**
	 * Constructor
	 * @param name
	 * @param npm
	 * @param gpa
	 */
	public StudentModel(String name, String npm, double gpa) {
		this.name = name;
		this.npm = npm;
		this.gpa = gpa;
	}
	
	/**
	 * Get student name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set student name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get student npm
	 * @return npm
	 */
	public String getNpm() {
		return npm;
	}
	
	/**
	 * Set student npm
	 * @param npm
	 */
	public void setNpm(String npm) {
		this.npm = npm;
	}
	
	/**
	 * Get student gpa
	 * @return gpa
	 */
	public double getGpa() {
		return gpa;
	}
	
	/**
	 * Set student gpa
	 * @param gpa
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}
