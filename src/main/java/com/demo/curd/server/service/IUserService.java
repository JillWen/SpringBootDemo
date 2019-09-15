package com.demo.curd.server.service;

import com.demo.curd.shared.domain.User;

import java.util.List;

public interface IUserService {
    User findById(int id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(int id);

    List<User> findAllUsers();

    void deleteAllUsers();

    boolean isUserExist(User user);
}
