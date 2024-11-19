package com.syriansoldier.big_event.mapper;

import com.syriansoldier.big_event.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class RegisterMapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void testRegister(){
        userMapper.register("张三", "1234");
        User user = userMapper.findUserByUsername("张三");
        assertEquals(user.getUsername(), "张三");
    }
}
