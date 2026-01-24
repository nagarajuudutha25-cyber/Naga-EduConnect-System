package com.edutech.progressive.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edutech.progressive.dto.TeacherDTO;
import com.edutech.progressive.entity.Teacher;
import com.edutech.progressive.exception.TeacherAlreadyExistsException;
import com.edutech.progressive.repository.CourseRepository;
import com.edutech.progressive.repository.EnrollmentRepository;
import com.edutech.progressive.repository.TeacherRepository;
import com.edutech.progressive.repository.UserRepository;
import com.edutech.progressive.service.TeacherService;

@Service
public class TeacherServiceImplJpa implements TeacherService {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImplJpa(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() throws Exception {
        return teacherRepository.findAll();
    }

    @Override
    public Integer addTeacher(Teacher teacher) throws Exception {
        Teacher existingTeacher = teacherRepository.findByEmail(teacher.getEmail());
        if (existingTeacher != null) {
            throw new TeacherAlreadyExistsException("Teacher with this email already exists, Email: " + teacher.getEmail());
        }
        return teacherRepository.save(teacher).getTeacherId();
    }

    @Override
    public List<Teacher> getTeacherSortedByExperience() throws Exception {
        List<Teacher> sortedTeachers = teacherRepository.findAll();
        Collections.sort(sortedTeachers);
        return sortedTeachers;
    }

    @Override
    public void updateTeacher(Teacher teacher) throws Exception {
        Teacher existingTeacher = teacherRepository.findByEmail(teacher.getEmail());
        if (existingTeacher != null) {
            throw new TeacherAlreadyExistsException("Teacher with this email already exists, Email: " + teacher.getEmail());
        }
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(int teacherId) throws Exception {
        teacherRepository.deleteById(teacherId);
    }

    @Override
    public Teacher getTeacherById(int teacherId) throws Exception {
        return teacherRepository.findByTeacherId(teacherId);
    }

    public void modifyTeacherDetails(TeacherDTO teacherDTO) {

    }

}

