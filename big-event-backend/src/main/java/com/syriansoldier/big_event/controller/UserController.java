package com.syriansoldier.big_event.controller;

import com.syriansoldier.big_event.dto.LoginDto;
import com.syriansoldier.big_event.dto.RegisterDto;
import com.syriansoldier.big_event.pojo.User;
import com.syriansoldier.big_event.service.impl.UserServiceImpl;
import com.syriansoldier.big_event.utils.JwtUtils;
import com.syriansoldier.big_event.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/register")
    public Result<?> register(@Validated @ModelAttribute RegisterDto params){
        // 1. 查询用户是否存在
        if(userService.findUserByUsername(params.getUsername()) != null){
            return Result.error("用户名已经创建");
        }

        // 2. 注册
        userService.register(params.getUsername(), params.getPassword());
        return Result.success();
    }

    @PostMapping("/login")
    public Result<?> login (@Validated @ModelAttribute LoginDto params){
        User user = userService.findUserByUsername(params.getUsername());
        String md5Pwd = DigestUtils.md5DigestAsHex(params.getPassword().getBytes());
        String ErrorMessage = "用户名或密码错误";

        if(user == null){
            return Result.error(ErrorMessage);
        }

        if(!md5Pwd.equals(user.getPassword())){
            return Result.error(ErrorMessage);
        }

        Map<String,Object> claims = new HashMap<>();
        claims.put("userId", user.getUserId());
        claims.put("username", user.getUsername());
        String token = jwtUtils.genJwt(claims);

        return Result.success("登录成功", token);
    }

    @PostMapping("/test")
    public Result<?> test(){
        return Result.success("token通过校验", null);
    }
}
