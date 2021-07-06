package com.service.impl;
import com.service.UserService;
import java.util.List;
import com.entity.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserMapper;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;

    @Override
    public List<User> queryUserPage(Integer startRows) {
        return userMapper.queryUserPage(startRows);
    }

    @Override
    public List<User> selectUserPage(String userName, String userSex, Integer startRows) {
        return userMapper.selectUserPage(userName, userSex, startRows);
    }

    @Override
    public Integer getRowCount(String userName, String userSex) {
        return userMapper.getRowCount(userName, userSex);
    }

    @Override
    public Integer createUser(User user) {
        return userMapper.createUser(user);
    }

    @Override
    public Integer deleteUserById(String userId) {
        return userMapper.deleteUserById(userId);
    }

    @Override
    public Integer deleteUserByIdList(@Param("list") List userIds) {
        return userMapper.deleteUserByIdList(userIds);
    }

    @Override
    public Integer updateUserById(User user) {
        return userMapper.updateUserById(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }


}

