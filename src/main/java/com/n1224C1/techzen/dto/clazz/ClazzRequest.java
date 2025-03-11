package com.n1224C1.techzen.dto.clazz;


import com.n1224C1.techzen.model.Student;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ClazzRequest {
    int id;
    String name;
}