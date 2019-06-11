package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    @ResponseBody
    public List<User> getUser(){
        List<User> users = userService.queryUser();
        System.out.println(users.get(0));
        return users;
    }

    @RequestMapping("/")
    public String goIndex(Model model){
        List<User> users = userService.queryUser();
        model.addAttribute("users",users);
        return "index";
    }
}
