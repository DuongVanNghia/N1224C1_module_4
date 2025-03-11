package com.n1224C1.techzen.dto.Department;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Table(name = "department") // Đảm bảo bảng tồn tại trong DB
@Data
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentRequest {
    Integer id;
    String name;
}