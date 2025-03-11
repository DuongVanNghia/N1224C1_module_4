package com.n1224C1.techzen.dto.student;


//import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.n1224C1.techzen.dto.clazz.ClazzRequest;
import com.n1224C1.techzen.model.Clazz;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class StudentRequest {
    String name;
    double score;
    ClazzRequest clazz;
}