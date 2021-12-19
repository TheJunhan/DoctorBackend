package com.example.demo.Utils;

import com.example.demo.Entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AllUserResponse {
    String email;
    UserEntity.UserRole role;
    public AllUserResponse(UserEntity userEntity) {
        this.email = userEntity.getEmail();
        this.role = userEntity.getRole();
    }
}
