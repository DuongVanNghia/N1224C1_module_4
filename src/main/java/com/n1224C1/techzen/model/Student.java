package com.n1224C1.techzen.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

//import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
public class Student {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    double score;

    @ManyToOne
    Clazz clazz;
}