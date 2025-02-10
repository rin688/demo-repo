package com.codegym.c0924g1_spring_boot.service;

import java.util.List;

public interface IService<T> {

    List<T> getAll();

    void save(T s);

    void update(int id, T s);

    void remove(int id);

    T findById(int id);

    List<T> findByName(String name);
}
