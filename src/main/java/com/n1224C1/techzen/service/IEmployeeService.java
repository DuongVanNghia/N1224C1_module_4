package com.n1224C1.techzen.service;

import com.n1224C1.techzen.dto.Employee.EmployeeSearchRequest;
import com.n1224C1.techzen.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest);
    Employee findById(int id);
    Employee save(Employee employee);

    void delete(int id);
}
