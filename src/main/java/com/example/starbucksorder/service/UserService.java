package com.example.starbucksorder.service;

import com.example.starbucksorder.domain.User;

public interface UserService {

    void addUser(User user);

    User findUser(String string);

    void removeUser(Long id);

}
