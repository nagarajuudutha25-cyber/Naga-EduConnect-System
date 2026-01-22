package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.dao.StudentDAO;
import com.edutech.progressive.entity.Student;
import com.edutech.progressive.service.StudentService;

public class StudentServiceImplJdbc  implements StudentService{
      private StudentDAO studentDAO;
      
    public StudentServiceImplJdbc(StudentDAO studentDAO) {
         this.studentDAO = studentDAO;
      }

    @Override
    public List<Student> getAllStudents() throws Exception {
        try {
         return studentDAO.getAllStudents();
        } catch (SQLException e) {
         // TODO Auto-generated catch block
         throw new Exception("",e);
        }
    }

    @Override
    public Integer addStudent(Student student) throws Exception {
       try {
         return studentDAO.addStudent(student);
       } catch (SQLException e) {
         // TODO Auto-generated catch block
         throw new Exception("",e);
       }
    }

    @Override
    public List<Student> getAllStudentSortedByName() throws Exception {
       try {
         
       List<Student> studentList = studentDAO.getAllStudents();
         Collections.sort(studentList);
         return studentList;
       } catch (SQLException e) {
         // TODO Auto-generated catch block
          throw new Exception("",e);
       }

    }

 
    public void updateStudent(Student student) throws Exception{
      try {
         studentDAO.updateStudent(student);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         throw new Exception("",e);
      }
    }

    public void deleteStudent(int studentId) throws Exception{
        try {
         studentDAO.deleteStudent(studentId);
        } catch (SQLException e) {
         // TODO Auto-generated catch block
       throw new Exception("",e);
        }
    }
 
    public Student getStudentById(int studentId) throws Exception{
        try {
         return studentDAO.getStudentById(studentId);
     
        } catch (SQLException e) {
         // TODO Auto-generated catch block
         throw new Exception("",e);
        }
    }
}