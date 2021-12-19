package com.example.demo.Utils;

import com.example.demo.Entity.UserEntity;
import lombok.Data;

@Data
public class LoginResponse {
    Integer userId;
    UserEntity.UserRole role;
}