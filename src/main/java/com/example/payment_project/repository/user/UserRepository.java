package com.example.payment_project.repository.user;

import com.example.payment_project.model.User;
import com.example.payment_project.repository.BaseRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByUsername(String username);


}
