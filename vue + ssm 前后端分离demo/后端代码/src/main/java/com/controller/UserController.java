package com.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.UserService;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/queryUserPage")
    @ResponseBody
    @CrossOrigin
    public List<User> queryUserPage(Integer page, HttpServletResponse response) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 5;
        int startRows = pageSize * (pageNow - 1);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        return userService.queryUserPage(startRows);
    }

    @RequestMapping("/selectUserPage")
    @ResponseBody
    @CrossOrigin
    public List<User> selectUserPage(String userName, String userSex, Integer page, HttpServletResponse response) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 5;
        int startRows = pageSize * (pageNow - 1);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        return userService.selectUserPage(userName, userSex, startRows);
    }

    @RequestMapping("/getRowCount")
    @ResponseBody
    @CrossOrigin()
    public Integer getRowCount(String userName, String userSex, HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        return userService.getRowCount(userName, userSex);
    }

    @RequestMapping("/createUser")
    @ResponseBody
    @CrossOrigin
    public Integer createUser(User user, HttpServletResponse response) {
        Random random = new Random();
        Integer number = random.nextInt(9000) + 1000;
        user.setUserId(System.currentTimeMillis() + String.valueOf(number));
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        return userService.createUser(user);
    }

    @RequestMapping("/deleteUserById")
    @ResponseBody
    @CrossOrigin()
    public Integer deleteUserById(String userId, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        return userService.deleteUserById(userId);
    }

    @RequestMapping(value = "/deleteUserByIdList")
    @ResponseBody
    @CrossOrigin
    public Integer deleteUserByIdList(String userIdList, HttpServletResponse response) {
        String userIdListSub = userIdList.substring(0, userIdList.length() - 1);
//        String[] userIds = userIdList.split(",");

        List userIds = new ArrayList();
        for (String userIdStr : userIdListSub.split(",")) {
            userIds.add(userIdStr.trim());
        }
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        return userService.deleteUserByIdList(userIds);
    }

    @RequestMapping("/updateUserById")
    @ResponseBody
    @CrossOrigin
    public Integer updateUserById(User user, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        return userService.updateUserById(user);
    }


    @RequestMapping("/findAll")
    @ResponseBody
    @CrossOrigin()
    public List<User> findAll(User user) {
        return userService.findAll();
    }


}

