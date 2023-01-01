package com.mypost.todopost.entity.userEntity;

import com.mypost.todopost.entity.BaseEntity;
import lombok.Builder;

import javax.persistence.*;

public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;


    @Builder
    public User(String name, String email, String picture ){
        this.name = name;
        this.email = email;
        this.picture = picture;
    }
    public User update(String name, String picture){
        this.name = name;
        this.picture = picture;
        return this;
    }
}
