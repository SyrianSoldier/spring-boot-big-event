package com.syriansoldier.big_event.mapper;

import com.syriansoldier.big_event.dto.UpdateUserInfoDto;
import com.syriansoldier.big_event.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User findUserByUsername(@Param("username") String username);

    void register(@Param("username") String username, @Param("password") String password);

    void update(@Param("user") UpdateUserInfoDto userinfo);

    void updateAvatar(@Param("id") Integer id, @Param("avatarUrl") String avatarUrl);

    void updatePwd(@Param("id") Integer id, @Param("password") String password);
}
