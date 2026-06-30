package com.example.basicCrudOps.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicCrudOps.model.Student;
import com.example.basicCrudOps.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StudentController {

	private final StudentService ser;

	@PostMapping
	public ResponseEntity<List<Student>> createStudent(@RequestBody Student req) {
		List<Student> data = ser.addStudent(req);
		return new ResponseEntity<List<Student>>(data, HttpStatus.OK);
		
	}

	@PutMapping
	public ResponseEntity<List<Student>> update(@RequestBody Student req) {
		List<Student> data = ser.updateStudent(req);
		return new ResponseEntity<List<Student>>(data, HttpStatus.OK);
	}

	@DeleteMapping("rno/{rno}")
	public ResponseEntity<List<Student>> deleteStudent(@PathVariable int rno) {
		List<Student> data = ser.deleteStudent(rno);
		return new ResponseEntity<List<Student>>(data, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> data = ser.getAllStudents();
		return new ResponseEntity<List<Student>>(data, HttpStatus.OK);
	}

	@GetMapping("rno/{rno}")
	public ResponseEntity<Student> getStudentById(@PathVariable int rno) {
		Student data = ser.getById(rno);
		return new ResponseEntity<Student>(data, HttpStatus.OK);
	}

}
