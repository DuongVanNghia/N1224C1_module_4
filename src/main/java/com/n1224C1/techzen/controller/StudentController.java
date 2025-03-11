package com.n1224C1.techzen.controller;

import com.n1224C1.techzen.dto.ApiResponse;
import com.n1224C1.techzen.dto.clazz.ClazzResponse;
import com.n1224C1.techzen.dto.page.PageResponse;
import com.n1224C1.techzen.dto.student.StudentRequest;
import com.n1224C1.techzen.dto.student.StudentResponse;
import com.n1224C1.techzen.exception.ApiException;
import com.n1224C1.techzen.exception.ErrorCode;
import com.n1224C1.techzen.mapper.IStudentMapper;
import com.n1224C1.techzen.model.Clazz;
import com.n1224C1.techzen.model.Student;
import com.n1224C1.techzen.service.IStudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//@Repository
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor//
@Scope("singleton")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {
    IStudentService studentService ;
    IStudentMapper studentMapper;
    @GetMapping
    public ResponseEntity<?> getStudents(@RequestParam(defaultValue = "") String name,
                                         Double fromScore,
                                         Double toScore,
                                         Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.builder()
                .data(new PageResponse<>(
                        studentService.findByName(name, fromScore, toScore, pageable)
                                .map(studentMapper::studentToStudentResponse)
                        )

                )
                .build());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> getStudent(@PathVariable("id") int id) {
        Student student = studentService.findById(id);
        if (student == null){
        throw new ApiException(ErrorCode.STUDENT_NOT_EXITS);
    }
    StudentResponse studentResponse = studentMapper.studentToStudentResponse(student);

        return ResponseEntity.ok(ApiResponse.<StudentResponse>builder()
                .data(studentMapper.studentToStudentResponse(student))
                .build());
    }

    @PostMapping
    //b1:nhan vao request
    public ResponseEntity<ApiResponse<StudentResponse>> createStudent(@RequestBody StudentRequest studentRequest) {
        //b2:chyển tu request -> entity
        Student student = studentMapper.studentRequestToStudent(studentRequest);
        //b3:lưu entity
        student =studentService.save(student);
        //b4: chuyen tu entity -> response
        StudentResponse studentResponse = studentMapper.studentToStudentResponse(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.<StudentResponse>builder()
                .data(studentMapper.studentToStudentResponse(student))
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> update(@PathVariable("id") int id, @RequestBody Student student) {
        if (studentService.findById(id) == null) {
            throw new ApiException(ErrorCode.STUDENT_NOT_EXITS);
        }
        student.setId(id);
        return ResponseEntity.ok(ApiResponse.<Student>builder()
                .data(studentService.save(student))
                .build());
    }
}