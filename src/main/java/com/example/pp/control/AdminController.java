package com.example.pp.control;

import com.example.pp.model.Role;
import com.example.pp.model.User;
import com.example.pp.service.RoleServiceImpl;
import com.example.pp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/admin/allUsers")
public class AdminController {


    private UserServiceImpl userService;

    private RoleServiceImpl roleService;

    private BCryptPasswordEncoder passwordEncoder;

    public AdminController(UserServiceImpl userService, RoleServiceImpl roleService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/admin/allUsers")
    public String allUsers(Model model){
        List<User> users = (List<User>) userService.getAllUsers();
        model.addAttribute("user", users);

        return "allUsers";
    }
    @GetMapping(value = "admin/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin/add";
    }
    @PostMapping("/admin")
    public String createUser(@ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return "redirect:/admin";
    }

/*
    @PostMapping(value = "admin/add")
    public String postAddUser(@ModelAttribute("user") User user,
                              @RequestParam(required=false) String roleAdmin) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getRoleById(2L));
        if (roleAdmin != null && roleAdmin.equals(1L)) {
            roles.add(roleService.getRoleById(2L));
        }
        user.setRoles(roles);
        userService.addUser(user);

        return "redirect:/admin/allUsers";
    }

 */

    @GetMapping(value = "admin/edit/{id}")
    public String editUser(ModelMap model, @PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        Set<Role> roles = user.getRoles();
        for (Role role: roles) {
            if (role.equals(roleService.getRoleById(1L))) {
                model.addAttribute("roleAdmin", true);
            }
        }
        model.addAttribute("user", user);
        return "admin/edit";
    }
    @PostMapping(value = "admin/edit")
    public String userUpdate(@ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return "redirect:/admin";
    }



    @GetMapping ("/admin/{id}")
    public String delete(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
