package com.n1224C1.techzen.service.impl;

import com.n1224C1.techzen.model.Student;
import com.n1224C1.techzen.repository.IStudentRepository;
import com.n1224C1.techzen.service.IStudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService implements IStudentService {
    IStudentRepository studentRepository ;

    public Page<Student> findByName(String name, Double fromScore, Double toScore, Pageable pageable) {
        return studentRepository.findByAttribute(name,fromScore,toScore,pageable);
    }

    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }
}