package com.n1224C1.techzen.repository;

import com.n1224C1.techzen.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IStudentRepository extends JpaRepository<Student, Integer> {
//    List<Student> findByNameContainingAndScoreBetween(String name, double fromScore, double toScore);

//    @Query("""
//    FROM Student Where name like concat('%',:name, '%')
//    AND(:fromScore is null or score >= :fromScore)
//    AND(:toScore is null or score <= :toScore)
//""")
@Query(value = """
    SELECT *FROM Student Where name like concat('%',:name, '%')
    AND(:fromScore is null or score >= :fromScore)
    AND(:toScore is null or score <= :toScore)
""", nativeQuery = true)
Page<Student> findByAttribute(@Param("name") String name,
                              @Param("fromScore") Double fromScore,
                              @Param("toScore") Double toScore,
                              @Param("pageable") Pageable pageable);

    Student findById(int id);
}
