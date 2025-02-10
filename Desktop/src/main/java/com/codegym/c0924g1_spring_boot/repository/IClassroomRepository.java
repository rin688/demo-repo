package com.codegym.c0924g1_spring_boot.repository;

import com.codegym.c0924g1_spring_boot.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClassroomRepository extends JpaRepository<Classroom, Integer> {
    List<Classroom> findAllByDeletedIsFalse();
}
