package com.example.demo.Service;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean register(String email, String password)
    {
        if(userRepository.findByEmail(email) != null)
        {
            return false;
        }
        UserEntity userEntity = new UserEntity(email, password);
        userRepository.save(userEntity);
        return true;
    }

    public boolean login(String email, String password)
    {
        UserEntity userEntity;
        if((userEntity = userRepository.findByEmail(email)) == null)
        {
            return false;
        }
        return userEntity.judgeEqual(email, password);
    }
}
