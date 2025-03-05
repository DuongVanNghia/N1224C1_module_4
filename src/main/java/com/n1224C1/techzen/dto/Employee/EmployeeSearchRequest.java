package com.n1224C1.techzen.dto.Employee;

import com.n1224C1.techzen.enums.Gender;
import com.n1224C1.techzen.model.Employee;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeSearchRequest {
    String name;
    LocalDate dobFrom;
    LocalDate dobTo;
    Gender gender;
    String salaryRange;
    String phone;
    Integer departmentId;

}
