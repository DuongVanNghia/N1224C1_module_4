package com.n1224C1.controller;

import com.n1224C1.Employee;
import com.n1224C1.dto.ApiResponse;
import com.n1224C1.exception.ApiException;
import com.n1224C1.exception.Errorcode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employees = new ArrayList<Employee>(
            Arrays.asList(
                    new Employee(1, "thanh", LocalDate.of(2003, 11, 22), Employee.Gender.Female, 14000000),
                    new Employee(2, "linh", LocalDate.of(2003, 7, 4), Employee.Gender.Female, 15000000),
                    new Employee(3, "Hai", LocalDate.of(2005, 9, 30), Employee.Gender.Male, 15000000)
            )

    );

    @GetMapping
    public List<Employee> listEmployee() {
        return employees;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> getEmployee(@PathVariable("id") int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {

                return ResponseEntity.ok(ApiResponse.<Employee>builder()
                        .data(employee)
                        .build());
            }
        }
        throw new ApiException(Errorcode.EMPLOYEE_NOT_EXIST);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> addEmployee(@RequestBody Employee employee) {
        employee.setId((int) (Math.random() * 1000));
        employees.add(employee);
        return ResponseEntity.ok(ApiResponse.<Employee>builder()
                .data(employee)
                .build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setTen(employee.getTen());
                emp.setGioitinh(employee.getGioitinh());
                emp.setNgaysinh(employee.getNgaysinh());
                emp.setLuong(employee.getLuong());
                return ResponseEntity.ok(ApiResponse.<Employee>builder()
                        .data(emp)
                        .build());
                //return ResponseEntity.ok(emp);
            }
        }
        throw new ApiException(Errorcode.EMPLOYEE_NOT_EXIST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> deleteEmployee(@PathVariable("id") int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                Employee deletedEmployee = employees.get(i);
                employees.remove(i);
                return ResponseEntity.ok(ApiResponse.<Employee>builder()
                        .data(deletedEmployee)
                        .build());

                //return ResponseEntity.ok(deletedEmployee);
            }
        }
        throw new ApiException(Errorcode.EMPLOYEE_NOT_EXIST);
    }
}
