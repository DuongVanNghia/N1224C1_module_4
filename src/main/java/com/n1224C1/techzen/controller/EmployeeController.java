package com.n1224C1.techzen.controller;

import com.n1224C1.techzen.dto.ApiResponse;
import com.n1224C1.techzen.exception.ErrorCode;
import com.n1224C1.techzen.model.Employee;
import com.n1224C1.techzen.exception.ApiException;
import com.n1224C1.techzen.dto.Employee.EmployeeSearchRequest;
import com.n1224C1.techzen.service.IEmployeeService;
import com.n1224C1.techzen.util.JsonInclude;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class EmployeeController {
    IEmployeeService employeeService;
    @GetMapping
    public ResponseEntity<?> getAll(
            EmployeeSearchRequest employeeSearchRequest
    ) {

        return JsonInclude.ok(employeeService.findByAttributes(employeeSearchRequest));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> createEmployee(@RequestBody Employee employee) {

        return JsonInclude.created(employeeService.save(employee));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> getEmployeeById(@PathVariable int id) {
        if(employeeService.findById(id) != null){
            return JsonInclude.ok(employeeService.findById(id));
        }
        throw  new ApiException(ErrorCode.EMPLOYEE_NOT_EXIST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Employee existingEmployee = employeeService.findById(id);
        if (existingEmployee != null) {
            employee.setId(UUID.randomUUID());
            return JsonInclude.ok(employeeService.save(employee));
        }
        throw new ApiException(ErrorCode.EMPLOYEE_NOT_EXIST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        if(employeeService.findById(id) == null){
            throw new ApiException(ErrorCode.EMPLOYEE_NOT_EXIST);
        }
        employeeService.delete(id);
        return  JsonInclude.noContent();
    }

}