package com.example.payment_project.service;

import com.example.payment_project.model.User;
import com.example.payment_project.repository.user.UserRepositoryImpl;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
@Getter
@Setter

public class UserService {
    private static  UserService userService = new UserService();
    private  UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();

    public UUID save(User user) {
        if (user.getPassword().isEmpty() || user.getUsername().isEmpty()) {
            throw new RuntimeException("Password or username is empty");
        }
        Optional<User> userByUsername = userRepository.findByUsername(user.getUsername());
        if (userByUsername.isPresent()) {
            throw new RuntimeException("This username %s already exist".formatted(user.getUsername()));
        }
        user.setId(UUID.randomUUID());
        user.setCreated_date(LocalDateTime.now());
        user.setUpdate_date(LocalDateTime.now());
        try {
            int res = userRepository.create(user);
            if (res == 1) {
                return user.getId();
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Userni saqlashda xatolik roy berdi");
        }
        return null;
    }

    public UUID login(User user) {
        if (user.getPassword().isEmpty() || user.getUsername().isEmpty()) {
            throw new RuntimeException("Password or username is empty");
        }
        Optional<User> userByUsername = userRepository.findByUsername(user.getUsername());
        if (userByUsername.isEmpty()) {
            throw new RuntimeException("Bunday user mavjud emas");
        }
        if (!(user.getPassword().equals(userByUsername.get().getPassword()))) {
            throw new RuntimeException("Bunday user mavjud emas");
        }
        return userByUsername.get().getId();

    }

    public static UserService getInstance() {

        return userService;
    }
}


