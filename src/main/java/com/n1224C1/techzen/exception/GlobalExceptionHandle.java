package com.n1224C1.techzen.exception;

import com.n1224C1.techzen.dto.ApiResponse;
import com.n1224C1.techzen.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException e){
        ErrorCode errorcode = e.getErrorcode();
        return ResponseEntity.status(ErrorCode.STUDENT_NOT_EXITS.getHttpStatus()).body(ApiResponse.<Student>builder()
                .code(ErrorCode.STUDENT_NOT_EXITS.getCode())
                .message(ErrorCode.STUDENT_NOT_EXITS.getMessage())
                .build());
    }
}
