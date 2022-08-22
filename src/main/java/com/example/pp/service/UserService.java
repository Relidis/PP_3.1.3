package com.example.pp.service;

import com.example.pp.model.User;

public interface UserService {
    User oneUser(long id);
    User save(User user);
    void delete(Long id);

    Iterable<User> allUsers();
}
