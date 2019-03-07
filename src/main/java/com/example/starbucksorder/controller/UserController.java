package com.example.starbucksorder.controller;

import com.example.starbucksorder.domain.User;
import com.example.starbucksorder.service.UserService;
import com.example.starbucksorder.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/join")
    public ResponseVO join(@RequestBody User user) {

        userService.addUser(user);

        return new ResponseVO(200, "create");

    }


}
