package com.sda.javadublin1spring.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class UserController {

    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", new Random().nextInt(1000));
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/blabla")
    public String test() {
        return "redirect:/users";
    }
}