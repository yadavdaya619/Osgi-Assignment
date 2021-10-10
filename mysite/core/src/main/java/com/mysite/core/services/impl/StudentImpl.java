package com.mysite.core.services.impl;

import com.mysite.core.services.Student;
import com.mysite.core.services.StudentConfig;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;
@Component(service = StudentConfig.class)
public class StudentImpl implements StudentConfig {

    public static List<Student> listOfStudents = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        listOfStudents.add(student);
    }

    @Override
    public void deleteStudent(Student student) {
        listOfStudents.remove(student);
    }

    @Override
    public boolean isStudentPassed(Student student) {
        if(student.getMarks_obtained() >= ClassSizeAndMarksImpl.marks)
            return true;
        return false;
    }

    @Override
    public Student getStudent(Student student) {
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        return listOfStudents;
    }
}