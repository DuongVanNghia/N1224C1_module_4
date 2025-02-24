package com.n1224C1;

import com.n1224C1.dto.ApiResponse;
import com.n1224C1.exception.ApiException;
import com.n1224C1.exception.Errorcode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class EmployeeGlobalExceptionHandle {
    public ResponseEntity<?> hanResponse(ApiException e){
        Errorcode errorcode = e.getErrorcode();
        return ResponseEntity.status(Errorcode.EMPLOYEE_NOT_EXIST.getHttpStatus()).body(ApiResponse.<Employee>builder()
                .code(Errorcode.EMPLOYEE_NOT_EXIST.getCode())
                .message("Employee not exist")
                .build());
    }
}
