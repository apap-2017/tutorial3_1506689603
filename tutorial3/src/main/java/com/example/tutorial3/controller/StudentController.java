package com.example.tutorial3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tutorial3.service.InMemoryStudentService;
import com.example.tutorial3.service.StudentService;
import com.example.tutorial3.model.StudentModel;

/**
 * 
 * Controller for student model
 * @author Haryo Parigroho
 *
 */
@Controller
public class StudentController {
	private final StudentService studentService;
	
	public StudentController() {
		studentService = new InMemoryStudentService();
	}
	
	/**
	 * Handle routing for /student/add
	 * @param name
	 * @param npm
	 * @param gpa
	 * @return add.html
	 */
	@RequestMapping("/student/add")
	public String add(@RequestParam(value="name", required=true)String name, 
			@RequestParam(value="npm", required=true)String npm,
			@RequestParam(value="gpa", required=true)double gpa) {
		StudentModel student = new StudentModel(name, npm, gpa);
		studentService.addStudent(student);
		return "add";
	}
	
	/*@RequestMapping("/student/view")
	public String view(Model model, @RequestParam(value="npm")String npm) {
		StudentModel student = studentService.selectStudent(npm);
		model.addAttribute("student", student);
		return "view";
	}*/
	
	/**
	 * Handle routing for /student/viewall
	 * @param model
	 * @return viewall.html
	 */
	@RequestMapping("/student/viewall")
	public String viewAll(Model model) {
		List<StudentModel> students = studentService.selectAllStudent();
		model.addAttribute("students", students);
		return "viewall";
	}
	
	/**
	 * Handle routing for /student/view/ or /student/view/{npm}
	 * @param npm
	 * @param model
	 * @return view.html
	 */
	@RequestMapping(value = {"/student/view/", "/student/view/{npm}"})
	public String viewStudent(@PathVariable Optional<String> npm, Model model) {
		if(npm.isPresent()) {
			StudentModel student = studentService.selectStudent(npm.get());
			if(student == null) {
				model.addAttribute("status", "notfound");
			} else {
				model.addAttribute("student", student);
				model.addAttribute("status", "ok");
			}
		} else {
			model.addAttribute("status", "notfound");
		}
		return "view";
	}
	
	/**
	 * Handle routing for /student/delete or /student/delete/{npm}
	 * @param npm
	 * @param model
	 * @return delete.html
	 */
	@RequestMapping(value = {"/student/delete/", "/student/delete/{npm}"})
	public String deleteStudent(@PathVariable Optional<String> npm, Model model) {
		if(npm.isPresent()) {
			StudentModel student = studentService.deleteStudent(npm.get());
			if (student == null) {
				model.addAttribute("status", "ok");
			} else {
				model.addAttribute("student", student);
				model.addAttribute("status", "ok");
			}
		} else {
			model.addAttribute("status", "notfound");
		}
		return "delete";
	}
}
