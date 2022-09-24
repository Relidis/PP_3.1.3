package com.example.pp.init;

import com.example.pp.model.Role;
import com.example.pp.model.User;
import com.example.pp.service.RoleService;
import com.example.pp.service.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ApplicationRunnerImpl implements ApplicationRunner {


    private UserService userService;
    private BCryptPasswordEncoder passwordEncoder;

    private RoleService roleService;

    public ApplicationRunnerImpl(UserService userService, BCryptPasswordEncoder passwordEncoder, RoleService roleService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public void run(ApplicationArguments args) {
        List<User> users = userService.getAllUsers();

        if (users.isEmpty()) {
            roleService.addRole(new Role("ROLE_ADMIN"));
            roleService.addRole(new Role("ROLE_USER"));
            Role admin = roleService.getRoleById(1L);
            Role user = roleService.getRoleById(2L);
            Set<Role> adminRole = new HashSet<>();
            Set<Role> userRole = new HashSet<>();
            adminRole.add(admin);
            userRole.add(user);
            userService.addUser(new User( "Misha", passwordEncoder.encode("admin"),23,"Misha@google.ru", adminRole ));
            userService.addUser(new User( "Dima", passwordEncoder.encode("user"),17,"dima@google.ru", userRole ));
            userService.addUser(new User("Kostya", passwordEncoder.encode("123"),30,"DOG@google.ru",  userRole));
            userService.addUser(new User("vasyap", passwordEncoder.encode("vasyap"),29,"1234@google.ru", userRole));
            userService.addUser(new User("vasyap", passwordEncoder.encode("kostyag"),43,"droptable@google.ru", userRole));

        }
    }
}
