package com.syriansoldier.big_event.controller;

import com.syriansoldier.big_event.pojo.User;
import com.syriansoldier.big_event.service.UserService;
import com.syriansoldier.big_event.service.impl.UserServiceImpl;
import com.syriansoldier.big_event.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @PostMapping("/register")
    public Result register(@RequestParam String username, @RequestParam String password){
        // 1. 查询用户是否存在
        if(userService.findUserByUsername(username) != null){
            return Result.error("用户名已经创建");
        }

        // 2. 注册
        userService.register(username, password);
        return Result.success();
    }


}
