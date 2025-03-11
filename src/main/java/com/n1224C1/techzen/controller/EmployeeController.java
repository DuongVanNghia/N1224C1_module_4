package com.n1224C1.techzen.controller;

import com.n1224C1.techzen.dto.ApiResponse;
import com.n1224C1.techzen.dto.Employee.EmployeeRequest;
import com.n1224C1.techzen.dto.Employee.EmployeeResponse;
import com.n1224C1.techzen.dto.page.PageResponse;
import com.n1224C1.techzen.exception.ErrorCode;
import com.n1224C1.techzen.mapper.IEmployeeMapper;
import com.n1224C1.techzen.model.Employee;
import com.n1224C1.techzen.exception.ApiException;
import com.n1224C1.techzen.dto.Employee.EmployeeSearchRequest;
import com.n1224C1.techzen.service.IEmployeeService;
import com.n1224C1.techzen.util.JsonInclude;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class EmployeeController {
    IEmployeeService employeeService;
    IEmployeeMapper employeeMapper;
    @GetMapping
    public ResponseEntity<?> getAll(
            EmployeeSearchRequest employeeSearchRequest,
            Pageable pageable

    ) {

        return JsonInclude.ok(new PageResponse<> (employeeService.findByAttributes(employeeSearchRequest,pageable)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EmployeeResponse>> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        Employee employee =employeeMapper.employeeRequestToEmployee(employeeRequest);
        employee =employeeService.save(employee);
        EmployeeResponse employeeResponse = employeeMapper.employeeToEmployeeResponse(employee);

        return JsonInclude.created(employeeResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeResponse>> getEmployeeById(@PathVariable int id) {
        if(employeeService.findById(id) != null){
            EmployeeResponse employeeResponse = employeeMapper.employeeToEmployeeResponse(employeeService.findById(id));
            return JsonInclude.ok(employeeResponse);

        }
        throw  new ApiException(ErrorCode.EMPLOYEE_NOT_EXIST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeResponse>> updateEmployee(@PathVariable int id , @RequestBody EmployeeRequest employeeRequest) {
        Employee existingEmployee = employeeService.findById(id);
        if (existingEmployee != null) {
            Employee employee = employeeMapper.employeeRequestToEmployee(employeeRequest);
            employee.setId(UUID.randomUUID());
            employee = employeeService.save(employee);
            EmployeeResponse employeeResponse = employeeMapper.employeeToEmployeeResponse(employee);




            return JsonInclude.ok(employeeResponse);
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