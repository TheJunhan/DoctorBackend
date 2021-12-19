package com.example.demo.Controller;

import com.example.demo.Service.UserService;
import com.example.demo.Utils.AllUserResponse;
import com.example.demo.Utils.LoginResponse;
import com.example.demo.Utils.SetRoleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/test")
    String test() {
        System.out.println("test");
        return "test";
    }
    @GetMapping("/register")
    boolean register(String email, String password) {
        if(password.length() == 0 || email.length() == 0)
            return false;
        return userService.register(email, password);
    }

    @GetMapping("/login")
    LoginResponse login(String email, String password) {
        return userService.login(email, password);
    }

    @GetMapping("/getAllUsers")
    List<AllUserResponse> getAllUsers(@Param("userId") Integer userId) {
        return userService.getAllUsers(userId);
    }

    @PostMapping("/setRole")
    void setRole(@RequestBody String jsonRequest) {
        SetRoleRequest request = new SetRoleRequest(jsonRequest);
        userService.setRole(request.getSetterId(), request.getGetterEmail(), request.getRole());
    }
}
