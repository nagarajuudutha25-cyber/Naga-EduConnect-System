package com.edutech.progressive.entity;

<<<<<<< HEAD
import javax.persistence.CascadeType;
=======
>>>>>>> 25b675a4964ddca4babd1fa0f41bd8b374326e9b
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Course {

    @Id
=======

@Entity
public class Course {
     @Id
>>>>>>> 25b675a4964ddca4babd1fa0f41bd8b374326e9b
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseName;
    private String description;
<<<<<<< HEAD
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    // private int teacherId;
=======
    private int teacherId;
    
    public Course() {
    }

>>>>>>> 25b675a4964ddca4babd1fa0f41bd8b374326e9b
    public Course(int courseId, String courseName, String description, int teacherId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
<<<<<<< HEAD
        // this.teacherId = teacherId;
        this.teacher.setTeacherId(teacherId);
    }
    public Course() {
    }
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    // public int getTeacherId() {
    // return teacherId;
    // }
    // public void setTeacherId(int teacherId) {
    // this.teacherId = teacherId;
    // }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;

    }

=======
        this.teacherId = teacherId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    

>>>>>>> 25b675a4964ddca4babd1fa0f41bd8b374326e9b
}