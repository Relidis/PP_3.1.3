package com.example.pp.service;

;
import com.example.pp.model.User;

import com.example.pp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    public User passwordEncoder(User User) {
        User.setPassword(passwordEncoder.encode(User.getPassword()));
        return User;
    }
    @Transactional(readOnly=true)
    @Autowired
    public void setUserRepo(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional(readOnly=true)
    @Override
    public void addUser(User user) {
        userRepository.addUser(passwordEncoder(user));
    }
    @Transactional(readOnly=true)
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
    @Transactional(readOnly=true)
    @Override
    public void editUser(User user) {
        userRepository.editUser(passwordEncoder(user));
    }
    @Transactional(readOnly=true)
    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }
    @Transactional(readOnly=true)
    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUserByUsername(username);
    }
}

