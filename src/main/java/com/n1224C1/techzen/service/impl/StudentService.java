package com.n1224C1.techzen.service.impl;

import com.n1224C1.techzen.model.Student;
import com.n1224C1.techzen.repository.IStudentRepository;
import com.n1224C1.techzen.service.IStudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService implements IStudentService {
    IStudentRepository studentRepository ;

    public List<Student> findByName(String name,Double fromScore, Double toScore) {
        return studentRepository.findByAttribute(name,fromScore,toScore);
    }

    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }
}