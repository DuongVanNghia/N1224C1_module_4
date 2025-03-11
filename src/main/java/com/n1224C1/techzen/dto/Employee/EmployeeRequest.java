package com.n1224C1.techzen.dto.Employee;


import com.n1224C1.techzen.enums.Gender;
import com.n1224C1.techzen.model.Department;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;


@Setter
@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeRequest {
    UUID id;
    String name;
    LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    Gender gender;
    double salary;
    String phone;
    Integer departmentId;

}