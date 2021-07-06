package com.test;


import com.entity.User;
import com.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 用户的业务层测试
 */
@RunWith(SpringJUnit4ClassRunner.class)//spring整合junit
@ContextConfiguration(locations = "classpath:applicationContext.xml")//加载配置文件

public class Test {

    @Autowired
    private UserService userService;//自动属性注入
    @org.junit.Test
    public void testFindAll(){
        List<User> user = userService.findAll();
        System.out.println(user);
    }


}
