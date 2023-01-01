package com.mypost.todopost.persistence;

import com.mypost.todopost.entity.userEntity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
}
