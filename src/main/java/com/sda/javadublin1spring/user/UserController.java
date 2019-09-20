package com.sda.javadublin1spring.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("users-view");
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;
    }

    @GetMapping("/users/{userId}")
    public ModelAndView userById(@PathVariable("userId") Long id) {
        ModelAndView modelAndView = new ModelAndView("user-view");
        modelAndView.addObject("user", userService.findById(id));
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/blabla")
    public String test() {
        return "redirect:/users";
    }
}