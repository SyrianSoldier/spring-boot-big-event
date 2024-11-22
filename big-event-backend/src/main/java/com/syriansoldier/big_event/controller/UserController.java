package com.syriansoldier.big_event.controller;

import com.syriansoldier.big_event.dto.LoginDto;
import com.syriansoldier.big_event.dto.RegisterDto;
import com.syriansoldier.big_event.dto.UpdateAvatarDto;
import com.syriansoldier.big_event.dto.UpdatePwdDto;
import com.syriansoldier.big_event.dto.UpdateUserInfoDto;
import com.syriansoldier.big_event.pojo.User;
import com.syriansoldier.big_event.service.impl.UserServiceImpl;
import com.syriansoldier.big_event.utils.JwtUtils;
import com.syriansoldier.big_event.utils.Result;
import com.syriansoldier.big_event.utils.ThreadLocalUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
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
    private StringRedisTemplate redisTemplate;

    @Autowired
    JwtUtils jwtUtils;

    @Value("${token.header}")
    String tokenHeader;

    @PostMapping("/register")
    public Result<?> register(@Validated @ModelAttribute RegisterDto params) {
        // 1. 查询用户是否存在
        if (userService.findUserByUsername(params.getUsername()) != null) {
            return Result.error("用户名已经创建");
        }

        // 2. 注册
        userService.register(params.getUsername(), params.getPassword());
        return Result.success();
    }

    @PostMapping("/login")
    public Result<?> login(@Validated @ModelAttribute LoginDto params) {
        User user = userService.findUserByUsername(params.getUsername());
        String md5Pwd = DigestUtils.md5DigestAsHex(params.getPassword().getBytes());
        String ErrorMessage = "用户名或密码错误";

        if (user == null) {
            return Result.error(ErrorMessage);
        }

        if (!md5Pwd.equals(user.getPassword())) {
            return Result.error(ErrorMessage);
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getUserId());
        claims.put("username", user.getUsername());
        String token = jwtUtils.genJwt(claims);

        // 将token存入redis
        redisTemplate.opsForValue().set("token", token);
        return Result.success("登录成功", token);
    }

    @GetMapping("/userinfo")
    public Result<User> userinfo(/* @RequestHeader(name = "Authorization") String token */) {
        Map<String, Object> userMap = ThreadLocalUtils.get();

        User user = userService.findUserByUsername((String) userMap.get("username"));

        return Result.success(user);
    }

    @PutMapping("/update")
    public Result<?> update(@Validated @RequestBody UpdateUserInfoDto userinfo) {
        userService.update(userinfo);
        return Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result<?> updateAvatar(@Validated @ModelAttribute UpdateAvatarDto avatar) {
        Map<String, Object> map = ThreadLocalUtils.get();

        userService.updateAvatar((Integer) map.get("userId"), avatar.getAvatarUrl());

        return Result.success("头像更新成功", null);
    }

    @PatchMapping("/updatePwd")
    public Result<?> updatePwd(@Validated @RequestBody UpdatePwdDto body) {
        // 1. 验证新旧密码是否一致
        if (!body.getOld_pwd().equals(body.getRe_pwd())) {
            return Result.error("两次密码不一致");
        }

        // 2. 验证旧密码是否正确
        Map<String, Object> map = ThreadLocalUtils.get();
        User user = userService.findUserByUsername((String) map.get("username"));
        String md5Pwd = DigestUtils.md5DigestAsHex(body.getOld_pwd().getBytes());
        if (!md5Pwd.equals(user.getPassword())) {
            return Result.error("旧密码错误");
        }

        // // 3. 校验更新后的密码是否和旧密码相同
        // if (md5Pwd.equals(DigestUtils.md5DigestAsHex(body.getNew_pwd().getBytes())))
        // {
        // return Result.error("新密码不能和旧密码相同");
        // }

        // 3. 更新密码
        userService.updatePwd(user.getUserId(), body.getNew_pwd());

        // 4. 清除redis中的token, 使原有的token失效
        redisTemplate.delete("token");

        return Result.success("更新密码成功", null);
    }

    @PostMapping("/test")
    public Result<?> test() {
        return Result.success("token通过校验", null);
    }
}
