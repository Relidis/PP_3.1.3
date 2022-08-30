package com.example.pp.control;

import com.example.pp.model.User;
import com.example.pp.service.UserService;
import com.example.pp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
     @Autowired
    private UserService userService;
    public Controller(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/allUsers")
    public String allUsers(Model model){
        List<User> users = (List<User>) userService.allUsers();
        model.addAttribute("user", users);

        return "allUsers";
    }

  /*  @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user",new User());
        return "new";
    }

   */
    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/admin";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model){
        User user = userService.oneUser(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edit")
    public String updateUser(User user){
        userService.save(user);
        return "redirect:/admin";
    }
    @GetMapping ("/{id}")
    public String delete(@PathVariable("id") long id){
        userService.delete(id);
        return "redirect:/admin";
    }
}
