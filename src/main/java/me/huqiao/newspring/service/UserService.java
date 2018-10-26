package me.huqiao.newspring.service;

import java.util.List;

import me.huqiao.newspring.domain.User;

public interface UserService {

    void add(User user);

    void delete(Long id);

    List<User> getAll();
    
    User findById(Long id);
}