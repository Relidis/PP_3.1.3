package com.example.pp.control;

import com.example.pp.model.Person;
import com.example.pp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
     @Autowired
    private PersonService personService;
    public Controller(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/allUsers")
    public String allUsers(Model model){
        List<Person> users = (List<Person>) personService.allUsers();
        model.addAttribute("person", users);
        // model.addAttribute("person",personDAO.allUsers());
        return "allUsers";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("person",new Person());
        return "new";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") Person person){
        personService.save(person);
        return "redirect:/allUsers";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model){
        Person person = personService.oneUser(id);
        model.addAttribute("person", person);
        return "edit";
    }

    @PostMapping("/edit")
    public String updateUser(Person person){
        personService.save(person);
        return "redirect:/allUsers";
    }
    @GetMapping ("/{id}")
    public String delete(@PathVariable("id") long id){
        personService.delete(id);
        return "redirect:/allUsers";
    }
}
