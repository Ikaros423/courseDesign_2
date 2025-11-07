package com.course.coursedesign2022.controller;

import com.course.coursedesign2022.service.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private Login login;

    @PutMapping("/login/{id}")
    public String login(@PathVariable Integer id) {
        boolean res = login.login(id);
        if (res){
            return "login success";
        }
        return "login failed";
    }
}
