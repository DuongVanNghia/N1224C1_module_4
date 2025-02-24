package com.n1224C1.repository;

import com.n1224C1.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> getStudents(String name);

    Student findById(int id);

    Student addStudent(Student student);

    Student updateStudent(Student student);

    Student deleteStudent(int id);

    List<Student> findbyName(String name);
}
