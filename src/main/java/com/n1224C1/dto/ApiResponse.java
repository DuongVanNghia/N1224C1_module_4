package com.n1224C1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)//nếu null thì loại bỏ, không hiển thị ra
public class ApiResponse<T> {
    Integer code;
    String message;
    T data;
}