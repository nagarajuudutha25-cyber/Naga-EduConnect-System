package com.edutech.progressive.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edutech.progressive.dto.StudentDTO;
import com.edutech.progressive.entity.Student;
import com.edutech.progressive.exception.StudentAlreadyExistsException;
import com.edutech.progressive.repository.AttendanceRepository;
import com.edutech.progressive.repository.EnrollmentRepository;
import com.edutech.progressive.repository.StudentRepository;
import com.edutech.progressive.repository.UserRepository;
import com.edutech.progressive.service.StudentService;

@Service
public class StudentServiceImplJpa implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImplJpa(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() throws Exception {
        return studentRepository.findAll();
    }

    @Override
    public Integer addStudent(Student student) throws Exception {
        Student existingStudent = studentRepository.findByEmail(student.getEmail());
        if (existingStudent != null) {
            throw new StudentAlreadyExistsException("Student with this email already exists, Email: " + student.getEmail());
        }
        return studentRepository.save(student).getStudentId();
    }

    @Override
    public List<Student> getAllStudentSortedByName() throws Exception {
        List<Student> studentList = studentRepository.findAll();
        Collections.sort(studentList);
        return studentList;
    }

    @Override
    public void updateStudent(Student student) throws Exception {
        Student existingStudent = studentRepository.findByEmail(student.getEmail());
        if (existingStudent != null && existingStudent.getStudentId() != student.getStudentId()) {
            throw new StudentAlreadyExistsException("Student with this email already exists, Email: " + student.getEmail());
        }
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int studentId) throws Exception {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student getStudentById(int studentId) throws Exception {
        return studentRepository.findByStudentId(studentId);
    }

    public void modifyStudentDetails(StudentDTO studentDTO) throws Exception{

    }

}
