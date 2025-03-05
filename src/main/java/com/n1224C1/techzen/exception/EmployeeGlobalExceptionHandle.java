package com.n1224C1.techzen.exception;

import com.n1224C1.techzen.dto.ApiResponse;
import com.n1224C1.techzen.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class EmployeeGlobalExceptionHandle {
    public ResponseEntity<?> hanResponse(ApiException e){
        ErrorCode errorcode = e.getErrorcode();
        return ResponseEntity.status(ErrorCode.EMPLOYEE_NOT_EXIST.getHttpStatus()).body(ApiResponse.<Employee>builder()
                .code(ErrorCode.EMPLOYEE_NOT_EXIST.getCode())
                .message("Employee not exist")
                .build());
    }
}
