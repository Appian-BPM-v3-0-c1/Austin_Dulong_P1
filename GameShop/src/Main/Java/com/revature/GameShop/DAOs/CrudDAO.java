package com.revature.GameShop.DAOs;

import com.revature.GameShop.Modles.User;

import java.util.List;

import java.util.List;

public interface CrudDAO<T> {
    int save(T obj);
    List<T> findAll();
    T findById(String id);

    User findById(int id);

    List<T> findAllById(int id);

    boolean update(T updateObj);
    boolean removeById(String id);
}
