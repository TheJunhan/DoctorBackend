package com.example.demo.Service;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public int login(String email, String password) {
        UserEntity userEntity = userRepository.findByEmail(email);
        System.out.println(userEntity);
        if(userEntity == null)
            return -1;
        return userEntity.judgeEqual(email, password) ? userEntity.getId() : -1;
    }
}
