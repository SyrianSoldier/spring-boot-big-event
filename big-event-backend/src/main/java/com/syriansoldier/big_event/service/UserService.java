package com.syriansoldier.big_event.service;

import com.syriansoldier.big_event.pojo.User;

public interface UserService {


    User findUserByUsername(String username);

    void register(String username, String password);
}
