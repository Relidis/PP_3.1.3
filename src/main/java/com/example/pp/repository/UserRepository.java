package com.example.pp.repository;

import com.example.pp.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


public interface UserRepository {
    void addUser(User user);

    void deleteUser(Long id);

    void editUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    UserDetails getUserByUsername(String username);

}