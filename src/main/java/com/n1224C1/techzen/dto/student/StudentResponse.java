package com.n1224C1.techzen.dto.student;

import com.n1224C1.techzen.dto.clazz.ClazzRequest;
import com.n1224C1.techzen.dto.clazz.ClazzResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class StudentResponse {
    int id;
    String name;
    double score;
    ClazzResponse clazz;
}
