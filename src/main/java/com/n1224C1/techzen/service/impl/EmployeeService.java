package com.n1224C1.techzen.service.impl;

import com.n1224C1.techzen.dto.Employee.EmployeeSearchRequest;
import com.n1224C1.techzen.model.Employee;
import com.n1224C1.techzen.model.Student;
import com.n1224C1.techzen.repository.IEmployeeRepository;
import com.n1224C1.techzen.repository.IStudentRepository;
import com.n1224C1.techzen.service.IEmployeeService;
import com.n1224C1.techzen.service.IStudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository ;

    @Override
    public List<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest) {
        return employeeRepository.findByAttribute(employeeSearchRequest.getName(),employeeSearchRequest.getDobFrom(),
                employeeSearchRequest.getDobTo(),
                employeeSearchRequest.getGender() == null ? null : employeeSearchRequest.getGender().toString(),
                employeeSearchRequest.getPhone(),
                employeeSearchRequest.getDepartmentId(),
                employeeSearchRequest.getSalaryRange());
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}