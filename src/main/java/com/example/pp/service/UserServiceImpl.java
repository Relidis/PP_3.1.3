package com.example.pp.service;

;
import com.example.pp.model.User;

import com.example.pp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Transactional(readOnly = true)
    public User oneUser(long id){
        return userRepository.findById(id).orElse(null);
    }
    @Transactional(readOnly = true)
    public Iterable<User> allUsers(){
        return userRepository.findAll();

    }
    @Transactional(readOnly = true)
    public User save(User user){
        return userRepository.save(user);

    }
    @Transactional(readOnly = true)
    public void delete(Long id){
        userRepository.deleteById(id);

    }
}

