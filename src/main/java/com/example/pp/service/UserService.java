package com.example.pp.service;

import com.example.pp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public interface UserService extends UserDetailsService {
    void addUser(User user);

    void deleteUser(Long id);

    void editUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();
}
