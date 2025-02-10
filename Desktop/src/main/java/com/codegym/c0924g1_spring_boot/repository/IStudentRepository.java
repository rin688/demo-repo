package com.codegym.c0924g1_spring_boot.repository;

import com.codegym.c0924g1_spring_boot.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "select * from students as s where s.name_student like concat('%', :name, '%')")
    List<Student> findAllByNameContaining(@Param("name") String name);
}
