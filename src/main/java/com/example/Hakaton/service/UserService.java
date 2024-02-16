package com.example.Hakaton.service;

import com.example.Hakaton.entity.User;
import com.example.Hakaton.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User loginUser(User user) {
        User registeredUser = userRepository.findByUsername(user.getUsername());
        if (registeredUser != null && registeredUser.getPassword().equals(user.getPassword())) {
            return registeredUser;
        }
        return null;
    }
}