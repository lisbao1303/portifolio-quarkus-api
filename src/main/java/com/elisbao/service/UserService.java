package com.elisbao.service;

import com.elisbao.model.User;
import com.elisbao.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.listAll();
    }

    public void createUser(User user) {
        userRepository.persist(user);
    }
}
