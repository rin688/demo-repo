package com.codegym.c0924g1_spring_boot.repository;

import com.codegym.c0924g1_spring_boot.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String username);
}