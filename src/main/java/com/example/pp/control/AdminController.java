package com.example.pp.control;

import com.example.pp.model.Role;
import com.example.pp.model.User;
import com.example.pp.service.RoleServiceImpl;
import com.example.pp.service.UserServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/admin")
public class AdminController {


    private UserServiceImpl userService;

    private RoleServiceImpl roleService;

    private BCryptPasswordEncoder passwordEncoder;

    public AdminController(UserServiceImpl userService, RoleServiceImpl roleService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("allUsers")
    public String allUsers(Model model){
        List<User> user = userService.getAllUsers();
        model.addAttribute("user", user);

        return "allUsers";
    }
    @GetMapping(value = "add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }
    @PostMapping(value = "add")
    public String postAddUser(@ModelAttribute("user") User user,
                              @RequestParam(required=false) String roleAdmin) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getRoleById(2L));
        if (roleAdmin != null && roleAdmin.equals("ROLE_ADMIN")) {
            roles.add(roleService.getRoleById(1L));
        }
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);

        return "redirect:/admin/AllUsers";
    }
    /*
    @PostMapping(value = "add")
    public String createUser(@ModelAttribute("user") Model model) {
        User user = new User();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<Role> roles = roleService.getAllRoles();

        userService.addUser(user);
        return "redirect:/admin/allUsers";
    }


     */


    @GetMapping (value = "/edit/{id}")
    public String editUser(Model model, @PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }
    @PatchMapping (value = "/edit/{id}")
    public String userUpdate(@ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.editUser(user);
        return "redirect:/admin/allUsers";
    }



    @DeleteMapping ("{id}")
    public String delete(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/admin/allUsers";
    }
}
