package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Student;
import com.edutech.progressive.service.impl.StudentServiceImplArraylist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
 
    private StudentServiceImplArraylist serviceImplArraylist = new StudentServiceImplArraylist();
    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudents() {
        return null;
    }
 
    @GetMapping("/student/{studentId}")
    public ResponseEntity<Student> getStudentById(int studentId) {
        return null;
    }
 
    @PostMapping("/student")
    public ResponseEntity<Integer> addStudent(Student student) {
        return null;
    }
 
    @PutMapping("/student/{studentId}")
    public ResponseEntity<Void> updateStudent(int studentId, Student student) {
        return null;
    }
 
    @DeleteMapping("/student/{studentId}")
    public ResponseEntity<Void> deleteStudent(int studentId) {
        return null;
    }
 
 
    @GetMapping("/student/fromArrayList")
    public ResponseEntity<List<Student>> getAllStudentFromArrayList() {
        return new ResponseEntity(serviceImplArraylist.getAllStudents(),HttpStatus.OK);
    }
 
    
    @PostMapping("/student/toArrayList")
    public ResponseEntity<Integer> addStudentToArrayList(Student student) {
        return new ResponseEntity(serviceImplArraylist.addStudent(student),HttpStatus.CREATED);
    }
 
    @GetMapping("student/fromArrayList/sorted")
    public ResponseEntity<List<Student>> getAllStudentSortedByNameFromArrayList() {
        return new ResponseEntity<>(serviceImplArraylist.getAllStudentSortedByName(),HttpStatus.OK);
    }
}