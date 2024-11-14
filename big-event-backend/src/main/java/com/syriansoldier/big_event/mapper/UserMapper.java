package com.syriansoldier.big_event.mapper;

import com.syriansoldier.big_event.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findUserByUsername(String username);

    void register(String username, String password);
}
