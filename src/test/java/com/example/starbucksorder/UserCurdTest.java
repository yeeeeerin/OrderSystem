package com.example.starbucksorder;

import com.example.starbucksorder.domain.User;
import com.example.starbucksorder.exception.coustomexception.AlreadyExistException;
import com.example.starbucksorder.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserCurdTest {

    @Autowired
    UserServiceImpl userServiceimpl;

    @Test
    public void userAdd(){

        User user = new User();
        user.setName("yeerin");

        userServiceimpl.addUser(user);

        User user1 = userServiceimpl.findUser("yeerin");

        assertThat(user1.getName(),is("yeerin"));

        userServiceimpl.removeUser(user1.getId());
    }

    @Test(expected = AlreadyExistException.class)
    public void userAddFail(){
        User user1 = new User();

        user1.setName("yerrin");

        userServiceimpl.addUser(user1);

    }

}
