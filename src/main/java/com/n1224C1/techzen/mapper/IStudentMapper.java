package com.n1224C1.techzen.mapper;

import com.n1224C1.techzen.dto.student.StudentRequest;
import com.n1224C1.techzen.dto.student.StudentResponse;
import com.n1224C1.techzen.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IStudentMapper {
    Student studentRequestToStudent(StudentRequest studentRequest);
    StudentResponse studentToStudentResponse(Student student);
}
