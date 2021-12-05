package com.example.demo.Controller;

import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/test")
    String test()
    {
        System.out.println("test");
        return "test";
    }
    @GetMapping("/register")
    boolean register(String email, String password)
    {
        if(password.length() == 0 || email.length() == 0)
            return false;
        return userService.register(email, password);
    }

    @GetMapping("/login")
    int login(String email, String password)
    {
        if(password.length() == 0 || email.length() == 0)
            return -1;
        int tmp = userService.login(email, password);
        return tmp;
    }
}
