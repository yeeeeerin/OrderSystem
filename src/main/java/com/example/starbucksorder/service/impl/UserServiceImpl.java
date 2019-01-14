package com.example.starbucksorder.service.impl;

import com.example.starbucksorder.domain.User;
import com.example.starbucksorder.exception.coustomexception.AlreadyExistException;
import com.example.starbucksorder.repository.UserRepository;
import com.example.starbucksorder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public void addUser(User user) {

        Optional<User> userOptional = userRepository.findByName(user.getName());
        if(!userOptional.isEmpty()){
            throw new AlreadyExistException("이미 존재하는 회원입니다");
        }

        userRepository.save(user);
    }

    @Override
    public User findUser(String name) {
        return userRepository.findByName(name).get();
    }

    @Override
    public void removeUser(Long id) {
        User user = userRepository.findById(id).get();

        userRepository.delete(user);
    }
}
