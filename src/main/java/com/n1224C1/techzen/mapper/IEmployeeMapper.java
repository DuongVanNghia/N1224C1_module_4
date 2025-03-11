package com.n1224C1.techzen.mapper;

import com.n1224C1.techzen.dto.Employee.EmployeeRequest;
import com.n1224C1.techzen.dto.Employee.EmployeeResponse;
import com.n1224C1.techzen.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IEmployeeMapper {
    Employee employeeRequestToEmployee(EmployeeRequest employeeRequest);
    EmployeeResponse employeeToEmployeeResponse(Employee employee);
}
