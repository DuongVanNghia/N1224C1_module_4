package com.n1224C1.techzen.service;

import com.n1224C1.techzen.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findByName(String name,Double fromScore, Double toScore);

    Student findById(int id);

    Student save(Student student);
}
