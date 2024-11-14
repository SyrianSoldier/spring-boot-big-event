package com.syriansoldier.big_event.mapper;

import com.syriansoldier.big_event.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void findUserByUsername(){
        User user = userMapper.findUserByUsername("john_doe");
        assertEquals("john_doe", user.getUsername());
        assertEquals("password123", user.getPassword());
    }
}
