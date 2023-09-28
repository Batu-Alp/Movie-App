package com.example.movieapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movieapp.Entity.User;
import com.example.movieapp.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addUser(String name, String surname, String email, String password) {

        User user = userRepository.insert(new User(name, surname, email, password));
        return user;

    }

}
