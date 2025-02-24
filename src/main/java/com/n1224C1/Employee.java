package com.n1224C1;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    int id;
    String ten;
    LocalDate ngaysinh;
    Gender gioitinh;
    double luong;

    public enum Gender {
        Male,
        Female
    }
}
