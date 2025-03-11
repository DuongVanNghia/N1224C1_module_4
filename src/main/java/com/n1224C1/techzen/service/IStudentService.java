package com.n1224C1.techzen.service;

import com.n1224C1.techzen.model.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IStudentService {
    Page<Student> findByName(String name, Double fromScore, Double toScore, Pageable pageable);

    Student findById(int id);

    Student save(Student student);
}
