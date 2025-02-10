package com.codegym.c0924g1_spring_boot.service;

import com.codegym.c0924g1_spring_boot.model.Student;
import org.springframework.data.domain.Slice;

public interface IStudentService extends IService<Student> {

    Slice<Student> findAll(int page, int size);

}
