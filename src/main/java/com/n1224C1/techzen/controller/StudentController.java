package com.n1224C1.techzen.controller;

import com.n1224C1.techzen.dto.ApiResponse;
import com.n1224C1.techzen.exception.ApiException;
import com.n1224C1.techzen.exception.ErrorCode;
import com.n1224C1.techzen.model.Student;
import com.n1224C1.techzen.service.IStudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
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

    @GetMapping
    public ResponseEntity<?> getStudents(@RequestParam(defaultValue = "") String name,
                                         Double fromScore,
                                         Double toScore) {
        return ResponseEntity.ok(ApiResponse.builder()
                .data(studentService.findByName(name, fromScore, toScore))

                .build());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable("id") int id) {
        Student student = studentService.findById(id);
        if (student == null) {
            throw new ApiException(ErrorCode.STUDENT_NOT_EXITS);
        }
        return ResponseEntity.ok(ApiResponse.<Student>builder()
                .data(student)
                .build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.<Student>builder()
                .data(studentService.save(student))
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