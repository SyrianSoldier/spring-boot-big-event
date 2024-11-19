package com.syriansoldier.big_event.pojo;

import lombok.Data;

@Data
public class User {
    private Long userId;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String userPic;
    private String createTime;
    private String updateTime;
}
