package com.n1224C1.techzen.util;

import com.n1224C1.techzen.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class JsonInclude {
    public static<T> ResponseEntity<ApiResponse<T>> ok(T body) {
        return ResponseEntity.ok().body(ApiResponse.<T>builder().data(body).build());
    }
    public static <T> ResponseEntity<ApiResponse<T>> created(T body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.<T>builder().data(body).build());
    }
    public static <T> ResponseEntity<ApiResponse<T>> noContent() {
        return ResponseEntity.noContent().build();
    }
}
