package com.n1224C1.service;

import com.n1224C1.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getStudents(String name);

    Student findById(int id);

    Student addStudent(Student student);

    Student updateStudent(Student student);

    Student deleteStudent(int id);
}
