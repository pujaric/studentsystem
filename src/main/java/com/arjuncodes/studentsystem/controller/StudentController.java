package com.arjuncodes.studentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arjuncodes.studentsystem.model.Student;
import com.arjuncodes.studentsystem.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
	@Autowired
	private StudentService studentService;

	@Value("${server.tomcat.relaxed-query-chars}")
	private String relaxedQueries;

	@PostMapping("/add")
	public String add(@RequestBody Student student) {
		studentService.saveStudent(student);
		return "New student is added";
	}

	@GetMapping("/getAll/{id}")
	public List<Student> list(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "address", required = false) String address, @PathVariable(value = "id") String id) {

		System.out.println(relaxedQueries);

		System.out.println(name);
		System.out.println(address);
		System.out.println(id);
		
		return studentService.getAllStudents();

	}
}
