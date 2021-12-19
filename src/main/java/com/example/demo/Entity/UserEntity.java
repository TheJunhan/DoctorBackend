package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="user", schema="doctorprotein")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    public UserEntity(String e, String p) {
        email = e;
        password = p;
    }

    public UserEntity() {
    }

    public boolean judgeEqual(String e, String p) {
        return e.equals(email) && p.equals(password);
    }

    public enum UserRole {
        USER, ADMIN, BANNED
    }
}
