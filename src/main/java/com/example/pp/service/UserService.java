package com.example.pp.service;

import com.example.pp.model.User;

public interface UserService {

    User findUserById(Long id);
    User oneUser(long id);
    boolean save(User user);
    void delete(Long id);

    Iterable<User> allUsers();
}
