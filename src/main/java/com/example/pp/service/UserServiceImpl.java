package com.example.pp.service;

;
import com.example.pp.model.Role;
import com.example.pp.model.User;

import com.example.pp.repository.RoleRepository;
import com.example.pp.repository.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Transactional(readOnly = true)
    public User findUserById(Long id) {
        Optional<User> userFromDb = userRepository.findById(id);
        return userFromDb.orElse(new User());
    }

    @Transactional(readOnly = true)
    public User oneUser(long id){
        return userRepository.findById(id).orElse(null);
    }
    @Transactional(readOnly = true)
    public List<User> allUsers(){
        return userRepository.findAll();

    }
    @Transactional(readOnly = true)
    public boolean save(User user){
        User userFromDB = userRepository.findByName(user.getName());

        if (userFromDB != null) {
            return false;
        }
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;

    }
    @Transactional(readOnly = true)
    public void delete(Long id){
        userRepository.deleteById(id);

    }
}

