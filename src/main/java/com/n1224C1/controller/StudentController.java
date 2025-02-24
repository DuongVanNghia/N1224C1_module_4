package com.n1224C1.controller;

import com.n1224C1.dto.ApiResponse;
import com.n1224C1.exception.ApiException;
import com.n1224C1.exception.Errorcode;
import com.n1224C1.model.Student;
import com.n1224C1.service.IStudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor//
@Scope("singleton")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {
    IStudentService studentServicey;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> findByName(@RequestParam(defaultValue = "") String name) {
        return ResponseEntity.ok(ApiResponse.<List<Student>>builder()
                .data(studentServicey.getStudents(name))
                .build());


    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getById(@PathVariable("id") int id) {
        Student student = studentServicey.findById(id);
        if (student == null) {
            throw new ApiException(Errorcode.STUDENT_NOT_EXITS);
        }
        return ResponseEntity.ok(ApiResponse.<Student>builder()
                .data(student)
                .build());
    }

    //THÊM MỚI
    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(ApiResponse.<Student>builder()
                .data(studentServicey.addStudent(student))
                .build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        student.setId(id);
        return ResponseEntity.ok(ApiResponse.<Student>builder()
                .data(studentServicey.updateStudent(student))
                .build());


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
        studentServicey.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}