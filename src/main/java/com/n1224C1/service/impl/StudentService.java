package com.n1224C1.service.impl;

import com.n1224C1.model.Student;
import com.n1224C1.repository.IStudentRepository;
import com.n1224C1.service.IStudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Scope("singleton")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService implements IStudentService {
    // @Autowired//tim bean
    IStudentRepository studentRepository;

    public List<Student> getStudents(String name) {
        return studentRepository.getStudents(name);
    }

    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    public Student addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    public Student deleteStudent(int id) {
        return studentRepository.deleteStudent(id);
    }
}