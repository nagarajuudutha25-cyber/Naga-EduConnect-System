package com.edutech.progressive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edutech.progressive.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>{

    Course findByCourseId(int clinicId);

    Course findByCourseName(String courseName);

    @Query("Select c FROM Course c WHERE c.teacher.teacherId = :teacherId")
    List<Course> findAllByTeacherId(int teacherId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Course c WHERE c.teacher.teacherId = :teacherId")
    void deleteByTeacherId(int teacherId);
    
}

