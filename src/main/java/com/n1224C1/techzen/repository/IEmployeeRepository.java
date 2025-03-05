package com.n1224C1.techzen.repository;

import com.n1224C1.techzen.dto.Employee.EmployeeSearchRequest;
import com.n1224C1.techzen.enums.Gender;
import com.n1224C1.techzen.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEmployeeRepository extends JpaRepository<Employee, UUID> {
    @Query(value = """
            SELECT e.* FROM employee e
            LEFT JOIN department d ON e.department_id = d.id
            Where (:name is null or e.name like concat('%',:name, '%'))
            AND (:dobFrom is null or e.date_of_birth >= :dobFrom)
            AND (:dobTo is null or e.date_of_birth <= :dobTo)
            AND (:gender is null or e.gender = :gender)
            AND (:phone is null or e.phone like concat('%',:phone, '%'))
            AND (:departmentId is null or d.id = :departmentId)
            AND (
            case 
            WHEN :salaryRange ='lt5' then e.salary < 5000000
            WHEN :salaryRange = '5-10' then e.salary between 5000000 and 10000000
            WHEN :salaryRange = '10-20' then e.salary between 10000000 and 20000000   
            When :salaryRange = 'gt20' then e.salary > 20000000
            ELSE True
            end
            
            )
            """, nativeQuery = true)
    List<Employee> findByAttribute(@Param("name") String name,
                                   @Param("dobFrom") LocalDate dobFrom,
                                   @Param("dobTo") LocalDate dobTo,
                                   @Param("gender") String gender,
                                   @Param("phone") String phone,
                                   @Param("departmentId") Integer departmentId,
                                   @Param("salaryRange") String salaryRange);

    // Tìm theo ID
    Optional<Employee> findById(UUID id);

    // Lưu hoặc cập nhật Employee
    Employee save(Employee employee);


    // Xóa theo ID (cần nếu không có entity sẵn)
    void deleteById(UUID id);
}
