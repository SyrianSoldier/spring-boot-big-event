package com.syriansoldier.big_event.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ResultTest {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testError() {
        String token = "Bear token";
        redisTemplate.opsForValue().set("token", token);
        assertTrue(token.equals(redisTemplate.opsForValue().get("token")));
    }
}
