package com.example.pp;

import com.example.pp.model.Role;
import com.example.pp.model.User;
import com.example.pp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
/*
    @Bean
    public CommandLineRunner CommandLineRunnerBean() {
        List<User> users = userService.getAllUsers();

        if (users.isEmpty()) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            Role admin = new Role("ROLE_ADMIN");
            Role user = new Role("ROLE_USER");
            Set<Role> adminRole = new HashSet<>();
            Set<Role> userRole = new HashSet<>();
            adminRole.add(admin);
            userRole.add(user);
            userService.addUser(new User(1L, "Misha", bCryptPasswordEncoder.encode("admin"), adminRole));
            userService.addUser(new User(2L,  "Dima", bCryptPasswordEncoder.encode("user"), userRole));
            userService.addUser(new User(3L, "Kostya", bCryptPasswordEncoder.encode("dimab"), userRole));
            userService.addUser(new User(4L, "vasyap", bCryptPasswordEncoder.encode("vasyap"), userRole));
            userService.addUser(new User(5L, "vasyap", bCryptPasswordEncoder.encode("kostyag"), userRole));
            return User;
        }
    }

 */
}
