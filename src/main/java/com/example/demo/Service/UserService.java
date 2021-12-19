package com.example.demo.Service;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Utils.AllUserResponse;
import com.example.demo.Utils.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean register(String email, String password) {
        if(userRepository.findByEmail(email) != null) {
            return false;
        }
        UserEntity userEntity = new UserEntity(email, password);
        userRepository.save(userEntity);
        return true;
    }

    public LoginResponse login(String email, String password) {
        UserEntity userEntity = userRepository.findByEmail(email);
        System.out.println(userEntity);
        LoginResponse loginResponse = new LoginResponse();
        if(userEntity == null) {
            loginResponse.setUserId(-1);
            return loginResponse;
        }
        if(userEntity.judgeEqual(email, password)) {
            loginResponse.setRole(userEntity.getRole());
            loginResponse.setUserId(userEntity.getId());
        }
        else {
            loginResponse.setUserId(-1);
        }
        return loginResponse;
    }

    public List<AllUserResponse> getAllUsers(Integer userId) {
        List<UserEntity> list = userRepository.findAllUsersExceptOne(userId);
        if(list == null)
            return null;
        List<AllUserResponse> res = new ArrayList<>();
        for(UserEntity user : list) {
            res.add(new AllUserResponse(user));
        }
        return res;
    }

    public void setRole(Integer setter, String getter, String role) {
        UserEntity userSetter = userRepository.findById(setter).orElseThrow(() -> new RuntimeException("没有这个用户"));
        if(userSetter.getRole() != UserEntity.UserRole.ADMIN)
            return;
        UserEntity userGetter = userRepository.findByEmail(getter);
        if(userGetter == null)
            throw new RuntimeException("被设置用户不存在");
        switch (role) {
            case "ADMIN":
                userGetter.setRole(UserEntity.UserRole.ADMIN);
                break;
            case "USER":
                userGetter.setRole(UserEntity.UserRole.USER);
                break;
            case "BANNED":
                userGetter.setRole(UserEntity.UserRole.BANNED);
        }
        userRepository.saveAndFlush(userGetter);
    }
}
