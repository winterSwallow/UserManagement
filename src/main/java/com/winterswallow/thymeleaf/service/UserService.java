package com.winterswallow.thymeleaf.service;

import com.winterswallow.thymeleaf.jpa.entity.User;
import com.winterswallow.thymeleaf.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        Iterable<User> userIterable = userRepository.findAll();
        List<User> userList = new ArrayList<User>();
        userIterable.forEach(user -> {
            userList.add(user);
        });
        return userList;
    }

    public List<User> findAllByNameContains(String keyword) {
        Iterable<User> userIterable = userRepository.findAllByNameContains(keyword);
        List<User> userList = new ArrayList<User>();
        userIterable.forEach(user -> {
            userList.add(user);
        });
        return userList;
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

}
