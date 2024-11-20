package com.syriansoldier.big_event.service;

import com.syriansoldier.big_event.dto.UpdateUserInfoDto;
import com.syriansoldier.big_event.pojo.User;

public interface UserService {

    User findUserByUsername(String username);

    void register(String username, String password);

    void update(UpdateUserInfoDto userinfo);

    void updateAvatar(Integer id, String avatarUrl);

    void updatePwd(Integer userId, String new_pwd);
}
