package com.example.demo.Repository;

import com.example.demo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Nullable
    @Query( value = "select * from user where user.email = ?1", nativeQuery = true)
    UserEntity findByEmail(String email);
}
