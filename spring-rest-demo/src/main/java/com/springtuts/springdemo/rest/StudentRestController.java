package com.springtuts.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springtuts.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> listOfStudents;
	
	// define @PostConstruct to load the student data ... only once!
	@PostConstruct
	public void loadData() {
		listOfStudents = new ArrayList<>();
		
		listOfStudents.add(new Student("Akash", "Thakur"));
		listOfStudents.add(new Student("Jenny", "Dsouza"));
		listOfStudents.add(new Student("Gaurav", "Jha"));
	}
	
	// define endpoint for "/students" - return a list of students
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return listOfStudents;
	}
	
	// define endpoint for "/students/{studentId} - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){
		
		// check the studentId against the list size
		if(studentId >= listOfStudents.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - "+studentId);
		}
		
		return listOfStudents.get(studentId);
	}

	
}
