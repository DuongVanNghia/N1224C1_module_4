package com.n1224C1;

import com.n1224C1.dto.ApiResponse;
import com.n1224C1.exception.ApiException;
import com.n1224C1.exception.Errorcode;
import com.n1224C1.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException e){
        Errorcode errorcode = e.getErrorcode();
        return ResponseEntity.status(Errorcode.STUDENT_NOT_EXITS.getHttpStatus()).body(ApiResponse.<Student>builder()
                .code(Errorcode.STUDENT_NOT_EXITS.getCode())
                .message(Errorcode.STUDENT_NOT_EXITS.getMessage())
                .build());
    }
}
