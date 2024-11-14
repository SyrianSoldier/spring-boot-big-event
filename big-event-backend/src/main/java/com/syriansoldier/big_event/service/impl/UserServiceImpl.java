package com.syriansoldier.big_event.service.impl;

import com.syriansoldier.big_event.mapper.UserMapper;
import com.syriansoldier.big_event.pojo.User;
import com.syriansoldier.big_event.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public void register(String username, String password) {
        userMapper.register(username, DigestUtils.md5DigestAsHex(password.getBytes()));
    }
}
