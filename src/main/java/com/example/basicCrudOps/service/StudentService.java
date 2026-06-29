package com.example.basicCrudOps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.basicCrudOps.model.Student;

@Service
public class StudentService {
	
	List<Student> list = new ArrayList<>();

	public List<Student> addStudent(Student st) {
		list.add(st);
		return list;
	}

	public List<Student> getAllStudents() {
		return list;
	}

	public Student getById(int rno) {
		for (Student s : list) {
			if (s.getRno() == rno) {
				return s;
			}
		}
		return null;
	}

	public List<Student> updateStudent(Student st) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getRno() == st.getRno()) {
				list.set(i, st);
				break;
			}
		}
		return list;
	}

	public List<Student> deleteStudent(int rno) {
		list.removeIf(student -> student.getRno() == rno);
		return list;
	}


}
