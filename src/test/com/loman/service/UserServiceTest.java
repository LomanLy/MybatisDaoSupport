package com.loman.service;

import com.github.pagehelper.PageInfo;
import com.loman.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-application.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void queryByPageTest(){
        PageInfo<User> page =  userService.queryByPage(null, 1, 10);
        System.out.println(page);
    }

}