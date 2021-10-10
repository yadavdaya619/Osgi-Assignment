package com.mysite.core.services;

import java.util.List;

public interface StudentConfig {
    void addStudent(Student student);
    void deleteStudent(Student student);
    boolean isStudentPassed(Student student);
    Student getStudent(Student student);
    List<Student> getAllStudents();
}
